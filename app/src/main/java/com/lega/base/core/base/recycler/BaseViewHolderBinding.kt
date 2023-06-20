package com.lega.base.core.base.recycler

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.lega.base.BR
import com.lega.base.core.base.BaseViewModel

class BaseViewHolderBinding(val viewmodel: BaseViewModel?, val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item:Any?){
        binding.setVariable(BR.viewModel,viewmodel)
        binding.setVariable(BR.item, item)
        binding.executePendingBindings()
    }
}