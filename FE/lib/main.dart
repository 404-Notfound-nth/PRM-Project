import 'dart:io';

import 'package:clinicbookingapp/views/login/login.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

final GlobalKey<NavigatorState> firstTabNavKey = GlobalKey<NavigatorState>();
final GlobalKey<NavigatorState> secondTabNavKey = GlobalKey<NavigatorState>();
final GlobalKey<NavigatorState> thirdTabNavKey = GlobalKey<NavigatorState>();

class MyHttpOverrides extends HttpOverrides {
  @override
  HttpClient createHttpClient(SecurityContext context) {
    return super.createHttpClient(context)
      ..badCertificateCallback =
          (X509Certificate cert, String host, int port) => true;
  }
}

void main() {
  HttpOverrides.global = new MyHttpOverrides();
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Dental Clinic Booking',
      theme: ThemeData(
        primaryColor: Colors.white,
//        textTheme: Theme.of(context).textTheme.apply(bodyColor: Constants.BLACK),
        visualDensity: VisualDensity.adaptivePlatformDensity,
      ),
      home: LoginScreen(),
      // new CupertinoApp(
      //   home: //LoginScreen(),
      //       DentalList(
      //     dental: [
      //       new Dental('Nha khoa Tâm Như', '200/1 Nguyễn Trọng Tuyển', 5),
      //       new Dental('nha khoa Kim', '211/41 Hoàng Văn Thụ', 5)
      //     ],
      //   ),
      //   localizationsDelegates: const <LocalizationsDelegate<dynamic>>[
      //     DefaultMaterialLocalizations.delegate,
      //     DefaultWidgetsLocalizations.delegate,
      //   ],
      // ),
    );
  }
}
