package cn.edu.sicnu.cs.stu.xiaoquan.myapplication_third

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView

class SecondActivity4 : AppCompatActivity() {

    private lateinit var tvTime: TextView
    private lateinit var btnStart: Button
    private lateinit var btnPause: Button
    private lateinit var btnReset: Button

    private var time = 0L
    private var isRunning = false
    private val handler = Handler(Looper.getMainLooper())

    private val runnable = object : Runnable {
        override fun run() {
            time += 1000
            val h = time / 3600000
            val m = (time % 3600000) / 60000
            val s = (time % 60000) / 1000
            tvTime.text = String.format("%02d:%02d:%02d", h, m, s)
            handler.postDelayed(this, 1000)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second4)

        tvTime = findViewById(R.id.tv_time)
        btnStart = findViewById(R.id.btn_start)
        btnPause = findViewById(R.id.btn_pause)
        btnReset = findViewById(R.id.btn_reset)

        // 如果有保存的数据，恢复
        savedInstanceState?.let {
            time = it.getLong("save_time")
            isRunning = it.getBoolean("save_running")
            val h = time / 3600000
            val m = (time % 3600000) / 60000
            val s = (time % 60000) / 1000
            tvTime.text = String.format("%02d:%02d:%02d", h, m, s)
            // 如果旋转前正在计时，继续跑
            if(isRunning){
                handler.post(runnable)
            }
        }

        btnStart.setOnClickListener {
            if (!isRunning) {
                isRunning = true
                handler.post(runnable)
            }
        }

        btnPause.setOnClickListener {
            isRunning = false
            handler.removeCallbacks(runnable)
        }

        btnReset.setOnClickListener {
            isRunning = false
            handler.removeCallbacks(runnable)
            time = 0L
            tvTime.text = "00:00:00"
        }
    }

    // 屏幕旋转时保存数据
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putLong("save_time", time)
        outState.putBoolean("save_running", isRunning)
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(runnable)
    }
}
