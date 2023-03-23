package com.arclightcreatives.recyclerview_basicapparchitecture

import androidx.lifecycle.ViewModel

class Mainviemodel : ViewModel(){

    var repository = Repository()
    var dataViewmodel = ArrayList<RepoModel>()

    fun getRepoitorydata(){
        repository.getRepomodels(object :Repositorydatacalback{
            override fun onRepositorydataready(data: ArrayList<RepoModel>) {
                dataViewmodel=data
            }
        })
    }

}