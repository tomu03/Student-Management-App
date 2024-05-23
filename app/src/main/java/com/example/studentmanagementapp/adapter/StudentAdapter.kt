package com.example.studentmanagementapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.studentmanagementapp.databinding.StduentListBinding
import com.example.studentmanagementapp.model.Student

class StudentAdapter(
    private val students: List<Student>,
    val onEdit: (Student) -> Unit,
    val onDelete: (String) -> Unit
) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    class StudentViewHolder(val binding: StduentListBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StudentAdapter.StudentViewHolder {
        return StudentViewHolder(
            StduentListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: StudentAdapter.StudentViewHolder, position: Int) {
        val student = students[position]
        Glide.with(holder.itemView.context).load(student.profileImage)
            .into(holder.binding.profileImage)
        holder.binding.fullNameTxt.text = student.fullName
        holder.binding.studentIdTxt.text = student.studentId
        holder.binding.subjectTxt.text = student.subject
        holder.binding.addressTxt.text = student.address
        holder.binding.emailTxt.text = student.email
        holder.binding.phoneTxt.text = student.phone

        holder.binding.editBtn.setOnClickListener {
            onEdit(student)
        }
        holder.binding.deleteBtn.setOnClickListener {
            onDelete(student.studentId)
        }
    }

    override fun getItemCount(): Int {
        return students.size
    }
}