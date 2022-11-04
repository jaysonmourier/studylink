import 'package:flutter/material.dart';

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
      home: const MyHome()
    );
  }
}

class MyHome extends StatelessWidget {
  const MyHome({super.key});
  
  @override
  Widget build(BuildContext context) {
    return const Scaffold(
      body: const Text('hello world!!'),
    );
  }
}
