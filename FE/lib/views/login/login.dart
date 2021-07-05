import 'package:clinicbookingapp/helpers/constants.dart';
import 'package:clinicbookingapp/views/global/background.dart';
import 'package:clinicbookingapp/views/register/register.dart';
import 'package:flutter/material.dart';
import 'dart:async';
import 'package:dio/dio.dart';
import 'package:clinicbookingapp/views/home/home.dart';

class LoginScreen extends StatefulWidget {
  @override
  _LoginScreenState createState() => _LoginScreenState();
}

class _LoginScreenState extends State<LoginScreen> {
  TextEditingController phoneController = TextEditingController();
  TextEditingController passwordController = TextEditingController();
  String error = "";

  String url = "https://localhost:8080/api/auth/login";
  Future logIn() async {
    try {
      var res = await Dio().post(url,
          options: Options(
            headers: {"Content-Type": "application/json"},
          ),
          data: {
            'phone': phoneController.text,
            'password': passwordController.text
          });
      if (res.data.toString().length > 0) {
        Navigator.push(context, MaterialPageRoute(builder: (_) => Home()));
      }
      // if (res.data.toString() == null) {
      //   error = "Invalid phone or password";
      // }
    } catch (e) {
      print(e.toString());
      error = "Invalid phone or password";
      print(error);
    }
  }

  @override
  Widget build(BuildContext context) {
    Size size = MediaQuery.of(context).size;

    return Scaffold(
      body: SingleChildScrollView(
        child: Container(
          width: size.width,
          height: size.height,
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              Background(
                title: "DENTAL CLINIC BOOKING",
              ),
              SizedBox(height: size.height * 0.001),
              Container(
                alignment: Alignment.center,
                //margin: EdgeInsets.symmetric(horizontal: 40),
                margin: const EdgeInsets.only(left: 35, bottom: 20, right: 35),
                child: TextFormField(
                  controller: phoneController,
                  decoration: InputDecoration(labelText: "Số điện thoại"),
                ),
              ),
              SizedBox(height: size.height * 0.001),
              Container(
                alignment: Alignment.center,
                margin: const EdgeInsets.only(left: 35, right: 35),
                child: TextFormField(
                  controller: passwordController,
                  decoration: InputDecoration(labelText: "Mật khẩu"),
                  obscureText: true,
                ),
              ),
              SizedBox(height: size.height * 0.001),
              Container(
                alignment: Alignment.centerRight,
                margin: EdgeInsets.symmetric(horizontal: 40, vertical: 10),
                child: GestureDetector(
                  onTap: () => {},
                  child: Text(
                    "Lấy lại mật khẩu",
                    style: TextStyle(
                        fontSize: 12,
                        fontWeight: FontWeight.bold,
                        color: Color(0xFF2661FA)),
                  ),
                ),
              ),
              Container(
                alignment: Alignment.center,
                margin: const EdgeInsets.only(top: 15),
                child: GestureDetector(
                  onTap: () => {},
                  child: Text(
                    error,
                    style: TextStyle(
                        fontSize: 15,
                        fontWeight: FontWeight.bold,
                        color: Colors.red),
                  ),
                ),
              ),
              SizedBox(height: size.height * 0.05),
              Container(
                alignment: Alignment.center,
                margin: EdgeInsets.symmetric(horizontal: 40, vertical: 10),
                child: RaisedButton(
                  onPressed: () {
                    logIn();
                  },
                  shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(80.0)),
                  textColor: Colors.white,
                  padding: const EdgeInsets.all(0),
                  child: Container(
                    alignment: Alignment.center,
                    height: 50.0,
                    width: size.width * 0.5,
                    decoration: new BoxDecoration(
                        //color: Colors.blue,
                        borderRadius: BorderRadius.circular(80.0),
                        gradient: new LinearGradient(colors: [
                          Constants.PRIMARY_COLOR,
                          Constants.HEAVY_BLUE
                          // Color.fromARGB(255, 255, 136, 34),
                          // Color.fromARGB(255, 255, 177, 41)
                        ])),
                    padding: const EdgeInsets.all(0),
                    child: Text(
                      "Đăng nhập",
                      textAlign: TextAlign.center,
                      style: TextStyle(fontWeight: FontWeight.bold),
                    ),
                  ),
                ),
              ),
              Container(
                alignment: Alignment.center,
                margin: EdgeInsets.symmetric(horizontal: 40, vertical: 10),
                child: GestureDetector(
                  onTap: () => {
                    Navigator.push(context,
                        MaterialPageRoute(builder: (context) => Register()))
                  },
                  child: Text(
                    "Bạn chưa có tài khoản? Hãy đăng kí",
                    style: TextStyle(
                        fontSize: 12,
                        fontWeight: FontWeight.bold,
                        color: Color(0xFF2661FA)),
                  ),
                ),
              )
            ],
          ),
        ),
      ),
    );
  }
}
