// https://docs.flutter.dev/cookbook/forms/validation

import 'dart:convert';

import 'package:studylink_web/models/Post.dart';

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
                contentController.text = " ";
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

Future<Post> createPost(String content) async {
  print("1");
  final response = await http.post(
    Uri.parse('http://localhost:8081/posts'),
    headers: <String, String>{
      'Content-Type': 'application/json; charset=UTF-8'
    },
    body: jsonEncode(<String, String>{
      'content': content,
    }),
  );
  print(response.statusCode);
  if (response.statusCode == 200) {
    // If the server did return a 201 CREATED response,
    // then parse the JSON.
    return Post.fromJson(jsonDecode(response.body));
  } else {
    // If the server did not return a 201 CREATED response,
    // then throw an exception.
    throw Exception('Failed to create Post.');
  }
}
