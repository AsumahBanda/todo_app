import 'package:flutter/material.dart';

class Avatar extends StatelessWidget {
  final String imageUrl;
  final double size;

  const Avatar({required this.imageUrl, required this.size});

  @override
  Widget build(BuildContext context) {
    return CircleAvatar(
      radius: size,
      backgroundImage: NetworkImage(imageUrl),
      backgroundColor: Colors.grey[200],
    );
  }
}
