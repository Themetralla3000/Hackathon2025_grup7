import 'package:flutter/material.dart';

class GameScreen extends StatelessWidget {
  final String email;

  GameScreen({required this.email});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Gamificación - $email"),
        backgroundColor: Color(0xFF1976D2), // Azul oscuro
      ),
      body: SingleChildScrollView(
        child: Padding(
          padding: const EdgeInsets.all(16.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              // Racha de cumplimiento de objetivos
              _buildStreakSection(),
              SizedBox(height: 30),  // Espacio entre secciones

              // Listado de objetivos
              _buildObjectivesList(),
              SizedBox(height: 30),  // Espacio entre secciones

              // Clasificación de consumo
              _buildRankingSection(),
            ],
          ),
        ),
      ),
    );
  }

  // Sección de la racha de cumplimiento de objetivos
  Widget _buildStreakSection() {
    return Card(
      color: Color(0xFFFFC107), // Color cálido para llamar la atención
      child: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Row(
          children: [
            Icon(
              Icons.local_fire_department,
              color: Colors.white,
              size: 40,
            ),
            SizedBox(width: 16),
            // Expandir el texto para que no cause overflow
            Expanded(
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text(
                    '¡Racha de Cumplimiento!',
                    style: TextStyle(
                      fontSize: 18,
                      fontWeight: FontWeight.bold,
                      color: Colors.white,
                    ),
                  ),
                  SizedBox(height: 8),
                  Text(
                    'Llevas 7 días consecutivos cumpliendo tus objetivos',
                    style: TextStyle(
                      fontSize: 16,
                      color: Colors.white,
                    ),
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }

  // Sección de listado de objetivos
  Widget _buildObjectivesList() {
    final objectives = [
      'Reducir el consumo de agua en un 10%',
      'No usar más de 100 litros diarios',
      'Usar la ducha en menos de 5 minutos',
      'Ajustar los grifos para evitar el derroche',
    ];

    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Text(
          'Objetivos de Reducción de Consumo',
          style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
        ),
        SizedBox(height: 10),
        ListView.builder(
          shrinkWrap: true,
          physics: NeverScrollableScrollPhysics(),
          itemCount: objectives.length,
          itemBuilder: (context, index) {
            return Card(
              margin: EdgeInsets.symmetric(vertical: 8.0),
              elevation: 4,
              child: Padding(
                padding: const EdgeInsets.all(16.0),
                child: Row(
                  children: [
                    Icon(Icons.check_circle, color: Colors.green, size: 30),
                    SizedBox(width: 16),
                    Expanded(
                      child: Text(
                        objectives[index],
                        style: TextStyle(fontSize: 16),
                      ),
                    ),
                  ],
                ),
              ),
            );
          },
        ),
      ],
    );
  }

  // Sección de clasificación de consumo
  Widget _buildRankingSection() {
    final usersRanking = [
      {'name': 'Carlos', 'consumo': 80},
      {'name': 'Ana', 'consumo': 95},
      {'name': 'Luis', 'consumo': 110},
      {'name': 'Pedro', 'consumo': 120},
    ];

    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Text(
          'Clasificación de Consumo de Agua',
          style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
        ),
        SizedBox(height: 10),
        ListView.builder(
          shrinkWrap: true,
          physics: NeverScrollableScrollPhysics(),
          itemCount: usersRanking.length,
          itemBuilder: (context, index) {
            final user = usersRanking[index];
            return Card(
              margin: EdgeInsets.symmetric(vertical: 8.0),
              elevation: 4,
              child: Padding(
                padding: const EdgeInsets.all(16.0),
                child: Row(
                  children: [
                    Text(
                      '${index + 1}.',
                      style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
                    ),
                    SizedBox(width: 16),
                    Expanded(
                      child: Text(
                        user['name'] as String,  // Asegúrate de que 'name' sea un String
                        style: TextStyle(fontSize: 16),
                      ),
                    ),
                    Text(
                      '${user['consumo']}L',  // Asegúrate de que 'consumo' sea un int
                      style: TextStyle(fontSize: 16),
                    ),
                  ],
                ),
              ),
            );
          },
        ),
      ],
    );
  }
}
