package Iteration3TestViviana;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.FileInputStream;
import java.io.IOException;

public class ManageFirebaseRules {

	
	public class FirebaseInit {
	    public static void initialize() throws IOException {
	        FileInputStream serviceAccount =
	            new FileInputStream("src/main/resources/firebase/serviceAccountKey.json");

	        FirebaseOptions options = new FirebaseOptions.Builder()
	            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
	            .setDatabaseUrl("C:\\Users\\Viviana Montoya V\\Downloads\\communityapplication-14c16-firebase-adminsdk-1js3k-5eba86790f.json")
	            .build();

	        FirebaseApp.initializeApp(options);
	    }
	}