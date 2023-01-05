import 'dart:convert';

import 'package:studylink_web/env.dart';
import 'package:studylink_web/models/Account.dart';
import 'package:http/http.dart' as http;

Future<Account> createAccount(String name, String lastname, String mail,
    String password, String dateNaissance) async {
  final response = await http.post(
    Uri.parse("${Env.HOST_API}:${Env.HOST_PORT}/user"),
    headers: <String, String>{
      'Content-Type': 'application/json; charset=UTF-8'
    },
    body: jsonEncode(<String, String>{
      'name': name,
      'lastname': lastname,
      'mail': mail,
      'password': password,
      'dateNaissance': dateNaissance,
    }),
  );

  if (response.statusCode == 200) {
    return Account.fromJson(jsonDecode(response.body));
  } else {
    throw Exception('Failed to create Account.');
  }
}
