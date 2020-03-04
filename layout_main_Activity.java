package com.example.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

        EditText e1,e2;
        Button bt;
        Spinner s;

        String[] dept_array={"CSE","ECE","IT","ME","CV","ISE"};

        String name,reg,dept;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                e1=(EditText)findViewById(R.id.editText2);
                e2=(EditText)findViewById(R.id.editText3);

                bt=(Button)findViewById(R.id.button);
                s=(Spinner)findViewById(R.id.spinner);
                ArrayAdapter adapter=new ArrayAdapter(MainActivity.this,android.R.layout.simple_spinner_item,dept_array);
                s.setAdapter(adapter);

                bt.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                name=e1.getText().toString();
                                reg=e2.getText().toString();
                                dept=s.getSelectedItem().toString();

                                Intent i=new Intent(MainActivity.this, activity_second.class);
                                i.putExtra("name_key",name);
                                i.putExtra("reg_key",reg);
                                i.putExtra("dept_key",dept);

                                startActivity(i);
                        }
                });
        }
}
