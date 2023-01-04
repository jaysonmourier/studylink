class Formulaire {
  final int date_diplome;
  final int date_prm_emploi;
  final double salaire_prm_emploi;
  final bool dans_entreprise;
  final double salaire_actuel;
  final String taille_entreprise;
  final String secteur;
  const Formulaire(
      {required this.date_diplome,
      required this.date_prm_emploi,
      required this.salaire_prm_emploi,
      required this.dans_entreprise,
      required this.salaire_actuel,
      required this.secteur,
      required this.taille_entreprise});

  factory Formulaire.fromJson(Map<String, dynamic> json) {
    return Formulaire(
        date_diplome: json['currentJobDelay'],
        date_prm_emploi: json['firstJobDelay'],
        salaire_prm_emploi: json['firstGrossSalary'],
        dans_entreprise: json['sameCompany'],
        salaire_actuel: json['currentGrossSalary'],
        secteur: json['currentCompanyDomain'],
        taille_entreprise: json['currentCompanySize']);
  }
}
