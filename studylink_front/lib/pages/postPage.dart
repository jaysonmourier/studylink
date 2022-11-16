import 'package:flutter/material.dart';

import '../widgets/post.dart';

class PostPage extends StatefulWidget {
  const PostPage({super.key});

  @override
  State<StatefulWidget> createState() {
    return PostPageState();
  }
}

class PostPageState extends State<PostPage> {
  @override
  Widget build(BuildContext context) {
    return const Scaffold(
      body: PostWidget(),
    );
  }

}