package com.bootcamp.imdb.data.remote.dataSources.auth

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await

class AuthRemoteDataSource {
    suspend fun signIn(email:String, password: String): FirebaseUser? {
        val authUser = FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).await()
        return authUser.user
    }

    suspend fun signUp(username:String, email:String, password: String): FirebaseUser? {
        val registerUser = FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).await()
        return registerUser.user
    }
}