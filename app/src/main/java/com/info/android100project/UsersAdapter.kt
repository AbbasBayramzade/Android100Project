package com.info.android100project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UsersAdapter:RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    var myList = arrayListOf<Users>()

    inner class ViewHolder(v:View):RecyclerView.ViewHolder(v){

       val userName = v.findViewById<TextView>(R.id.txtname)
        val userSurname = v.findViewById<TextView>(R.id.txtusername)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return  ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.apply {

            userName.text = myList[position].name
            userSurname.text = myList[position].surname

        }

    }

    override fun getItemCount(): Int {
        return myList.size
    }

    fun updateList(list: ArrayList<Users>){

        this.myList = list

    }

    fun addItem(newUser:Users){
        myList.add(newUser)
        notifyItemInserted(myList.size - 1)
    }

}