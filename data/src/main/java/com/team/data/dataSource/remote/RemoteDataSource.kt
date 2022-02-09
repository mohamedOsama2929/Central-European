package com.team.data.dataSource.remote

import com.team.data.remote.IRemoteData
import com.team.entities.remote.currencies.response.CurrenciesResponse
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val iRemoteData: IRemoteData) :
    IRemoteDataSource {
    override suspend fun getData(key: String): CurrenciesResponse {
        return iRemoteData.getData(key)
    }
}


/*  override fun getData(key: String): Single<CurrenciesResponse> {

      return iRemoteData.getData(key)
  }*/
