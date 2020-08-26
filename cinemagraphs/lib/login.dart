import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_auth_buttons/flutter_auth_buttons.dart';
import 'package:google_sign_in/google_sign_in.dart';
import 'FormValidator.dart';
import 'Feed.dart';

class login extends StatefulWidget {
  login({Key key}) : super(key: key);

  @override
  _loginState createState() => _loginState();
}

class LoginRequestData {
  String email = '';
  String password = '';
}

class _loginState extends State<login> {
  void initState() {
    super.initState();
  }

  void dispose() {
    super.dispose();
  }

  GlobalKey<FormState> _key = new GlobalKey();
  bool _validate = false;
  LoginRequestData _loginData = LoginRequestData();
  bool _obscureText = true;

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      body: new Center(
        child: new SingleChildScrollView(
          child: new Container(
            margin: new EdgeInsets.all(20.0),
            child: Center(
              child: new Form(
                  key: _key,
                  autovalidate: _validate,
                  child:
                  Column(
                    children: <Widget>[
                      /*
                      new Image.asset(
                        'assets/logo.png',
                        height: 100,
                        width: 100,
                      ),*/
                      new SizedBox(height: 50.0),
                      new TextFormField(
                        keyboardType: TextInputType.emailAddress,
                        autofocus: false,
                        decoration: InputDecoration(
                          hintText: 'Email',
                          contentPadding: EdgeInsets.fromLTRB(
                              20.0, 15.0, 20.0, 15.0),
                          border:
                          OutlineInputBorder(borderRadius: BorderRadius
                              .circular(32.0)),
                        ),
                        validator: FormValidator().validateEmail,
                        onSaved: (String value) {
                          _loginData.email = value;
                        },
                      ),
                      new SizedBox(height: 20.0),
                      new TextFormField(
                          autofocus: false,
                          obscureText: _obscureText,
                          keyboardType: TextInputType.text,
                          decoration: InputDecoration(
                            hintText: 'Password',
                            contentPadding: EdgeInsets.fromLTRB(
                                20.0, 10.0, 20.0, 10.0),
                            border:
                            OutlineInputBorder(borderRadius: BorderRadius
                                .circular(32.0)),
                            suffixIcon: GestureDetector(
                              onTap: () {
                                setState(() {
                                  _obscureText = !_obscureText;
                                });
                              },
                              child: Icon(
                                _obscureText ? Icons.visibility : Icons
                                    .visibility_off,
                                semanticLabel:
                                _obscureText
                                    ? 'show password'
                                    : 'hide password',
                              ),
                            ),
                          ),
                          validator: FormValidator().validatePassword,
                          onSaved: (String value) {
                            _loginData.password = value;
                          }),
                      new SizedBox(height: 15.0),
                      new Padding(
                        padding: EdgeInsets.symmetric(vertical: 16.0),
                        child: RaisedButton(
                          shape: RoundedRectangleBorder(
                            borderRadius: BorderRadius.circular(24),
                          ),
                          onPressed: _sendToServer,
                          padding: EdgeInsets.all(12),
                          color: Colors.lightBlueAccent,
                          child: Text('Log In', style: TextStyle(
                              color: Colors.white)),
                        ),
                      ),
                      new GoogleSignInButton(
                        onPressed: () {
                          doGoogleSignIn();
                        },
                      ),
                      new FlatButton(
                        child: Text(
                          'Forgot password?',
                          style: TextStyle(color: Colors.black54),
                        ),
                        onPressed: _showForgotPasswordDialog,
                      ),
                      new FlatButton(
                        onPressed: _sendToRegisterPage,
                        child: Text('Not a member? Sign up now',
                            style: TextStyle(color: Colors.black54)),
                      ),
                    ],
                  )
              ),
            ),
          ),
        ),
      ),
    );
  }

  _sendToRegisterPage() {

    Navigator.push(
        context,
        //MaterialPageRoute(builder: (context) => RegisterPage()),);
        MaterialPageRoute(builder: (context) => MyHomePage(title: "Flutter")),);

  }

  Future<String>_sendToServer() async{
    if (_key.currentState.validate()) {
      // No any error in validation
      _key.currentState.save();

      try {
        final FirebaseAuth _auth = FirebaseAuth.instance;

        AuthResult result = await _auth.signInWithEmailAndPassword(
            email: _loginData.email, password: _loginData.password);
        FirebaseUser user = result.user;
        return user.uid;
      }
      catch(e){
        print(e);
      }

    } else {
      // validation error
      setState(() {
        _validate = true;
      });
    }
  }


  Future<Null> _showForgotPasswordDialog() async {
    await showDialog<String>(
        context: context,
        builder: (BuildContext context) {
          return new AlertDialog(
            title: const Text('Please enter your eEmail'),
            contentPadding: EdgeInsets.all(5.0),
            content: new TextField(
              decoration: new InputDecoration(hintText: "Email"),
              onChanged: (String value) {
                _loginData.email = value;
              },
            ),
            actions: <Widget>[
              new FlatButton(
                child: new Text("Ok"),
                onPressed: () async {
                  _loginData.email = "";
                  Navigator.pop(context);
                },
              ),
              new FlatButton(
                child: new Text("Cancel"),
                onPressed: () => Navigator.pop(context),
              ),
            ],
          );
        });
  }

  void doGoogleSignIn() async {
    try {
      final GoogleSignIn _googleSignIn = GoogleSignIn();
      final FirebaseAuth _auth = FirebaseAuth.instance;

      final GoogleSignInAccount googleUser = await _googleSignIn.signIn();
      final GoogleSignInAuthentication googleAuth = await googleUser.authentication;

      final AuthCredential credential = GoogleAuthProvider.getCredential(
        accessToken: googleAuth.accessToken,
        idToken: googleAuth.idToken,
      );

      final FirebaseUser user = (await _auth.signInWithCredential(credential)).user;
      print("signed in " + user.displayName);

      // store user data
      Firestore.instance
          .collection("users")
          .document(user.uid)
          .setData({
        "email": user.email,
        "displayName": user.displayName,
        "photoUrl": user.photoUrl,
        "lastLogin": DateTime.now()
      });

    } catch (e) {
      print(e);
    }
  }
}
