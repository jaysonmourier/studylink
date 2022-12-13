// ignore_for_file: prefer_const_constructors, sort_child_properties_last

import 'package:flutter/material.dart';

class FormulaireWidget extends StatefulWidget {
  const FormulaireWidget({Key? key}) : super(key: key);

  @override
  State<StatefulWidget> createState() {
    return FormulaireWidgetState();
  }
}

enum Premierjob { tresrapide, rapide, moyen, lent }

enum MemeEntreprise { oui, non }

enum TailleEntreprise { trespetite, petite, moyenne, grande }

class FormulaireWidgetState extends State<FormulaireWidget> {
  String? dropDownValue;
  String? radioButtonValue1;
  TextEditingController? textController1;
  TextEditingController? textController2;
  String? radioButtonValue2;
  TextEditingController? textController3;
  String? radioButtonValue3;
  final scaffoldKey = GlobalKey<ScaffoldState>();

  @override
  void initState() {
    super.initState();
    textController1 = TextEditingController();
    textController2 = TextEditingController();
    textController3 = TextEditingController();
  }

  @override
  void dispose() {
    textController1?.dispose();
    textController2?.dispose();
    textController3?.dispose();
    super.dispose();
  }

  Premierjob? _dureepremierjob = Premierjob.tresrapide;
  MemeEntreprise? _memeentreprise = MemeEntreprise.oui;
  TailleEntreprise? _tailleentreprise = TailleEntreprise.trespetite;
  final List<String> _secteur = [
    'Agroalimentaire',
    'Banque & Assurance',
    'Bois - Papier - Carton - Imprimerie',
    'BTP - Matériaux de construction',
    'Chimie - Parachimie',
    'Commerce - Négoce - Distribution',
    'Edition - Communication - Multimédia',
    'Électronique - Électricité',
    'Études & Conseils',
    'Industrie',
    'Pharmaceutique',
    'Informatique - Télécoms',
    'Machines & Équipements',
    'Automobile',
    'Métallurgie',
    'Services aux Entreprises',
    'Textile - Habillement - Chaussure',
    'Transports - Logistique'
  ];

