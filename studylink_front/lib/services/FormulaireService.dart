import 'dart:convert';
import 'package:studylink_web/env.dart';
import 'package:studylink_web/models/Formulaire.dart';
import 'package:http/http.dart' as http;

Future<Formulaire> createFormulaire(String content) async {
  final response = await http.post(
    Uri.parse("${Env.HOST_API}:${Env.HOST_PORT}/formulaire"),
    headers: <String, String>{
      'Content-Type': 'application/json; charset=UTF-8'
    },
    body: jsonEncode(<String, String>{
      'content': content,
    }),
  );
  if (response.statusCode == 200) {
    return Formulaire.fromJson(jsonDecode(response.body));
  } else {
    throw Exception('Failed to create Post.');
  }
}
