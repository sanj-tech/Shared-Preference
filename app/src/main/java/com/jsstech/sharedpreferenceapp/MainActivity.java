package com.jsstech.sharedpreferenceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtMsg;
    Button savebtn,displaybtn;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtMsg=findViewById(R.id.msg);
        savebtn=findViewById(R.id.btsave);
        displaybtn=findViewById(R.id.btdisplay);
        textView=findViewById(R.id.tvdisplay);

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences=getSharedPreferences("user msg",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("message",edtMsg.getText().toString().trim());
                editor.apply();
                Toast.makeText(MainActivity.this,"save Sucessfully",Toast.LENGTH_SHORT).show();
            }
        });

        displaybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences=getSharedPreferences("user msg",Context.MODE_PRIVATE);
                String message=sharedPreferences.getString("message","");
                textView.setText("Message: "+message);

            }
        });






    }
}