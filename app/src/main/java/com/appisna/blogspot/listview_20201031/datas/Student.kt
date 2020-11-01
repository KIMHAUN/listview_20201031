package com.appisna.blogspot.listview_20201031.datas

class Student(
    val name: String,
    val address:String,
    val birthYear:Int) {
    //val을 붙인다는 것 student1.name 등으로 가져다 쓸 수 있음.(해딩 클래스의 멤버 변수)
    //안 붙이는 것 : 잠깐 쓰고 버림.

    //보조 생성자(이름만 아는 학생/ 다양한 형태의 생성자)
    constructor(name:String){
        //this
    }

    //num1에는 나중에 null을 넣을 수도 있다.
    var num1: Int? = 10





}