package com.example.recviewanimation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recviewanimation.R
import com.example.recviewanimation.moduls.SubMember


class CustomSubAdapter(val context: Context,val subMember:List<SubMember>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.sub_custom_item,parent,false)
        return CustomSubViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       val (status) = subMember[position]
    }

    override fun getItemCount(): Int {
        return subMember.size
    }
    class CustomSubViewHolder(view: View):RecyclerView.ViewHolder(view)
}