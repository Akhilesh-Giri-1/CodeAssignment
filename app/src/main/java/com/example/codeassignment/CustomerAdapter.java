package com.example.codeassignment;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.Viewholder> {

    private Context context;
    private ArrayList<CustomerModel> customerModelArrayList;
    Spinner spin ;

    // Constructor
    public CustomerAdapter(Context context, ArrayList<CustomerModel> customerModelArrayList) {
        this.context = context;
        this.customerModelArrayList = customerModelArrayList;
    }


    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        CustomerModel model = customerModelArrayList.get(position);
        holder.customerName.setText(model.getCustomer_name());
        holder.customerAddress.setText(model.getCustomer_address());

        List<String> spinArr=new ArrayList<String>();
        spinArr.add("Select");
        spinArr.add("SALARIED");
        spinArr.add("Self Employed");
        spinArr.add("Student");

        ArrayAdapter<String> aa = new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item,spinArr);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
    }

    @Override
    public int getItemCount() {
        return customerModelArrayList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        private TextView customerName, customerAddress, textView;
        LinearLayout linearLayout;
        ProgressBar pbar;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            linearLayout=(LinearLayout) itemView.findViewById(R.id.idLinear);
            spin=(Spinner)  itemView.findViewById(R.id.spinner);

            pbar = (ProgressBar) itemView.findViewById(R.id.progressBar);
            textView = (TextView) itemView.findViewById(R.id.spinner_item);

            spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                    textView.setText("");

                    if(arg0.getItemAtPosition(position).equals("Select")){
                        pbar.setVisibility(View.INVISIBLE);
                    }
                    else {
                        pbar.setVisibility(View.VISIBLE);
                        Handler handler = new Handler();

                        new Thread(new Runnable() {
                            public void run() {
                                try {
                                    pbar.setVisibility(View.VISIBLE);
                                    Thread.sleep(5000);

                                } catch (Exception e) {
                                }
                                handler.post(new Runnable() {
                                    public void run() {

                                        pbar.setVisibility(View.INVISIBLE);
                                        textView = (TextView) itemView.findViewById(R.id.spinner_item);
                                        textView.setText("done");
                                    }
                                });
                            }
                        }).start();
                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            customerName = itemView.findViewById(R.id.idName);
            customerAddress = itemView.findViewById(R.id.idAdrress);


        }
    }

}
