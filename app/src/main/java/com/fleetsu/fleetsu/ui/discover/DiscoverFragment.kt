package com.fleetsu.fleetsu.ui.discover

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.SimpleItemAnimator
import com.fleetsu.fleetsu.AppViewModelsFactory
import com.fleetsu.fleetsu.R
import com.fleetsu.fleetsu.baseui.BaseFragment
import com.fleetsu.fleetsu.ui.main.UserViewModel
import kohii.v1.exoplayer.Kohii
import kotlinx.android.synthetic.main.discover_fragment.*
import javax.inject.Inject

class DiscoverFragment : BaseFragment(), MemeAdapter.OnMemeClickListener {
    override fun layoutId() = R.layout.discover_fragment

    private lateinit var memeAdapter: MemeAdapter

    @Inject
    lateinit var vmFactory: AppViewModelsFactory

    private lateinit var viewModel: UserViewModel

    override fun onViewReady(inflatedView: View, args: Bundle?) {
        initRecyclerView()
//        val memList = listOf(
//            Meme(
//                0,
//                false,
//                "https://storage.googleapis.com/prod-reflect-videos/data/swapped_videos/4e9e37c0-6d0f-40c2-ac3d-ae3ec498e83b.mp4",
//                MemeType.Video
//            ),
//            Meme(1, false, "https://i.redd.it/xibya3746le61.jpg", MemeType.Photo),
//            Meme(2, false, "https://i.redd.it/xibya3746le61.jpg", MemeType.Photo)
//        )
        //(
    }


    override fun setListeners() {

    }

    override fun initViewModel() {
        viewModel = ViewModelProvider(requireActivity(), vmFactory).get(UserViewModel::class.java)
        viewModel.memList.observe(this, {
            (rvMemes.adapter as MemeAdapter).submitList(it)
        })
        arguments?.getString("userName")?.let {
            viewModel.getUserByUserName(it)
        }

    }

    private fun initRecyclerView() {
        val kohii = Kohii[requireContext()]
        kohii.register(this).addBucket(rvMemes)
        memeAdapter = MemeAdapter(this, kohii)
        with(rvMemes) {
            (itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
            layoutManager = LinearLayoutManager(context)
            overScrollMode = View.OVER_SCROLL_NEVER
            adapter = memeAdapter
        }
    }

    override fun onLikeClicked(id: Long, checked: Boolean) {

    }

//    fun View.addSystemBottomPadding(
//        targetView: View = this,
//        isConsumed: Boolean = false
//    ) {
//        doOnApplyWindowInsets { _, insets, initialPadding ->
//            targetView.updatePadding(
//                bottom = initialPadding.bottom + insets.systemWindowInsetBottom
//            )
//            if (isConsumed) {
//                insets.replaceSystemWindowInsets(
//                    Rect(
//                        insets.systemWindowInsetLeft,
//                        insets.systemWindowInsetTop,
//                        insets.systemWindowInsetRight,
//                        0
//                    )
//                )
//            } else {
//                insets
//            }
//        }
//    }
//
//    private fun View.updatePadding(
//        left: Int = paddingLeft,
//        top: Int = paddingTop,
//        right: Int = paddingRight,
//        bottom: Int = paddingBottom
//    ) {
//        setPadding(left, top, right, bottom)
//    }

}