import 'dart:convert';

import 'package:studylink_web/env.dart';
import 'package:studylink_web/models/Account.dart';
import 'package:http/http.dart' as http;

Future<Account> createAccount(String name, String lastname, String email,
    String password, String dateNaissance) async {
  final payload = jsonEncode(<String, String>{
    'name': name,
    'lastname': lastname,
    'email': email,
    'password': password,
    'dateNaissance': dateNaissance,
  });
  print(payload);
  final response = await http.post(
    Uri.parse("${Env.HOST_API}:${Env.HOST_PORT}/user"),
    headers: <String, String>{
      'Content-Type': 'application/json; charset=UTF-8'
    },
    body: payload,
  );

  if (response.statusCode == 201) {
    return Account.fromJson(jsonDecode(response.body));
  } else {
    throw Exception('Failed to create Account.');
  }
}
