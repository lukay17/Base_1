package com.lega.base.ui.activity

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.navArgs
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.firebase.auth.FirebaseAuth
import com.lega.base.R
import com.lega.base.core.extension.viewBinding
import com.lega.base.databinding.ActivityMainBinding
import com.lega.base.ui.fragments.LoginFragmentDirections
import com.lega.base.ui.utils.CustomSnackBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)
    private val TAG:String = "MainActivity"
   val args:MainActivityArgs by navArgs()
    var snackBar: CustomSnackBar = CustomSnackBar()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding?.root)

       val bundle:Bundle? = intent.extras

        if(bundle != null){
            //snackBar.Image(binding.navHostMain, "Bienvenido " + args.user?.user, 2)
            snackBar.Image(binding.navHostMain, "Bienvenido ", 2)
        }

    }
}