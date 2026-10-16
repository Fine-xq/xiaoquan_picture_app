package cn.edu.sicnu.cs.stu.xiaoquan.myapplication_third

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SecondActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second2)

        val etInput: EditText = findViewById(R.id.et_input)
        val btnBack: Button = findViewById(R.id.btn_back)

        btnBack.setOnClickListener {
            val content = etInput.text.toString()
            val intent = Intent()
            intent.putExtra("back_data", content)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}
