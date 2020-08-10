package com.fleetsu.fleetsu.data.sharedpreferences

interface AppSharedPreferences {

    /**
     * is logged in detects if user is logged in
     * */
    fun isLoggedIn(): Boolean

    /**
     * set the value of sign in status
     * */
    fun setLoggedIn(loggedIn: Boolean)

    /**
     * Using for getting currentUser from db
     * */
    fun getCurrentUserId(): Int

    /**
     * setter for countryId
     * */
    fun setCurrentUserId(id: Int)

}