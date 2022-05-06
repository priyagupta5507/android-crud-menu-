package com.exam.employeetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

public class insertemp extends AppCompatActivity {

    TextView ename, phoneno, email;
    AutoCompleteTextView designation;
    Button inserbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertemp);
        ename=findViewById(R.id.employeename);
        phoneno=findViewById(R.id.employeephone);
        email=findViewById(R.id.employeeemail);
        designation=findViewById(R.id.employeedesignation);
        inserbtn=findViewById(R.id.insertdata);

        String[] designations = {"Clerk","Executive","Manager"};

        ArrayAdapter adp = new ArrayAdapter(insertemp.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,designations);

        designation.setAdapter(adp);
        designation.setThreshold(1);

        employeedb employeedatabase = new employeedb(insertemp.this,"employee",null,1);

        inserbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String employeephone = phoneno.getText().toString();
                Integer phoneno = Integer.parseInt(employeephone);
                employeedatabase.addData(ename.getText().toString(),designation.getText().toString(),phoneno,email.getText().toString());
                Intent i = new Intent(insertemp.this,MainActivity.class);
                startActivity(i);
            }
        });

    }
}