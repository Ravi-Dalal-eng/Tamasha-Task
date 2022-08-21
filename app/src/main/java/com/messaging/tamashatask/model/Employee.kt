package com.messaging.tamashatask.model


data class Employee(val id:Long,
                    val employee_name:String,
                    val employee_salary:Int,
                    val employee_age:Int,
                    val profile_image:String,
                    var visibility:Boolean=false)
