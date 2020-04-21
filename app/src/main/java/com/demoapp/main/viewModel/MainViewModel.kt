package com.demoapp.main.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mindorks.framework.mvvm.data.repository.MainRepository
import com.mindorks.framework.mvvm.utils.Resource
import com.niravjoshi.proof_of_concept.concepts.model.FeedsDTO
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel() : ViewModel() {


    var mainRepository = MainRepository()

    var feedsDTOLiveData = MutableLiveData<Resource<FeedsDTO>>()

    fun getFeeds() {
        feedsDTOLiveData.postValue(Resource.loading(null))
        mainRepository.getFeeds()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ t: FeedsDTO? ->
                feedsDTOLiveData.postValue(Resource.success(t))
            }, { t: Throwable? ->
                feedsDTOLiveData.postValue(Resource.error("Something Went Wrong", null))
            }
            )
    }

    fun getFeedsList(): LiveData<Resource<FeedsDTO>> {
        return feedsDTOLiveData
    }


}