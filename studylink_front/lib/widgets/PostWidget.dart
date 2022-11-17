import 'dart:convert';

import 'package:flutter/material.dart';

import '../models/Post.dart';
import 'package:studylink_web/env.dart';
import 'package:http/http.dart' as http;

class PostWidget extends StatefulWidget {
  String id;
  PostWidget({super.key, required this.id});

  @override
  State<StatefulWidget> createState() {
    return PostWidgetState();
  }
}

class PostWidgetState extends State<PostWidget> {
  @override
  Widget build(BuildContext context) {
    //print(post.content);
    return FutureBuilder(
      future: getPost(widget.id),
      builder: (context, snapshot) {
        if (snapshot.hasData) {
          return Container(
              padding: const EdgeInsets.all(10),
              child: Column(
                children: [
                  Row(
                    children: const [CircleAvatar(radius: 30)],
                  ),
                  Row(
                    children: [Expanded(child: Text(snapshot.data!.content))],
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.end,
                    children: [
                      TextButton(
                          onPressed: () => {}, child: const Text('like')),
                      TextButton(
                          onPressed: () => {}, child: const Text('comment'))
                    ],
                  ),
                ],
              ));
        } else if (snapshot.hasError) {
          return const Text('error');
        } else {
          return const CircularProgressIndicator();
        }
      },
    );
  }
}

Future<Post?> getPost(String id) async {
  final response = await http.get(
      Uri.parse("${Env.HOST_API}:${Env.HOST_PORT}/posts/$id"),
      headers: <String, String>{
        'Content-Type': 'application/json; charset=UTF-8'
      });
  if (response.statusCode == 200) {
    return Post.fromJson(jsonDecode(response.body));
  } else if (response.statusCode == 400) {
    throw Exception('Failed to get Post.');
  } else {
    throw Exception('Failed to create Post.');
  }
}
