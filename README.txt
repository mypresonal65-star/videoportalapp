VIDEO PORTAL — ANDROID + iOS APP (Capacitor)
========================================================================
Website code (index.html, admin.html, Google Sign-In) — SAB KUCH
BILKUL WAISA HI HAI jaisa tumne diya. Koi change nahi kiya.
Ye app sirf tumhari live website (https://prev-live-classes-azio.onrender.com)
ko native shell me wrap karta hai.

========================================================================
QUICK START
========================================================================

1) Node.js install karo (nodejs.org se LTS version)

2) Terminal me:
     npm install

3) Capacitor platforms add karo (pehli baar hi karna hai):
     npx cap add android
     npx cap add ios

4) Android native patch apply karo:
     - android-native-patch/MainActivity.java ko copy karke
       android/app/src/main/java/com/aspire2027/videoportal/MainActivity.java
       me paste karo (replace)
     - android-native-patch/SETUP-INSTRUCTIONS.txt follow karo
       (build.gradle dependency + AndroidManifest.xml intent-filter)

5) iOS native patch apply karo:
     - ios-native-patch/SETUP-INSTRUCTIONS.txt follow karo
       (Xcode Associated Domains capability)

6) well-known-files-for-render/ ki dono files apni Render website pe
   in exact paths pe host karo:
     /.well-known/assetlinks.json
     /.well-known/apple-app-site-association
   (assetlinks.json me apna SHA256 fingerprint bharna — instructions
   android-native-patch/SETUP-INSTRUCTIONS.txt me hai)

7) Sync + build:
     npx cap sync
     npx cap open android   → Android Studio khulega, APK/AAB banao
     npx cap open ios       → Xcode khulega (Mac chahiye), IPA banao

========================================================================
FILE STRUCTURE
========================================================================
  package.json                        → Capacitor dependencies
  capacitor.config.json               → app ka config (website URL yahan set hai)
  www/index.html                      → chhota fallback page (offline dikhne ke liye)
  android-native-patch/               → Google login fix (Android)
  ios-native-patch/                   → Google login fix (iOS)
  well-known-files-for-render/        → App Links verification files
                                         (apni website pe host karni hain)

========================================================================
PUBLISHING
========================================================================
Android (Google Play):
  - Google Play Console account: $25 (one-time)
  - Android Studio se "Generate Signed Bundle" (.aab) banao
  - Play Console pe upload karo, store listing (screenshots, description) bharo
  - Review me 1-3 din lagte hain

iOS (App Store):
  - Apple Developer account: $99/year
  - Xcode se Archive → App Store Connect pe upload
  - Review me 1-2 din lagte hain, guidelines strict hain (privacy policy
    URL zaroor chahiye hoga — apni website pe ek privacy page bana lena)

========================================================================
IMPORTANT REMINDERS
========================================================================
- capacitor.config.json me appId "com.aspire2027.videoportal" hai —
  ye Play Store/App Store pe permanent identity ban jaata hai, badal
  na ho to abhi hi final kar lo.
- Website update karoge (Render pe naya deploy) to app automatically
  naya content dikhayega — dobara app store submit karne ki zarurat
  NAHI (kyunki app sirf live URL load karta hai). Sirf tab dobara
  submit karna padega jab app-level cheez badle (icon, permissions, etc).
