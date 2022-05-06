package com.exam.employeetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

public class searchemployee extends AppCompatActivity {

    AutoCompleteTextView empsearch;
    TextView empid, empname, empdesignation, phoneno, empemail;
    Button searchbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchemployee);
        empsearch=findViewById(R.id.employeesearch);
        searchbtn=findViewById(R.id.searchbtn);
        empid=findViewById(R.id.employeeid);
        empname=findViewById(R.id.empname);
        empdesignation=findViewById(R.id.empdesignation);
        phoneno=findViewById(R.id.empphone);
        empemail=findViewById(R.id.empemail);

        employeedb empdata = new employeedb(searchemployee.this,"employee",null,1);

        ArrayAdapter adp = new ArrayAdapter(searchemployee.this,androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                empdata.displaynames());

        empsearch.setAdapter(adp);
        empsearch.setThreshold(1);

        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor result = empdata.findbyname(empsearch.getText().toString());
                result.moveToNext();
                empid.setText(result.getString(0));
                empname.setText(result.getString(1));
                empdesignation.setText(result.getString(2));
                phoneno.setText(result.getString(3));
                empemail.setText(result.getString(4));
            }
        });


    }
}