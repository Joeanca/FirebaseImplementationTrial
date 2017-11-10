package com.example.jorge.firebaseimplementationtrial;

import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joeanca on 2017-11-08.
 */

public class DatabaseFunctions {
    // ENTRY POINT FOR THE APP TO ACCESS THE DATABASE
    private FirebaseDatabase mFirebaseDatabase;

    // SPECIFIC PART REFERENCE TO THE DATABASE IT ONLY GOES TO THE USER
    private DatabaseReference mUserDatabaseReference;

    // A CHILD LISTENER FOR THE
    private ChildEventListener mChildEventListener;

    // LOCAL USER
    User currentUser;

    String uID;

    public User StartDB(){
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        uID = "ruperto";


        // TODO GET INFO FROM Firbase UI GUID

        mUserDatabaseReference = mFirebaseDatabase.getReference().child("users");
        retrieveUserFromDatabase(mUserDatabaseReference);
        Log.e("null???", "1st check: " + currentUser );

        return currentUser;
    }

    private void retrieveUserFromDatabase(final DatabaseReference mUserDatabaseReference) {

        Log.d("mUserReference", "retrieveUserFromDatabase: " +mUserDatabaseReference);
        mUserDatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChild(uID)){
                    currentUser = (User) dataSnapshot.getValue(User.class);
                    Log.e("userName", "onDataChange: " + currentUser);
                }
                else{
                    getFirebaseUICredentials();
                    mUserDatabaseReference.child(uID).setValue(currentUser);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //TODO "something went wrong" please retry the last thing you were trying to do. If the problem persist call 1-800-OHH-WELL
            }
        });
    }

    private void getFirebaseUICredentials() {
        String email = "some@tacos.com";
        String name = "myname";
        Log.e("zecheck", "StartDB: I am in ze if");
            //INITIALIZE USER
            final List<String> scheduleList = new ArrayList<String>() {
                {
                    add("ONE");
                    add("TWO");
                    add("THREE");
                    add("FOUR");
                }};
            List<String> zones = new ArrayList<String>() {{
                add("ONE");
                add("TWO");
                add("THREE");
                add("FOUR");
            }};

            currentUser = new User();
            currentUser.setScheduleList(scheduleList);
            currentUser.setZoneList(zones);
            currentUser.setEmail(email);
            currentUser.setName(name);
            //Log.e("currentUser", "StartDB: " + mUserDatabaseReference.getKey());

    }

    private void StartZones(DatabaseReference userReference){
        List<Zone> zoneList;
        DatabaseReference mZonesDBReference = mUserDatabaseReference.child("zones");
        // TO ADD A USER. OR PUSH INFORMATION TO THE DATABASE SETTING UP LISTENERS
        mChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                // THIS IS WHEN SOMETHING IS INSERTED INTO THE CHILDREN OR AT START TO INSERT ALL THE ZONES/ SCHEDULES

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                // THIS GETS CALLED WHEN THE CONTENTS OF THE CHILD GETS CHANGED

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                // THIS GETS CALLED WHEN THE CHILD IS DELETED
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                // IF ONE OF THE MESSAGES CHANGES POSITION
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // SOME ERROR OCCURRED WHEN TRYING TO MAKE CHANGES
            }
        };

        mZonesDBReference.addChildEventListener(mChildEventListener);
    }

    private void StartSchedule(){
        DatabaseReference mScheduleDBReference = mUserDatabaseReference.child("zones");

        // TO ADD A USER. OR PUSH INFORMATION TO THE DATABASE SETTING UP LISTENERS
        mChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                // THIS IS WHEN SOMETHING IS INSERTED INTO THE CHILDREN OR AT START TO INSERT ALL THE ZONES/ SCHEDULES
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                // THIS GETS CALLED WHEN THE CONTENTS OF THE CHILD GETS CHANGED
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                // THIS GETS CALLED WHEN THE CHILD IS DELETED
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                // IF ONE OF THE MESSAGES CHANGES POSITION
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // SOME ERROR OCCURRED WHEN TRYING TO MAKE CHANGES
            }
        };

        mScheduleDBReference.addChildEventListener(mChildEventListener);
    }



}
