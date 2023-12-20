package com.walletmix.custometab.di

import com.walletmix.custometab.service.QuotesService
import com.walletmix.custometab.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit.Builder {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }
    @Provides
    @Singleton
    fun getUserServices(retrofit: Retrofit.Builder): QuotesService {
        return retrofit.build().create(QuotesService::class.java)
    }
}