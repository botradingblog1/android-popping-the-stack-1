# App playground for with Tasks Stacks in Android (Java)
## Overview

The purpose of the app is to let the developer experiment with one and multiple task stacks and understand how to pop activities off the stacks again.

## Supporting material
Check out my [blog post](http://justmobiledev.com/popping-the-stack-in-android/) on popping the stack for a detailed explanation.

The Android documentation on [Tasks and Activities](https://developer.android.com/guide/components/activities/tasks-and-back-stack) is a good read to better understand the project.

## Getting Started
Open the Android project file in Android Studio or Eclipse with Android Development Tools. Then clean, build and run on a device or emulator.

## Prerequisites
Android Studio or Eclipse with Android Development Tools.

## Building
1. Open the project in Android Studio or Eclipse
2. Clean and build the project
3. Use the 'Play' (>) button to launch the app on a device or emulator

## Installing & Deployment
1. You can run the app in an Android emulator from Android Studio or
2. You can connect a Developer Mode enabled Android device via USB cable to your computer and run the app on the device.

## Usage
1. When the app is started, you can select either the 'One Task' or the 'Two Task' button
2. Press the 'One Task' button to add activities to the first task stack. Note that the MainActivity is on the bottom of the stack, the MyActivity is on the top. When you look at the 'Recent Task' list, you only see one task. Use the 'Clear Top' button to pop the stack.
3. Press the 'Two Task' button to create a new task stack. Note that the MyActivityTask2 is on the bottom of the task stack, MyActivityTask2 is on the top. When you look at the 'Recent Task' list, you see two tasks: The first task is the MainActivity, the second task has the MyActivityTask2 activities. Use the 'Clear Top' button to pop the stack.

## Implementation
* In order to create the one task stack, we simply start MyActivity
* In order to create a new task, we need to set the taskAffinity in the AndroidManifest.xml for an activity in a different package: task2/MyActivityTask2.
* In addition, we set the FLAG_ACTIVITY_NEW_TASK flag in the intent to start task2/MyActivity2
* To pop the stack and clear all activities, we start the MainActivity using the FLAG_ACTIVITY_CLEAR_TOP flag.

## Versioning
Version 1.0

## Authors
Christian Scheid - (https://justmobiledev.com)[https://justmobiledev.com]

## License
This project is licensed under the MIT License - see the LICENSE.md file for details

## Screenshots
![Popping the stack](screenshots/android-popping-the-stack-1.png?raw=true "Popping the stack")

![Popping the stack](screenshots/android-popping-the-stack-2.png?raw=true "Popping the stack")
