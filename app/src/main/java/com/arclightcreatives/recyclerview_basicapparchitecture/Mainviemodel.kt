package com.arclightcreatives.recyclerview_basicapparchitecture

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class Mainviemodel(application: Application) : AndroidViewModel(application){

    var repository = Repository(NetManager(application))
    var isLoading = ObservableField<Boolean>()
    var dataViewmodel = MutableLiveData<ArrayList<RepoModel>>()
    //lateinit var compositeDisposable: CompositeDisposable
    private val compositeDisposable =CompositeDisposable()


    /*fun getRepoitorydata(){
        isLoading.set(true)
        repository.getdatafromRemote(object :Repositorydatacalback{
            override fun onRepositorydataready(data: ArrayList<RepoModel>) {
                dataViewmodel.value=data
                isLoading.set(false)
            }
        })
    }*/


    fun getRepoitorydata(){
        isLoading.set(true)
       compositeDisposable += repository.getdatafromRemote()
           .subscribeOn(Schedulers.newThread())
           .observeOn(AndroidSchedulers.mainThread())
           .subscribeWith(object : DisposableObserver<ArrayList<RepoModel>>(){


           override fun onError(e: Throwable) {
           }

           override fun onComplete() {
               isLoading.set(false)
           }

           override fun onNext(t: ArrayList<RepoModel>) {
               dataViewmodel.value=t
           }

       })


    }

    override fun onCleared() {
        super.onCleared()
        if(!compositeDisposable.isDisposed){
            compositeDisposable.dispose()
        }
    }

}

private operator fun CompositeDisposable.plusAssign(disposable: Disposable) {
    add(disposable)
}
