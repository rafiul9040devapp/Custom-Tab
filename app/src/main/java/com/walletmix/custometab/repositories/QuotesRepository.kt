package com.walletmix.custometab.repositories

import com.walletmix.custometab.models.ResponseQuotes
import com.walletmix.custometab.service.QuotesService
import retrofit2.Response
import javax.inject.Inject

class QuotesRepository @Inject constructor(private var api: QuotesService) {
    suspend fun getAllQuotesFromRepo(): Response<List<ResponseQuotes>> {
        return api.getAllQuotes()
    }
}