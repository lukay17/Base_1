package com.lega.base.ui.vm

import androidx.lifecycle.MutableLiveData
import com.lega.base.core.base.BaseViewModel
import com.lega.base.domain.usecase.AddPersonalUseCase
import com.lega.base.domain.usecase.UpdatePersonalUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddUpdateViewModel @Inject constructor(
    private val addPersonalUseCase: AddPersonalUseCase,
    private val updatePersonalUseCase: UpdatePersonalUseCase
) : BaseViewModel() {

    val TAG:String = "AddUpdateViewModel"

    val nombres = MutableLiveData("")
    val apellidos = MutableLiveData("")
    val cargo = MutableLiveData("")
    val bp = MutableLiveData("")

}