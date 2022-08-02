package com.module.appcheckup.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import com.module.appcheckup.databinding.DashboardViewFragmentBinding

class DashboardViewFragment : Fragment() {

    lateinit var binding: DashboardViewFragmentBinding

    //private val dashboardViewModel: DashboardViewModel by viewModels()
    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DashboardViewFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel::class.java) // Deprecated
        //dashboardViewModel = ViewModelProvider(this).get(DashboardViewModel::class.java) // by viewModels()
        dashboardViewModel =
            ViewModelProvider(requireActivity()).get(DashboardViewModel::class.java) // by activityViewModels()
        dashboardViewModel.myData.observe(viewLifecycleOwner) {
            binding.tvLog.text = it
        }

        binding.tvLog.setOnClickListener {
            dashboardViewModel.setData("DVF:Resetting")
        }

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            /*  dashboardViewModel.updateData().collectLatest {
                  binding.tvLog.text = it.toString()
              }*/

            /*  dashboardViewModel.myDataFlow.collectLatest {
                  binding.tvLog.text = it
              }*/
        }
    }

    companion object {
        fun newInstance() = DashboardViewFragment()
    }
}