import 'package:flutter/material.dart';

class BigBoldText extends StatelessWidget {
  const BigBoldText({
    Key? key,
    this.label = "Create Account",
  
  }) : super(key: key);

  final String label;

  @override
  Widget build(BuildContext context) {
    return Text(
      label,
      style: Theme.of(context).textTheme.titleSmall,
    );
  }
}

class MyBodySmallText extends StatelessWidget {
  const MyBodySmallText({
    Key? key,
    required this.text,
  }) : super(key: key);

  final String text;
  @override
  Widget build(BuildContext context) {
    return Text(
      text,
      style: Theme.of(context).textTheme.bodySmall,
    );
  }
}
