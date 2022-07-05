package com.bootcamp.imdb.domain.remote.auth

import com.google.firebase.auth.FirebaseUser

interface LoginRepository {
    suspend fun signIn(email:String, password: String): FirebaseUser?
}