class Params {
  String root_url = "http://localhost:8080";

  String build(final String params) {
    root_url += "/$params";
    return root_url;
  }
}