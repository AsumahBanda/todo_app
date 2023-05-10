import 'package:flutter/material.dart';

import '../widgets/buttons.dart';
import '../widgets/textfields.dart';
import '../widgets/texts_widgets.dart';

class SignUpPage extends StatelessWidget {
  final _formKey = GlobalKey<FormState>();

  SignUpPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Theme.of(context).primaryColor,
      body: Padding(
        padding: const EdgeInsets.all(30.0),
        child: SingleChildScrollView(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              const SizedBox(
                height: 50,
              ),
              const BigBoldText(),
              const SizedBox(height: 30),
              Form(
                key: _formKey,
                child: Column(
                  children: [
                    MyUnderlinedTextField(
                      hintText: "Enter your name",
                      ontap: (value) {
                        if (value != null && value.isEmpty) {
                          return 'Please enter your username';
                        }
                        return null;
                      },
                    ),
                    const SizedBox(height: 40),
                    MyUnderlinedTextField(
                      hintText: "Enter your email",
                      ontap: (value) {
                        if (value != null && value.isEmpty) {
                          return 'Please enter your email';
                        }
                        return null;
                      },
                    ),
                    const SizedBox(height: 40),
                    MyUnderlinedTextField(
                      hintText: "Enter your password",
                      ontap: (value) {
                        if (value != null && value.isEmpty) {
                          return 'Please enter your password';
                        }
                        return null;
                      },
                    ),
                    const SizedBox(height: 40),
                    MyUnderlinedTextField(
                      hintText: "Confirm password",
                      ontap: (value) {
                        if (value != null && value.isEmpty) {
                          return 'Please enter your password';
                        }
                        return null;
                      },
                    ),
                  ],
                ),
              ),
              const SizedBox(height: 30),
              MyElevatedButton(
                label: "Sign Up",
                onTap: () {
                  if (_formKey.currentState!.validate()) {
                    // do sign up logic here
                  }
                },
              ),
              const SizedBox(height: 20),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  const MyBodySmallText(
                    text: "Already have an account?",
                  ),
                  TextButton(
                    onPressed: () {
                      // navigate to login page
                    },
                    child: const MyBodySmallText(text: "Sign in"),
                  ),
                ],
              ),
            ],
          ),
        ),
      ),
    );
  }
}
