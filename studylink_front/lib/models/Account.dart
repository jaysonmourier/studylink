class Account {
  final String id;
  final String name;
  final String lastname;
  final String email;
  final String password;
  final String dateNaissance;
  final DateTime dateCreation;
  const Account(
      {required this.name,
      required this.id,
      required this.lastname,
      required this.email,
      required this.password,
      required this.dateNaissance,
      required this.dateCreation});

  factory Account.fromJson(Map<String, dynamic> json) {
    return Account(
        id: json['id'],
        name: json['name'],
        lastname: json['lastname'],
        email: json['email'],
        password: json['password'],
        dateNaissance: json['dateNaissance'],
        dateCreation: DateTime.parse(json['dateCreation']));
  }
}
