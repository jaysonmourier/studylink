import 'package:flutter/material.dart';

import '../widgets/PostWidget.dart';

class PostPage extends StatelessWidget {
  String id;
  PostPage({Key? key, required this.id}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      width: 150,
      child: PostWidget(id: id),
    );
  }
}
