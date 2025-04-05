import 'package:flutter/material.dart';

class CustomAppBar extends StatelessWidget implements PreferredSizeWidget {
  final String title;

  CustomAppBar({required this.title});

  // Implementación de preferredSize
  @override
  Size get preferredSize => Size.fromHeight(120);  // Define la altura del AppBar

  @override
  Widget build(BuildContext context) {
    return AppBar(
      backgroundColor: Color(0xFF1A237E), // Color común para el encabezado
      elevation: 10, // Sombra sutil
      shape: RoundedRectangleBorder(
        borderRadius: BorderRadius.vertical(bottom: Radius.circular(30)), // Bordes redondeados
      ),
      title: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text(
            title,
            style: TextStyle(
              fontSize: 24,
              fontWeight: FontWeight.bold,
              color: Colors.white,
              letterSpacing: 1.2, // Espaciado entre letras
            ),
          ),
        ],
      ),
      actions: [
        IconButton(
          icon: Icon(Icons.notifications, size: 30),
          onPressed: () {
            // Aquí puedes manejar la acción de notificaciones
          },
        ),
      ],
    );
  }
}
