package com.aspire2027.videoportal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.browser.customtabs.CustomTabsIntent;
import com.getcapacitor.BridgeActivity;

/*
 * ========================================================================
 * PATH: android/app/src/main/java/com/aspire2027/videoportal/MainActivity.java
 * ========================================================================
 * Ye file `npx cap add android` chalane ke baad automatically ban jaati hai
 * (default empty version). Uski jagah is poore content se REPLACE kar do.
 *
 * Kya karta hai:
 *  - Poora app normal WebView me hi chalta hai (tumhari website jaisi ki
 *    taisi dikhti hai) — SIRF jab URL "accounts.google.com" ho, tab use
 *    WebView ke bajaye Chrome Custom Tab (system browser) me kholta hai.
 *  - index.html/admin.html me KUCH BHI change nahi karna — Google Sign-In
 *    button waisa hi rahega jaisa hai.
 * ========================================================================
 */
public class MainActivity extends BridgeActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WebView webView = this.bridge.getWebView();

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url != null && url.contains("accounts.google.com")) {
                    // Google login ko system browser me kholo (WebView me nahi)
                    CustomTabsIntent customTabsIntent = new CustomTabsIntent.Builder().build();
                    customTabsIntent.launchUrl(MainActivity.this, Uri.parse(url));
                    return true; // WebView ko is URL ko load karne se rok do
                }
                // baaki sab kuch (tumhari website, admin panel, API calls) normal hi chalega
                return false;
            }
        });
    }

    @Override
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        // Jab Google login ke baad https://prev-live-classes-azio.onrender.com pe
        // redirect hota hai aur App Link verified hai, Android is app ko wapas khol dega
        // aur webview apne aap wahi URL load kar lega (bridge handle karta hai).
    }
}
