import 'package:flutter/material.dart';
import 'package:video_player/video_player.dart';

class VPlayer extends StatefulWidget {
  VPlayer({Key key, this.url}) : super (key: key);

  final String url;

  @override
  _VPlayerState createState() => _VPlayerState();
}

class _VPlayerState extends State<VPlayer> {

  VideoPlayerController _vd;
  Future<void> _vdf;

  void initState() {

    _vd = VideoPlayerController.network(widget.url);
    _vdf = _vd.initialize();
    _vd.setLooping(true);

    _vd.play();

    super.initState();
  }

  void dispose() {
    _vd.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return AspectRatio(
    aspectRatio: _vd.value.aspectRatio,
    child:
        Container(
      decoration:
      BoxDecoration(

          color: Colors.white,
          borderRadius: BorderRadius.only(
              topLeft: Radius.circular(20),
              topRight: Radius.circular(20),
              bottomLeft: Radius.circular(20),
              bottomRight: Radius.circular(20)
          ),

          boxShadow: [
            BoxShadow(
              color: Colors.grey.withOpacity(0.5),
              spreadRadius: 3,
              blurRadius: 3,
              offset: Offset(0, 3), // changes position of shadow
            )
          ]
      ),

        child: FutureBuilder(
      future: _vdf,
      builder: (context, snapshot) {
        if (snapshot.connectionState == ConnectionState.done) {
          return Center(child: ClipRRect( borderRadius: BorderRadius.circular(20.0),
              child: VideoPlayer(_vd),
          ));
        } else {
          return Center(
            child: CircularProgressIndicator(),
          );
        }
      },
    )
        )
    );
  }
}