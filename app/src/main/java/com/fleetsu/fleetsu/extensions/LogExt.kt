package com.fleetsu.fleetsu.extensions

import android.util.Log
import com.fleetsu.fleetsu.BuildConfig

fun logd(tag: String, text: String?) {
    if (!BuildConfig.ENABLE_LOGS) return
    Log.d(tag, text)
}

fun loge(tag: String, text: String?, tr: Exception?) {
    if (!BuildConfig.ENABLE_LOGS) return
    Log.e(tag, text, tr)
}

fun loge(tag: String, text: String?) {
    if (!BuildConfig.ENABLE_LOGS) return
    Log.e(tag, text)
}