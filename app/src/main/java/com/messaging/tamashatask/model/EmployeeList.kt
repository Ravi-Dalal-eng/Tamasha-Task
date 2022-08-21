package com.messaging.tamashatask.model

data class EmployeeList(val status:String,
                        val message:String,
                        val data:List<Employee>)