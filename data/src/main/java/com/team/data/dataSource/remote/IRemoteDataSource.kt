package com.team.data.dataSource.remote

import com.team.entities.remote.currencies.response.CurrenciesResponse

interface IRemoteDataSource {

    suspend fun getData(key: String): CurrenciesResponse
}