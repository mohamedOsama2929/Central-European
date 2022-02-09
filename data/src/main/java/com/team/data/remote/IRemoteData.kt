package com.team.data.remote

import com.team.entities.remote.currencies.response.CurrenciesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface IRemoteData {

    @GET("latest")
    suspend fun getData(@Query("access_key") key: String): CurrenciesResponse
}