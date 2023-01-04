package com.info.android100project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.info.android100project.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding

    private val args by navArgs<DetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentDetailsBinding.inflate(inflater,container,false)



       binding.txtAge.text = args.user.age.toString()
        binding.txtName.text = args.user.name
        binding.txtSurname.text = args.user.surname
        binding.txtId.text = args.user.id.toString()
//        binding.txtSurname.text = args.toString()

        // Inflate the layout for this fragment


        binding.btnBack.setOnClickListener {
            requireActivity().onBackPressed()
        }

        return binding.root
    }





}