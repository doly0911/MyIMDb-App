package com.bootcamp.imdb.domain.remote.auth

import com.bootcamp.imdb.data.remote.dataSources.auth.LoginRemoteDataSource
import com.google.firebase.auth.FirebaseUser

class LoginRepositoryImpl (private val remoteDataSource: LoginRemoteDataSource): LoginRepository {

    override suspend fun signIn(email: String, password: String): FirebaseUser? = remoteDataSource.signIn(email, password)
}