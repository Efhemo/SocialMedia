package com.efhem.socialmedia.network

import com.efhem.socialmedia.BuildConfig
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


private const val BASE_URL: String = "http://35.226.14.35:8080/api/v1/"

private val sLogLevel =
    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

val interceptor = HttpLoggingInterceptor()
val client: OkHttpClient =
    OkHttpClient.Builder().addInterceptor(interceptor.setLevel(sLogLevel)).build()


object Network {

    private val retrofit by lazy {
        Retrofit.Builder().baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    val service: Service by lazy {
        retrofit.create(Service::class.java)
    }

}
