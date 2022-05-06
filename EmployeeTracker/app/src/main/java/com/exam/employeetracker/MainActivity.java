package com.exam.employeetracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView employeelist;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        employeelist=findViewById(R.id.emplist);

        employeedb employeenames = new employeedb(MainActivity.this,"employee",null,1);

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,employeenames.displaynames());

        employeelist.setAdapter(adp);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.m1:
                Intent i1 = new Intent(MainActivity.this,insertemp.class);
                startActivity(i1);
                break;

            case R.id.m2:
                Intent i2 = new Intent(MainActivity.this,MainActivity.class);
                startActivity(i2);
                break;

            case R.id.m3:
                Intent i3 = new Intent(MainActivity.this,searchemployee.class);
                startActivity(i3);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}