package com.bootcamp.imdb.domain.remote.auth

import com.bootcamp.imdb.data.remote.dataSources.auth.AuthRemoteDataSource
import com.google.firebase.auth.FirebaseUser

class AuthRepositoryImpl (private val remoteDataSource: AuthRemoteDataSource): AuthRepository {

    override suspend fun signIn(email: String, password: String): FirebaseUser? = remoteDataSource.signIn(email, password)
    override suspend fun signUp(username: String, email: String, password: String): FirebaseUser? = remoteDataSource.signUp(username, email, password)
}