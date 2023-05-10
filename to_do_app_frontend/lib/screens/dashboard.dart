import 'package:flutter/material.dart';
import 'package:to_do_app_frontend/widgets/avatars.dart';
import 'package:to_do_app_frontend/widgets/texts_widgets.dart';

import '../models.dart/task.dart';

class TaskDashboardScreen extends StatelessWidget {
  final List<Task> tasks;

  TaskDashboardScreen({required this.tasks});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: const Color(0xff9E1B2F),
        title: const Text('My Tasks'),
        centerTitle: true,
        leading: const Padding(
          padding: EdgeInsets.all(8.0),
          child: Avatar(
            imageUrl: "",
            size: 20,
          ),
        ),
      ),
      body: Container(
        padding: const EdgeInsets.all(16.0),
        child: ListView.builder(
          itemCount: tasks.length,
          itemBuilder: (context, index) {
            final task = tasks[index];

            return Card(
              elevation: 4.0,
              color: Theme.of(context).primaryColor,
              shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(30)),
              child: ListTile(
                leading: const CircleAvatar(
                  backgroundImage: NetworkImage(""),
                ),
                title: BigBoldText(label: task.title),
                subtitle: Padding(
                  padding: const EdgeInsets.symmetric(vertical: 10),
                  child: Text(
                    task.description,
                    maxLines: 2,
                  ),
                ),
                trailing: Column(
                  mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                  children: [
                    GestureDetector(
                      onTap: () {},
                      child: Container(
                          padding: EdgeInsets.all(5),
                          decoration: BoxDecoration(
                              color: Theme.of(context).backgroundColor,
                              borderRadius: BorderRadius.circular(15)),
                          child: MyBodySmallText(
                              text: task.isComplete ? "Done" : "pending")),
                    ),
                    GestureDetector(
                      onTap: () {},
                      child: Icon(
                        Icons.delete,
                        color: Theme.of(context).textTheme.bodySmall?.color,
                      ),
                    )
                  ],
                ),
              ),
            );
          },
        ),
      ),
    );
  }
}
