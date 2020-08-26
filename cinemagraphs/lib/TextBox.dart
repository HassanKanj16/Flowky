import 'package:flutter/material.dart';

class ProgressBar extends StatefulWidget {
  ProgressBar({Key key}) : super (key: key);

  @override
  _ProgressBarState createState() => _ProgressBarState();
}

class _ProgressBarState extends State<ProgressBar>{

  void initState() {

    super.initState();
  }

  void dispose() {

    super.dispose();
  }

  @override
  Widget build(BuildContext context) {

    return TextFormField(
      keyboardType: TextInputType.emailAddress,
      autofocus: false,
      decoration: InputDecoration(
        hintText: 'Email',
        //contentPadding: EdgeInsets.fromLTRB(20.0, 15.0, 20.0, 15.0),
        border: OutlineInputBorder(borderRadius: BorderRadius.circular(40.0)),
      )
    );
  }
}