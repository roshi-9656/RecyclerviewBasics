package com.arclightcreatives.recyclerview_basicapparchitecture

import android.os.Handler

class Localdatasource {
    fun getRepodatafromlocal(onRepoLocalReadyCallback: OnRepoLocalReadyCallback) {
        var repoList = ArrayList<RepoModel>()
        repoList.add(RepoModel("Roshin", "9901180595", "books", "close"))
        repoList.add(RepoModel("Monika", "2135123", "books", "close"))
        repoList.add(RepoModel("Anu", "2135123", "books", "open"))

        Handler().postDelayed({ onRepoLocalReadyCallback.onLocalDataReady(repoList) }, 2000)
    }

    fun saveRepositories(arrayList: ArrayList<RepoModel>) {
        //todo save repositories in DB
    }
}

interface OnRepoLocalReadyCallback {
    fun onLocalDataReady(data: ArrayList<RepoModel>)
}