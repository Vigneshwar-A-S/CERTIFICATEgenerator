package com.example.istecertification;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
         
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "TAG" ;
    private RecyclerView mProductRView;
    private LinearLayoutManager mLayoutManage;

    private ArrayList<ProductItem> mProductList = new ArrayList<>();   /*here the arraylist is empty, so we need to fetch data from firebase*/
    private ProductAdapter mProductAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {

        //initialize RecyclerView

        mProductRView = ( RecyclerView ) findViewById(R.id.product_rview);

        //setting Layout Manager for Recylcler view
        mLayoutManage = new LinearLayoutManager(this);
        mProductRView.setLayoutManager(mLayoutManage);

        /*For Recycler View, We need to Create Adapter, before that we create a firebase data model(PRODUCT ITEM.CLASS)*/

        /*Setting Adapter view to recycler view*/

        mProductAdapter = new ProductAdapter(this, mProductList);

        mProductRView.setAdapter(mProductAdapter);

        fetchData();
    }

    private void fetchData() {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("products");
        myRef.addValueEventListener(new ValueEventListener() {
            private DatabaseError error;

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

//                datasnapshot is a list of json data
//                lets run for loop to set data in our array list

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    ProductItem item = dataSnapshot1.getValue( ProductItem.class);
                    mProductList.add(item);
                }

                mProductAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }
}
