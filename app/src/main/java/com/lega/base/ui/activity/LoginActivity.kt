package com.lega.base.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lega.base.R
import com.lega.base.core.extension.viewBinding
import com.lega.base.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityLoginBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}