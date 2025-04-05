class AuthService {
  static String? currentUserEmail;

  static void loginAs(String email) {
    currentUserEmail = email;
  }

  static void logout() {
    currentUserEmail = null;
  }

  static bool isLoggedIn() {
    return currentUserEmail != null;
  }
}
