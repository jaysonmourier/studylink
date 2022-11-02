package com.devops.studylink.config;

import java.io.FileInputStream;
import org.springframework.stereotype.Service;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service
public class FirebaseInit {
    String serviceAccountKey = "../../../../../resources/serviceAccountKey.json";
    public void initialization() {
        try {
            FileInputStream serviceAccount = new FileInputStream(serviceAccountKey);
            FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://studylink-1fed0-default-rtdb.europe-west1.firebasedatabase.app")
                .build();
            FirebaseApp.initializeApp(options);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
