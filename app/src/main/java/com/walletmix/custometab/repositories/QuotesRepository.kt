package com.walletmix.custometab.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.walletmix.custometab.models.ResponseQuotes
import com.walletmix.custometab.service.QuotesService
import retrofit2.Response
import javax.inject.Inject

class QuotesRepository @Inject constructor(private var api: QuotesService) {

    private val _responseQuotes = MutableLiveData<List<ResponseQuotes>>()
    val responseQuotes: LiveData<List<ResponseQuotes>> get() = _responseQuotes

    suspend fun getAllQuotesFromRepo() {
        try {
            val response = api.getAllQuotes()

            if (response.isSuccessful) {
                _responseQuotes.postValue(response.body())
            } else {
                // Handle unsuccessful response
                handleErrorResponse(response)
            }
        } catch (e: Exception) {
            // Handle network or unexpected errors
            handleNetworkError(e)
        }

//
//        val response = api.getAllQuotes()
//        if (response.isSuccessful) {
//            _responseQuotes.postValue(response.body())
//        }
    }

    private fun handleErrorResponse(response: Response<List<ResponseQuotes>>) {
        val errorCode = response.code()
        val errorMessage = response.message()
        // Example: Log the error
        Log.e("QuotesRepository", "HTTP Error: $errorCode, Message: $errorMessage")
    }
    private fun handleNetworkError(e: Exception) {
        Log.e("QuotesRepository", "Network Error: ${e.message}", e)
    }


}