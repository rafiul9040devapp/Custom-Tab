package com.walletmix.custometab

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.walletmix.custometab.models.ResponseQuotes
import com.walletmix.custometab.repositories.QuotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuotesViewModel @Inject constructor(private var repository: QuotesRepository) : ViewModel() {

    val quotes: LiveData<List<ResponseQuotes>> get() = repository.responseQuotes
    fun getAllQuotesFromVM() {
        viewModelScope.launch {
            repository.getAllQuotesFromRepo()
        }
    }
}