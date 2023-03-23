package com.arclightcreatives.recyclerview_basicapparchitecture

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Mainviemodel : ViewModel(){

    var repository = Repository()
    var dataViewmodel = MutableLiveData<ArrayList<RepoModel>>()

    fun getRepoitorydata(){
        repository.getRepomodels(object :Repositorydatacalback{
            override fun onRepositorydataready(data: ArrayList<RepoModel>) {
                dataViewmodel.value=data
            }
        })
    }

}