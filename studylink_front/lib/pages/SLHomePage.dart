import 'package:flutter/material.dart';
import 'package:studylink_web/responsive/HomeHeroAppSectionMobile.dart';
import 'package:studylink_web/responsive/HomePageDesktop.dart';
import 'package:studylink_web/responsive/HomePageMobile.dart';
import 'package:studylink_web/responsive/responsive_layout.dart';

class SLHomePage extends StatelessWidget {
  const SLHomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
      child: Column(
        children: const [
          ResponsiveLayout(
              mobileBody: HomePageMobile(),
              desktopBody: HomePageMobile()),
          ResponsiveLayout(mobileBody: HomeHeroAppSectionMobile(), desktopBody: HomeHeroAppSectionMobile())
        ],
      ),
    );
  }
}
