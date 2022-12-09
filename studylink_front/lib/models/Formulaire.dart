class Formulaire {
  final String date_diplome;
  final Sring date_prm_emploi;
  final Integer salaire_prm_emploi;
  final Integer salaire_actuel;
  final String taille_entreprise;
  final DateTime created_at;
  const Formulaire({required this.date_diplome, required this.date_prm_emploi, 
              required this.salaire_prm_emploi, required this.salaire_actuel, 
              required this.taille_entreprise,required this.created_at});

  factory Formulaire.fromJson(Map<String, dynamic> json) {
    return Formulaire(
      date_diplome : json['date_diplome'],
      date_premier_emploi : json['date_prm_emploi'],
      salaire_prm_emploi: Integer.parse(json['salaire_prm_emploi']),
      salaire_actuel: Integer.parse(json['salaire_actuel']),  
      taille_entreprise : json['taille_entreprise'],
      created_at: DateTime.parse(json['creationDate'])
    );
  }