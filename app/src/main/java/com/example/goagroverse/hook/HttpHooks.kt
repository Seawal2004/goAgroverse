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
            .baseUrl("http://192.168.1.77:5000/") // Use 10.0.2.2 for Android Emulator
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
            val mediaType = "application/json".toMediaType()
            val requestBody = json.toRequestBody(mediaType)
            val response = apiService.postRequest(link, requestBody)
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
