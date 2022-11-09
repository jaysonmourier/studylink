import 'package:flutter/material.dart';
import 'package:studylink_web/widgets/form.dart';

// widgets
import 'widgets/post.dart';

void main() {
  runApp(const Studylink());
}

class Studylink extends StatelessWidget {
  const Studylink({super.key});


  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Studylink',
      theme: ThemeData(
        
        primarySwatch: Colors.blue,
      ),
      home: Scaffold(
        body: SafeArea(
          child: Container(
            padding: EdgeInsets.all(20),
            width: 500,
            child: FormWidget(),
            alignment: Alignment.center,
          ),
        ),
      )
    );
  }
}
