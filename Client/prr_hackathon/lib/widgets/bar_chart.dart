import 'package:flutter/material.dart';
import 'package:fl_chart/fl_chart.dart';
import 'package:intl/intl.dart';

class ConsumoBarChart extends StatelessWidget {
  final List<Map<String, dynamic>> dataList;

  const ConsumoBarChart({super.key, required this.dataList});

  @override
  Widget build(BuildContext context) {
    final barGroups = <BarChartGroupData>[];
    final labels = <String>[];

    for (int i = 0; i < dataList.length; i++) {
      final item = dataList[i];
      final date = DateFormat('MM/dd').format(DateTime.parse(item['date']));
      final total = item['total'].toDouble();

      labels.add(date);
      barGroups.add(
        BarChartGroupData(
          x: i,
          barRods: [
            BarChartRodData(
              y: total,
              colors: [Color(0xFF42A5F5)],
              width: 5,
              borderRadius: BorderRadius.circular(6),
            ),
          ],
        ),
      );
    }

    return Column(
      children: [
        Text('Consumo total por día',
            style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold)),
        SizedBox(
          height: 250,
          child: BarChart(
            BarChartData(
              barGroups: barGroups,
              borderData: FlBorderData(show: false),
              gridData: FlGridData(show: true),
              barTouchData: BarTouchData(enabled: false),
              titlesData: FlTitlesData(
                leftTitles: SideTitles(showTitles: true),
                bottomTitles: SideTitles(
                  showTitles: true,
                  getTitles: (value) {
                    final index = value.toInt();

                    // Mostrar solo algunos títulos si hay muchas entradas
                    if (dataList.length > 10) {
                      // Solo muestra los labels en los índices clave (0, 10, 20, 30)
                      if ([0, 9, 19, 29].contains(index)) {
                        return '${index + 1}'; // Día del mes (aprox)
                      }
                      return '';
                    }

                    // Mostrar todos si hay pocos datos
                    if (index >= 0 && index < labels.length) {
                      return labels[index];
                    }

                    return '';
                  },
                  margin: 8,
                ),
                topTitles: SideTitles(showTitles: false),
              ),
            ),
          ),
        ),
      ],
    );
  }
}
