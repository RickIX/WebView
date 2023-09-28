package br.edu.up.webapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var webView: WebView = findViewById(R.id.webView)

        val webSettings: WebSettings =webView.getSettings()
        webSettings.javaScriptEnabled = true


        var jsInterface: JavaScriptInterface =
            JavaScriptInterface(this);
        webView.addJavascriptInterface(jsInterface,"Android");

        webView.loadUrl("file:///android_asset/index.html")

    }

    class JavaScriptInterface(private val context: Context){
        @JavascriptInterface
        fun showToast (message: String?) {
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        }
    }

}