  // the selected value
  String? _selectedsecteur;
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      key: scaffoldKey,
      appBar: AppBar(
        automaticallyImplyLeading: false,
        title: Text(
          'Formulaire',
        ),
        actions: [],
        centerTitle: false,
        elevation: 2,
      ),
      body: SafeArea(
        child: GestureDetector(
          onTap: () => FocusScope.of(context).unfocus(),
          child: Container(
            width: double.infinity,
            height: 650,
            child: Column(
              mainAxisSize: MainAxisSize.max,
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(
                  'En quelle année avez-vous été diplômé de votre master MIAGE à l\'université Paris Nanterre ?',
                ),
                Expanded(
                  child: Align(
                    alignment: AlignmentDirectional(0, 0),
                    child: TextFormField(
                      controller: textController1,
                      autofocus: true,
                      obscureText: false,
                      decoration: InputDecoration(
                        hintText: 'Ex : 2015',
                        enabledBorder: UnderlineInputBorder(
                          borderSide: BorderSide(
                            color: Color(0x00000000),
                            width: 1,
                          ),
                          borderRadius: const BorderRadius.only(
                            topLeft: Radius.circular(4.0),
                            topRight: Radius.circular(4.0),
                          ),
                        ),
                        focusedBorder: UnderlineInputBorder(
                          borderSide: BorderSide(
                            color: Color(0x00000000),
                            width: 1,
                          ),
                          borderRadius: const BorderRadius.only(
                            topLeft: Radius.circular(4.0),
                            topRight: Radius.circular(4.0),
                          ),
                        ),
                        errorBorder: UnderlineInputBorder(
                          borderSide: BorderSide(
                            color: Color(0x00000000),
                            width: 1,
                          ),
                          borderRadius: const BorderRadius.only(
                            topLeft: Radius.circular(4.0),
                            topRight: Radius.circular(4.0),
                          ),
                        ),
                        focusedErrorBorder: UnderlineInputBorder(
                          borderSide: BorderSide(
                            color: Color(0x00000000),
                            width: 1,
                          ),
                          borderRadius: const BorderRadius.only(
                            topLeft: Radius.circular(4.0),
                            topRight: Radius.circular(4.0),
                          ),
                        ),
                      ),
                    ),
                  ),
                ),
                Divider(),
                Text(
                  'Combien de temps avez-vous mis pour trouver votre premier travail après l\'obtention de votre diplôme?',
                ),
                Row(
                  children: <Widget>[
                    ConstrainedBox(
                      constraints: BoxConstraints(
                        /// Just an example, but this makes sure, that since you set a fixed width like 300.0, on small screens this won't get too big. For example by setting a maxWidth constraint like this, its width will be 300.0, but at max as big as 1 / 3 of the screen width so it gets smaller on small screen sizes
                        maxWidth: MediaQuery.of(context).size.width / 3,
                      ),
                      child: SizedBox(
                        /// Enter your fixed width here, 300.0 ist just an example
                        width: 300.0,
                        child: ListTile(
                          title: const Text('0-3 mois'),
                          leading: Radio<Premierjob>(
                            value: Premierjob.tresrapide,
                            groupValue: _dureepremierjob,
                            onChanged: (Premierjob? value) {
                              setState(() {
                                _dureepremierjob = value;
                              });
                            },
                          ),
                        ),
                      ),
                    ),
                    Expanded(
                      child: ListTile(
                        title: const Text('3-6 mois'),
                        leading: Radio<Premierjob>(
                          value: Premierjob.rapide,
                          groupValue: _dureepremierjob,
                          onChanged: (Premierjob? value) {
                            setState(() {
                              _dureepremierjob = value;
                            });
                          },
                        ),
                      ),
                    ),
                    Expanded(
                      child: ListTile(
                        title: const Text('6-9 mois'),
                        leading: Radio<Premierjob>(
                          value: Premierjob.moyen,
                          groupValue: _dureepremierjob,
                          onChanged: (Premierjob? value) {
                            setState(() {
                              _dureepremierjob = value;
                            });
                          },
                        ),
                      ),
                    ),
                    Expanded(
                      child: ListTile(
                        title: const Text('Supérieur à 9 mois'),
                        leading: Radio<Premierjob>(
                          value: Premierjob.lent,
                          groupValue: _dureepremierjob,
                          onChanged: (Premierjob? value) {
                            setState(() {
                              _dureepremierjob = value;
                            });
                          },
                        ),
                      ),
                    )
                  ],
                ),
                Divider(),
                Text(
                  'Salaire brut annuel du premier travail (en €)',
                ),
                TextFormField(
                  controller: textController2,
                  autofocus: true,
                  obscureText: false,
                  decoration: InputDecoration(
                    hintText: 'Ex : 12123',
                    enabledBorder: UnderlineInputBorder(
                      borderSide: BorderSide(
                        color: Color(0x00000000),
                        width: 1,
                      ),
                      borderRadius: const BorderRadius.only(
                        topLeft: Radius.circular(4.0),
                        topRight: Radius.circular(4.0),
                      ),
                    ),
                    focusedBorder: UnderlineInputBorder(
                      borderSide: BorderSide(
                        color: Color(0x00000000),
                        width: 1,
                      ),
                      borderRadius: const BorderRadius.only(
                        topLeft: Radius.circular(4.0),
                        topRight: Radius.circular(4.0),
                      ),
                    ),
                    errorBorder: UnderlineInputBorder(
                      borderSide: BorderSide(
                        color: Color(0x00000000),
                        width: 1,
                      ),
                      borderRadius: const BorderRadius.only(
                        topLeft: Radius.circular(4.0),
                        topRight: Radius.circular(4.0),
                      ),
                    ),
                    focusedErrorBorder: UnderlineInputBorder(
                      borderSide: BorderSide(
                        color: Color(0x00000000),
                        width: 1,
                      ),
                      borderRadius: const BorderRadius.only(
                        topLeft: Radius.circular(4.0),
                        topRight: Radius.circular(4.0),
                      ),
                    ),
                  ),
                ),
                Divider(),
                Text(
                  'Êtes-vous encore dans cette entreprise ?',
                ),
                Row(
                  children: <Widget>[
                    ConstrainedBox(
                      constraints: BoxConstraints(
                        /// Just an example, but this makes sure, that since you set a fixed width like 300.0, on small screens this won't get too big. For example by setting a maxWidth constraint like this, its width will be 300.0, but at max as big as 1 / 3 of the screen width so it gets smaller on small screen sizes
                        maxWidth: MediaQuery.of(context).size.width / 3,
                      ),
                      child: SizedBox(
                        /// Enter your fixed width here, 300.0 ist just an example
                        width: 300.0,
                        child: ListTile(
                          title: const Text('oui'),
                          leading: Radio<MemeEntreprise>(
                            value: MemeEntreprise.oui,
                            groupValue: _memeentreprise,
                            onChanged: (MemeEntreprise? value) {
                              setState(() {
                                _memeentreprise = value;
                              });
                            },
                          ),
                        ),
                      ),
                    ),
                    Expanded(
                      child: ListTile(
                        title: const Text('non'),
                        leading: Radio<MemeEntreprise>(
                          value: MemeEntreprise.non,
                          groupValue: _memeentreprise,
                          onChanged: (MemeEntreprise? value) {
                            setState(() {
                              _memeentreprise = value;
                            });
                          },
                        ),
                      ),
                    ),
                  ],
                ),
                Divider(),
                Text(
                  'Salaire brut annuel dans votre entreprise actuelle (en  €)',
                ),
                TextFormField(
                  controller: textController3,
                  autofocus: true,
                  obscureText: false,
                  decoration: InputDecoration(
                    hintText: 'Ex : 29876',
                    enabledBorder: UnderlineInputBorder(
                      borderSide: BorderSide(
                        color: Color(0x00000000),
                        width: 1,
                      ),
                      borderRadius: const BorderRadius.only(
                        topLeft: Radius.circular(4.0),
                        topRight: Radius.circular(4.0),
                      ),
                    ),
                    focusedBorder: UnderlineInputBorder(
                      borderSide: BorderSide(
                        color: Color(0x00000000),
                        width: 1,
                      ),
                      borderRadius: const BorderRadius.only(
                        topLeft: Radius.circular(4.0),
                        topRight: Radius.circular(4.0),
                      ),
                    ),
                    errorBorder: UnderlineInputBorder(
                      borderSide: BorderSide(
                        color: Color(0x00000000),
                        width: 1,
                      ),
                      borderRadius: const BorderRadius.only(
                        topLeft: Radius.circular(4.0),
                        topRight: Radius.circular(4.0),
                      ),
                    ),
                    focusedErrorBorder: UnderlineInputBorder(
                      borderSide: BorderSide(
                        color: Color(0x00000000),
                        width: 1,
                      ),
                      borderRadius: const BorderRadius.only(
                        topLeft: Radius.circular(4.0),
                        topRight: Radius.circular(4.0),
                      ),
                    ),
                  ),
                ),
                Divider(),
                Text(
                  'Secteur d\'activité de votre entreprise actuelle',
                ),
                DropdownButton<String>(
                  value: _selectedsecteur,
                  onChanged: (value) {
                    setState(() {
                      _selectedsecteur = value;
                    });
                  },
                  hint: Text(
                    'Sélectionner le secteur',
                    style: TextStyle(color: Colors.black),
                  ),
                  // Hide the default underline
                  underline: Container(),
                  // set the color of the dropdown menu
                  isExpanded: true,

                  // The list of options
                  items: _secteur
                      .map((e) => DropdownMenuItem(
                            value: e,
                            child: Container(
                              alignment: Alignment.centerLeft,
                              child: Text(
                                e,
                                style: const TextStyle(fontSize: 18),
                              ),
                            ),
                          ))
                      .toList(),
                ),
                Divider(),
                Text(
                  'Taille de votre entreprise actuelle',
                ),
                Row(
                  children: <Widget>[
                    ConstrainedBox(
                      constraints: BoxConstraints(
                        /// Just an example, but this makes sure, that since you set a fixed width like 300.0, on small screens this won't get too big. For example by setting a maxWidth constraint like this, its width will be 300.0, but at max as big as 1 / 3 of the screen width so it gets smaller on small screen sizes
                        maxWidth: MediaQuery.of(context).size.width / 3,
                      ),
                      child: SizedBox(
                        /// Enter your fixed width here, 300.0 ist just an example
                        width: 300.0,
                        child: ListTile(
                          title: const Text(
                              'Micro-entreprise (moins de 10 personnes)'),
                          leading: Radio<TailleEntreprise>(
                            value: TailleEntreprise.trespetite,
                            groupValue: _tailleentreprise,
                            onChanged: (TailleEntreprise? value) {
                              setState(() {
                                _tailleentreprise = value;
                              });
                            },
                          ),
                        ),
                      ),
                    ),
                    Expanded(
                      child: ListTile(
                        title: const Text(
                            'Petite entreprise (de 10 à 49 personnes)'),
                        leading: Radio<TailleEntreprise>(
                          value: TailleEntreprise.petite,
                          groupValue: _tailleentreprise,
                          onChanged: (TailleEntreprise? value) {
                            setState(() {
                              _tailleentreprise = value;
                            });
                          },
                        ),
                      ),
                    ),
                  ],
                ),
                Row(
                  children: <Widget>[
                    ConstrainedBox(
                      constraints: BoxConstraints(
                        /// Just an example, but this makes sure, that since you set a fixed width like 300.0, on small screens this won't get too big. For example by setting a maxWidth constraint like this, its width will be 300.0, but at max as big as 1 / 3 of the screen width so it gets smaller on small screen sizes
                        maxWidth: MediaQuery.of(context).size.width / 3,
                      ),
                      child: SizedBox(
                        /// Enter your fixed width here, 300.0 ist just an example
                        width: 300.0,
                        child: ListTile(
                          title: const Text(
                              'Moyenne entreprise (de 50 à 249 personnes)'),
                          leading: Radio<TailleEntreprise>(
                            value: TailleEntreprise.moyenne,
                            groupValue: _tailleentreprise,
                            onChanged: (TailleEntreprise? value) {
                              setState(() {
                                _tailleentreprise = value;
                              });
                            },
                          ),
                        ),
                      ),
                    ),
                    Expanded(
                      child: ListTile(
                        title: const Text(
                            'Grande entreprise (250 personnes occupées ou plus)'),
                        leading: Radio<TailleEntreprise>(
                          value: TailleEntreprise.grande,
                          groupValue: _tailleentreprise,
                          onChanged: (TailleEntreprise? value) {
                            setState(() {
                              _tailleentreprise = value;
                            });
                          },
                        ),
                      ),
                    ),
                  ],
                ),
                Center(
                  child: ElevatedButton(
                      onPressed: () {}, child: const Icon(Icons.send)),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
