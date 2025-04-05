import 'package:flutter/material.dart';

class InfoScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('HydroVision - Aigua Sostenible'),
        backgroundColor: Colors.blue,
      ),
      body: SingleChildScrollView(
        padding: EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            // Company Info
            Text(
              'Qui som:',
              style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
            ),
            SizedBox(height: 8),
            Text(
              'Som una empresa innovadora compromesa amb el consum responsable i sostenible de l\'aigua a Mataró. '
                  'Amb la nostra app, t\'ajudem a ser més conscient del teu ús diari de l\'aigua, proporcionant-te informació '
                  'per reduir-ne el malbaratament, estalviar diners i protegir el medi ambient.',
              style: TextStyle(fontSize: 16),
            ),
            SizedBox(height: 16),

            // Slogan
            Text(
              'Eslògan:',
              style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
            ),
            SizedBox(height: 8),
            Text(
              '"Cada gota compta, cada acció fa la diferència."',
              style: TextStyle(fontSize: 16, fontStyle: FontStyle.italic),
            ),
            SizedBox(height: 16),

            // ODS (Sustainable Development Goals)
            Text(
              'ODS en les que ens centrem:',
              style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
            ),
            SizedBox(height: 8),
            Row(
              children: [
                Text('💧 ODS 6: Aigua neta i sanejament'),
              ],
            ),
            Row(
              children: [
                Text('♻️ ODS 12: Producció i consum responsables'),
              ],
            ),
            Row(
              children: [
                Text('🌱 ODS 13: Acció climàtica'),
              ],
            ),
            Row(
              children: [
                Text('📜 ODS 16: Pau, justícia i institucions sòlides'),
              ],
            ),
            Row(
              children: [
                Text('🤝 ODS 17: Aliances per als objectius'),
              ],
            ),
            Row(
              children: [
                Text('⚙️ ODS 9: Indústria, innovació i infraestructura'),
              ],
            ),
            SizedBox(height: 16),

            // Location
            Text(
              'Ubicació:',
              style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
            ),
            SizedBox(height: 8),
            Text(
              '📍 Parc TecnoCampus Mataró-Maresme\n'
                  'Carrer d\'Ernest Lluch, 32, 08302 Mataró, Barcelona',
              style: TextStyle(fontSize: 16),
            ),
            SizedBox(height: 16),

            // Contact Info
            Text(
              'Contacte:',
              style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
            ),
            SizedBox(height: 8),
            Text(
              '✉️ suporthydrovision@gmail.com',
              style: TextStyle(fontSize: 16),
            ),
            Text(
              '📞 Tel: +34 618 059 569',
              style: TextStyle(fontSize: 16),
            ),
          ],
        ),
      ),
    );
  }
}


