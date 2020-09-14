# Flowky
Social media app for cinemagraphs
flowky.app

## Mobile app
Old design (New design on website):

<img src="https://i.postimg.cc/tRvDh6Pj/ezgif-com-video-to-gif.gif" width="400">

**CMakeLists.txt** - statically links OpenCV (OpenCV-android-sdk) and C++ video processing scripts (ios/CppScripts)

**LIBERTY_UI_KIT** - UI used for the login page

**main.dart** - file to specify starting screen (SplashScreen() or MyHomePage())

**FormValidator.dart** - verifies email and password are in correct format

**native-flowky** - Module for integration with C++ code


### Screens

**SplashScreen.dart** - checks if user already logged in at launch, decides which screen to open

**Camera.dart** - camera view

**Feed.dart** - main view

**login.dart** - login view with authentication using Firebase

###### *Todo*

###### *-Highlight.dart - view for adjusting motion mask, with paint and erase functions*


### Elements

**TextBox.dart** - defines textbox with rounded corners

**ProgressBar.dart** - used for scoring people's posts, rounded corners

**RecordButton.dart** - shows duration during video capture

**Player.dart** - video player



## Video processing

**Stabilization** - using Lukas-Kanade (Baker, 2004), utomatic edge cropping using perspective transform

**Automatic motion mask** - using SSD matrix, standard deviation, and feathering

**Looping** - using Euclidian difference and triangle inequality, frame interpolating using two way SIFT and map scaling

###### *Todo*

###### *-Complete rest of C++ bindings*

###### *-Rolling shutter correction*

###### *-Add functions being tested*


C++ Project using State design pattern

Simplified class hierarchy:

![class hierarchy](https://i.postimg.cc/FRQdkjvZ/Capture.png)
