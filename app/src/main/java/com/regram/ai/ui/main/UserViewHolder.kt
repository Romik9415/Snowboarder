package com.regram.ai.ui.main

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.regram.ai.R
import kotlinx.android.synthetic.main.item_user_info.view.*

class UserViewHolder(
    private val userAdapterInterface: UserAdapter.UserAdapterInterface,
    itemView: View
) : RecyclerView.ViewHolder(itemView) {
    fun bind(user: User, position: Int) {
        itemView.tvName.text = user.userName
        val q = when (position % 4) {
            0 -> {
                R.color.crcl1
            }
            1 -> {
                R.color.crcl2
            }
            2 -> {
                R.color.crcl3
            }
            3 -> {
                R.color.crcl4
            }
            else -> R.color.crcl4
        }
        itemView.ivInstIll.backgroundTintList = itemView.context.getColorStateList(q)

        itemView.ivInstIll
        itemView.setOnClickListener {
            userAdapterInterface.onUserClicked(user.userName)
        }
    }

}
