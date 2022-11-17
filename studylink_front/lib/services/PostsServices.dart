import 'dart:convert';

import 'package:studylink_web/env.dart';
import 'package:studylink_web/models/Post.dart';
import 'package:http/http.dart' as http;

Future<Post> getPost(String id) async {
  final response = await http.get(
      Uri.parse("${Env.HOST_API}:${Env.HOST_PORT}/posts/$id"),
      headers: <String, String>{
        'Content-Type': 'application/json; charset=UTF-8'
      });
  if (response.statusCode == 200) {
    return Post.fromJson(jsonDecode(response.body));
  } else {
    throw Exception('Failed to get Post.');
  }
}
