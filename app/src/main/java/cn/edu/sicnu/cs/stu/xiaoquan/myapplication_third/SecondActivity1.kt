package cn.edu.sicnu.cs.stu.xiaoquan.myapplication_third

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second1)

        val tvParam:TextView = findViewById(R.id.tv_param)
        val msg = intent.getStringExtra("msg")
        tvParam.text = "收到主页面数据：\n$msg"
    }
}
