package com.amadeus.feelens;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class InviteFriendsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_friends);
        FloatingActionButton fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        FloatingActionButton fab3 = (FloatingActionButton) findViewById(R.id.fab3);
        ImageView img1 = (ImageView) findViewById(R.id.iv1);
        ImageView img2 = (ImageView) findViewById(R.id.iv2);
        ImageView img3 = (ImageView) findViewById(R.id.iv3);

        Glide.with(getApplicationContext()).load(R.drawable.giovanni_wall).into(img1);
        Glide.with(getApplicationContext()).load(R.drawable.joao_wall).into(img2);
        Glide.with(getApplicationContext()).load(R.drawable.kaick_wall).into(img3);


        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(InviteFriendsActivity.this, "Amigo convidado!", Toast.LENGTH_SHORT).show();
            }
        });

        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(InviteFriendsActivity.this, "Amigo convidado!", Toast.LENGTH_SHORT).show();

            }
        });

        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(InviteFriendsActivity.this, "Amigo convidado!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
