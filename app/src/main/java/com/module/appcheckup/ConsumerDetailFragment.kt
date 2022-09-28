package com.module.appcheckup

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.module.appcheckup.databinding.FragmentConsumerDetailBinding


/**
 * A simple [Fragment] subclass.
 * Use the [ConsumerDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ConsumerDetailFragment : Fragment(R.layout.fragment_consumer_detail) {

    var binding: FragmentConsumerDetailBinding? = null
    val consumerArgs: ConsumerDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentConsumerDetailBinding.bind(view)
        val args = arguments

        // Via Bundle
        /*args?.let {
            val name = it.getString("name")
            val yob = it.getString("yob")
            name?.takeIf { it.isNotEmpty() }?.let {
                (activity as AppCompatActivity).supportActionBar?.title = "Welcome $it"
            }
            binding?.resultInfo?.text = buildString {
                append(name)
                append(" ")
                append(yob)
            }
        }*/

        //Via Safe-args -- Primitives
        /*consumerArgs.let {
            val name = it.vname
            val yob = it.vyob
            name.takeIf { it.length > 0 }?.let {
                (activity as AppCompatActivity).supportActionBar?.title = "Welcome $it"
            }
            binding?.resultInfo?.text = buildString {
                append("Safe-args ")
                append(name)
                append(" ")
                append(yob)
            }
        }*/

        //Via Parcelable Data Object
        consumerArgs.let {
            val dataObject = it.dataObj
            val name = dataObject.name
            val yob = dataObject.yob
            name.takeIf { it.length > 0 }?.let {
                (activity as AppCompatActivity).supportActionBar?.title = "Welcome $it"
            }
            binding?.resultInfo?.text = buildString {
                append("Safe-args-Parcel ")
                append(name)
                append(" ")
                append(yob)
            }
        }
    }
}
