package io.github.ktctomcat.android.kamonegiapp

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_info)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.info)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 表示するhtmlファイルの指定
        val webView: WebView = findViewById(R.id.webView)
        // JavaScriptを有効にする
        webView.settings.javaScriptEnabled = true
        // htmlファイルの指定
        webView.loadUrl("https://ktctomcat.github.io/kamonegi/index.html")

        // 戻るボタン
        val closeButton: Button = findViewById(R.id.closeButton)
        closeButton.setOnClickListener {
            finish()
        }
    }
}