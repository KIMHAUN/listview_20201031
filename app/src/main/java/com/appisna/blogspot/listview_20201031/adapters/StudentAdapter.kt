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

    //getView함수 오버라이딩 => 자동 작성되는 return문 삭제함.
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView
        if(tempRow == null){
            //현재 줄이 널일 때
            //inflate : xml을 data화??
            tempRow = inf.inflate(R.layout.student_list_item, null)
            //inf.inflate(R.layout.리스트아이템(한줄에 해당하는 파일, 부가정보는 없음.)
        }

        val row = tempRow!!
        //tempRow가 절대 null이 아니라면 대입하자.
        //완성된 row를 getView의 결과로 선정.

        return row
    }
}