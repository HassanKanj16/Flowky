# Flowky
Social media app for cinemagraphs

##Mobile app

**LIBERTY_UI_KIT** - UI used for the login page

**main.dart** - file to specify starting screen (SplashScreen() or MyHomePage())
**login.dart** - authentication with Firebase
**FormValidator.dart** - verifies email and password are in correct format
**native-flowky** - Module for integration with C++ code

###Screens
**SplashScreen.dart** - checks if user already logged in at launch
**Camera.dart** - camera view
**Feed.dart** - main view

*Highlight.dart* - view for adjusting motion mask, with paint and erase functions
*Loop.dart* - view for choosing starting point and one of suggested looping points

###Elements
**TextBox.dart** - defines textbox with rounded corners
**ProgressBar.dart** - used for scoring people's posts, rounded corners
**Player.dart** - video player

##Video processing

**Stabilization** - using Lukas-Kanade (Baker, 2004)
**Automatic motion mask** - using SSD matrix, standard deviation, and feathering
**Looping** - using Euclidian difference and triangle inequality
