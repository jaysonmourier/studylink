import 'package:beamer/beamer.dart';
import 'package:flutter/material.dart';
import 'package:studylink_web/pages/HomePage.dart';
import 'package:studylink_web/pages/accountPage.dart';
import 'package:studylink_web/pages/formPage.dart';
import 'package:studylink_web/pages/postPage.dart';
import 'package:studylink_web/pages/formulairePage.dart';
// widgets

void main() {
  String myurl = Uri.base.toString();
  String? para1 = Uri.base.queryParameters["id"];
  runApp(const Studylink());
}

class Studylink extends StatefulWidget {
  const Studylink({super.key});

  @override
  State<StatefulWidget> createState() {
    return StudylinkState();
  }
}

class StudylinkState extends State<Studylink> {
  final routeDelegate = BeamerDelegate(
    locationBuilder: RoutesLocationBuilder(routes: {
      '/': (context, state, data) => const HomePage(),
      '/posts': (context, state, data) => const FormPage(),
      '/formulaire': (context, state, data) => const FormulairePage(),
      '/account': (context, state, data) => const AccountPage(),
      '/posts/:id': (context, state, data) {
        final id = state.pathParameters['id']!;
        return BeamPage(
            key: ValueKey('post-$id'),
            title: 'A simple post',
            type: BeamPageType.scaleTransition,
            child: PostPage(id: id));
      }
    }),
  );

  @override
  Widget build(BuildContext context) {
    return MaterialApp.router(
      routeInformationParser: BeamerParser(),
      routerDelegate: routeDelegate,
    );
  }
}
