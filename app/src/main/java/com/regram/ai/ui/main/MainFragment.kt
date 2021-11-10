package com.regram.ai.ui.main

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator
import com.regram.ai.AppViewModelsFactory
import com.regram.ai.R
import com.regram.ai.baseui.BaseFragment
import com.regram.ai.extensions.hideKeyboard
import com.regram.ai.extensions.setFocus
import com.regram.ai.extensions.toastSh
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
        val itemTouchHelper = ItemTouchHelper(simpleItemTouchCallback)
        itemTouchHelper.attachToRecyclerView(rvUsers)
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
                    //val id = rvUsers.adapter?.itemCount?.toLong() ?: 0
                    viewModel.setUser(User(edAddUser.text.toString()))
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

    private val simpleItemTouchCallback: ItemTouchHelper.SimpleCallback = object :
        ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return false
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, swipeDir: Int) {
            Toast.makeText(context, "User Deleted ", Toast.LENGTH_SHORT).show()
            val position = viewHolder.adapterPosition
            deleteItemByPosition(position)
        }
    }

    private fun deleteItemByPosition(position: Int) {
        viewModel.removeUser(userList.toList()[position])
    }

    override fun onUserClicked(userName: String) {
        val direction = MainFragmentDirections.actionMainFragmentToStartFragment(userName)
        findNavController().navigate(direction)
    }
}
