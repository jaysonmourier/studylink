import 'package:flutter/material.dart';

import '../widgets/PostWidget.dart';

class PostPage extends StatefulWidget {
  const PostPage({super.key});

  @override
  State<StatefulWidget> createState() {
    return PostPageState();
  }
}

class PostPageState extends State<PostPage> {
  String myurl = Uri.base.toString();
  String? para1 = Uri.base.queryParameters["id"];

  @override
  Widget build(BuildContext context) {
    String test = para1 ?? "null";
    return Scaffold(
      body: PostWidget(),
    );
  }

}