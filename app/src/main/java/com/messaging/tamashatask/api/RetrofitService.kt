package com.messaging.tamashatask.api

import com.messaging.tamashatask.model.EmployeeList
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {
    @GET("employees")
    fun getEmployeeList(): Call<EmployeeList>

    companion object {

        var retrofitService: RetrofitService? = null

        fun getInstance(): RetrofitService {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://dummy.restapiexample.com/api/v1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}