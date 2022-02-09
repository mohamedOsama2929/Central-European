package com.team.domain.use_cases

import com.team.domain.domainRepo.IDomainRepo
import com.team.domain.excuter.PostExecutionThread
import com.team.domain.utils.FlowUseCase
import com.team.entities.DataState
import com.team.entities.remote.currencies.response.CurrenciesResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetDataUseCase @Inject constructor(
    private val repo: IDomainRepo,
    postExecutionThread: PostExecutionThread
) : FlowUseCase<DataState<CurrenciesResponse>, String>(postExecutionThread) {
    override suspend fun buildUseCaseObservable(params: String?): Flow<DataState<CurrenciesResponse>> {
        return flow {
            emit(DataState.Loading)
            try {
                emit(DataState.Success(repo.getData(params.toString())))
            } catch (e: Exception) {
                emit(DataState.Error(e))
            }
        }
    }
}