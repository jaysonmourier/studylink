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
  print("${Env.HOST_API}:${Env.HOST_PORT}/formulaire");
  final response = await http.post(
    Uri.parse("${Env.HOST_API}:${Env.HOST_PORT}/formulaire"),
    headers: <String, String>{
      'Content-Type': 'application/json; charset=UTF-8'
    },
    body: jsonEncode(<String, String>{
      'date_diplome': date_diplome,
      'date_prm_emploi': date_prm_emploi,
      'salaire_prm_emploi': salaire_prm_emploi,
      'dans_entreprise': dans_entreprise,
      'salaire_actuel': salaire_actuel,
      'secteur': secteur,
      'taille_entreprise': taille_entreprise,
    }),
  );
  print(response.statusCode);
  if (response.statusCode == 200) {
    return Formulaire.fromJson(jsonDecode(response.body));
  } else {
    throw Exception('Failed to create Formulaire.');
  }
}
