package com.team.mvvmstructure

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //  private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //   navController=Navigation.findNavController(this,R.id.nav_host_fragment)
    }

    /* override fun onSupportNavigateUp(): Boolean {
         return NavigationUI.navigateUp(navController,null )
     }*/

}