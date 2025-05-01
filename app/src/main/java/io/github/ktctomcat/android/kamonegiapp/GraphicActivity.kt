package io.github.ktctomcat.android.kamonegiapp

import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GraphicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_graphic)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.graphic)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // webView
        val webView: WebView = findViewById(R.id.webView)
        webView.settings.javaScriptEnabled = true // JavaScriptを有効にする
        webView.loadUrl("https://ktctomcat.github.io/kamonegi/graphic.html") // htmlファイルの指定

        // 戻るボタン
        val closeButton: Button = findViewById(R.id.closeButton)
        closeButton.setOnClickListener {
            finish()
        }
    }
}