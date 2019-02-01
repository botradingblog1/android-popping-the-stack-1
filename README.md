# App for experimenting with Tasks and Activities in Android (Java)
## Overview
The purpose or this project is to show how preferences can be stored securely in your app.
For example, sometimes it is necessary to store sensitive user information persistently in your app (e.g. a user's DOB or ddress).
The default Android SharedPreferences are safed in a plain text XML file in the app's internal storage, so not a good place to store sensitive information.

This project shows you how to create a wrapper around the standard SharedPreferences class that encrypts both preference keys and values with a strong encryption algorithm.
This project uses the the Android Keystore system and crypto algorithms from the java.security library.

## Supporting material
Check out my [blog post on storing preferences securely](http://justmobiledev.com/storing-preferences-securely-on-android/), for a detailed explanation.

The Android documentation on [the Android Keystore System](https://developer.android.com/training/articles/keystore) is a good read to better understand the project.

## Implementation
* The SecurePrefsBuilder is a builder class used to specify properties for your shared preferences, e.g. file name, or if keys should be encrypted.
* The wrapper around the standard SharedPreferences is implemented in the SecurePrefs class.
* The project uses the Android KeyGenerator to create an AES-256 encryption key, which is safely stored in the Keystore.
* When you set values, the key and the value is encrypted in the SharedPrefs class with the encryption key retrieved from the Keystore before they are stored in the shared preferences XML file.
* When you get values, they key is encrypted to look up the value, the value is decrypted from the shared preferences XML file. For both actions the encryption key is retrieved from the Keystore.
* To see how your key and value are stored, open the 'Device Explorer' from the right Android Studio tab, and go to data\data\com.mobile.justmobiledev.androidsecurepreferences1\shared_prefs\my_secure_prefs_file.xml.
You can right-click on the file and 'Save As' to a temp directory on your computer. The file content should show the encrypted key and value, e.g.

```xml
<map>
    <string name="atgF69t3sjhUZwJosmIRZSfgXLQhg21FxbrJ534ATXo=&#10;">pXJ7qfFftbUlMozjOidT6EBXwX4l5go2XE3mo/DVrxw=&#10;    </string>
</map>
```

## Usage
1. When the app is started, you can enter a preference value into the first field.
2. Press the 'Start' button to encrypt key and value and store them into the preferences xml file
3. The app fetches the preferences again, decrypts the value and displays them in the second text field.

## Screenshots
![Popping the stack](screenshots/android-popping-the-stack-1.png?raw=true "Popping the stack")
