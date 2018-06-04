package ua.android.cozy.cozyandroid.viewlayer

import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import ua.android.cozy.cozyandroid.viewlayer.live_data.SingleLiveEvent

open class BaseViewModel : ViewModel() {
    val compositeDisposable = CompositeDisposable()
    val toast = SingleLiveEvent<String>()


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }


    fun handleError(throwable: Throwable){
        toast.value = throwable.message
        throwable.printStackTrace()
    }



}