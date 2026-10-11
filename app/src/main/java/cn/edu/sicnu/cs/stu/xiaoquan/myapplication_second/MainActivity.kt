package cn.edu.sicnu.cs.stu.xiaoquan.myapplication_second

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import cn.edu.sicnu.cs.stu.xiaoquan.myapplication_second.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val model = ProgramAdviser()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 区1：点击按钮动态新增TextView，从字符串资源取值
        binding.btnAdd.setOnClickListener {
            val newTv = TextView(this)s
            newTv.text = getString(R.string.new_item)
            binding.llContainer.addView(newTv)
        }

        // 区2：MVC交互，按钮查询模型
        binding.btnQuery.setOnClickListener {
            val inputStr = binding.etInput.text.toString()
            val resultText = model.getAnswer(inputStr)
            binding.tvResult.text = resultText
        }
    }
}
S