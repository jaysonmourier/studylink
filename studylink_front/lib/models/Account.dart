class Account {
  final String name;
  final String lastname;
  final String mail;
  final String password;
  final DateTime created_at;
  const Account(
      {required this.name,
      required this.lastname,
      required this.mail,
      required this.password,
      required this.created_at});

  factory Account.fromJson(Map<String, dynamic> json) {
    return Account(
        name: json['name'],
        lastname: json['lastname'],
        mail: json['mail'],
        password: json['password'],
        created_at: DateTime.parse(json['creationDate']));
  }
}
