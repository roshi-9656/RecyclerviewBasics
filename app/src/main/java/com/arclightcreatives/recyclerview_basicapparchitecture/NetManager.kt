package com.arclightcreatives.recyclerview_basicapparchitecture

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

class NetManager(private var applicationContext: Context) {
    private var status: Boolean? = false

    val isConnectedToInternet: Boolean?
        get() {
            val conManager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                val network = conManager.activeNetwork
                val capabilities = conManager.getNetworkCapabilities(network)
                capabilities != null && capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
            } else {
                conManager.activeNetworkInfo?.type == ConnectivityManager.TYPE_WIFI
            }
        }
}