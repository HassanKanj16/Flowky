import 'package:flutter/material.dart';

class ProgressBar extends StatefulWidget {
  ProgressBar({Key key}) : super (key: key);
  
  @override
  _ProgressBarState createState() => _ProgressBarState();
}

class _ProgressBarState extends State<ProgressBar>{

  double _value = 0;

  void initState() {

    super.initState();
  }

  void dispose() {

    super.dispose();
  }

  @override
  Widget build(BuildContext context) {


    return SliderTheme(
      /*
      data: SliderThemeData(
          thumbColor: Colors.green,
          thumbShape: RoundSliderThumbShape(enabledThumbRadius: 0),
          trackShape: RoundedRectSliderTrackShape()

      ),*/

        data: SliderTheme.of(context).copyWith(
          activeTrackColor: Color(0xff303ef2),
          inactiveTrackColor: Color(0xfff0e9e9),
          trackShape: RoundedRectSliderTrackShape(),
          trackHeight: 12.0,
          thumbShape: RoundSliderThumbShape(enabledThumbRadius: 0),
          thumbColor: Colors.redAccent,
          overlayColor: Colors.red.withAlpha(32),
          overlayShape: RoundSliderOverlayShape(overlayRadius: 0),

          valueIndicatorTextStyle: TextStyle(
            color: Colors.white,
          ),
        ),

      child: Slider(
        value: _value,
        onChanged: (val) {
          _value = val;
          setState(() {});
        },
      ),
    );
  }
}