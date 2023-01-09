import 'package:flutter/material.dart';
import 'package:studylink_web/pages/chartPage.dart';
import 'package:studylink_web/pages/formPage.dart';
import 'package:studylink_web/pages/postPage.dart';

class HomePage extends StatefulWidget {
  const HomePage({super.key});

  @override
  State<HomePage> createState() {
    return HomePageState();
  }
}

class HomePageState extends State<HomePage> {
  int _selectedIndex = 0;
  void _onItemTapped(int index) {
    setState(() {
      _selectedIndex = index;
    });
  }
  static List<Widget> _widgetOptions =  <Widget>[
    HomePage(),
    chartPage(),
  ];
  @override
  Widget build(BuildContext context) {
    return Text('Studylink Home Page');
  }
}