We Love Coding - Amazon Fire TV App
===========

## Guidance

1. [Setting Up Your Development Environment](https://developer.amazon.com/public/solutions/devices/fire-tv/docs/setting-up-your-development-environment)
1. [Connecting ADB](https://developer.amazon.com/public/solutions/devices/fire-tv/docs/connecting-adb)
1. [Installing and Running Your App](https://developer.amazon.com/public/solutions/devices/fire-tv/docs/installing-and-running-your-app)

## Quickstart

```
ant debug && run.bat
```

## Instructions

- Connect to Amazon Fire TV (192.168.178.74)

```
adb kill-server
adb start-server
adb connect 192.168.178.74
```

- Build project

```
ant debug
```

- Refresh APK and run main activity

```
adb install -r "bin/wlc-fire-tv-debug.apk"
adb shell am start -n com.welovecoding.app.firetv/.MainActivity
```

Note: If you build the app for the first time, then you should remove the `-r` from `adb install`.
