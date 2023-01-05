import 'package:flutter/material.dart';
import 'package:studylink_web/pages/formPage.dart';

class HomeHeroAppSectionMobile extends StatelessWidget {
  const HomeHeroAppSectionMobile({super.key});

  @override
  Widget build(BuildContext context) {
    return Padding(padding: const EdgeInsets.only(left: 0, top: 20, right: 0, bottom: 20), child: OutlinedButton(
      onPressed: () {
        debugPrint('Received click');
        Navigator.of(context)
          .push(MaterialPageRoute(builder: (_) => const FormPage()));
      },
      child: const Text('Access to the App'),
    ));
  }
}