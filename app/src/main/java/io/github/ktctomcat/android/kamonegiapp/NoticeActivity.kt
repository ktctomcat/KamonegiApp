package io.github.ktctomcat.android.kamonegiapp

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NoticeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_notice)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.notice)) { v, insets ->
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
        // スタイルの設定
        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                view?.evaluateJavascript(
                    """var style = document.createElement('style');
                        style.innerHTML = ".header, .gnav, .footer { display: none; }";
                        document.head.appendChild(style);"""
                ) { }
            }
        }

        // 戻るボタン
        val closeButton: Button = findViewById(R.id.closeButton)
        closeButton.setOnClickListener {
            finish()
        }
    }
}