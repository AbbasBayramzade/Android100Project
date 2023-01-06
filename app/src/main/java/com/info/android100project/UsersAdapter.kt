package com.info.android100project

import android.text.Html
import android.text.SpannableStringBuilder
import android.text.SpannedString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import androidx.core.text.color
import androidx.core.text.italic
import androidx.recyclerview.widget.RecyclerView
import com.info.android100project.databinding.ListItemBinding
import com.info.android100project.listener.UserClickListener
import kotlin.contracts.contract

class UsersAdapter(private val userClickListener: UserClickListener):RecyclerView.Adapter<UsersAdapter.ViewHolder>() {


    var myList = arrayListOf<Users>()

    inner class ViewHolder(val binding: ListItemBinding):RecyclerView.ViewHolder(binding.root){

       /*val userName = v.findViewById<TextView>(R.id.txtname)
        val userSurname = v.findViewById<TextView>(R.id.txtusername)
        val userIdddd = v.findViewById<TextView>(R.id.txt_item_age)
        val */

     /*   init {
            itemView.setOnClickListener {

                listener.onItemClick(adapterPosition)

            }
        }*/

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent,false)

        return  ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = myList[position]

        holder.binding.apply {

            txtname.text = "Ad: ${item.name}"
            txtusername.text = "Soyad: ${item.surname}"

            val s = "Yaş: <b>${item.age} </b>"

            txtItemAge.text = HtmlCompat.fromHtml(s,HtmlCompat.FROM_HTML_MODE_LEGACY)
            txtItemId.text = "id: ${item.id.toString()}"

        }

        holder.itemView.setOnClickListener {

           userClickListener.onClick(item)

        }

    }




    override fun getItemCount(): Int {
        return myList.size
    }

    fun updateList(list: ArrayList<Users>){

        this.myList = list

        notifyDataSetChanged()

    }

    fun addItem(newUser:Users){
        myList.add(newUser)
        notifyItemInserted(myList.size - 1)
    }




}