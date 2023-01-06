package com.info.android100project

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.info.android100project.databinding.FragmentListBinding
import com.info.android100project.listener.UserClickListener

class ListFragment : Fragment(),UserClickListener {

    private lateinit var usrName:EditText
    private lateinit var usrSurname:EditText

    private lateinit var userAge:EditText

    private var lastId = 0L

    private val usersAdapter by lazy {

        //burda tapammiramki userin icine ne gonderim?
        UsersAdapter(this)

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
        userAge = binding.etUserAge
//        lastCreatedUserId = binding

        var adapter = usersAdapter

        binding.recItems.adapter = adapter
        binding.recItems.layoutManager = LinearLayoutManager(context)

        usersAdapter.updateList(list)



        binding.btnAdd.setOnClickListener {

            val ad = AlertDialog.Builder(binding.root.context, androidx.transition.R.style.Base_ThemeOverlay_AppCompat_Dialog_Alert)
            ad.setTitle("Bu sexs siyahiya elave olunacaq")
            ad.setIcon(R.drawable.logo)
            ad.setMessage("elave olunsunmu?")
            ad.setPositiveButton("Beli"){View,dialogInterface ->

                usersAdapter.addItem(Users(lastId++,usrName.text.toString(),usrSurname.text.toString(),userAge.text.toString().toInt()))

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

    override fun onClick(user: Users) {
        findNavController().navigate(ListFragmentDirections.listToDetailsfrgmnt(user))
//        arguments = Bundle().apply {
//            putSerializable("user",user)
//        }
    }

}