import 'package:camera/camera.dart';
import 'package:cinemagraphs/Camera.dart';
import 'package:cinemagraphs/ProgressBar.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'Player.dart';
import 'package:flutter_statusbarcolor/flutter_statusbarcolor.dart';

/*
void main() {
  runApp(MyApp());
}


class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {

    FlutterStatusbarcolor.setStatusBarColor(Colors.grey[50]);
    SystemChrome.setSystemUIOverlayStyle(SystemUiOverlayStyle.dark);

    return MaterialApp(
      home: MyHomePage(title: 'Flutter'),
    );
  }
}
 */

class MyHomePage extends StatefulWidget {
  MyHomePage({Key key, this.title}) : super(key: key);

  final String title;

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  final IconData cam = const IconData(0xf2d3,
      fontFamily: CupertinoIcons.iconFont,
      fontPackage: CupertinoIcons.iconFontPackage);

  final IconData profile = const IconData(0xf2d8,
      fontFamily: CupertinoIcons.iconFont,
      fontPackage: CupertinoIcons.iconFontPackage);

  @override
  Widget build(BuildContext context) {

    return Scaffold(
        body: Stack(children: <Widget>[
      Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            new Container(
              height: 600,
              margin: const EdgeInsets.only(left: 15.0, right: 15.0),
              child: new VPlayer(
                  url:
                      "https://media.giphy.com/media/mFHbNzga4uZtPORkdX/giphy.mp4"),
            ),
            Container(
                margin: const EdgeInsets.only(
                    top: 10.0, bottom: 5.0, left: 30.0, right: 30.0),
                child: Row(children: <Widget>[
                  CircleAvatar(radius: 13, backgroundImage: NetworkImage("")),
                  ProgressBar(),
                  Text("1,440 pts")
                ])),
          ],
        ),
      ),
      Align(
          alignment: Alignment.bottomLeft,
          child: FloatingActionButton(
            child: Icon(cam),
            backgroundColor: Color(0xffff00),
            elevation: 0,
            foregroundColor: Colors.black,
            heroTag: "btn1",
            onPressed:

                () async {
              CameraDescription firstCam = await mainCam();
              Navigator.push(
                context,
                //MaterialPageRoute(builder: (context) => RegisterPage()),);
                MaterialPageRoute(
                    builder: (context) => TakePictureScreen(camera: firstCam)),
              );
            },
          )),
      Align(
          alignment: Alignment.bottomRight,
          child: FloatingActionButton(
            child: Icon(profile),
            backgroundColor: Color(0xffff00),
            elevation: 0,
            heroTag: "btn2",
            onPressed: null,
            foregroundColor: Colors.black,
          ))
    ]));
  }
}

Future<CameraDescription> mainCam() async {
  // Ensure that plugin services are initialized so that `availableCameras()`
  // can be called before `runApp()`
  WidgetsFlutterBinding.ensureInitialized();

  // Obtain a list of the available cameras on the device.
  final cameras = await availableCameras();

  // Get a specific camera from the list of available cameras.
  return cameras.first;
}
