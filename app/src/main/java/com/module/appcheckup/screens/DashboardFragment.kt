package com.module.appcheckup.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.module.appcheckup.databinding.DashboardFragmentBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class DashboardFragment : Fragment() {

    private lateinit var binding: DashboardFragmentBinding
    private val dashboardViewModel: DashboardViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DashboardFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    /* References
    https://medium.com/androiddevelopers/a-safer-way-to-collect-flows-from-android-uis-23080b1f8bda
    https://medium.com/androiddevelopers/repeatonlifecycle-api-design-story-8670d1a7d333
    https://www.linkedin.com/pulse/kotlin-flow-simplified-paul-emeka?trk=public_profile_article_view
    https://logidots.com/insights/live-data-flow-shared-flow-state-flow-2/#:~:text=The%20main%20difference%20between%20a,and%20emits%20nothing%20by%20default.
    */

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btn1.setOnClickListener {
            //dashboardViewModel.setData(binding.inputTxt.text.toString())
            //dashboardViewModel.setDataStateFlow(binding.inputTxt.text.toString())
            dashboardViewModel.setDataSharedFlow(binding.inputTxt.text.toString())
        }

        /* dashboardViewModel.myData.observe(viewLifecycleOwner) {
             binding.tvLog.text = it
             Toast.makeText(context, "I'm in LiveData", Toast.LENGTH_SHORT).show()
         }*/

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                /* launch {
                     dashboardViewModel.updateData().collectLatest {
                         binding.tvLog.text = it.toString()
                     }
                 }*/

                /*launch {
                    dashboardViewModel.myDataStateFlow.collectLatest {
                        binding.tvLog.text = it
                        Toast.makeText(context, "I'm in StateFlow", Toast.LENGTH_SHORT).show()
                    }
                }*/

                launch {
                    dashboardViewModel.myDataSharedFlow.collectLatest {
                        binding.tvLog.text = it
                        Toast.makeText(context, "I'm in SharedFlow", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    companion object {
        fun newInstance() = DashboardFragment()
    }
}