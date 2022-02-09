package com.team.data.repo

import com.team.data.dataSource.remote.IRemoteDataSource
import com.team.domain.domainRepo.IDomainRepo
import javax.inject.Inject

class Repo @Inject constructor(
    val iRemoteDataSource: IRemoteDataSource,
) : IDomainRepo {

    /*----------------------------------------Remote----------------------------------------*/
/*
    override fun getData(key: String): Single<CurrenciesResponse> {
        return iRemoteDataSource.getData(key)

    }*/

}