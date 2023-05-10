import 'package:dio/dio.dart';

class UserRepository {
  final dio = Dio();
  static String baseUrl = "http://10.0.2.2:8080/todo/api/users";
  void logIn() async {
    Map<String, String> query = {
      "username": "Abdullah",
      "password": "password7"
    };
    final response = await dio.get("$baseUrl/login", queryParameters: query);
    print(response);
  }
}
