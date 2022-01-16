package com.example.recviewanimation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recviewanimation.R
import com.example.recviewanimation.moduls.Member
import com.example.recviewanimation.moduls.SubMember

class CustomAdapter(val context: Context,val member: List<Member>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        private val TYPE_ITEM_VIEW = 0
        private val TYPE_ITEM_LIST = 1
    }
    override fun getItemViewType(position: Int): Int {
        return if (member[position].memberSub.isNotEmpty()) TYPE_ITEM_LIST else TYPE_ITEM_VIEW
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == TYPE_ITEM_LIST){
            val header = LayoutInflater.from(parent.context).inflate(R.layout.inner_recycler,parent,false)
            return CustomListHolder(header)

        }
        val footer = LayoutInflater.from(parent.context).inflate(R.layout.custom_item_layout,parent,false)
        return CustomViewHolder(footer)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val member = member[position]

        if (holder is CustomViewHolder){
            holder.name.text = member.name
            holder.lastname.text = member.lastname
        }
        if (holder is CustomListHolder){
            val recyclerView = holder.recyclerView

            val memberSub = member.memberSub
            refreshSubAdapter(recyclerView,memberSub)
        }

    }


    override fun getItemCount(): Int {
        return member.size
    }
    class CustomViewHolder(view: View):RecyclerView.ViewHolder(view){

        val name = view.findViewById<TextView>(R.id.name)
        val lastname = view.findViewById<TextView>(R.id.lastname)

    }
    class CustomListHolder(view:View):RecyclerView.ViewHolder(view){
        var recyclerView:RecyclerView = view.findViewById(R.id.inner_recycler)
    }
    fun refreshSubAdapter(recyclerView: RecyclerView,subMember: List<SubMember>){
        val adapter = CustomSubAdapter(context,subMember)
        recyclerView.adapter = adapter
}
}