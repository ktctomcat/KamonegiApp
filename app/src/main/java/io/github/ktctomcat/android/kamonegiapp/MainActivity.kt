package io.github.ktctomcat.android.kamonegiapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btInfo = findViewById<Button>(R.id.btInfo)
        val btNotice = findViewById<Button>(R.id.btNotice)
        val btGraphic = findViewById<Button>(R.id.btGraphic)

        val listener = ClickListener()
        btInfo.setOnClickListener(listener)
        btNotice.setOnClickListener(listener)
        btGraphic.setOnClickListener(listener)
    }


    private inner class ClickListener : View.OnClickListener {
        override fun onClick(view: View) {
            when (view.id) {
                R.id.btInfo -> {
                    val intent = Intent(this@MainActivity, InfoActivity::class.java)
                    startActivity(intent)
                }

                R.id.btNotice -> {
                    val intent = Intent(this@MainActivity, NoticeActivity::class.java)
                    startActivity(intent)
                }

                R.id.btGraphic -> {
                    val intent = Intent(this@MainActivity, GraphicActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}