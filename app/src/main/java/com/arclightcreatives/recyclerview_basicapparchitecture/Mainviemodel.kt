package com.arclightcreatives.recyclerview_basicapparchitecture

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

class Mainviemodel : ViewModel(){

    var repository = Repository()
    var isLoading = ObservableField<Boolean>()
    var dataViewmodel = MutableLiveData<ArrayList<RepoModel>>()

    fun getRepoitorydata(){
        isLoading.set(true)
        repository.getRepomodels(object :Repositorydatacalback{
            override fun onRepositorydataready(data: ArrayList<RepoModel>) {
                dataViewmodel.value=data
                isLoading.set(false)
            }
        })
    }

}