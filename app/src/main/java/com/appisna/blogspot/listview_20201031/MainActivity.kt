package com.appisna.blogspot.listview_20201031

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.appisna.blogspot.listview_20201031.datas.Student

class MainActivity : AppCompatActivity() {
    //멤버변수
    val mStudentList = ArrayList<Student>();



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mStudentList.add(Student("김하은", "구로", 1995))
        mStudentList.add(Student("구본아", "용산", 1991))
        mStudentList.add(Student("조경진", "은평", 1988))
        mStudentList.add(Student("박성윤", "연수", 1996))
        mStudentList.add(Student("조윤주", "구로", 1996))





    }
}