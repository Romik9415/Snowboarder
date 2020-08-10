package com.fleetsu.fleetsu.ui.login

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.fleetsu.fleetsu.AppViewModelsFactory
import com.fleetsu.fleetsu.R
import com.fleetsu.fleetsu.baseui.BaseFragment
import com.fleetsu.fleetsu.data.database.entity.UserEntity
import com.fleetsu.fleetsu.extensions.loadWithGlide
import com.fleetsu.fleetsu.glide.GlideApp
import kotlinx.android.synthetic.main.fragment_login.*
import javax.inject.Inject

class LoginFragment : BaseFragment() {

    @Inject
    lateinit var vmFactory: AppViewModelsFactory
    private lateinit var viewModel: LoginViewModel

    companion object {
        val TAG = LoginFragment::class.java.simpleName
        fun newInstance() = LoginFragment()
    }

    override fun layoutId(): Int = R.layout.fragment_login

    override fun onViewReady(inflatedView: View, args: Bundle?) {
        setListeners()
    }

    override fun initViewModel() {
        viewModel = ViewModelProviders
            .of(this, vmFactory)
            .get(LoginViewModel::class.java)

        viewModel.getUser().observe(this, Observer<UserEntity> { t ->
            t?.let {
                Log.d("test", it.firstName)
                showAvatar(it.avatarUrl)
            }
        })
    }

    private fun showAvatar(avatarUrl: String) {
        ivAvatar.loadWithGlide(avatarUrl)
        val glide = GlideApp.with(this)
        glide.load(avatarUrl)
            .fitCenter()
            .into(ivAvatar)
    }

    private fun setListeners() {

    }
}
