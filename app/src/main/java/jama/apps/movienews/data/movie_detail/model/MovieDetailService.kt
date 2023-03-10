package jama.apps.movienews.data.movie_detail.model

import jama.apps.movienews.BuildConfig
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import jama.apps.movienews.data.movie_detail.model.remote.response.Credits
import jama.apps.movienews.data.movie_detail.model.remote.response.MovieDetailResponse
import jama.apps.movienews.data.movie_detail.model.remote.response.MovieTrailerRes

interface MovieDetailService {
    @GET("movie/{movie_id}")
    suspend fun getMovieDetailById(
        @Path("movie_id") movie_id: Long,
        @Query("api_key") closeReason: String = BuildConfig.TOKEN,
    ): Response<MovieDetailResponse>

    @GET("movie/{movie_id}/videos")
    suspend fun getMovieTrailerListById(
        @Path("movie_id") movie_id: Long,
        @Query("api_key") closeReason: String = BuildConfig.TOKEN,
    ): Response<MovieTrailerRes>

    @GET("movie/{movie_id}/credits")
    suspend fun getCredits(
        @Path("movie_id") movie_id: Long,
        @Query("api_key") closeReason: String = BuildConfig.TOKEN,
    ): Response<Credits>
}