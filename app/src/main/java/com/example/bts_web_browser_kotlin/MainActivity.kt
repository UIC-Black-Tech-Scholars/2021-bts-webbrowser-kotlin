package com.example.bts_web_browser_kotlin

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    lateinit var webview:WebView
    lateinit var searchButton:ImageButton
    lateinit var backButton:ImageButton
    lateinit var urlText:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webview = findViewById(R.id.webview)
        urlText = findViewById(R.id.url)

        webview.loadUrl("https://www.google.com")
        webview.settings.javaScriptEnabled = true // we need to enable javascript
        webview.canGoBack()
        webview.webViewClient = WebClient(this)

        searchButton = findViewById(R.id.search_btn)
        backButton = findViewById(R.id.back_btn)

        searchButton.setOnClickListener{
            val url = urlText.text.toString()
            webview.loadUrl(url)
        }

        backButton.setOnClickListener {
            webview.goBack()
        }

    }



    class WebClient internal constructor(private val activity: Activity): WebViewClient(){
        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean {
            view?.loadUrl(request?.url.toString())
            return true
        }

    }
}