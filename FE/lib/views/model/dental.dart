//this model

class Dental{
  final String nameDental;
  final String addressDental;
  final double rating;

  const Dental({
    this.nameDental,
    this.addressDental,
    this.rating,
    }
  );

  factory Dental.fromJson(Map<String, dynamic> json) => Dental(
      nameDental: json['nameDental'],
      addressDental: json['addressDental'],
      rating: json['rating']
  );

  Map<String, dynamic> toJson() => {
    'nameDental': nameDental,
    'addressDental': addressDental,
    'rating': rating
  };
}