package com.example.istecertification;

/*this is a recycler view adapter so extend ReCYCLER VIEW*/

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.nio.file.attribute.PosixFileAttributes;
import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<ProductItem> mProductList;


    /*Lets create a public constructor, so we can send array list, contacts, from mainactivity*/


    public ProductAdapter(Context con, ArrayList<ProductItem> list)
    {
        this.mContext=con;
        this.mProductList=list;
    }


    @NonNull
    @Override
    public ProductAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.inflate_product_item,parent,false);

                /*passing view instance to myViewHolder*/

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.MyViewHolder holder, int position) {
       /*Setting data to the text view*/

        holder.nfruit.setText(mProductList.get(position).getFruits());
        holder.nquantity.setText(mProductList.get(position).getQuantity());

//        holder.nprice.setText(mContext.getString(R.string.Rs)+" " + mProductListget(position).getFruits());




    }

    @Override
    public int getItemCount() {

//        returning array list size

        return mProductList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {

        public TextView nfruit, nquantity;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nfruit = (TextView) itemView.findViewById(R.id.nfruit);
            nquantity = (TextView) itemView.findViewById(R.id.nquantity);

        }
    }

}
