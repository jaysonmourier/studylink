import '../flutter_flow/flutter_flow_drop_down.dart';
import '../flutter_flow/flutter_flow_radio_button.dart';
import '../flutter_flow/flutter_flow_theme.dart';
import '../flutter_flow/flutter_flow_util.dart';
import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';

class FormulaireWidget extends StatefulWidget {
  const FormulaireWidget({Key? key}) : super(key: key);

  @override
  State<StatefulWidget>  createState() {
    return PostWidgetState();
  }
}

class _HomePageWidgetState extends State<FormulaireWidget> {
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

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      key: scaffoldKey,
      backgroundColor: FlutterFlowTheme.of(context).primaryBackground,
      appBar: AppBar(
        backgroundColor: FlutterFlowTheme.of(context).primaryColor,
        automaticallyImplyLeading: false,
        title: Text(
          'Formulaire',
          style: FlutterFlowTheme.of(context).title2.override(
                fontFamily: 'Poppins',
                color: Colors.white,
                fontSize: 22,
              ),
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
            decoration: BoxDecoration(
              color: FlutterFlowTheme.of(context).secondaryBackground,
            ),
            child: Column(
              mainAxisSize: MainAxisSize.max,
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(
                  'En quelle année avez-vous été diplômé de votre master MIAGE à l\'université Paris Nanterre ?',
                  style: FlutterFlowTheme.of(context).bodyText1,
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
                        hintStyle: FlutterFlowTheme.of(context).bodyText2,
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
                      style: FlutterFlowTheme.of(context).bodyText1,
                    ),
                  ),
                ),
                Divider(),
                Text(
                  'Combien de temps avez-vous mis pour trouver votre premier travail après l\'obtention de votre diplôme?',
                  style: FlutterFlowTheme.of(context).bodyText1,
                ),
                FlutterFlowRadioButton(
                  options: [
                    'Entre 0 et 3 mois',
                    'Entre 3 et 6 mois',
                    'Entre 6 et 9 mois',
                    'Supérieur à 9 mois'
                  ].toList(),
                  initialValue: 'Supérieur à 9 mois',
                  onChanged: (val) => setState(() => radioButtonValue1 = val),
                  optionHeight: 25,
                  textStyle: FlutterFlowTheme.of(context).bodyText1.override(
                        fontFamily: 'Poppins',
                        color: Colors.black,
                      ),
                  buttonPosition: RadioButtonPosition.left,
                  direction: Axis.vertical,
                  radioButtonColor: Colors.blue,
                  inactiveRadioButtonColor: Color(0x8A000000),
                  toggleable: false,
                  horizontalAlignment: WrapAlignment.start,
                  verticalAlignment: WrapCrossAlignment.start,
                ),
                Divider(),
                Text(
                  'Salaire brut annuel du premier travail  (en€)',
                  style: FlutterFlowTheme.of(context).bodyText1,
                ),
                TextFormField(
                  controller: textController2,
                  autofocus: true,
                  obscureText: false,
                  decoration: InputDecoration(
                    hintText: 'Ex : 12123',
                    hintStyle: FlutterFlowTheme.of(context).bodyText2,
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
                  style: FlutterFlowTheme.of(context).bodyText1,
                ),
                Text(
                  'Êtes-vous encore dans cette entreprise ?',
                  style: FlutterFlowTheme.of(context).bodyText1,
                ),
                FlutterFlowRadioButton(
                  options: ['Oui', 'Non'].toList(),
                  onChanged: (val) => setState(() => radioButtonValue2 = val),
                  optionHeight: 25,
                  textStyle: FlutterFlowTheme.of(context).bodyText1.override(
                        fontFamily: 'Poppins',
                        color: Colors.black,
                      ),
                  buttonPosition: RadioButtonPosition.left,
                  direction: Axis.vertical,
                  radioButtonColor: Colors.blue,
                  inactiveRadioButtonColor: Color(0x8A000000),
                  toggleable: false,
                  horizontalAlignment: WrapAlignment.start,
                  verticalAlignment: WrapCrossAlignment.start,
                ),
                Divider(),
                Text(
                  'Salaire brut annuel dans votre entreprise actuelle (en  €)',
                  style: FlutterFlowTheme.of(context).bodyText1,
                ),
                TextFormField(
                  controller: textController3,
                  autofocus: true,
                  obscureText: false,
                  decoration: InputDecoration(
                    hintText: 'Ex : 29876',
                    hintStyle: FlutterFlowTheme.of(context).bodyText2,
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
                  style: FlutterFlowTheme.of(context).bodyText1,
                ),
                Divider(),
                Text(
                  'Secteur d\'activité de votre entreprise actuelle',
                  style: FlutterFlowTheme.of(context).bodyText1,
                ),
                FlutterFlowDropDown<String>(
                  options: [
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
                  ],
                  onChanged: (val) => setState(() => dropDownValue = val),
                  width: 500,
                  height: 50,
                  textStyle: FlutterFlowTheme.of(context).bodyText1.override(
                        fontFamily: 'Poppins',
                        color: Colors.black,
                      ),
                  hintText: 'Please select...',
                  fillColor: Colors.white,
                  elevation: 2,
                  borderColor: Colors.transparent,
                  borderWidth: 0,
                  borderRadius: 0,
                  margin: EdgeInsetsDirectional.fromSTEB(12, 4, 12, 4),
                  hidesUnderline: true,
                ),
                Divider(),
                Text(
                  'Taille de votre entreprise actuelle',
                  style: FlutterFlowTheme.of(context).bodyText1,
                ),
                FlutterFlowRadioButton(
                  options: [
                    'Micro-entreprise (moins de 10 personnes)',
                    'Petite entreprise (de 10 à 49 personnes)',
                    'Moyenne entreprise (de 50 à 249 personnes)',
                    'Grande entreprise (250 personnes occupées ou plus)'
                  ].toList(),
                  onChanged: (val) => setState(() => radioButtonValue3 = val),
                  optionHeight: 25,
                  textStyle: FlutterFlowTheme.of(context).bodyText1.override(
                        fontFamily: 'Poppins',
                        color: Colors.black,
                      ),
                  buttonPosition: RadioButtonPosition.left,
                  direction: Axis.vertical,
                  radioButtonColor: Colors.blue,
                  inactiveRadioButtonColor: Color(0x8A000000),
                  toggleable: false,
                  horizontalAlignment: WrapAlignment.start,
                  verticalAlignment: WrapCrossAlignment.start,
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
