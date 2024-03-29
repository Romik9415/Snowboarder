package com.regram.ai.extensions

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.regram.ai.glide.GlideApp

fun ImageView.loadWithGlide(url: String?, placeholderResId: Int? = null) {
    GlideApp.with(context).load(url).also { glideRequest ->
        placeholderResId?.let {
            glideRequest.placeholder(it)
        }
        glideRequest.into(this)
    }
}

fun ImageView.loadWithGlideRoundedCorners(url: String?, radius: Int, placeholderId: Int? = null) {
    GlideApp.with(context).load(url)
        .also { glideRequest ->
            placeholderId?.let {
                glideRequest.placeholder(it)
            }
            glideRequest
                .transform(CenterCrop(), RoundedCorners(radius))
                .into(this)
        }

}

fun Fragment.toastL(text: String) {
    Toast.makeText(activity, text, Toast.LENGTH_LONG).show()
}

fun Fragment.toastSh(text: String) {
    Toast.makeText(activity, text, Toast.LENGTH_SHORT).show()
}

fun Fragment.changeVisibility(visibility: Int, vararg views: View?) {
    for (view in views) {
        view?.visibility = visibility
    }
}

fun Activity.toastL(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_LONG).show()
}

fun Activity.toastSh(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

fun Activity.changeVisibility(visibility: Int, vararg views: View?) {
    for (view in views) {
        view?.visibility = visibility
    }
}

fun EditText?.setFocus() {
    this?.requestFocus()
    val imm = this?.context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}

fun Context.changeVisibility(visibility: Int, vararg views: View) {
    for (view in views) {
        view.visibility = visibility
    }
}

fun View?.show() {
    this?.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.INVISIBLE
}

fun View?.gone() {
    this?.visibility = View.GONE
}