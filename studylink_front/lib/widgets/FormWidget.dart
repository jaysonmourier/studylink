// https://docs.flutter.dev/cookbook/forms/validation

import 'package:flutter/material.dart';
import 'package:studylink_web/services/PostsServices.dart';

class FormWidget extends StatefulWidget {
  const FormWidget({super.key});

  @override
  FormWidgetState createState() {
    return FormWidgetState();
  }
}

class FormWidgetState extends State<FormWidget> {
  /* 
    Une clé globale identifie de manière unique des élèments dans toute
    l'application.
   */
  final _formKey = GlobalKey<FormState>();
  TextEditingController contentController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Form(
      key: _formKey,
      child: Column(
        children: <Widget>[
          TextFormField(
            controller: contentController,
            decoration: const InputDecoration(hintText: "What's new?"),
          ),
          ElevatedButton(
              onPressed: (() {
                print(contentController.text);
                if (_formKey.currentState!.validate()) {
                  createPost(contentController.text);
                  contentController.text = "";
                }
              }),
              child: const Icon(Icons.send))
        ],
      ),
    );
  }
}
