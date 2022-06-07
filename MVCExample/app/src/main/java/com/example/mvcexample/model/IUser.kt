package com.example.mvcexample.model

interface IUser {
    val email: String?
    val password: String?
    val isValid: Int
}