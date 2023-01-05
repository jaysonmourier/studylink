import 'package:flutter/material.dart';

import '../widgets/PostWidget.dart';

class PostPage extends StatelessWidget {
  final String id;
  const PostPage({Key? key, required this.id}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return SizedBox(
      width: 150,
      child: PostWidget(id: id),
    );
  }
}
