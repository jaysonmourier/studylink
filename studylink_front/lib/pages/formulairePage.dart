import 'package:flutter/material.dart';
import '../widgets/FormulaireWidget.dart';

class FormPage extends StatefulWidget {
  const FormPage({super.key});

  @override
  State<StatefulWidget> createState() {
    return FormulairePage();
  }
}

class FormulairePage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return const Scaffold(
      body: FormulaireWidget(),
    );
  }
}
