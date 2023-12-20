package com.walletmix.custometab.service

import com.walletmix.custometab.models.ResponseQuotes
import com.walletmix.custometab.utils.Constants
import retrofit2.Response
import retrofit2.http.GET

interface QuotesService {
    @GET(Constants.QUOTES_END_POINT)
    suspend fun getAllQuotes() : Response<List<ResponseQuotes>>
}