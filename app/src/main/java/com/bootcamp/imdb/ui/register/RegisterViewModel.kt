package com.bootcamp.imdb.ui.register

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import com.bootcamp.imdb.domain.remote.auth.AuthRepository
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.launch

class RegisterViewModel(private val repo: AuthRepository): ViewModel() {

    private val context: Context? = null
    private val _registerResponse = MutableLiveData<FirebaseUser?>()
    val registerResponse: LiveData<FirebaseUser?>
        get() = _registerResponse

    fun createUser(username: String, email: String, password: String){
        viewModelScope.launch {
            try {
                _registerResponse.value = repo.signUp(username, email, password)
            } catch (e: FirebaseAuthWeakPasswordException) {
                Toast.makeText(context, "No debe ser menor de 6 caracteres", Toast.LENGTH_SHORT).show()
            } catch (e: Exception){
                Log.d("RegisterViewModel", "error en createUser", e)
            }
        }
    }

    class RegisterViewModelFactory(private val repo: AuthRepository): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(AuthRepository::class.java).newInstance(repo)
        }
    }
}