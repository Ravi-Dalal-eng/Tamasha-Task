package com.messaging.tamashatask.repository

import androidx.lifecycle.MutableLiveData
import com.messaging.tamashatask.api.RetrofitService
import com.messaging.tamashatask.model.Employee
import com.messaging.tamashatask.model.EmployeeList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository(private val retrofitService: RetrofitService) {

    val employeeList = MutableLiveData<MyResponse<EmployeeList>>()

    fun getemployeeList():MutableLiveData<MyResponse<EmployeeList>>{
         val response=retrofitService.getEmployeeList()
        response.enqueue(object : Callback<EmployeeList> {
            override fun onResponse(call: Call<EmployeeList>, response: Response<EmployeeList>) {
                employeeList.postValue(MyResponse.Success(response.body()))
            }

            override fun onFailure(call: Call<EmployeeList>, t: Throwable) {
                employeeList.postValue(MyResponse.Error(t.message.toString()))
            }
        })
    return employeeList
    }
}