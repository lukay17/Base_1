package com.lega.base.ui.fragments

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.lega.base.R
import com.lega.base.R.layout
import com.lega.base.core.base.BaseFragmentDb
import com.lega.base.core.extension.loadImage
import com.lega.base.databinding.FragmentDetailBinding
import com.lega.base.domain.models.Personal
import com.lega.base.ui.utils.CustomToast
import com.lega.base.ui.vm.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment: BaseFragmentDb<FragmentDetailBinding, DetailViewModel>() {

    override fun getLayout(): Int = layout.fragment_detail
    override val viewModel: DetailViewModel by viewModels()
    val TAG:String = "DetailFragement"
    val args: DetailFragmentArgs by navArgs()
    var dialog: Dialog? = null


    override fun eventListeners() {
        dataBinding.btnBack.setOnClickListener {
            val directions = DetailFragmentDirections.toPersonalList()
            navigate(directions)
        }

        dataBinding.btnDelete.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Importante")
                .setMessage("Seguro desea emilinar el registro?")
                .setNegativeButton("No"){dialog, wich->
                    CustomToast.Error(requireContext(),"Solicitud Cancelada !!!",1).show()
                }
                .setPositiveButton("Si"){dialog, wich->
                    CustomToast.Success(requireContext(),"Registro Eliminado",1).show()
                    viewModel.deletePersonal(args.personal.id)
                    val directions = DetailFragmentDirections.toPersonalList()
                    navigate(directions)
                }
                .show()
        }

        dataBinding.btnUpdate.setOnClickListener {
            //openwinDialog()
            //openloseDialog()
            //viewModel.getPersonalId(args.personal.id)
            val directions1 = DetailFragmentDirections.toAddUpdateFragment(args.personal)
            navigate(directions1)
        }
    }

    override fun observeViewModels() {
        viewModel.persona.observe(viewLifecycleOwner, ::personaSucess)
    }

    override fun initViewModels() {
        with(dataBinding) {
            val drawable = resources.getDrawable(R.drawable.person1)
            personalImg.loadImage(args.personal.img, drawable)
            personalName.setText(args.personal.nombres.toString() + ' ' + args.personal.apellidos.toString())
            personalCargo.setText(args.personal.cargo.toString())
            personalEstacion.setText(args.personal.estacion.toString())
            personalBp.setText(args.personal.bp.toString())
        }
    }

    override fun showError(message: String?) {}

    private fun personaSucess(persona: Personal?) {
        if(persona == null && persona?.id!! < 1){
            CustomToast.Error(requireContext(),"Error, Please Try Again",1).show()
        }else {
            val directions = DetailFragmentDirections.toAddUpdateFragment(persona)
            navigate(directions)
        }
    }

    fun openloseDialog(){
        dialog?.setContentView(R.layout.lose_layout_dialog)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val imageViewClose:ImageView
        imageViewClose = dialog?.findViewById(R.id.image_close)!!
        val btn_OK:Button
        btn_OK = dialog?.findViewById(R.id.btn_ok)!!

        imageViewClose.setOnClickListener {
            dialog?.dismiss()
            CustomToast.Error(requireContext(),"cerro dialog",1).show()
        }
        btn_OK.setOnClickListener {
            dialog?.dismiss()
            CustomToast.Error(requireContext(),"cerro OK",1).show()
        }

        dialog!!.show()
    }

    fun openwinDialog(){
            dialog?.setContentView(R.layout.win_layout_dialog)
            dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            val imageViewClose:ImageView
            imageViewClose = dialog?.findViewById(R.id.image_close)!!
            val btn_OK:Button
            btn_OK = dialog?.findViewById(R.id.btn_ok)!!

        imageViewClose.setOnClickListener {
            dialog?.dismiss()
            CustomToast.Error(requireContext(),"cerro dialog",1).show()
        }
        btn_OK.setOnClickListener {
            dialog?.dismiss()
            CustomToast.Error(requireContext(),"cerro OK",1).show()
        }

        dialog!!.show()

    }
}

