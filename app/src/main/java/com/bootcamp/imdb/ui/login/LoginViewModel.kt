package com.bootcamp.imdb.ui.login

import android.util.Log
import androidx.lifecycle.*
import com.bootcamp.imdb.data.remote.models.Auth
import com.bootcamp.imdb.domain.auth.LoginRepository
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.launch

class LoginViewModel(private val repo: LoginRepository): ViewModel() {

    private val _authResponse = MutableLiveData<FirebaseUser?>()
    val authResponse: LiveData<FirebaseUser?>
        get() = _authResponse

    fun signIn(email: String, password:String){
        viewModelScope.launch {
            try {
                _authResponse.value = repo.signIn(email, password)
            } catch (e: FirebaseAuthInvalidCredentialsException) {
                Log.d("LoginViewModel", "error: ", e)
            } catch (e : Exception){
                Log.e("LoginViewModel", "error: ", e)
            }
        }
    }

    class LoginViewModelFactory(private val repo: LoginRepository): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(LoginRepository::class.java).newInstance(repo)
        }
    }

}