import 'package:flutter/material.dart';

class MyThemes {
  static Color primaryColor = const Color(0xff9E1B2F);
  static Color background = const Color(0xffFF5E76);
  static const Color color = Colors.white;
  static TextTheme myTextTheme() {
    return const TextTheme(
        bodySmall: TextStyle(fontSize: 16, color: color),
        bodyMedium: TextStyle(color: Colors.white),
        titleSmall: TextStyle(
          fontSize: 16,
          fontWeight: FontWeight.bold,
          color: color,
        ));
  }

  static ThemeData theme() {
    return ThemeData(
        primaryColor: primaryColor,
        backgroundColor: background,
        scaffoldBackgroundColor: background,
        appBarTheme: AppBarTheme(color: primaryColor, centerTitle: true),
        textTheme: myTextTheme());
  }
}
