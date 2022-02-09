package com.team.data.repo

import com.team.data.dataSource.local.ILocalDataSource
import com.team.data.dataSource.remote.IRemoteDataSource
import com.team.domain.domainRepo.IDomainRepo
import com.team.entities.remote.currencies.response.CurrenciesResponse
import javax.inject.Inject

class Repo @Inject constructor(
    private val iRemoteDataSource: IRemoteDataSource,
    private val iLocalDataSource: ILocalDataSource
) : IDomainRepo {
    override suspend fun getData(key: String): CurrenciesResponse {
        return iRemoteDataSource.getData(key)
    }

    /*----------------------------------------Remote----------------------------------------*/

    /*   override fun getData(key: String): Single<CurrenciesResponse> {
           return iRemoteDataSource.getData(key)

       }*/

    /*----------------------------------------Local----------------------------------------*/
/*
    override fun saveData(currencies: Currencies) {
        iLocalDataSource.saveData(currencies)
    }*/
}