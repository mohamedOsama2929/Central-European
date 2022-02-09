package com.team.core.utils.network


import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Log

class ConnectivityReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.e("TAG", "onReceive: ")
        val connectivityManager = context?.getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        networkStatus(activeNetwork)
    }

    private fun networkStatus(activeNetwork: NetworkInfo?) {
        if (activeNetwork == null || !activeNetwork.isConnectedOrConnecting) {
            NetworkUtils.getNetworkUtils().setNetworkStatus(NetworkUtils.DISCONNECTED)

        } else if (activeNetwork.state == NetworkInfo.State.CONNECTING) {
            NetworkUtils.getNetworkUtils().setNetworkStatus(NetworkUtils.CONNECTING)
        } else if (activeNetwork.isConnected) {
            NetworkUtils.getNetworkUtils().setNetworkStatus(NetworkUtils.CONNECTED)
        }
    }
}