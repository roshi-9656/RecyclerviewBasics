package com.arclightcreatives.recyclerview_basicapparchitecture

import android.os.Handler

class Remotedatasource {

    fun getRepodataremote(onRepoRemoteReadyCallback: OnRepoRemoteReadyCallback) {
        var repoList = ArrayList<RepoModel>()
        repoList.add(RepoModel("Roshin", "2135123", "books", "close"))
        repoList.add(RepoModel("Monika", "2135123", "books", "close"))
        repoList.add(RepoModel("Anu", "2135123", "books", "open"))
        Handler().postDelayed({ onRepoRemoteReadyCallback.onRemoteDataReady(repoList) }, 2000)
    }
}

interface OnRepoRemoteReadyCallback {
    fun onRemoteDataReady(data: ArrayList<RepoModel>)
}