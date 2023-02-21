package com.hfad.datianagrafici.fragments.list

import android.annotation.SuppressLint
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hfad.datianagrafici.R
import com.hfad.datianagrafici.data.User

//class che ha la funzione di adapter per il recycler view
class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()

    //gestore della view(layout)
    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row,parent,
            false))
    }

    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]

        holder.itemView.findViewById<TextView>(R.id.id_txt).text = currentItem.id.toString()
        holder.itemView.findViewById<TextView>(R.id.name_txt).text = currentItem.firstName
        holder.itemView.findViewById<TextView>(R.id.surname_txt).text = currentItem.lastName
        holder.itemView.findViewById<TextView>(R.id.age_txt).text = currentItem.age.toString()
        holder.itemView.findViewById<TextView>(R.id.city_txt).text = currentItem.cityBirth
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(user: List<User>){
        this.userList = user
        notifyDataSetChanged()
    }
}