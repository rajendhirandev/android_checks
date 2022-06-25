package com.module.appcheckup.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.module.appcheckup.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding
    //private val dashboardViewModel: DashboardViewModel by viewModels() // test purpose

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            updateFragment(DashboardFragment.newInstance())
        }

        binding.btn2.setOnClickListener {
            updateFragment(DashboardViewFragment.newInstance())
        }

        /* lifecycleScope.launch {
             repeatOnLifecycle(Lifecycle.State.STARTED) {

             }
         }

         dashboardViewModel.myData.observe(this) {

         }*/
    }

    fun updateFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(binding.container.id, fragment)
            commit()
        }
    }
}
