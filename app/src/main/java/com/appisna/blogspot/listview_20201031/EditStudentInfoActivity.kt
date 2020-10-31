package com.appisna.blogspot.listview_20201031

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_student_info.*

//입력 완료하고 복귀
class EditStudentInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_student_info)

        okBtn.setOnClickListener {
            //1. 입력한 항목들 받아내기
            val inputName = nameEdt.text.toString()
            val largeArea = largeAreaEdt.text.toString()
            val smallArea = smallAreaEdt.text.toString()

            //년도는 정수 형태로 저장하는 게 편리함.
            //입력 문구(text) -> String -> Int
            val birthYear = birthYearEdt.text.toString().toInt()

            //2. 결과로써 설정(+ 확인을 누른게 맞다고 세팅)
            //결과를 담기위한 빈 Intent(왕복이 아니니까 정보 x)
            val resultIntent = Intent()
            //하나의 Intent에 여러개의 putExtra 해도 무방.
            resultIntent.putExtra("name", inputName)
            resultIntent.putExtra("largeArea", largeArea)
            resultIntent.putExtra("smallArea", smallArea)
            resultIntent.putExtra("birthYear", birthYear)

            //확인 맞다. resultIntent(캐리어) 들고가자.
            setResult(Activity.RESULT_OK, resultIntent)

            //3. 이전 화면으로 복귀
            finish()




        }
    }
}