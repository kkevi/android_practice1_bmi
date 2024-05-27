package com.example.learning_android_1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

// 앱이 처음 실행 됐을 때 빌드하는 메인 함수 : MainActivity
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main) //화면을 실질적으로 그려주는 부분 > res/layout 폴더 내에 있음

        val heightEditText = findViewById<EditText>(R.id.et_height) // 이 변수가 et_height 컴포넌트와 연결됨
        val weightEditText = findViewById<EditText>(R.id.et_weight) // 이 변수가 et_weight 컴포넌트와 연결됨
        val submitButton = findViewById<Button>(R.id.btn_check)

        submitButton.setOnClickListener() {
            if(heightEditText.text.isEmpty()) {
                Toast.makeText(this, "신장을 입력해 주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(weightEditText.text.isEmpty()) {
                Toast.makeText(this, "체중을 입력해 주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val height : Int = heightEditText.text.toString().toInt() // text editor 안에 있는 값을 받아오는 변수
            val weight : Int = weightEditText.text.toString().toInt()

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("height", height)
            intent.putExtra("weight", weight)

            startActivity(intent) // mainActivity 에서 ResultActivity 를 호출 하는 함수
        }
    }
}

// 모든 화면은 xml 화면과 kt 소스코드가 1:1로 대응하여 작동