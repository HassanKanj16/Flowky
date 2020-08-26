import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';

import 'Feed.dart';
import 'login.dart';

class SplashScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return StreamBuilder(
      stream: FirebaseAuth.instance.onAuthStateChanged,
      builder: (ctx, AsyncSnapshot<FirebaseUser> snapshot) {
        if(snapshot.hasData) {
          if(snapshot.data != null) {

            // if user is signed in
            return MyHomePage();

          } else {
            // if user is not signed in
            return login();
          }
        }

        // if user is not signed in
        return login();
      },
    );
  }
}