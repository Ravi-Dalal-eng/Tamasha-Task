package com.messaging.tamashatask.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.messaging.tamashatask.databinding.EmployeeItemBinding
import com.messaging.tamashatask.model.Employee


class EmployeeAdapter(private val employeeList:List<Employee>):
    RecyclerView.Adapter<EmployeeAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeAdapter.ViewHolder {
        val binding = EmployeeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val employee = employeeList[position]
        val visibility=employee.visibility
        holder.itemBinding.apply {
            id.setText("Id : ".plus(employee.id))
            name.setText(employee.employee_name)
            age.setText("Age : ".plus(employee.employee_age))
            salary.setText("Salary : ".plus(employee.employee_salary))
            salaryLayout.visibility= if(visibility) View.VISIBLE else View.GONE
            parentLayout.setOnClickListener {
                employee.visibility=!employee.visibility
                notifyItemChanged(position)
            }
        }

    }

    override fun getItemCount() = employeeList.size

    class ViewHolder(val itemBinding: EmployeeItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root)

}