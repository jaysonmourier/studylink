import 'dart:convert';

import 'package:flutter/material.dart';

import '../models/Post.dart';
import 'package:studylink_web/env.dart';
import 'package:http/http.dart' as http;

class PostWidget extends StatefulWidget {
  const PostWidget({super.key});

  @override
  State<StatefulWidget> createState() {
    // TODO: implement createState
    return PostWidgetState();
  }
}

class PostWidgetState extends State<PostWidget> {
  String id = "d2885df9-22b1-4946-addd-e2be47806bf5";
  //Post post = createPost("b42d7cca-e862-428f-b5f5-1dc2d5c09064") as Post;

  @override
  Widget build(BuildContext context) {
    //print(post.content);
    return FutureBuilder(
      future: createPost(id),
      builder:(context, snapshot) {
        if(snapshot.connectionState == ConnectionState.done) {
          return Container(
        padding: const EdgeInsets.all(10),
        child: Column(
          children: [
            Row(
              children: const [CircleAvatar(radius: 30)],
            ),
            Row(
              children: [
                Expanded(
                    child: Text(snapshot.data!.content))
              ],
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.end,
              children: [
                TextButton(onPressed: () => {}, child: const Text('like')),
                TextButton(onPressed: () => {}, child: const Text('comment'))
              ],
            ),
          ],
        ));
        } else {
          return const CircularProgressIndicator();
        }
      },
    );
  }
}

Future<Post> createPost(String id) async {
  final response = await http.get(
      Uri.parse("${Env.HOST_API}:${Env.HOST_PORT}/posts/${id}"),
      headers: <String, String>{
        'Content-Type': 'application/json; charset=UTF-8'
      });
  if (response.statusCode == 200) {
    return Post.fromJson(jsonDecode(response.body));
  } else {
    throw Exception('Failed to create Post.');
  }
}
