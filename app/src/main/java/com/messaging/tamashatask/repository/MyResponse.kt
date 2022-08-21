package com.messaging.tamashatask.repository

import com.messaging.tamashatask.model.EmployeeList

sealed class MyResponse<T>(val data: T?=null, val errorMessage:String?=null){
    class Loading<T>:MyResponse<T>()
    class Success<T>(data: T? = null):MyResponse<T>(data = data)
    class Error<T>(errorMessage: String):MyResponse<T>(errorMessage = errorMessage)
}