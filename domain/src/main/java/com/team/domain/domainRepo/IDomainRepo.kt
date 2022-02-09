package com.team.domain.domainRepo

import com.team.entities.remote.currencies.response.CurrenciesResponse

interface IDomainRepo {
    /*----------------------------------------Remote----------------------------------------*/
    suspend fun getData(key: String): CurrenciesResponse

    /*----------------------------------------Local----------------------------------------*/
/*
    fun saveData(currencies: Currencies)
*/
}