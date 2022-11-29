import 'package:flutter/material.dart';
import 'package:syncfusion_flutter_charts/charts.dart';

class HistData {
  late double x;
  HistData({required this.x});
}

class chartPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final List<HistData> histogramData = <HistData>[
      HistData(x: 100932.1675986),
      HistData(x: 83000.66614623),
      HistData(x: 269241.71427337),
      HistData(x: 158692.95697616),
      HistData(x: 181355.02317849),
      HistData(x: 219154.96214086),
      HistData(x: 148310.95058409),
      HistData(x: 218256.26594732),
      HistData(x: 197387.07032098),
      HistData(x: 210857.68241083),
      HistData(x: 200385.42714571),
      HistData(x: 200827.86175243),
      HistData(x: 166596.82100282),
      HistData(x: 238854.4313945),
      HistData(x: 149148.08333024),
      HistData(x: 214052.3012706),
      HistData(x: 151028.2578645),
      HistData(x: 155005.43802331),
      HistData(x: 58043.09506089),
      HistData(x: 67763.28874857),
      HistData(x: 193583.29614695),
      HistData(x: 230852.01005149),
      HistData(x: 210669.4582249),
      HistData(x: 227245.48240586),
      HistData(x: 152975.81415708),
      HistData(x: 212181.79205854),
      HistData(x: 128747.5193582),
      HistData(x: 194958.55804049),
      HistData(x: 278095.54400819),
      HistData(x: 126767.44519922),
      HistData(x: 134341.15161823),
      HistData(x: 262780.46555858),
      HistData(x: 206924.21033295),
      HistData(x: 219690.6621569),
      HistData(x: 120488.38975674),
      HistData(x: 185535.99558261),
      HistData(x: 154015.38698567),
      HistData(x: 151406.99141494),
      HistData(x: 179134.94641512),
      HistData(x: 139199.32833775),
      HistData(x: 53530.4980663),
      HistData(x: 228716.82019351),
      HistData(x: 302671.91638931),
      HistData(x: 110846.44765399),
      HistData(x: 185193.42221024),
      HistData(x: 153939.24069866),
      HistData(x: 231469.5832827),
      HistData(x: 189528.14594676),
      HistData(x: 158222.89363133),
      HistData(x: 291610.4636031),
    ];
    return Center(
        child: SizedBox(
            width: 600,
            height: 500,
            child: SfCartesianChart(
                title: ChartTitle(text: 'Secteur A'),
                series: <ChartSeries>[
                  HistogramSeries<HistData, double>(
                      dataSource: histogramData,
                      showNormalDistributionCurve: true,
                      curveColor: const Color.fromRGBO(192, 108, 132, 1),
                      binInterval: 40000,
                      yValueMapper: (HistData data, _) => data.x)
                ])));
  }
}
