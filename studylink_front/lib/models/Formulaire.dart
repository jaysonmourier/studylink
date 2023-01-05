class Formulaire {
  final String date_diplome;
  final String date_prm_emploi;
  final String salaire_prm_emploi;
  final String dans_entreprise;
  final String salaire_actuel;
  final String taille_entreprise;
  final String secteur;
  final DateTime created_at;
  const Formulaire(
      {required this.date_diplome,
      required this.date_prm_emploi,
      required this.salaire_prm_emploi,
      required this.dans_entreprise,
      required this.salaire_actuel,
      required this.secteur,
      required this.taille_entreprise,
      required this.created_at});

  factory Formulaire.fromJson(Map<String, dynamic> json) {
    return Formulaire(
        date_diplome: json['date_diplome'],
        date_prm_emploi: json['date_prm_emploi'],
        salaire_prm_emploi: json['salaire_prm_emploi'],
        dans_entreprise: json['dans_entreprise'],
        salaire_actuel: json['salaire_actuel'],
        secteur: json['secteur'],
        taille_entreprise: json['taille_entreprise'],
        created_at: DateTime.parse(json['creationDate']));
  }
}
