package com.example.labact3_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    EditText editText, editText2, editText3, editText4, editText5, editText6, editText7, editText8;
    private Button save, next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        editText5 = findViewById(R.id.editText5);
        editText6 = findViewById(R.id.editText6);
        editText7 = findViewById(R.id.editText7);
        editText8 = findViewById(R.id.editText8);

        save = findViewById(R.id.btn_save);
        next = findViewById(R.id.btn_next);

        save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Set <String> set = new HashSet<>();

                set.add(String.valueOf(editText.getText()));
                set.add(String.valueOf(editText2.getText()));
                set.add(String.valueOf(editText3.getText()));
                set.add(String.valueOf(editText4.getText()));
                set.add(String.valueOf(editText5.getText()));
                set.add(String.valueOf(editText6.getText()));
                set.add(String.valueOf(editText7.getText()));
                set.add(String.valueOf(editText8.getText()));

                saveData(convertSetString(set));
                Toast.makeText(v.getContext(), "Successfully Saved", Toast.LENGTH_LONG).show();
            }
        }

        );


    }

    private String convertSetString(Set<String> set){
        StringBuilder sb = new StringBuilder();
        for (String s:set){

            sb.append(s).append("-");
        }
        return sb.toString();
    }

    public void openActivity(Class activityClass){
        Intent i= new Intent(this,activityClass);
        startActivity(i);

    }








    public void saveData(String data){
        //String data= editText.getText().toString();
       // String data2= editText2.getText().toString();
       // String data3= editText3.getText().toString();
       // String data4= editText4.getText().toString();
       // String data5= editText5.getText().toString();
       // String data6= editText6.getText().toString();
       // String data7= editText7.getText().toString();
       // String data8= editText8.getText().toString();

        FileOutputStream fos= null;

        try {
            fos= openFileOutput("data.txt", MODE_PRIVATE);

            fos.write(data.getBytes());
        } catch (FileNotFoundException e) {
            Log.d("error","File not Found...");
        } catch (IOException e) {
            Log.d("error","IO Error");

        }finally{
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Toast.makeText(this, "Data was saved in Internal Storage..", Toast.LENGTH_LONG).show();

    }
}
