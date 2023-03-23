package com.arclightcreatives.recyclerview_basicapparchitecture

class Repository {

    fun getRepomodels(repositorydatacalback: Repositorydatacalback) {
        var repoList = ArrayList<RepoModel>()
        repoList.add(RepoModel("Roshin", "2135123", "books", "close"))
        repoList.add(RepoModel("Monika", "2135123", "books", "close"))
        repoList.add(RepoModel("Anu", "2135123", "books", "open"))
        repositorydatacalback.onRepositorydataready(repoList)
    }

}

interface Repositorydatacalback{
    fun onRepositorydataready(data :ArrayList<RepoModel>)
}