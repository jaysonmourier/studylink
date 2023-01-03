abstract class Env {
  static const HOST_API =
      String.fromEnvironment("HOST_API", defaultValue: "http://localhost");
  static const HOST_PORT =
      String.fromEnvironment("HOST_PORT", defaultValue: "8081");
}
