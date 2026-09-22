package cn.edu.sicnu.cs.stu.xiaoquan.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var textView: TextView
    private var currentIndex = 0
    private val imgList = intArrayOf(R.drawable.flag_cn, R.drawable.flag_us, R.drawable.flag_ru)
    private val textList = arrayOf("中国", "United States", "Россия")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //根布局
        val rootLayout = LinearLayout(this)
        rootLayout.orientation = LinearLayout.VERTICAL
        rootLayout.setPadding(40, 80, 40, 40)

        //图片控件
        imageView = ImageView(this)
        val imgLp = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            800
        )
        imageView.layoutParams = imgLp
        imageView.scaleType = ImageView.ScaleType.CENTER_INSIDE
        imageView.setImageResource(imgList[currentIndex])
        rootLayout.addView(imageView)

        //文本控件（多语言文字）
        textView = TextView(this)
        val textLp = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        textLp.topMargin = 40
        textView.layoutParams = textLp
        textView.textSize = 24f
        textView.text = textList[currentIndex]
        rootLayout.addView(textView)

        //按钮
        val btnSwitch = Button(this)
        val btnLp = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        btnSwitch.layoutParams = btnLp
        btnSwitch.text = "切换图片"
        btnSwitch.setOnClickListener {
            currentIndex = (currentIndex + 1) % imgList.size
            imageView.setImageResource(imgList[currentIndex])
            textView.text = textList[currentIndex]
        }
        rootLayout.addView(btnSwitch)

        setContentView(rootLayout)
    }
}