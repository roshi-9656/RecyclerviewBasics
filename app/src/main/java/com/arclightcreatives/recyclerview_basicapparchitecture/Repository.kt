package com.arclightcreatives.recyclerview_basicapparchitecture

import java.util.logging.Handler

class Repository {

    fun getRepomodels(repositorydatacalback: Repositorydatacalback) {
        var repoList = ArrayList<RepoModel>()
        repoList.add(RepoModel("Roshin", "2135123", "books", "close"))
        repoList.add(RepoModel("Monika", "2135123", "books", "close"))
        repoList.add(RepoModel("Anu", "2135123", "books", "open"))
        android.os.Handler().postDelayed({repositorydatacalback.onRepositorydataready(repoList)},2000)

    }

}

interface Repositorydatacalback{
    fun onRepositorydataready(data :ArrayList<RepoModel>)
}