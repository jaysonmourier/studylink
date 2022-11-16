import 'package:flutter/material.dart';
import 'package:studylink_web/widgets/FormWidget.dart';

class FormPage extends StatefulWidget {
  const FormPage({super.key});
  
  @override
  State<StatefulWidget> createState() {
    return FormPageState();
  }
}

class FormPageState extends State<FormPage> {
  @override
  Widget build(BuildContext context) {
    return const Scaffold(
      body: FormWidget(),
    );
  }

}