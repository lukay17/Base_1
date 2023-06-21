package com.lega.base.ui.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
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
    var dialog: Dialog? = null

    override fun eventListeners() {
        dataBinding.buttonSuccess.setOnClickListener {
            showSuccessDialog()
        }
        dataBinding.buttonError.setOnClickListener {
            showErrorDialog()
        }
        dataBinding.buttonWarning.setOnClickListener {
            showWarningDialog()
        }
    }

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
        if (user?.user != null && user?.user.trim().isEmpty()) {
            CustomToast.Error(requireContext(),
                "Incorrect Username and / or Password, Please Verify and Try Again",
                1).show()
            //snackBar.Image(requireView(), "Incorrect Username and / or Password, Please Verify and Try Again", 4)
        } else {
            //Log.e("lega", "el Usuario es ${user?.user}")
            val directions = LoginFragmentDirections.actionLoginFragmentToMainActivity(user)
            navigate(directions)
        }
    }

    private fun showSuccessDialog() {
        val builder = AlertDialog.Builder(requireContext(),  R.style.AlertDialogTheme)
        val view: View = LayoutInflater.from(requireContext()).inflate(
            R.layout.layout_success_dialog,
            view?.findViewById(R.id.layoutDialogContainer) as ConstraintLayout?
        )
        builder.setView(view)
        (view.findViewById<View>(R.id.textTitle) as TextView).text =
            resources.getString(R.string.success_title)
        (view.findViewById<View>(R.id.textMessage) as TextView).text =
            resources.getString(R.string.dummy_text)
        (view.findViewById<View>(R.id.buttonAction) as Button).setText(resources.getString(R.string.okay))
        (view.findViewById<View>(R.id.imageIcon) as ImageView).setImageResource(R.drawable.done)
        val alertDialog = builder.create()
        view.findViewById<View>(R.id.buttonAction).setOnClickListener {
            alertDialog.dismiss()
            Toast.makeText(requireContext(), "Success", Toast.LENGTH_SHORT).show()
        }
        if (alertDialog.window != null) {
            alertDialog.window!!.setBackgroundDrawable(ColorDrawable(0))
        }
        alertDialog.show()
    }

    private fun showWarningDialog() {
        val builder = AlertDialog.Builder(requireContext(), R.style.AlertDialogTheme)
        val view: View = LayoutInflater.from(requireContext()).inflate(
            R.layout.layout_warning_dialog,
            view?.findViewById(R.id.layoutDialogContainer) as ConstraintLayout?
        )
        builder.setView(view)
        (view.findViewById<View>(R.id.textTitle) as TextView).text =
            resources.getString(R.string.warning_title)
        (view.findViewById<View>(R.id.textMessage) as TextView).text =
            resources.getString(R.string.dummy_text)
        (view.findViewById<View>(R.id.buttonYes) as Button).text =
            resources.getString(R.string.yes)
        (view.findViewById<View>(R.id.buttonNo) as Button).text =
            resources.getString(R.string.no)
        (view.findViewById<View>(R.id.imageIcon) as ImageView).setImageResource(R.drawable.warning)
        val alertDialog = builder.create()
        view.findViewById<View>(R.id.buttonYes).setOnClickListener {
            alertDialog.dismiss()
            Toast.makeText(requireContext(), "Yes", Toast.LENGTH_SHORT).show()
        }
        view.findViewById<View>(R.id.buttonNo).setOnClickListener {
            alertDialog.dismiss()
            Toast.makeText(requireContext(), "No", Toast.LENGTH_SHORT).show()
        }
        if (alertDialog.window != null) {
            alertDialog.window!!.setBackgroundDrawable(ColorDrawable(0))
        }
        alertDialog.show()
    }

    private fun showErrorDialog() {
        val builder = AlertDialog.Builder(requireContext(), R.style.AlertDialogTheme)
        val view: View = LayoutInflater.from(requireContext()).inflate(
            R.layout.layout_error_dialog,
            view?.findViewById(R.id.layoutDialogContainer) as ConstraintLayout?
        )
        builder.setView(view)
        (view.findViewById<View>(R.id.textTitle) as TextView).text =
            resources.getString(R.string.error_title)
        (view.findViewById<View>(R.id.textMessage) as TextView).text =
            resources.getString(R.string.dummy_text)
        (view.findViewById<View>(R.id.buttonAction) as Button).text =
            resources.getString(R.string.okay)
        (view.findViewById<View>(R.id.imageIcon) as ImageView).setImageResource(R.drawable.error)
        val alertDialog = builder.create()
        view.findViewById<View>(R.id.buttonAction).setOnClickListener {
            alertDialog.dismiss()
            Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
        }
        if (alertDialog.window != null) {
            alertDialog.window!!.setBackgroundDrawable(ColorDrawable(0))
        }
        alertDialog.show()
    }

}


