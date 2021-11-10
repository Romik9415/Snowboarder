package com.regram.ai.ui.login

import androidx.lifecycle.ViewModel
import com.regram.ai.repositories.UserRepository
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    //fun getUser(lat: Double, lon: Double) = userRepository.getUser(lat,lon)

}