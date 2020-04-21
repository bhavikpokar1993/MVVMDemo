package com.mindorks.framework.mvvm.data.repository

import com.demoapp.network.APIService
import com.demoapp.network.RetrofitSingleTon
import com.niravjoshi.proof_of_concept.concepts.model.FeedsDTO
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.schedulers.Schedulers.io

class MainRepository() {


    private val mAPIService: APIService by lazy {
        return@lazy RetrofitSingleTon.getInstance().getAPIService()
    }

    fun getFeeds(): Observable<FeedsDTO> {
        return mAPIService.getFeedsData()
    }

}

