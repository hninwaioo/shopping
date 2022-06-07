package com.za.sbs.delivery.utils

import android.content.Context
import android.net.ConnectivityManager
import android.view.View
import android.widget.EditText
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.material.snackbar.Snackbar
import com.za.sbs.delivery.R
import org.jetbrains.anko.toast

fun String.toMMNum() = this.fold("") { acc, c ->
    if (c in '0'..'9') {
        // acc + ((c.toInt() - '0'.toInt()) + '၀'.toInt())
        acc + (c.toInt() + 4112).toChar()
    } else {
        acc + c
    }
}

fun Int.toMMNum() = this.toString().fold("") { acc, c ->
    if (c in '0'..'9') {
        // acc + ((c.toInt() - '0'.toInt()) + '၀'.toInt())
        acc + (c.toInt() + 4112).toChar()
    } else {
        acc + c
    }
}

fun Context.isInternetAvailable(): Boolean {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetworkInfo = connectivityManager.activeNetworkInfo
    return activeNetworkInfo != null && activeNetworkInfo.isConnected
}

fun Context.availableConnection(view: View? = null, yes: () -> Unit) {
    if (!this.isInternetAvailable()) {
        if (view == null) {
            this.toast(getString(R.string.connection_error))
        } else {
            if (view is SwipeRefreshLayout) {
                view.isRefreshing = false
            }
            Snackbar.make(view,R.string.connection_error,Snackbar.LENGTH_SHORT).show()
        }
    } else {
        yes()
    }
}

fun EditText.isValid(): Boolean {
    return !this.text.toString().isNullOrEmpty()
}