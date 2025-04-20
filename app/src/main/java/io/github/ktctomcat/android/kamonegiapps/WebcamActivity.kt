package io.github.ktctomcat.android.kamonegiapps

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WebcamActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        //　システムバーの領域にもビューを広げるための設定。
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_webcam)

        // システムバー（ステータスバーやナビゲーションバー）によってビューが隠れないように調整する設定。
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.webcam)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }






    }
}