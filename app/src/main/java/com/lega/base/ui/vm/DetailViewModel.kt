package com.lega.base.ui.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lega.base.core.base.BaseViewModel
import com.lega.base.core.base.SingleEvent
import com.lega.base.domain.models.Personal
import com.lega.base.domain.models.User
import com.lega.base.domain.usecase.DeletePersonalUseCase
import com.lega.base.domain.usecase.GetLogInUseCase
import com.lega.base.domain.usecase.GetPersonalUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel  @Inject constructor(
    private val deletePersonalUseCase: DeletePersonalUseCase,
    private val personalIdUseCase: GetPersonalUseCase
) : BaseViewModel() {

    val TAG:String = "DetailViewModel"

    private val _persona = MutableLiveData<Personal>()
    val persona get() = _persona

    fun deletePersonal(userId: Int) {
        viewModelScope.launch {
            deletePersonalUseCase.execute(DeletePersonalUseCase.Params(userId))
                .onStart {  _loading.value = true }
                .onCompletion { _loading.value = false }
                .catch { _error.value = SingleEvent(it)  }
                .collect{  _persona.value = it }
        }
    }

    fun getPersonalId(userId: Int) {
        viewModelScope.launch {
            personalIdUseCase.execute(GetPersonalUseCase.Params(userId))
                .onStart {  _loading.value = true }
                .onCompletion { _loading.value = false }
                .catch {  _error.value = SingleEvent(it)  }
                .collect{ _persona.value = it}
        }
    }
}