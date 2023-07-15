package com.task.remote.di.services.packges_listing


import com.task.remote.di.services.EndPoints
import com.task.remote.di.services.countries_listing.models.CountryPackagesResponse
import com.task.remote.di.services.packges_listing.models.LocalEsimResponseItem
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PackagesService {

    @GET(EndPoints.LocalESimsEndpoint)
    fun getLocalEsims(): Single<List<LocalEsimResponseItem>>

    @GET(EndPoints.CountryPackagesEndpoint)
    fun getCountryPackages(@Path("id") id: String): Single<CountryPackagesResponse>

}