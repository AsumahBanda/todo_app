import 'dart:math';

class Task {
  final String title;
  final String description;
  bool isComplete;

  Task(
      {required this.title,
      required this.description,
      this.isComplete = false});

  void toggleComplete() {
    isComplete = !isComplete;
  }
}

class TaskGenerator {
  static final List<String> titles = [
    "Complete project report",
    "Prepare for meeting with client",
    "Finalize design mockups",
    "Write test cases",
    "Review code changes",
    "Debug issue with server",
    "Refactor codebase",
    "Deploy application to production",
    "Create user documentation",
    "Schedule team training"
  ];
  static final List<String> descriptions = [
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis tristique eros at blandit pretium.",
    "Vivamus imperdiet commodo odio vel semper. Nulla facilisi. Nam varius fringilla urna, id sollicitudin augue lobortis a.",
    "Donec in faucibus lacus. Proin aliquam arcu vitae justo commodo imperdiet. Etiam convallis eget odio sit amet euismod.",
    "Suspendisse vitae diam bibendum, pharetra quam ac, finibus ipsum. Sed eu odio libero. Mauris non consectetur justo.",
    "Sed dictum enim eget mauris congue, vel tincidunt ante dapibus. Sed iaculis urna ac lacus laoreet, eget semper ex varius.",
    "Curabitur consectetur massa vel lectus ornare, vitae tempus nulla iaculis. Suspendisse non blandit ex.",
    "Maecenas quis ipsum auctor, venenatis est sit amet, euismod ex. Aliquam eu magna malesuada, efficitur nulla quis, vestibulum arcu.",
    "Nullam tristique mauris id quam congue suscipit. Donec hendrerit leo sapien, nec congue mauris ultrices id.",
    "Fusce vel mauris dictum, convallis metus id, lobortis dolor. Vestibulum tincidunt at metus vel iaculis.",
    "Pellentesque nec lacus in arcu varius malesuada. Integer imperdiet arcu eget neque interdum facilisis."
  ];

  static List<Task> generateTasks(int count) {
    Random rand = new Random();
    List<Task> tasks = [];
    for (int i = 0; i < count; i++) {
      String title = titles[rand.nextInt(titles.length)];
      String description = descriptions[rand.nextInt(descriptions.length)];
      bool status = rand.nextBool();
      tasks.add(
          Task(title: title, description: description, isComplete: status));
    }
    return tasks;
  }
}
