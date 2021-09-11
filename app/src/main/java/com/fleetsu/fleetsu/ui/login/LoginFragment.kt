package com.fleetsu.fleetsu.ui.login

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.fleetsu.fleetsu.R
import com.fleetsu.fleetsu.baseui.BaseFragment
import com.fleetsu.fleetsu.extensions.addSystemBottomPadding
import com.fleetsu.fleetsu.extensions.addSystemTopPadding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : BaseFragment(), View.OnClickListener {

    override fun layoutId(): Int = R.layout.fragment_login

    override fun onViewReady(inflatedView: View, args: Bundle?) {
//        constraintLayout.addSystemBottomPadding()
//        clSubscriptionContainer.addSystemTopPadding()
//
//        activity?.window?.apply {
//            decorView.systemUiVisibility =
//                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                decorView.systemUiVisibility =
//                    decorView.systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
//            }
//        }
//        ivIll1.animation = AnimationUtils.loadAnimation(this.context, R.anim.anim_bounce_fly_1)
//        ivIll2.animation = AnimationUtils.loadAnimation(this.context, R.anim.anim_bounce_fly_2)
//        ivIll3.animation = AnimationUtils.loadAnimation(this.context, R.anim.anim_bounce_fly_3)
//        ivIll4.animation = AnimationUtils.loadAnimation(this.context, R.anim.anim_bounce_fly_4)
//        ivIll5.animation = AnimationUtils.loadAnimation(this.context, R.anim.anim_bounce_fly_5)
//        ivIll6.animation = AnimationUtils.loadAnimation(this.context, R.anim.anim_bounce_fly_6)
//
//        val q = listOf(1, 2, 3)
    }

    private fun setAuthListener() {
        FirebaseAuth.getInstance().addAuthStateListener {
            if (it.currentUser != null) {

            }
        }
    }

    override fun initViewModel() {
    }

    override fun setListeners() {
        tvStart.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            tvStart -> {
                startLogin()
            }
        }
    }

    private fun startLogin() {
        val direction = LoginFragmentDirections.actionLoginFragmentToMainFragment()
        findNavController().navigate(direction)
//        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//            .requestIdToken(getString(R.string.default_web_client_id))
//            .requestEmail()
//            .build()
//        val mGoogleSignInClient = GoogleSignIn.getClient(requireContext(), gso);
//        startActivityForResult(mGoogleSignInClient.signInIntent, RC_LOGIN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_LOGIN) {
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account: GoogleSignInAccount? = task.getResult(ApiException::class.java)
                account?.let {
                    firebaseAuthWithGoogle(it)
                }
            } catch (e: ApiException) {
                Toast.makeText(requireContext(), e.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun firebaseAuthWithGoogle(account: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
        FirebaseAuth.getInstance().signInWithCredential(credential)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    val user: FirebaseUser? = FirebaseAuth.getInstance().currentUser
                    Toast.makeText(requireContext(), "User Signed In", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(
                        requireContext(), "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    companion object {
        const val RC_LOGIN = 123
    }
}
