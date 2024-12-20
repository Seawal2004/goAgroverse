package com.example.goagroverse.module

import com.example.goagroverse.model.User

data class LoginRequest(
    val username: String,
    val password: String
)


data class LoginResponse(
    val token: String,
    val user: User
)
