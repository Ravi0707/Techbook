package com.example.techbook.ui.main;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.techbook.R;
import com.example.techbook.data.CurrentUser;
import com.example.techbook.data.CurrentUserInfoHolder;
import com.example.techbook.database.Database;
import com.example.techbook.ui.welcome.Welcome;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.squareup.picasso.Picasso;

import java.util.Objects;

import javax.annotation.Nullable;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    public static NavigationView navigationView;
    Toolbar toolbar;
    TextView profileName, profileEmail;
    CircleImageView profileImage;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    NavController navController;
    Database database = new Database();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);
        profileName = navigationView.getHeaderView(0).findViewById(R.id.headerProfileName);
        profileEmail = navigationView.getHeaderView(0).findViewById(R.id.headerProfileEmail);
        profileImage = navigationView.getHeaderView(0).findViewById(R.id.headerImageView);
        getUserData();
        setupNavigation();

    }

    public void getUserData() {
        final Uri imageUri = database.getProfilePictureUrl();
        DocumentReference docRef = database.getUserData();

        docRef.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                assert documentSnapshot != null;
                String name = documentSnapshot.getString("Name");
                String email = documentSnapshot.getString("Email");
                CurrentUserInfoHolder.getInstance().setItem(new CurrentUser(name, imageUri, email, user.getUid()));
                profileName.setText(name);
                profileEmail.setText(email);
                Picasso.get().load(imageUri).placeholder(R.drawable.ic_user).into(profileImage);
            }
        });

    }

    private void setupNavigation() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerLayout = findViewById(R.id.drawer_layout);

        navigationView = findViewById(R.id.navigationView);

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout);

        NavigationUI.setupWithNavController(navigationView, navController);

        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.navHome:
                navController.navigate(R.id.navHome);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.navNotes:
                navController.navigate(R.id.navNotes);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.navAssignments:
                navController.navigate(R.id.navAssignments);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_logout:
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setTitle("Logout");
                alertDialogBuilder
                        .setMessage("Are you sure want to logout?")
                        .setCancelable(false)
                        .setPositiveButton("NO",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.dismiss();
                                    }
                                })

                        .setNegativeButton("YES", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.dismiss();
                                FirebaseAuth.getInstance().signOut();
                                startActivity(new Intent(MainActivity.this, Welcome.class));
                                finish();
                            }
                        });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
                break;

            case R.id.nav_share:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,
                        "Hey check out my app at Playstore");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                break;
        }
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment), drawerLayout);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}