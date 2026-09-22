# KNPortal (Android, Java)

A simple, beginner-friendly Android login screen built with Java + XML
(no Kotlin, no Jetpack Compose) for a student practical assessment.

## What's included

- `MainActivity` / `activity_main.xml` — login screen (username/email,
  password with show/hide toggle, LOGIN button, Forgot Password, Create
  Account, and a `knportal` tag).
- `HomeActivity` / `activity_home.xml` — simple dashboard shown after a
  demo "successful" login, with a Logout button.
- Basic input validation (empty-field checks) — **no real backend/API is
  connected**; this is a UI/UX demo only.

## Opening the project in Android Studio

1. Open Android Studio → **Open** → select this project folder.
2. Let Gradle sync (Android Studio will generate the Gradle wrapper files
   if they are missing).
3. Run the `app` module on an emulator or device (min SDK 24).

If you prefer to build it from scratch yourself as a learning exercise,
follow the full step-by-step instructions provided alongside this
project, which explain how to create a new **Empty Views Activity**
project in Android Studio and paste each file's contents in.

## Notes

- `INTERNET` permission and the WebView/browser integration for the real
  `knportal` URL are intentionally left out of the base app and are
  documented separately as an **optional** enhancement.
