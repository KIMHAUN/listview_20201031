package com.appisna.blogspot.listview_20201031.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.appisna.blogspot.listview_20201031.R
import com.appisna.blogspot.listview_20201031.datas.Student

class StudentAdapter(
    val mContext: Context,
    val resId: Int,
    val mList: ArrayList<Student>) : ArrayAdapter<Student>(mContext, resId, mList) {
    //ArrayAdapter는 기본 생성자 제공하지 않음. -> 생성자 커스터마이징
    //Student Adapter는 ArrayAdapter를 상속함.
    //class 어댑터클래스 이름(val mContext: Context, val resId: Int, val mList: ArrayList<Student(데이터 클래스)>

    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView
        if(tempRow == null){
            //현재 줄이 널일 때
            //inflate : xml
            tempRow = inf.inflate(R.layout.student_list_item, null)
        }

        val row = tempRow!!
        return row



    }



}