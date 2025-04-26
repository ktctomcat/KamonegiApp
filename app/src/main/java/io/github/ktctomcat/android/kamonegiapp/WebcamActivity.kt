package io.github.ktctomcat.android.kamonegiapp

import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WebcamActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_webcam)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.webcam)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 表示するhtmlファイルの指定
        val infoWebView: WebView = findViewById(R.id.webview)
        infoWebView.loadUrl("https://ktctomcat.github.io/kamonegi/information.html")
        infoWebView.settings.javaScriptEnabled = true

        // 戻るボタン
        val closeButton: Button = findViewById(R.id.closeButton)
        closeButton.setOnClickListener {
            finish()
        }
    }
}