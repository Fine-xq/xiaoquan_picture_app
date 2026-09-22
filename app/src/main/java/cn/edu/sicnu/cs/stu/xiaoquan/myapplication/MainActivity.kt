package cn.edu.sicnu.cs.stu.xiaoquan.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private var currentIndex = 0
    private val imgList = intArrayOf(R.drawable.flag_cn, R.drawable.flag_ru, R.drawable.flag_us)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val rootLayout = LinearLayout(this)
        rootLayout.orientation = LinearLayout.VERTICAL
        rootLayout.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        rootLayout.setPadding(40,80,40,40)

        imageView = ImageView(this)
        imageView.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            800
        )
        imageView.scaleType = ImageView.ScaleType.CENTER_INSIDE
        imageView.setImageResource(imgList[currentIndex])
        rootLayout.addView(imageView)

        val btnSwitch = Button(this)
        btnSwitch.text = "切换图片"
        btnSwitch.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        btnSwitch.setOnClickListener {
            currentIndex = (currentIndex + 1) % imgList.size
            imageView.setImageResource(imgList[currentIndex])
        }
        rootLayout.addView(btnSwitch)

        setContentView(rootLayout)
    }
}