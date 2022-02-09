package com.team.mvvmstructure.ui.viewmode

import android.util.Log
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.viewModelScope
import com.team.data.local.DataStoreManager
import com.team.domain.use_cases.GetDataUseCase
import com.team.entities.DataState
import com.team.entities.remote.currencies.response.CurrenciesResponse
import com.team.mvvmstructure.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getDataUseCase: GetDataUseCase,
    private val dataStore: DataStoreManager
) : BaseViewModel() {
    val LAST_PLAYED_SONG_KEY = stringPreferencesKey(name = "last_Played_song")

    private var _currenciesLiveData: MutableStateFlow<DataState<CurrenciesResponse>> =
        MutableStateFlow(DataState.Idle)

    fun getData(key: String) {
        viewModelScope.launch {
            getDataUseCase.execute(key).onEach { response ->
                _currenciesLiveData.emit(response)
                //   readNextReviewTime()
            }.launchIn(viewModelScope)
        }
    }


    private fun readNextReviewTime() {
        viewModelScope.launch {
            dataStore.readValue(LAST_PLAYED_SONG_KEY) {
                Log.e("TAG", "readNextReviewTime: " + this)

            }
        }
    }

    val getCurrenciesLiveData: StateFlow<DataState<CurrenciesResponse>>
        get() {
            return _currenciesLiveData
        }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}