import 'package:flutter/material.dart';
import '../widgets/appbar.dart';
import '../widgets/bar_chart.dart';

class HistoryScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    // Datos hardcoded para semana
    final List<Map<String, dynamic>> weeklyData = [
      {'date': '2025-03-30', 'total': 12},
      {'date': '2025-03-31', 'total': 16},
      {'date': '2025-04-01', 'total': 14},
      {'date': '2025-04-02', 'total': 18},
      {'date': '2025-04-03', 'total': 10},
      {'date': '2025-04-04', 'total': 11},
      {'date': '2025-04-05', 'total': 15},
    ];

    // Datos hardcoded para mes con 30 días
    final List<Map<String, dynamic>> monthlyData = List.generate(30, (index) {
      final day = index + 1;
      final date = DateTime(2025, 3, day);
      final total = 10 + (index % 7) * 2; // Simulación de valores
      return {
        'date': date.toIso8601String().split('T').first,
        'total': total,
      };
    });

    return Scaffold(
      appBar: AppBar(
        title: Text("Historial de Consumo"),
      ),
      body: SingleChildScrollView(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text(
              "Consumo semanal",
              style: TextStyle(
                fontSize: 20,
                fontWeight: FontWeight.bold,
                color: Color(0xFF1976D2),
              ),
            ),
            SizedBox(height: 10),
            ConsumoBarChart(dataList: weeklyData),
            SizedBox(height: 30),
            Text(
              "Consumo mensual",
              style: TextStyle(
                fontSize: 20,
                fontWeight: FontWeight.bold,
                color: Color(0xFF1976D2),
              ),
            ),
            SizedBox(height: 10),
            ConsumoBarChart(dataList: monthlyData),
          ],
        ),
      ),
    );
  }
}
