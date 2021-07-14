import 'dart:convert';

import 'package:clinicbookingapp/views/model/dental.dart';
import 'package:http/http.dart' as http;
//not need
class DentalsApi {
  static Future<List<Dental>> getDentals(String query) async {
    final url = Uri.parse(
        'https://localhost:8080/api/dentistry');
    final response = await http.get(url);

    if (response.statusCode == 200) {
      final List dentals = json.decode(response.body);

      return dentals.map((json) => Dental.fromJson(json)).where((dental) {
        final nameDental = dental.nameDental.toLowerCase();
        final addressDental = dental.addressDental.toLowerCase();
        final searchLower = query.toLowerCase();

        return nameDental.contains(searchLower) ||
            addressDental.contains(searchLower);
      }).toList();
    } else {
      throw Exception();
    }
  }
}
