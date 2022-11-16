import 'dart:convert';
import 'package:http/http.dart' as http;
import 'package:studylink_web/models/Post.dart';
import 'package:studylink_web/params.dart';


Future<Post> createPost(String content) async {
  final response = await http.post(
    Uri.parse(Params().build("posts")),
    headers: <String, String>{
      'Content-Type': 'application/json; charset=UTF-8'
    },
    body: jsonEncode(<String, String>{
      'content': content,
    }),
  );
  
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