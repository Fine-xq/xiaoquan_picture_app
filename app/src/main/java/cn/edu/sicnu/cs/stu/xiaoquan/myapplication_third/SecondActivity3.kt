package cn.edu.sicnu.cs.stu.xiaoquan.myapplication_third

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts

class SecondActivity3 : AppCompatActivity() {

    private lateinit var ivPhoto: ImageView

    private val takePicture = registerForActivityResult(ActivityResultContracts.TakePicturePreview()) { bitmap ->
        if(bitmap != null){
            ivPhoto.setImageBitmap(bitmap)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second3)

        val btnCamera:Button = findViewById(R.id.btn_camera)
        ivPhoto = findViewById(R.id.iv_photo)

        btnCamera.setOnClickListener {
            takePicture.launch(null)
        }
    }
}
