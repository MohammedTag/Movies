package com.task.remote.di.services.listing


import com.task.remote.di.services.EndPoints
import com.task.remote.di.services.countries_listing.models.MovieDetailsResponse
import com.task.remote.di.services.listing.models.MoviesResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Url

interface TheMoviesService {

    @GET(EndPoints.DiscoverEndpoint)
    @Headers("Authorization: ${EndPoints.authorization}")
    fun getAvailableMovies(): Single<MoviesResponse>

    @GET
    @Headers("Authorization: ${EndPoints.authorization}")
    fun getMovieDetails(@Url url:String ,@Path("id") id: String): Single<MovieDetailsResponse>

}