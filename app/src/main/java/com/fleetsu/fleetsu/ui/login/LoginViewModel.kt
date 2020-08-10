package com.fleetsu.fleetsu.ui.login

import androidx.lifecycle.ViewModel
import com.fleetsu.fleetsu.repositories.UserRepository
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    fun getUser() = userRepository.getUser()

}