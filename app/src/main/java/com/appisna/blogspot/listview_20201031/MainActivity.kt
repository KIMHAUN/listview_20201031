package com.appisna.blogspot.listview_20201031

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.appisna.blogspot.listview_20201031.adapters.StudentAdapter
import com.appisna.blogspot.listview_20201031.datas.Student
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //멤버변수
    val mStudentList = ArrayList<Student>(); // 객체화

    lateinit var mAdapter : StudentAdapter
    //어댑터는 멤버변수로 만드는 게 향후 코딩에 편리.
    //하지만 멤버변수로 만들 때 초기화하면 앱 실행시 튕김.
    // 멤버변수로 만들되, 초기화는 나중에 하는 이유.
    
    var REQ_FOR_STUDENT_INFO = 1000

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

            //정말로 삭제할지 묻기 => 경고창을 만들어서 띄워주자.
            //확인이 눌렸을 때만 제거.
            val alert = AlertDialog.Builder(this)
            alert.setTitle("학생 명부 삭제")
            alert.setMessage("정말 해당 학생을 삭제하시겠습니까?")
            alert.setPositiveButton("확인", DialogInterface.OnClickListener { dialog, which ->
                //확인이 눌렸을 때 할 일
                //오래 눌린 학생을 목록에서 제거.
                //mStudentList.remove(longClickedStudent) //학생을 삭제하자.
                mStudentList.removeAt(position) // 해당 위치의 데이터 삭제

                //삭제 후 어댑터에게 변경사항 노티. 새로 반영 해라.(습관적으로 같이 적어주자).
                //lateinit var을 사용하는 이유.
                mAdapter.notifyDataSetChanged()

                Log.d("삭제 후 개수", mStudentList.size.toString())
            })
            // 할일이 없어요
            alert.setNegativeButton("취소", null)
            alert.show()



            Log.d("롱클릭 이벤트", longClickedStudent.name)
            Log.d("삭제 전 개수", mStudentList.size.toString())
            //Boolean 값으로 결과를 리턴 해야 함.(안한 상태에서는 에러 처리)
            //false일 때는 클릭 이벤트도 실행함


            return@setOnItemLongClickListener true
        }
        
//        학생 추가하기 버튼 이벤트
        makeNewStudentBtn.setOnClickListener { 
            val myIntent = Intent(this, EditStudentInfoActivity::class.java)
            //그냥 액티비티 아니고 결과를 바람
            startActivityForResult(myIntent, REQ_FOR_STUDENT_INFO)
            
        }



    }

    //가져온 정보 반영하기
    //Intent는 null일 수 있다.
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        //학생정보 가지러 갔다온 거 맞니?
        if(requestCode == REQ_FOR_STUDENT_INFO) {
            //확인 누른거 맞니?
            if (resultCode == Activity.RESULT_OK) {
                //첨부한 데이터(data?)를 가지고 학생을 만들어서 목록에 추가하자.
                //data? -> data!!
                //!!한번 했으면 뒤에 거는 안해도 됨. 그래서 경고.
                val newStudent = Student(
                    data!!.getStringExtra("name")!!,
                    "${data.getStringExtra("largeArea")} ${data.getStringExtra("smallArea")}",
                    data.getIntExtra("birthYear", 1970)
                )

                //data?.getStringExtra
                //data가 null이 아닐 때 실행하자.
                //data!!.getStringExtra
                //data는 null이 아니라고 우기기. null이 있을 가능성 제거하고 사용.


                //add to list
                mStudentList.add(newStudent)
                mAdapter.notifyDataSetChanged()

            }
        }
    }

}