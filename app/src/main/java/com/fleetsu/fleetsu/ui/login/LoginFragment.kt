package com.fleetsu.fleetsu.ui.login

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.fleetsu.fleetsu.AppViewModelsFactory
import com.fleetsu.fleetsu.R
import com.fleetsu.fleetsu.baseui.BaseFragment
import com.fleetsu.fleetsu.data.database.entity.UserEntity
import com.fleetsu.fleetsu.extensions.addSystemBottomPadding
import com.fleetsu.fleetsu.extensions.addSystemTopPadding
import com.fleetsu.fleetsu.extensions.loadWithGlide
import com.fleetsu.fleetsu.extensions.toastL
import com.fleetsu.fleetsu.glide.GlideApp
import kotlinx.android.synthetic.main.fragment_login.*
import javax.inject.Inject

class LoginFragment : BaseFragment(), View.OnClickListener {

//    @Inject
//    lateinit var vmFactory: AppViewModelsFactory
//    private lateinit var viewModel: LoginViewModel


    override fun layoutId(): Int = R.layout.fragment_login

    override fun onViewReady(inflatedView: View, args: Bundle?) {
        constraintLayout.addSystemBottomPadding()
        clSubscriptionContainer.addSystemTopPadding()

        activity?.window?.apply {
            decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                decorView.systemUiVisibility =
                    decorView.systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
            }
        }
        ivIll1.animation = AnimationUtils.loadAnimation(this.context, R.anim.anim_bounce_fly_1)
        ivIll2.animation = AnimationUtils.loadAnimation(this.context, R.anim.anim_bounce_fly_2)
        ivIll3.animation = AnimationUtils.loadAnimation(this.context, R.anim.anim_bounce_fly_3)
        ivIll4.animation = AnimationUtils.loadAnimation(this.context, R.anim.anim_bounce_fly_4)
        ivIll5.animation = AnimationUtils.loadAnimation(this.context, R.anim.anim_bounce_fly_5)
        ivIll6.animation = AnimationUtils.loadAnimation(this.context, R.anim.anim_bounce_fly_6)
    }

    override fun initViewModel() {
//        viewModel = ViewModelProviders
//            .of(this, vmFactory)
//            .get(LoginViewModel::class.java)
//
//        viewModel.getUser().observe(this, Observer<UserEntity> { t ->
//            t?.let {
//                Log.d("test", it.firstName)
//                showAvatar(it.avatarUrl)
//            }
//        })
    }

    private fun showAvatar(avatarUrl: String) {
//        ivAvatar.loadWithGlide(avatarUrl)
//        val glide = GlideApp.with(this)
//        glide.load(avatarUrl)
//            .fitCenter()
//            .into(ivAvatar)
    }

    override fun setListeners() {
        tvStart.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            tvStart -> {
                //LoginFra
                val direction = LoginFragmentDirections.actionLoginFragmentToStartFragment()
                findNavController().navigate(direction)
            }
        }
    }
}
