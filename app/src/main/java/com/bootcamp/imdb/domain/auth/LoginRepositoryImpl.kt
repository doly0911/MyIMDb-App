package com.bootcamp.imdb.domain.auth

import com.bootcamp.imdb.data.remote.dataSources.auth.LoginDataSource
import com.google.firebase.auth.FirebaseUser

class LoginRepositoryImpl (private val dataSource: LoginDataSource): LoginRepository {

    override suspend fun signIn(email: String, password: String): FirebaseUser? = dataSource.signIn(email, password)
}