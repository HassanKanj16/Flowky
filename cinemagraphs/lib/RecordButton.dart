import 'package:flutter/material.dart';

class RecordButton extends StatefulWidget {

  final Function down, up;

  RecordButton({Key key, this.down, this.up}) : super (key: key);

  @override
  RecordButtonState createState() => RecordButtonState();
}

class RecordButtonState extends State<RecordButton>
    with SingleTickerProviderStateMixin {
  AnimationController controller;

  @override
  void initState() {
    super.initState();

    controller =
        AnimationController(vsync: this, duration: Duration(seconds: 5));
    controller.addListener(() {
      setState(() {});
    });
  }

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTapDown: (_) {
        widget.down();
        controller.forward();
        },
      onTapUp: (_) {
        if (controller.status == AnimationStatus.forward) {
          widget.up();
          controller.reverse();
        }
      },
      child: Stack(
        alignment: Alignment.center,
        children: <Widget>[
          CircularProgressIndicator(
            value: 1.0,
            valueColor: AlwaysStoppedAnimation<Color>(Colors.grey),
          ),
          CircularProgressIndicator(
            value: controller.value,
            valueColor: AlwaysStoppedAnimation<Color>(Colors.blue),
          ),
          Icon(Icons.add)
        ],
      ),
    );
  }
}