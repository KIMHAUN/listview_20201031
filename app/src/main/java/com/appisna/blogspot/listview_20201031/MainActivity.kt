package com.appisna.blogspot.listview_20201031

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.appisna.blogspot.listview_20201031.adapters.StudentAdapter
import com.appisna.blogspot.listview_20201031.datas.Student
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //멤버변수
    val mStudentList = ArrayList<Student>();

    lateinit var mAdapter : StudentAdapter
    //어댑터는 멤버변수로 만드는 게 향후 코딩에 편리.
    //하지만 멤버변수로 만들 때 초기화하면 앱 실행시 튕김.
    // 멤버변수로 만들되, 초기화는 나중에 하는 이유.

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
        //객체화된 어댑터 변수를 리스트뷰 변수의 어댑터로 동작하게 지정
        //리스트뷰 변수.adapter = 어댑터 변수
        studentList.adapter = mAdapter

        studentList.setOnItemClickListener { parent, view, position, id ->
            //position : 눌린 위치가 어디인지 알려주는 역할
            //위치에 맞는 학생의 이름을 토스트 출력
            val clickedStudent = mStudentList[position]

            Toast.makeText(this, clickedStudent.name, Toast.LENGTH_SHORT).show()


        }

        studentList.setOnItemLongClickListener { parent, view, position, id ->
            //해당 줄을 길게 누르면 실행할 코드
            val longClickedStudent = mStudentList[position]

            Log.d("롱클릭 이벤트", longClickedStudent.name)
            Log.d("삭제 전 개수", mStudentList.size.toString())
            //Boolean 값으로 결과를 리턴 해야 함.(안한 상태에서는 에러 처리)
            //false일 때는 클릭 이벤트도 실행함

            //오래 눌린 학생을 목록에서 제거.
            //mStudentList.remove(longClickedStudent) //학생을 삭제하자.
            mStudentList.removeAt(position) // 해당 위치의 데이터 삭제

            //삭제 후 어댑터에게 변경사항 노티. 새로 반영 해라.(습관적으로 같이 적어주자).
            //lateinit var을 사용하는 이유.
            mAdapter.notifyDataSetChanged()

            Log.d("삭제 후 개수", mStudentList.size.toString())
            return@setOnItemLongClickListener true
        }



    }
}