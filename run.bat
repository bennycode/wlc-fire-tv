adb install -r "target/wlc-fire-tv-1.0.0-SNAPSHOT.apk"
adb shell am start -n com.welovecoding.app.firetv/.MainActivity
REM adb shell am start -n com.welovecoding.app.firetv/.rest.SampleSpiceActivity