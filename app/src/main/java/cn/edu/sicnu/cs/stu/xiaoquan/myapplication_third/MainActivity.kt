package cn.edu.sicnu.cs.stu.xiaoquan.myapplication_third

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView

    private val requestSecond2 = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if(result.resultCode == RESULT_OK){
            val data = result.data?.getStringExtra("back_data")
            tvResult.text = "返回结果：$data"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etMainInput:EditText = findViewById(R.id.et_main_input)
        val btn1:Button = findViewById(R.id.btn1)
        val btn2:Button = findViewById(R.id.btn2)
        val btn3:Button = findViewById(R.id.btn3)
        val btn4:Button = findViewById(R.id.btn4)
        tvResult = findViewById(R.id.tv_result)

        btn1.setOnClickListener {
            val intent = Intent(this,SecondActivity1::class.java)
            val inputStr = etMainInput.text.toString()
            intent.putExtra("msg",inputStr)
            startActivity(intent)
        }

        btn2.setOnClickListener {
            val intent = Intent(this,SecondActivity2::class.java)
            requestSecond2.launch(intent)
        }

        btn3.setOnClickListener {
            val intent = Intent(this,SecondActivity3::class.java)
            startActivity(intent)
        }

        btn4.setOnClickListener {
            val intent = Intent(this,SecondActivity4::class.java)
            startActivity(intent)
        }
    }
}
