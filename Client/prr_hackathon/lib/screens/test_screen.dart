import 'package:flutter/material.dart';

import '../widgets/bar_chart.dart';


class BarChartScreen extends StatelessWidget {
  final List<Map<String, dynamic>> consumoDataList = [
    {
      "date": "2025-04-01",
      "ducha": 20,
      "grifo": 15,
      "lavadora": 10,
      "cisterna": 18,
      "lavaplatos": 7,
      "total": 70,
      "userId": 1
    },
    {
      "date": "2025-04-02",
      "ducha": 25,
      "grifo": 12,
      "lavadora": 13,
      "cisterna": 20,
      "lavaplatos": 10,
      "total": 80,
      "userId": 1
    },
    {
      "date": "2025-04-03",
      "ducha": 18,
      "grifo": 14,
      "lavadora": 11,
      "cisterna": 19,
      "lavaplatos": 8,
      "total": 70,
      "userId": 1
    },
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Historial de Consumo")),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: ConsumoBarChart(dataList: consumoDataList),
      ),
    );
  }
}
