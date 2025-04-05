import 'package:flutter/material.dart';
import 'package:fl_chart/fl_chart.dart';

class ConsumoPieChart extends StatelessWidget {
  final Map<String, int> consumoData;

  const ConsumoPieChart({super.key, required this.consumoData});

  @override
  Widget build(BuildContext context) {
    // Convertir el mapa de datos a una lista de PieChartSectionData
    List<PieChartSectionData> sections = consumoData.entries
        .map((entry) => PieChartSectionData(
      value: entry.value.toDouble(),
      color: _getColorForDevice(entry.key),
      radius: 60, // Radio del círculo completo
      titleStyle: TextStyle(
        fontSize: 0, // Sin títulos dentro del gráfico
        color: Colors.transparent, // Sin títulos
      ),
    ))
        .toList();

    return Container(
      width: 180,  // Ajustamos el tamaño para evitar overflow
      height: 180,
      child: PieChart(
        PieChartData(
          sections: sections,
          borderData: FlBorderData(show: false),
          centerSpaceRadius: 0, // Sin agujero en el centro
          sectionsSpace: 2, // Espacio entre las secciones
        ),
      ),
    );
  }

  // Método para asignar colores a cada dispositivo
  Color _getColorForDevice(String device) {
    switch (device) {
      case 'Ducha':
        return Color(0xFF42A5F5); // Azul
      case 'Grifo':
        return Color(0xFFFFC107); // Amarillo
      case 'Lavadora':
        return Color(0xFF66BB6A); // Verde
      case 'Cisterna':
        return Color(0xFFEF5350); // Rojo
      case 'Lavaplatos':
        return Color(0xFFAB47BC); // Púrpura
      default:
        return Colors.grey;
    }
  }
}
