package com.lega.base.ui.vm

import android.util.Log
import androidx.lifecycle.*
import com.lega.base.core.base.BaseViewModel
import com.lega.base.core.base.SingleEvent
import com.lega.base.domain.models.User
import com.lega.base.domain.usecase.GetLogInUseCase
import com.lega.base.ui.utils.CustomSnackBar
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEmpty
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel  @Inject constructor(
    private val getLogInUseCase: GetLogInUseCase
) : BaseViewModel() {

    val TAG:String = "LoginViewModel"

    val username = MutableLiveData("")
    val password = MutableLiveData("")

    private val _user = MutableLiveData<User>()
    val user get() = _user

    fun logIn() {
        viewModelScope.launch {
            getLogInUseCase.execute(GetLogInUseCase.Params(username.value?:"",password.value?:""))
                .onStart { _loading.value = true }
                .onCompletion { _loading.value = false }
                .catch { _error.value = SingleEvent(it) }
                .collect{ _user.value = it}
        }
    }
}