package com.regram.ai.ui.main

import androidx.lifecycle.MutableLiveData
import com.regram.ai.BaseViewModel
import com.regram.ai.repositories.UserRepository
import com.regram.ai.ui.discover.Meme
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserViewModel @Inject constructor(
    private val localUserRepository: UserRepository
) : BaseViewModel() {

    val userLiveData = localUserRepository.getUsers()
    val memList = MutableLiveData<List<Meme>>()

    fun setUser(user: User) {
        launch {
            localUserRepository.setUser(user)
        }
        addUserContentOnBack(user.userName)
    }

    fun removeUser(user: User) {
        launch {
            localUserRepository.removeUser(user)
        }
    }

    private fun addUserContentOnBack(userString: String) {
        launchHandled({ localUserRepository.setUserToRepo(userString) }, {

        })

    }

    fun getUserByUserName(userName: String) {
        launchHandled({ localUserRepository.getUserByUserName(userName) }, {
            memList.postValue(it)
        })
    }


}
