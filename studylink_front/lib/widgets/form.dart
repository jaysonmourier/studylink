// https://docs.flutter.dev/cookbook/forms/validation

import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;

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
                if (_formKey.currentState!.validate()) {
                  Future<http.Response> createAlbum(String title) {
                    return http.post(
                      Uri.parse('http://localhost:8082/posts'),
                      headers: <String, String>{
                        'Content-Type': 'application/json; charset=UTF-8',
                      },
                      body: jsonEncode(<String, String>{
                        'content': contentController.text,
                      }),
                    );
                  }
                }
              }),
              child: const Icon(Icons.send))
        ],
      ),
    );
  }
}
