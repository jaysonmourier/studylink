// https://docs.flutter.dev/cookbook/forms/validation

import 'dart:convert';
import 'package:studylink_web/models/Post.dart';
import 'package:flutter/material.dart';
import 'package:studylink_web/services/postService.dart';

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
  TextEditingController contentController = new TextEditingController();

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
                }
              }),
              child: const Icon(Icons.send))
        ],
      ),
    );
  }
}
