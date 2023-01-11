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
import com.info.android100project.dialog.AddDialogClickListener
import com.info.android100project.dialog.AddDialogFragment

class ListFragment : Fragment(), AddDialogClickListener {

    /*private lateinit var usrName:EditText
    private lateinit var usrSurname:EditText
    private lateinit var usrAge:EditText

    private val usersAdapter by lazy {

        UsersAdapter()

    }*/

    lateinit var binding:FragmentListBinding

    var lastId = 0L

    private lateinit var addDialogF: AddDialogFragment
    private lateinit var adapter:UsersAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentListBinding.inflate(inflater,container,false)

        adapter = UsersAdapter(arrayListOf())

        adapter.onItemClick = {

            val action = ListFragmentDirections.listToDetailsfrgmnt()
            findNavController().navigate(action)

        }

        binding.recItems.adapter = adapter
        binding.recItems.apply {

            adapter = this@ListFragment.adapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)

        }

        binding.btnAdd.setOnClickListener {

            val args = Bundle()

            args.putSerializable("AddDialogClickListener",this)
            addDialogF = AddDialogFragment()
            addDialogF.arguments = args
            addDialogF.show(childFragmentManager,"AddDialog")

//
        }

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onAddClick(user: Users) {
        adapter.addItem(user.also {
            it.id = lastId++
        })
    }


}