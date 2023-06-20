package com.lega.base.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.lega.base.R
import com.lega.base.core.base.BaseFragmentDb
import com.lega.base.databinding.FragmentLoginBinding
import com.lega.base.domain.models.User
import com.lega.base.ui.utils.CustomSnackBar
import com.lega.base.ui.utils.CustomToast
import com.lega.base.ui.vm.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragmentDb<FragmentLoginBinding, LoginViewModel>() {

    override fun getLayout(): Int = R.layout.fragment_login
    override val viewModel: LoginViewModel by viewModels()
    var snackBar: CustomSnackBar = CustomSnackBar()

    override fun eventListeners() {}

    override fun setBindingLayout() {
        super.setBindingLayout()
        dataBinding.viewModel = viewModel
    }

    override fun observeViewModels() {
        viewModel.user.observe(viewLifecycleOwner, ::loginSucess)
    }

    override fun showError(message: String?) {
        snackBar.Image(requireView(), message.toString(), 2)
    }

    private fun loginSucess(user: User?) {
        if(user?.user != null && user?.user.trim().isEmpty()){
            CustomToast.Error(requireContext(),"Incorrect Username and / or Password, Please Verify and Try Again",1).show()
            //snackBar.Image(requireView(), "Incorrect Username and / or Password, Please Verify and Try Again", 4)
        }else {
            //Log.e("lega", "el Usuario es ${user?.user}")
            val directions = LoginFragmentDirections.actionLoginFragmentToMainActivity(user)
            navigate(directions)
        }
    }

}

