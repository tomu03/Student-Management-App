package com.example.studentmanagementapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.studentmanagementapp.model.Student
import com.example.studentmanagementapp.repository.StudentRepository

class StudentViewModels {
    private val repository = StudentRepository()

    private val _students = MutableLiveData<List<Student>>()
    val students :LiveData<List<Student>> get()= _students

    fun loadStudent(){
        repository.getStudents { students->
            _students.value  = students
         }
    }

    fun deleteStudent(studrntId : String){
        repository.deleteStudent(studrntId){ success ->
            if (success){
                loadStudent()
            }
        }
    }

    fun addStudent(student: Student, onComlete:(Boolean) -> Unit) {
        repository.addStudent(student) { success ->
           if (success){
               loadStudent()
           }
            onComlete(success)
        }
    }

    fun updateStudent(student: Student, onComlete:(Boolean) -> Unit) {
        repository.updateStudent(student) { success ->
            if (success){
                loadStudent()
            }
            onComlete(success)
        }
    }

}