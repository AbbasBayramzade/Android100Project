package com.info.android100project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.info.android100project.databinding.ListItemBinding

class UsersAdapter(private var userList:ArrayList<Users>):RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    var onItemClick:((Users) ->Unit)? = null

    inner class ViewHolder(val holderBinding: ListItemBinding):RecyclerView.ViewHolder(holderBinding.root){

        /* val userName = v.findViewById<TextView>(R.id.txtname)
          val userSurname = v.findViewById<TextView>(R.id.txtusername)
          val userID = v.findViewById<TextView>(R.id.txtuserId)*/

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return  ViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var user = userList[position]
        holder.holderBinding.also {

            it.txtuserId.text = user.id.toString()
            it.txtname.text = user.name
            it.txtusername.text = user.surname
            it.txtuserage.text = user.age.toString()

        }

        holder.itemView.setOnClickListener {

            onItemClick?.invoke(user)

        }

    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun updateList(list: ArrayList<Users>){

        this.userList = list

        notifyDataSetChanged()

    }

    fun addItem(newUser:Users){
        userList.add(newUser)
        notifyItemInserted(userList.size - 1)
    }

}