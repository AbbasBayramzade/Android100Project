package com.info.android100project.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.info.android100project.Users
import com.info.android100project.dialog.FragmentAddDialogBinding

class AddDialogFragment: DialogFragment(){

    var id:Long = 0
    private lateinit var binding: FragmentA

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAddDialogBinding.inflate(inflater,container,false)

        binding.addBtn.setOnClickListener {

            var listener = requireArguments().getSerializable("AddDialogListener")!! as AddDialogClickListener

            listener.onAddClick(

                user = Users(
                    null,binding.nameEditTxt.text.toString(),
                    binding.surnameEditTxt.text.toString(),
                    binding.ageEditTxt.text.toString().toInt()
                )

            )

            dismiss()

        }

        return binding.root
    }


}

fun interface AddDialogClickListener:java.io.Serializable{
    fun onAddClick(user: Users)
}