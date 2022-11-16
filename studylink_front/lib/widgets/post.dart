import 'package:flutter/material.dart';

class Post extends StatelessWidget {
  const Post({super.key});

  @override
  Widget build(BuildContext context) {
    return Container(
      padding: const EdgeInsets.all(10),
      child: Column(
      children: [
        Row(
          children: const [
            CircleAvatar(radius: 30)
          ],
        ),
        Row(
          children: [
            Expanded(child: Text('${Uri.base.queryParameters['id']} + Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec tincidunt dignissim velit. Cras sit amet libero dui. Vestibulum urna dolor, aliquam non risus id, vestibulum posuere sem. Suspendisse lobortis blandit egestas. Nullam ut finibus orci, a lacinia odio. Nulla in tellus arcu. Nullam turpis odio, semper eget tellus eu, fringilla sollicitudin lorem. Maecenas vestibulum, massa in egestas mollis, mi felis dapibus est, non dapibus lacus velit non est. Nunc bibendum diam at lorem pretium, quis dignissim massa pharetra.'))
          ],
        ),
        Row(
          mainAxisAlignment: MainAxisAlignment.end,
          children: [
            TextButton(onPressed: () => {}, child: const Text('like')),
            TextButton(onPressed: () => {}, child: const Text('comment'))
          ],
        ),
      ],
    )
    );
  }
}