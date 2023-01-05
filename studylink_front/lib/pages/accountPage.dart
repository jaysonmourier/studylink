import 'package:flutter/material.dart';
import 'package:studylink_web/widgets/AccountWidget.dart';

class AccountPage extends StatefulWidget {
  const AccountPage({super.key});

  @override
  State<StatefulWidget> createState() {
    return AccountPageState();
  }
}

class AccountPageState extends State<AccountPage> {
  @override
  Widget build(BuildContext context) {
    return const Scaffold(
      body: AccountWidget(),
    );
  }
}
