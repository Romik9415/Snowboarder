package com.regram.ai.extensions

import android.util.Log
import com.regram.ai.BuildConfig

fun logd(tag: String, text: String) {
    if (!BuildConfig.ENABLE_LOGS) return
    Log.d(tag, text)
}

fun loge(tag: String, text: String?, tr: Exception?) {
    if (!BuildConfig.ENABLE_LOGS) return
    Log.e(tag, text, tr)
}

fun loge(tag: String, text: String) {
    if (!BuildConfig.ENABLE_LOGS) return
    Log.e(tag, text)
}