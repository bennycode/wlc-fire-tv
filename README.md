We Love Coding - Amazon Fire TV App
===========

## Technology Stack

- Java 1.8
- Android 4.2.2 (API level 17, Jelly Bean)
- Amazon Fire TV SDK (Fire OS 3.0)

## Guidance

1. [Setting Up Your Development Environment](https://developer.amazon.com/public/solutions/devices/fire-tv/docs/setting-up-your-development-environment)
1. [Connecting ADB](https://developer.amazon.com/public/solutions/devices/fire-tv/docs/connecting-adb)
1. [Installing and Running Your App](https://developer.amazon.com/public/solutions/devices/fire-tv/docs/installing-and-running-your-app)

## Quickstart

1. Connect to Amazon Fire TV
1. Clean & Build project
1. Refresh APK
1. Run main activity

### Connect to Amazon Fire TV (192.168.178.74)

```
adb kill-server
adb start-server
adb connect 192.168.178.74
```

### Build project

Maven Clean & Build in NetBeans IDE

### Refresh APK and run main activity

```
adb install -r "target/wlc-fire-tv-1.0.0-SNAPSHOT.apk"
adb shell am start -n com.welovecoding.app.firetv/.MainActivity
```

Note: If you build the app for the first time, then you should remove the `-r` from `adb install`.
