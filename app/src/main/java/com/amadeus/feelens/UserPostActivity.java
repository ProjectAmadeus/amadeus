package com.amadeus.feelens;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class UserPostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_post);

        Button postButton = (Button) findViewById(R.id.btnPostPhoto);
        ImageView postImage = (ImageView) findViewById(R.id.ivPostImagePreview);
        Spinner taskSpinner = (Spinner) findViewById(R.id.spinner_tasks);
        final EditText postDesc = (EditText) findViewById(R.id.etPostDescription);
        String[] spinnerTasks = new String[]{"Mooca Burger", "Casarão do Vinil", "Antigo Cotonifício"};


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, spinnerTasks);
        taskSpinner.setAdapter(adapter);

        Intent intent = getIntent();
        final Uri imageUri = Uri.parse(intent.getExtras().getString("uri"));
        postImage.setImageURI(imageUri);

        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                intent.putExtra("post_desc", postDesc.getText().toString());
                intent.putExtra("new_uri", imageUri.toString());
                startActivity(intent);
            }
        });



    }
}
