class Post {
  final String id;
  final String content;
  final DateTime created_at;
  const Post({required this.id, required this.content, required this.created_at});

  factory Post.fromJson(Map<String, dynamic> json) {
    return Post(
      id: json['id'],
      content: json['content'],
      created_at: DateTime.parse(json['creationDate'])
    );
  }
}