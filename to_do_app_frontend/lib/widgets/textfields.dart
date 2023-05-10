import 'package:flutter/material.dart';

class MyUnderlinedTextField extends StatelessWidget {
  const MyUnderlinedTextField({
    Key? key,
    required this.hintText,
    this.hintColor = Colors.white,
    this.ontap,
  }) : super(key: key);

  final String hintText;
  final Color hintColor;
  final String? Function(String? value)? ontap;
  @override
  Widget build(BuildContext context) {
    return TextFormField(
      decoration: InputDecoration(
        hintText: hintText,
        enabledBorder: OutlineInputBorder(
            borderSide: BorderSide(
                color: Theme.of(context).textTheme.bodySmall!.color!),
            borderRadius: BorderRadius.circular(50)),
        focusedBorder: OutlineInputBorder(
            borderSide: BorderSide(
                color: Theme.of(context).textTheme.bodySmall!.color!),
            borderRadius: BorderRadius.circular(50)),
        errorBorder: OutlineInputBorder(
            borderSide: BorderSide(color: Theme.of(context).errorColor),
            borderRadius: BorderRadius.circular(50)),
        focusedErrorBorder: OutlineInputBorder(
            borderSide: BorderSide(color: Theme.of(context).errorColor),
            borderRadius: BorderRadius.circular(50)),
        hintStyle: TextStyle(color: hintColor),
      ),
      validator: ontap,
    );
  }
}
