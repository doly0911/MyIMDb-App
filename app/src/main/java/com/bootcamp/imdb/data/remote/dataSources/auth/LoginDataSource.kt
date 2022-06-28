package com.bootcamp.imdb.data.remote.dataSources.auth

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class LoginDataSource {
    suspend fun signIn(email:String, password: String): FirebaseUser? {
        val authUser = FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).await()
        return authUser.user
    }
}