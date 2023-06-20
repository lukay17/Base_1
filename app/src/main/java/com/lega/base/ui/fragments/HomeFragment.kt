package com.lega.base.ui.fragments

import android.util.Log
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import com.lega.base.R
import com.lega.base.core.base.BaseFragmentDb
import com.lega.base.core.base.recycler.BaseRvAdapter
import com.lega.base.data.response.Persona
import com.lega.base.databinding.FragmentHomeBinding
import com.lega.base.domain.models.Personal
import com.lega.base.ui.utils.CustomSnackBar
import com.lega.base.ui.utils.CustomToast
import com.lega.base.ui.vm.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragmentDb<FragmentHomeBinding, HomeViewModel>() {

    override val viewModel: HomeViewModel by viewModels()
    override fun getLayout(): Int  = R.layout.fragment_home
    var snackBar: CustomSnackBar = CustomSnackBar()
    val TAG:String = "HomeFragement"

    private val adapter by lazy {
        BaseRvAdapter<Personal>(R.layout.item_personal_list){ personal ->
            personal?.let {
                viewModel.getPersonalId(it.id)
               // snackBar.Image(requireView(), "Has seleccionado a " +it.id + " " + it.nombres + " " + it.apellidos, 2)
            }
        }
    }

    override fun eventListeners() {
        dataBinding.personalRv.adapter = adapter

            dataBinding.filterPersonal.addTextChangedListener {personalFilter ->
                if(dataBinding.filterPersonal.getText().toString().isEmpty()){
                    initViewModels()
                }else {
                    val personalFiltered = adapter.items.filter { personal ->
                        personal.apellidos.lowercase()
                            .contains(personalFilter.toString().lowercase())
                    }
                    adapter.updateAdapter(personalFiltered)
                }
            }
    }

    override fun initViewModels() {
        viewModel.emptyPersonalList()
        viewModel.loadPersonalList()
    }

    override fun observeViewModels() {
        viewModel.personalList.observe(viewLifecycleOwner){
            adapter.items = it
        }

        viewModel.persona.observe(viewLifecycleOwner, ::personaSucess)
    }

    private fun personaSucess(persona: Personal?) {
        if(persona == null && persona?.id!! < 1){
            CustomToast.Error(requireContext(),"Error, Please Try Again",1).show()
        }else {
           val directions = HomeFragmentDirections.toDetailFragment(persona)
            navigate(directions)
        }
        //Log.e(TAG, persona?.nombres.toString() + ' ' + persona?.apellidos.toString())
    }

}




