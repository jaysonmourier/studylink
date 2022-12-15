import 'package:flutter/material.dart';
import 'package:studylink_web/responsive/Screens.dart';

class ResponsiveLayout extends StatelessWidget {
  final Widget mobileBody;
  final Widget desktopBody;

  ResponsiveLayout({required this.mobileBody, required this.desktopBody});

  @override
  Widget build(BuildContext context) {
    return LayoutBuilder(builder: (context, constraints) {
      if(constraints.maxWidth < Screens.PHONE_WIDTH) {
        return mobileBody;
      } else {
        return desktopBody;
      }
    });
  }
}
