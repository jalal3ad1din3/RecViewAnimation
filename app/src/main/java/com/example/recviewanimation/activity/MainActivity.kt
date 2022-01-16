package com.example.recviewanimation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recviewanimation.R
import com.example.recviewanimation.adapter.CustomAdapter
import com.example.recviewanimation.moduls.Member
import com.example.recviewanimation.moduls.SubMember
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

        val members = prepareMemberList()
        refreshAdapter(members)

    }

    private fun initView(){
        recyclerView.layoutManager = GridLayoutManager(this,1)

        val animation = AnimationUtils.loadLayoutAnimation(this,R.anim.layout_anim_buttom)
        recyclerView.layoutAnimation = animation
    }

    fun refreshAdapter(members: List<Member>){
        val adapter = CustomAdapter(this,members)
        recyclerView.adapter = adapter
    }

    fun prepareMemberList(): List<Member>{
        val member = ArrayList<Member>()

        for(i in 0..15){
            if(i == 3||i == 8||i==13){
                member.add(Member("Jalal"+i,"bin Dilshod"+i,prepareSubMember()))
            } else {
                member.add(Member("Kamor"+i,"Tumor"+i,ArrayList<SubMember>()))
            }
        }
        return member
    }


    fun prepareSubMember():List<SubMember>{

        val members = ArrayList<SubMember>()
        for(i in 0..5){
            members.add(SubMember("offline"))
        }
        return members
    }
}