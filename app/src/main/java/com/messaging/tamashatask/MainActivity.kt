package com.messaging.tamashatask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.messaging.tamashatask.adapter.EmployeeAdapter
import com.messaging.tamashatask.api.RetrofitService
import com.messaging.tamashatask.databinding.ActivityMainBinding
import com.messaging.tamashatask.model.Employee
import com.messaging.tamashatask.repository.MainRepository
import com.messaging.tamashatask.repository.MyResponse
import com.messaging.tamashatask.viewmodel.MainViewModel
import com.messaging.tamashatask.viewmodel.MyViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var employeeList: ArrayList<Employee>
    private lateinit var retrofitService: RetrofitService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initialize()

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = EmployeeAdapter(employeeList)

        viewModel.getemployeeList().observe(this, Observer {
            when (it) {
                is MyResponse.Success -> {
                    if (it.data != null) {
                        employeeList.addAll(it.data.data)
                        (binding.recyclerView.adapter as EmployeeAdapter).notifyDataSetChanged()
                    } else
                        Toast.makeText(this, "Too Many Requests...\nPlease try again...", Toast.LENGTH_LONG).show()
                }


                is MyResponse.Error -> {
                    Toast.makeText(this, "No Internet Connection...", Toast.LENGTH_LONG).show()
                }
                is MyResponse.Loading -> {}
            }

        })
    }
    private fun initialize() {
        employeeList= ArrayList()
        retrofitService=RetrofitService.getInstance()
        viewModel =
            ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService)))
                .get(MainViewModel::class.java)
    }
}