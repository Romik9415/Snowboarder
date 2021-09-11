package com.fleetsu.fleetsu.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.fleetsu.fleetsu.R

class UserAdapter(private val userAdapterInt: UserAdapterInterface) :
    ListAdapter<User, UserViewHolder>(UserDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_user_info, parent, false)
        return UserViewHolder(userAdapterInt, view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    object UserDiff : DiffUtil.ItemCallback<User>() {

        override fun areItemsTheSame(oldItem: User, newItem: User) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: User, newItem: User) =
            oldItem.userName == newItem.userName
    }

    interface UserAdapterInterface {
        fun onUserClicked(userId: Long) {
        }
    }

}