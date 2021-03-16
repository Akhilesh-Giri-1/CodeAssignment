package com.example.codeassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<CustomerModel> customerModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView=(RecyclerView) findViewById(R.id.recycler_view);
        customerModelArrayList=new ArrayList<>();
        customerModelArrayList.add(new CustomerModel("Sachin","Bandra East"));
        customerModelArrayList.add(new CustomerModel("Ajay","Vasai West"));
        customerModelArrayList.add(new CustomerModel("Vijay","Bhayander East"));
        customerModelArrayList.add(new CustomerModel("Rohit","Borivali East"));
        customerModelArrayList.add(new CustomerModel("Kuldeep","Andheri East"));
        customerModelArrayList.add(new CustomerModel("Deepak","Dadar West"));
        customerModelArrayList.add(new CustomerModel("Harish","Bandra West"));
        customerModelArrayList.add(new CustomerModel("Aman","Dahisar East"));
        customerModelArrayList.add(new CustomerModel("Sandeep","Matunga west"));
        customerModelArrayList.add(new CustomerModel("Pradeep","Palghar East"));

        Collections.sort(customerModelArrayList, new Comparator<CustomerModel>() {
            @Override
            public int compare(CustomerModel o1, CustomerModel o2) {
                return o1.getCustomer_name().compareTo(o2.getCustomer_name());
            }
        });
        CustomerAdapter customerAdapter=new CustomerAdapter(this, customerModelArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(customerAdapter);
    }



}