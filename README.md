We Love Coding - Amazon Fire TV App
===========

## Build & Run

```
ant debug && run.bat
```

## Hints

```
adb kill-server
adb start-server
adb connect 192.168.178.74

adb install "out/production/wlc-fire-tv/-tv.apk"
adb install -r "out/production/wlc-fire-tv/-tv.apk"
adb shell am start -n com.welovecoding.app.firetv/.MainActivity
```
