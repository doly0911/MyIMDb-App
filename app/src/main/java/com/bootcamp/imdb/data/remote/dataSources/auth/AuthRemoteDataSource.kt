package com.bootcamp.imdb.data.remote.dataSources.auth

import com.bootcamp.imdb.data.remote.models.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class AuthRemoteDataSource {
    suspend fun signIn(email:String, password: String): FirebaseUser? {
        return withContext(Dispatchers.IO){
            val authUser = FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).await()
            authUser.user
        }
    }

    suspend fun signUp(username:String, email:String, password: String): FirebaseUser? {
        return  withContext(Dispatchers.IO) {
            val registerUser = FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).await()
            registerUser.user?.uid?.let {uid ->
                FirebaseFirestore.getInstance().collection("users").document(uid).set(User(username, email, "fotoUrl.png")).await()
            }
            registerUser.user
        }
    }
}