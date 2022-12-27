package com.info.android100project

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.info.android100project.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private lateinit var usrName:EditText
    private lateinit var usrSurname:EditText

    private val usersAdapter by lazy {

        UsersAdapter()

    }

    var list = arrayListOf<Users>()

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentListBinding.inflate(inflater,container,false)

        usrName = binding.edtTxtName
        usrSurname = binding.edtTxtSurname

        binding.recItems.adapter = usersAdapter
        binding.recItems.layoutManager = LinearLayoutManager(context)

        usersAdapter.updateList(list)

        binding.btnAdd.setOnClickListener {

            val ad = AlertDialog.Builder(binding.root.context, androidx.transition.R.style.Base_ThemeOverlay_AppCompat_Dialog_Alert)
            ad.setTitle("Bu sexs siyahiya elave olunacaq")
            ad.setIcon(R.drawable.logo)
            ad.setMessage("elave olunsunmu?")
            ad.setPositiveButton("Beli"){View,dialogInterface ->

                usersAdapter.addItem(Users(usrName.text.toString(),usrSurname.text.toString()))

            }

            ad.setNegativeButton("Xeyr"){View,dialogInterface ->
                findNavController().popBackStack()
            }

            ad.setCancelable(false)
            ad.create().show()

//
        }

        // Inflate the layout for this fragment
        return binding.root
    }


}