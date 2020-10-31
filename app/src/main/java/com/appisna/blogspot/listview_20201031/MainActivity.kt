package com.appisna.blogspot.listview_20201031

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.appisna.blogspot.listview_20201031.adapters.StudentAdapter
import com.appisna.blogspot.listview_20201031.datas.Student
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //멤버변수
    val mStudentList = ArrayList<Student>();

    lateinit var mAdapter : StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mStudentList.add(Student("김하은", "구로", 1995))
        mStudentList.add(Student("구본아", "용산", 1991))
        mStudentList.add(Student("조경진", "은평", 1988))
        mStudentList.add(Student("박성윤", "연수", 1996))
        mStudentList.add(Student("조윤주", "구로", 1996))
        mStudentList.add(Student("아이유", "강남", 1993))
        mStudentList.add(Student("박보검", "도봉", 1993))
        mStudentList.add(Student("차은우", "금천", 1997))
        mStudentList.add(Student("박보영", "철원", 1990))
        mStudentList.add(Student("유세윤", "안산", 1997))
        mStudentList.add(Student("장윤주", "화성", 1990))

        //context : 어떤 화면인가? 어떤 화면에서 이 어뎁터를 쓰는가
        //resId : res폴더. 숫자 변환됨.
        //mList : 어떤 목록을 뿌릴건가요?
        mAdapter = StudentAdapter(this, R.layout.student_list_item, mStudentList)

        //이 어뎁터 xml과 연결하기
        studentList.adapter = mAdapter



    }
}