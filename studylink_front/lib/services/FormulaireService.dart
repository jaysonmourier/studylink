import 'dart:convert';
import 'package:studylink_web/env.dart';
import 'package:studylink_web/models/Formulaire.dart';
import 'package:http/http.dart' as http;

Future<Formulaire> createFormulaire(
    String date_diplome,
    String date_prm_emploi,
    String salaire_prm_emploi,
    String dans_entreprise,
    String salaire_actuel,
    String secteur,
    String taille_entreprise) async {
  print("${Env.HOST_API}:${Env.HOST_PORT}/stats");
  final response = await http.post(
    Uri.parse("${Env.HOST_API}:${Env.HOST_PORT}/stats"),
    headers: <String, String>{
      'Content-Type': 'application/json; charset=UTF-8'
    },
    body: jsonEncode(<String, dynamic>{
      //'date_diplome': int.parse(date_diplome),
      'firstJobDelay': 3, //int.parse(date_prm_emploi),
      'firstGrossSalary': double.parse(salaire_prm_emploi),
      'sameCompany': true,
      'currentGrossSalary': double.parse(salaire_actuel),
      'currentCompanyDomain': secteur,
      'currentCompanySize': taille_entreprise,
      // 'currentJobDelay': 3,
    }),
  );

  print(
    jsonEncode(<String, dynamic>{
      //'date_diplome': int.parse(date_diplome),
      'firstJobDelay': 3, //int.parse(date_prm_emploi),
      'firstGrossSalary': double.parse(salaire_prm_emploi),
      'sameCompany': true,
      'currentGrossSalary': double.parse(salaire_actuel),
      'currentCompanyDomain': secteur,
      'currentCompanySize': taille_entreprise,
      'currentJobDelay': 3,
    }),
  );
  print(response.statusCode);

  if (response.statusCode == 200) {
    return Formulaire.fromJson(jsonDecode(response.body));
  } else {
    throw Exception('Failed to create Formulaire.');
  }
}
