import 'package:flutter/material.dart';
import 'package:to_do_app_frontend/models.dart/task.dart';
import 'package:to_do_app_frontend/widgets/texts_widgets.dart';

class TaskDetailsPage extends StatelessWidget {
  const TaskDetailsPage({super.key, required this.task});
  final Task task;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: BigBoldText(
          label: ' ${task.title}',
        ),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Center(
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.center,
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              MyBodySmallText(
                text: 'Description: ${task.description}',
              ),
              const SizedBox(height: 70.0),
              MyBodySmallText(
                text: 'Status: ${task.isComplete ? 'Completed' : 'Incomplete'}',
              ),
              const SizedBox(height: 50.0),
              const MyBodySmallText(text: 'Due Date: 12-03-2009')
            ],
          ),
        ),
      ),
    );
  }
}
