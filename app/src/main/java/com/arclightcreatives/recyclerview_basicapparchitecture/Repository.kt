package com.arclightcreatives.recyclerview_basicapparchitecture

import android.content.Context
import java.util.logging.Handler

class Repository (private val netManager: NetManager){

    var localdatasource = Localdatasource()
    var remotedatasource = Remotedatasource()


    /*fun getRepomodels(repositorydatacalback: Repositorydatacalback) {
        var repoList = ArrayList<RepoModel>()
        repoList.add(RepoModel("Roshin", "2135123", "books", "close"))
        repoList.add(RepoModel("Monika", "2135123", "books", "close"))
        repoList.add(RepoModel("Anu", "2135123", "books", "open"))
        android.os.Handler().postDelayed({repositorydatacalback.onRepositorydataready(repoList)},2000)
    }*/



    fun getdatafromRemote(repositorydatacalback: Repositorydatacalback) {

        netManager.isConnectedToInternet?.let {
            if(it){
                remotedatasource.getRepodataremote(object : OnRepoRemoteReadyCallback {
                    override fun onRemoteDataReady(data: ArrayList<RepoModel>) {
                        localdatasource.saveRepositories(data)
                        repositorydatacalback.onRepositorydataready(data)
                    }
                })
            }else{
                localdatasource.getRepodatafromlocal(object : OnRepoLocalReadyCallback{
                    override fun onLocalDataReady(data: ArrayList<RepoModel>) {
                        repositorydatacalback.onRepositorydataready(data)
                    }
                })
            }
        }

    }

}

interface Repositorydatacalback {
    fun onRepositorydataready(data: ArrayList<RepoModel>)
}