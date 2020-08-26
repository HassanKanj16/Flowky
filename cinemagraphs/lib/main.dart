import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_statusbarcolor/flutter_statusbarcolor.dart';

import 'Feed.dart';
import 'SplashScreen.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {

    FlutterStatusbarcolor.setStatusBarColor(Colors.grey[50]);
    SystemChrome.setSystemUIOverlayStyle(SystemUiOverlayStyle.dark);
    SystemChrome.setEnabledSystemUIOverlays(SystemUiOverlay.values);

    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home:
      //SplashScreen(),
      MyHomePage(),

      //theme: ThemeData(),
    );
  }
}