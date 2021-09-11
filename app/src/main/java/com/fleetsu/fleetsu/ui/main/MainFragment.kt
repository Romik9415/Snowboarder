package com.fleetsu.fleetsu.ui.main

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.SimpleItemAnimator
import com.fleetsu.fleetsu.AppViewModelsFactory
import com.fleetsu.fleetsu.R
import com.fleetsu.fleetsu.baseui.BaseFragment
import com.fleetsu.fleetsu.extensions.hideKeyboard
import com.fleetsu.fleetsu.extensions.setFocus
import com.fleetsu.fleetsu.extensions.toastSh
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject


class MainFragment : BaseFragment(), View.OnClickListener, UserAdapter.UserAdapterInterface {

    @Inject
    lateinit var vmFactory: AppViewModelsFactory

    private lateinit var viewModel: UserViewModel

    override fun layoutId() = R.layout.fragment_main
    var standardBottomSheetBehavior: BottomSheetBehavior<View>? = null

    private lateinit var expandableChargersAdapter: UserAdapter
    private val userList = mutableSetOf<User>()

    override fun onViewReady(inflatedView: View, args: Bundle?) {
        initRecyclerView()
//        activity?.window?.apply {
//            decorView.systemUiVisibility =
//                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//        }
        standardBottomSheetBehavior = BottomSheetBehavior.from(standardBottomSheet)
        standardBottomSheetBehavior?.state = BottomSheetBehavior.STATE_EXPANDED
        standardBottomSheetBehavior?.state = BottomSheetBehavior.STATE_HIDDEN
    }

    override fun setListeners() {
        addProfile.setOnClickListener(this)
        setUserName.setOnClickListener(this)
    }

    override fun initViewModel() {
        viewModel = ViewModelProvider(requireActivity(), vmFactory).get(UserViewModel::class.java)
        viewModel.userLiveData.observe(this, {
            it?.let {
                userList.addAll(it)
                (rvUsers.adapter as UserAdapter).submitList(it)
            }
        })
        (rvUsers.adapter as UserAdapter).apply {
            submitList(userList.toList())
        }
    }

    private fun initRecyclerView() {
        expandableChargersAdapter = UserAdapter(this)
        with(rvUsers) {
            (itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
            layoutManager = LinearLayoutManager(context)
            overScrollMode = View.OVER_SCROLL_NEVER
            adapter = expandableChargersAdapter
        }
    }

    override fun onClick(v: View?) {
        when (v) {
            addProfile -> {
                standardBottomSheetBehavior?.state = BottomSheetBehavior.STATE_EXPANDED
                Handler().postDelayed({
                    // Actions to do after 5 seconds
                    edAddUser.setFocus()
                }, 300)
            }
            setUserName -> {
                if (edAddUser.text.toString().isNotBlank()) {
                    val id = rvUsers.adapter?.itemCount?.toLong() ?: 0
                    viewModel.setUser(User(id, edAddUser.text.toString()))
                }
                standardBottomSheetBehavior?.state = BottomSheetBehavior.STATE_HIDDEN
                Handler().postDelayed({
                    // Actions to do after 5 seconds
                    toastSh("User added")
                    hideKeyboard()
                }, 300)
            }
        }
    }

    override fun onUserClicked(userName: String) {
        val direction = MainFragmentDirections.actionMainFragmentToStartFragment(userName)
        findNavController().navigate(direction)
    }
}
