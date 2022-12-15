import 'package:flutter/material.dart';

class SLHomePage extends StatelessWidget  {
  const SLHomePage({super.key});

  @override
  Widget build(BuildContext context) {
    final currentWidth = MediaQuery.of(context).size.width;
    return Scaffold(
      backgroundColor: currentWidth > 500 ? Colors.red : Colors.blue,
      body: Center(
        child: Text(currentWidth.toString()),
      ),
    );
  }

}