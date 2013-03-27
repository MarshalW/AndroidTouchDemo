package com.example.touch;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class MyActivity extends Activity {

    private WebView webView;

    private CustomerViewGroup topView;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        this.webView = (WebView) this.findViewById(R.id.webView);
        this.webView.loadUrl("http://www.apache.org/licenses/LICENSE-2.0.txt");

        this.topView = (CustomerViewGroup) this.findViewById(R.id.topView);
        this.topView.setView(this.webView);
    }
}
