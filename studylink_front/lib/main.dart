import 'package:flutter/material.dart';
import 'package:studylink_web/pages/formPage.dart';
import 'package:studylink_web/pages/postPage.dart';

// widgets

void main() {
  String myurl = Uri.base.toString();
  String? para1 = Uri.base.queryParameters["id"];
  runApp(const Studylink());
}

class Studylink extends StatelessWidget {
  const Studylink({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      initialRoute: '/',
      routes: {
        '/':(context) => const FormPage(),
        '/get':(context) => const PostPage()
      },
    );
  }
}
