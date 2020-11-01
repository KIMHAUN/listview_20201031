package com.appisna.blogspot.listview_20201031.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.appisna.blogspot.listview_20201031.R
import com.appisna.blogspot.listview_20201031.datas.Student
import java.util.*
import kotlin.collections.ArrayList

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

        var tempRow = convertView //null일 가능성 있음. View?의 ?도 같이온다.
        //돌려막기 할 게 없을 때 inflate(그린다)! 있을 때는 안한다. => OOM 방지
        if(tempRow == null){ //null처리
            //현재 줄이 널일 때
            //inflate : xml을 data화??
            tempRow = inf.inflate(R.layout.student_list_item, null)
            //inf.inflate(R.layout.리스트아이템(한줄에 해당하는 파일, 부가정보는 없음.)
        }

        val row = tempRow!!
        //tempRow가 절대 null이 아니니까 대입하자.
        //완성된 row를 getView의 결과로 선정.
        //row가 바로 결과가 되지 말고 가공을 거친 후에 결과가 되게 하자.(row변수에 담겨있는 xml기반 객체의 내용물을 변경해주자.


        val nameTxt = row.findViewById<TextView>(R.id.nameTxt);
        val ageTxt = row.findViewById<TextView>(R.id.ageTxt);
        val addressTxt = row.findViewById<TextView>(R.id.addressTxt);

        //뿌려줄 근거 데이터
        val studentData = mList[position]

        nameTxt.text = studentData.name
        addressTxt.text = studentData.address
        //생년을 가지고 그대로 찍으면 오류. 나이로 변환해야 함. 2020년 나이.
        var age = 2020 - studentData.birthYear + 1

        //앱을 킨 시점 나이 구하기
        val now = Calendar.getInstance()
        age = now.get(Calendar.YEAR) - studentData.birthYear + 1
        ageTxt.text = "${age}세"

        return row
    }

    fun sumTwoNumbers(param1 :Int, param2: Int): Int {
        return param1 + param2
    }
}
