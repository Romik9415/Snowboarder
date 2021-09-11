package com.fleetsu.fleetsu.ui.main

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_user_info.view.*

class UserViewHolder(
    private val userAdapterInterface: UserAdapter.UserAdapterInterface,
    itemView: View
) : RecyclerView.ViewHolder(itemView) {
    fun bind(user: User) {
        itemView.tvName.text = user.userName
        itemView.setOnClickListener {
            userAdapterInterface.onUserClicked(user.id)
        }
    }

}
