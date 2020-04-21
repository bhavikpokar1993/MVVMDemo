package com.demoapp.network

import com.niravjoshi.proof_of_concept.concepts.model.FeedsDTO
import io.reactivex.Observable
import retrofit2.http.GET

interface APIService {
    @GET("s/2iodh4vg0eortkl/facts.json")
    fun getFeedsData(): Observable<FeedsDTO>
}