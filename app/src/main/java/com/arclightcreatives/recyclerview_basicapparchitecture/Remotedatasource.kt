package com.arclightcreatives.recyclerview_basicapparchitecture

import android.os.Handler
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class Remotedatasource {

    fun getRepodataremote(): Observable<ArrayList<RepoModel>> {
        var repoList = ArrayList<RepoModel>()
        repoList.add(RepoModel("Roshin", "2135123", "books", "close"))
        repoList.add(RepoModel("Monika", "2135123", "books", "close"))
        repoList.add(RepoModel("Anu", "2135123", "books", "open"))
        //  Handler().postDelayed({ onRepoRemoteReadyCallback.onRemoteDataReady(repoList) }, 2000)
        return Observable.just(repoList).delay(2, TimeUnit.SECONDS)

    }
}

interface OnRepoRemoteReadyCallback {
    fun onRemoteDataReady(data: ArrayList<RepoModel>)
}