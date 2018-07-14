package com.es.david.vacinas.DAO;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConfFirebase {
    private static DatabaseReference refFirebase;
    public static FirebaseAuth auth;


    public static DatabaseReference getRefFirebase(){
        if (refFirebase == null) {
            refFirebase = FirebaseDatabase.getInstance().getReference();
        }
        return refFirebase;
    }

    public static FirebaseAuth getAuth(){
        if (auth == null) {
            auth = FirebaseAuth.getInstance();
        }
        return auth;
    }
}
