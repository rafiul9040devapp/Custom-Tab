package com.walletmix.custometab

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.walletmix.custometab.models.ResponseQuotes
import com.walletmix.custometab.repositories.QuotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class QuotesViewModel @Inject constructor(private var repository: QuotesRepository) : ViewModel() {

    private val _responseQuotes = MutableLiveData<Response<List<ResponseQuotes>>>()
    val productResponse: LiveData<Response<List<ResponseQuotes>>> = _responseQuotes

    fun getAllQuotesFromVM() {
        viewModelScope.launch {
            _responseQuotes.postValue(repository.getAllQuotesFromRepo())
        }
    }

    fun setApiData(apiData: Response<List<ResponseQuotes>>) {
        _responseQuotes.value = apiData
    }
}