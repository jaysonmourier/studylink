import 'package:flutter/material.dart';
import 'package:studylink_web/pages/HomePage.dart';
import 'package:studylink_web/pages/chartPage.dart';
import 'package:studylink_web/pages/postPage.dart';

class MainApp extends StatelessWidget {
  const MainApp({super.key});

  static const String _title = 'Flutter Code Sample';

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      title: _title,
      home: MainAppState(),
    );
  }
}

class MainAppState extends StatefulWidget {
  const MainAppState({super.key});

  @override
  State<MainAppState> createState() => _MainAppState();
}

class _MainAppState extends State<MainAppState> {
  int _selectedIndex = 0;
  static const TextStyle optionStyle =
      TextStyle(fontSize: 30, fontWeight: FontWeight.bold);
  static const List<Widget> _widgetOptions = <Widget>[
    HomePage(),
    chartPage(),
    PostPage(id: '25312fd3-9b1f-4e29-b7f2-24a56aec9b08'),
  ];

  void _onItemTapped(int index) {
    setState(() {
      _selectedIndex = index;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('BottomNavigationBar Sample'),
      ),
      body: Center(
        child: _widgetOptions.elementAt(_selectedIndex),
      ),
      bottomNavigationBar: BottomNavigationBar(
        items: const <BottomNavigationBarItem>[
          BottomNavigationBarItem(
            icon: Icon(Icons.home),
            label: 'Home',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.auto_graph_rounded),
            label: 'Statistiques',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.message),
            label: 'Les posts',
          ),
        ],
        currentIndex: _selectedIndex,
        selectedItemColor: Colors.amber[800],
        onTap: _onItemTapped,
      ),
    );
  }
}
