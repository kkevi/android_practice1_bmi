package com.example.learning_android_1

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow
import kotlin.math.round

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra( "height", 0)
        val weight = intent.getIntExtra( "weight", 0)

        //BMI 계산식
        var result = weight / (height/100.0).pow(2.0) // 키는 실제로 cm가 아닌 m로 계산 해야하기 때문에 100으로 나눠주고, 제곱계산 (pow) 해준다.
        result = round(result * 10) / 10

        var resText: String = ""
        var resImage = 0
        var resTextColor = 0
        
        if(result < 18.5) {
            resText = "저체중"
            resImage = R.drawable.bmi_lv1
            resTextColor = Color.YELLOW
        } else if (result >= 18.5 && result < 23.0){
            resText = "정상 체중"
            resImage = R.drawable.bmi_lv2
            resTextColor = Color.GREEN
        } else if (result >= 23.0 && result < 25.0){
            resText = "과체중"
            resImage = R.drawable.bmi_lv3
            resTextColor = Color.BLACK
        } else if (result >= 25.0 && result < 30.0){
            resText = "경도 비민"
            resImage = R.drawable.bmi_lv4
            resTextColor = Color.CYAN
        } else if (result >= 30.0 && result < 35.0){
            resText = "중정도 비만"
            resImage = R.drawable.bmi_lv5
            resTextColor = Color.CYAN
        } else {
            resText = "고도 비만"
            resImage = R.drawable.bmi_lv6
            resTextColor = Color.RED
        }

        val tv_resValue = findViewById<TextView>(R.id.tv_resValue)
        val tv_resText = findViewById<TextView>(R.id.tv_resText)
        val iv_image = findViewById<ImageView>(R.id.iv_image)
        val btn_back = findViewById<Button>(R.id.btn_back)

        tv_resValue.text = result.toString()
        tv_resText.text = resText
        tv_resText.setTextColor(resTextColor)
        iv_image.setImageResource(resImage)

        btn_back.setOnClickListener() {
            finish()
        }
    }
}