package com.arclightcreatives.recyclerview_basicapparchitecture

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

class Mainviemodel(application: Application) : AndroidViewModel(application){

    var repository = Repository(NetManager(application))
    var isLoading = ObservableField<Boolean>()
    var dataViewmodel = MutableLiveData<ArrayList<RepoModel>>()

    fun getRepoitorydata(){
        isLoading.set(true)
        repository.getdatafromRemote(object :Repositorydatacalback{
            override fun onRepositorydataready(data: ArrayList<RepoModel>) {
                dataViewmodel.value=data
                isLoading.set(false)
            }
        })
    }

}