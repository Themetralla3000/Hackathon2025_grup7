import 'package:flutter/material.dart';
import 'screens/home_page.dart';
import 'screens/history_screen.dart';
import 'screens/game_screen.dart';
import 'screens/info_screen.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  final String userEmail = "usuario@example.com"; // Simulación de email

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'App con Navegación Inferior',
      theme: ThemeData(
          primarySwatch: Colors.blue,
          ),
      home: NavigationController(email: userEmail),
    );
  }
}

class NavigationController extends StatefulWidget {
  final String email;

  NavigationController({required this.email});

  @override
  State<NavigationController> createState() => _NavigationControllerState();
}

class _NavigationControllerState extends State<NavigationController> {
  int _currentIndex = 0;

  late final List<Widget> _pages = [
    HomeScreen(email: widget.email),
    HistoryScreen(),
    GameScreen(email:widget.email),
    InfoScreen(),
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: _pages[_currentIndex],
      bottomNavigationBar: BottomNavigationBar(
        currentIndex: _currentIndex,
        selectedItemColor: Color(0xFF1976D2),
        unselectedItemColor: Colors.grey,
        onTap: (index) {
          setState(() {
            _currentIndex = index;
          });
        },
        items: const [
          BottomNavigationBarItem(
            icon: Icon(Icons.home),
            label: 'Inicio',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.history),
            label: 'Historial',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.videogame_asset),
            label: 'Juego',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.info),
            label: 'Info',
          ),
        ],
      ),
    );
  }
}
