package com.example.studentmanagementapp.model

data class Student(
    val profileImage: String? ="",
    var fullName:String ="",
    var studentId:String = "",
    var subject:String = "",
    var address:String = "",
    var email:String = "",
    var phone:String = ""
)