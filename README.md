# Flowky
Social media app for cinemagraphs

## Mobile app

**LIBERTY_UI_KIT** - UI used for the login page

**main.dart** - file to specify starting screen (SplashScreen() or MyHomePage())

**FormValidator.dart** - verifies email and password are in correct format

**native-flowky** - Module for integration with C++ code

###### *Todo*

###### *-Authentication with email*

###### *-Adjust validator*

###### *-Functionality for buttons and connect to database*

###### *-Integration with Instagram*

###### *-Customize UI and add logo*

### Screens

**SplashScreen.dart** - checks if user already logged in at launch, decides which screen to open

**Camera.dart** - camera view

**Feed.dart** - main view

**login.dart** - login view with authentication using Firebase

###### *Todo*

###### *-Highlight.dart - view for adjusting motion mask, with paint and erase functions*

###### *-Loop.dart - view for choosing starting point and one of suggested looping points*

###### *-Profile.dart - view of profile*

### Elements

**TextBox.dart** - defines textbox with rounded corners

**ProgressBar.dart** - used for scoring people's posts, rounded corners

**RecordButton.dart** - shows duration during video capture

**Player.dart** - video player

###### *Todo*

###### *-Customized Button*

###### *-Add bar showing tilt and jitter limit during capture*

###### *-Fix appearance of progress bar*

## Video processing

**Stabilization** - using Lukas-Kanade (Baker, 2004) and automatic edge cropping

**Automatic motion mask** - using SSD matrix, standard deviation, and feathering

**Looping** - using Euclidian difference and triangle inequality, frame interpolating using two way SIFT and map scaling

###### *Todo*

###### *-Adjust C++ to work with Flutter*

###### *-Optimize for ARM Neon, add SIMD where needed, multithreading*

###### *-Motion region KLT tracking?*
