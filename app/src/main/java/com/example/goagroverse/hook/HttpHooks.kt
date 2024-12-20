package com.example.goagroverse.hook

import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

object HttpHooks {

    // Retrofit Instance
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://localhost:5000/") // Ganti dengan URL Backend Anda
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Interface untuk API
    private interface ApiService {
        @GET
        suspend fun getRequest(
            @Url url: String,
            @QueryMap params: Map<String, String> = emptyMap()
        ): Any

        @POST
        suspend fun postRequest(
            @Url url: String,
            @Body body: RequestBody
        ): Any
    }

    private val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    // Fungsi untuk GET Request
    suspend fun get(link: String, params: Map<String, String> = emptyMap()): Result<Any> {
        return try {
            val response = apiService.getRequest(link, params)
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // Fungsi untuk POST Request
    suspend fun post(link: String, param: Map<String, Any>): Result<Any> {
        return try {
            // Konversi parameter ke JSON
            val json = Gson().toJson(param)
            val requestBody = json.toRequestBody("application/json".toMediaType())
            val response = apiService.postRequest(link, requestBody)
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}