import 'package:flutter/material.dart';
import '../widgets/bar_chart.dart';  // Import de gráfico de barras
import '../widgets/pie_chart_page.dart';  // Import de gráfico de pastel

// Pantalla principal
class HomeScreen extends StatelessWidget {
  final String email;

  HomeScreen({required this.email});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Bienvenido, $email"
        ,),
        backgroundColor: Color(0xFF1976D2), // Azul oscuro
      ),
      body: SingleChildScrollView(  // Esto permite desplazamiento
        child: Padding(
          padding: const EdgeInsets.all(16.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              // Título y gráfico de pie
              Text(
                'Distribución del Consumo',
                style: TextStyle(
                  fontSize: 22,
                  fontWeight: FontWeight.bold,
                  color: Color(0xFF1976D2), // Azul oscuro
                ),
              ),
              SizedBox(height: 20),
              // Fila para el gráfico de pie y la leyenda
              Row(
                children: [
                  // Gráfico de pie
                  ConsumoPieChart(
                    consumoData: {
                      'Ducha': 30,
                      'Grifo': 20,
                      'Lavadora': 25,
                      'Cisterna': 15,
                      'Lavaplatos': 10,
                    }, // Asegúrate de pasar datos reales
                  ),
                  SizedBox(width: 20),
                  // Leyenda a la derecha
                  Expanded(
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        _buildLegendItem(Color(0xFF42A5F5), 'Ducha: 30%'),
                        _buildLegendItem(Color(0xFFFFC107), 'Grifo: 20%'),
                        _buildLegendItem(Color(0xFF66BB6A), 'Lavadora: 25%'),
                        _buildLegendItem(Color(0xFFEF5350), 'Cisterna: 15%'),
                        _buildLegendItem(Color(0xFFAB47BC), 'Lavaplatos: 10%'),
                      ],
                    ),
                  ),
                ],
              ),
              SizedBox(height: 40),  // Espacio entre el gráfico de pie y el gráfico de barras
              // Título de gráfico semanal
              Text(
                'Consumo Total por Día (Semana)',
                style: TextStyle(
                  fontSize: 22,
                  fontWeight: FontWeight.bold,
                  color: Color(0xFF1976D2), // Azul oscuro
                ),
              ),
              SizedBox(height: 20),
              // Gráfico semanal con un tamaño definido
              SizedBox(
                height: 300,  // Ajustamos la altura del gráfico
                child: ConsumoBarChart(
                  dataList: [
                    {'date': '2025-03-30', 'total': 132},
                    {'date': '2025-03-31', 'total': 104},
                    {'date': '2025-04-01', 'total': 178},
                    {'date': '2025-04-02', 'total': 93},
                    {'date': '2025-04-03', 'total': 92},
                    {'date': '2025-04-04', 'total': 112},
                    {'date': '2025-04-05', 'total': 102},
                  ], // Asegúrate de pasar datos reales
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }

  // Método para crear los elementos de la leyenda
  Widget _buildLegendItem(Color color, String label) {
    return Row(
      children: [
        Container(
          width: 20,
          height: 20,
          color: color,
        ),
        SizedBox(width: 8),
        Text(
          label,
          style: TextStyle(
            fontSize: 16,
            fontWeight: FontWeight.w600,
            color: Color(0xFF1976D2),
          ),
        ),
      ],
    );
  }
}
