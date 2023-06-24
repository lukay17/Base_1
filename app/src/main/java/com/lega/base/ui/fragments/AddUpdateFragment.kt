package com.lega.base.ui.fragments

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.lega.base.R
import com.lega.base.core.base.BaseFragmentDb
import com.lega.base.databinding.FragmentAddUpdateBinding
import com.lega.base.ui.vm.AddUpdateViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddUpdateFragment: BaseFragmentDb<FragmentAddUpdateBinding, AddUpdateViewModel>() {

    override fun getLayout(): Int = R.layout.fragment_detail
    override val viewModel: AddUpdateViewModel by viewModels()
    val TAG: String = "AddUpdateFragement"
    val args: AddUpdateFragmentArgs by navArgs()

    override fun eventListeners(){
        dataBinding.btnBack.setOnClickListener{
            val directions = AddUpdateFragmentDirections.toDetailFragment(args.personal)
            navigate(directions)
        }

    }

    override fun observeViewModels(){

    }

    override fun initViewModels(){
        val nombre:String = args.personal.nombres
        Log.e(TAG, args.personal.nombres.toString())
    }


}
