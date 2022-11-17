import 'package:flutter/material.dart';
import 'package:studylink_web/services/PostsServices.dart';

class PostWidget extends StatefulWidget {
  String id;
  PostWidget({super.key, required this.id});

  @override
  State<StatefulWidget> createState() {
    return PostWidgetState();
  }
}

class PostWidgetState extends State<PostWidget> {
  @override
  Widget build(BuildContext context) {
    //print(post.content);
    return FutureBuilder(
      future: getPost(widget.id),
      builder: (context, snapshot) {
        if (snapshot.hasData) {
          return Container(
              padding: const EdgeInsets.all(10),
              child: Column(
                children: [
                  Row(
                    children: const [CircleAvatar(radius: 30)],
                  ),
                  Row(
                    children: [Expanded(child: Text(snapshot.data!.content))],
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.end,
                    children: [
                      TextButton(
                          onPressed: () => {}, child: const Text('like')),
                      TextButton(
                          onPressed: () => {}, child: const Text('comment'))
                    ],
                  ),
                ],
              ));
        } else if (snapshot.hasError) {
          return const Text('error');
        } else {
          return const CircularProgressIndicator();
        }
      },
    );
  }
}
