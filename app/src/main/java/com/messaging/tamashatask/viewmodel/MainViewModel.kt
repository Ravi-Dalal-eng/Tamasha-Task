package com.messaging.tamashatask.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.messaging.tamashatask.model.Employee
import com.messaging.tamashatask.model.EmployeeList
import com.messaging.tamashatask.repository.MainRepository
import com.messaging.tamashatask.repository.MyResponse

class MainViewModel(private val repository: MainRepository) : ViewModel() {

    fun getemployeeList():MutableLiveData<MyResponse<EmployeeList>>{
       return repository.getemployeeList()


    }
}

