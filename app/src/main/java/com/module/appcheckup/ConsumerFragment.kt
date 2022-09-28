package com.module.appcheckup

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.module.appcheckup.databinding.FragmentConsumerBinding

/**
 * A simple [Fragment] subclass.
 * Use the [ConsumerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ConsumerFragment : Fragment(R.layout.fragment_consumer) {
    lateinit var binding: FragmentConsumerBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentConsumerBinding.bind(view)
        setListeners()
    }

    private fun setListeners() {
        binding.apply {
            this.eligibleChkBtn.setOnClickListener {
                val consumerName = this.consumerNameInputEdit.text.toString()
                val consumerYoB = this.consumerYobInputEdit.text.toString()
                val bundleData = bundleOf("name" to consumerName, "yob" to consumerYoB)

                if (consumerName.isNotEmpty() && consumerYoB.isNotEmpty()) {
                    //Through Bundle
                    //findNavController().navigate(R.id.action_consumer_to_detail_fragment, bundleData)

                    // Safe-args
                    /*val action = ConsumerFragmentDirections.actionConsumerToDetailFragment(
                        consumerName, consumerYoB)
                    findNavController().navigate(action)*/

                    //Parcelize Data Object
                    val action = ConsumerFragmentDirections.actionConsumerToDetailFragment(
                        consumerName, consumerYoB, ConsumerData(consumerName, consumerYoB)
                    )
                    findNavController().navigate(action)
                } else {
                    Toast.makeText(
                        activity, "Name and Year of Birth is mandatory", Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}