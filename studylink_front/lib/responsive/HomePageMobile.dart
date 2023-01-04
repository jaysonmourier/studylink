import 'package:flutter/material.dart';

class HomePageMobile extends StatelessWidget {
  const HomePageMobile({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        decoration: const BoxDecoration(
            image: DecorationImage(
                image: NetworkImage(
                    "https://images.pexels.com/photos/1205651/pexels-photo-1205651.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"),
                fit: BoxFit.cover,
                colorFilter: ColorFilter.mode(
                    Color.fromARGB(135, 0, 0, 0), BlendMode.darken))),
        height: 250,
        child: Padding(
          padding: const EdgeInsets.symmetric(vertical: 20, horizontal: 0),
          child: Center(
              child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
            children: const [
              Text('STUDYLINK',
                  style: TextStyle(
                      color: Colors.white,
                      fontWeight: FontWeight.w700,
                      letterSpacing: 5,
                      fontSize: 25),),
                      Padding(padding: EdgeInsets.symmetric(vertical: 8, horizontal: 0)),
                      Text("Une plateforme de suivi universitaire dsq jdklsq jkdls jdkq l", style: TextStyle(color: Colors.white),)
            ],
          )),
        ),
      ),
    );
  }
}
