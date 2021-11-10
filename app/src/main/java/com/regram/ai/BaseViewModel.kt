package com.regram.ai

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import retrofit2.HttpException
import kotlin.coroutines.CoroutineContext

open class BaseViewModel : ViewModel(), CoroutineScope {

    protected val _isLoading: MediatorLiveData<Boolean> = MediatorLiveData()
    protected val _errors: MutableLiveData<Event<Throwable>> = MutableLiveData()
    val _networkExceptions: MutableLiveData<Event<HttpException>> = MutableLiveData()

    val isLoading: LiveData<Boolean> = _isLoading
    val errors: LiveData<Event<Throwable>> = _errors
    val networkExceptions: LiveData<Event<HttpException>> = _networkExceptions

    private var job: Job = SupervisorJob()

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, t ->
        _errors.postValue(Event(t))
        _isLoading.postValue(false)
    }

    override val coroutineContext: CoroutineContext =
            Dispatchers.Main + job + coroutineExceptionHandler

    private val ioCoroutineContext: CoroutineContext = Dispatchers.IO + job

    protected fun <T> launchHandled(
            task: suspend CoroutineScope.() -> T,
            onSuccess: (T) -> Unit,
            onError: ((Exception) -> Unit)? = null
    ) {
        launch(ioCoroutineContext) {
            _isLoading.postValue(true)
            try {
                onSuccess(task())
            } catch (h: HttpException) {
                //onError?.invoke(h.message())
                h.printStackTrace()
                _networkExceptions.postValue(Event(h))
            } catch (e: Exception) {
                onError?.invoke(e)
                e.printStackTrace()
                _errors.postValue(Event(e))
            } finally {
                _isLoading.postValue(false)
            }
        }
    }

    /**
     * Load data from server without sh0wing progress bar
     */

    protected fun <T> silentLaunchHandled(
            task: suspend CoroutineScope.() -> T,
            onSuccess: (T) -> Unit,
            onError: ((Exception) -> Unit)? = null
    ) {
        launch(ioCoroutineContext) {
            try {
                onSuccess(task())
            } catch (h: HttpException) {
                //onError?.invoke(h.message())
                h.printStackTrace()
                _networkExceptions.postValue(Event(h))
            } catch (e: Exception) {
                onError?.invoke(e)
                e.printStackTrace()
                _errors.postValue(Event(e))
            }
        }
    }

    override fun onCleared() {
        job.cancel()
        ioCoroutineContext.cancelChildren()
        coroutineContext.cancelChildren()
        super.onCleared()
    }
}