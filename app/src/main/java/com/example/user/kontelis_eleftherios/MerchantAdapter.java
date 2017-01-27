package com.example.user.kontelis_eleftherios;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 27/1/2017.
 */

public class MerchantAdapter extends ArrayAdapter<Merchant> {

    private ArrayList<Merchant> merchants;
    private Context context;

    public MerchantAdapter(Context context, ArrayList<Merchant> objects) {
        super(context, 0, objects);
        this.merchants = objects;
        this.context = context;
    }

    public ArrayList<Merchant> getMerchants() {
        return merchants;
    }

    public void setMerchants(ArrayList<Merchant> merchants) {
        this.merchants = merchants;
    }

    @NonNull
    @Override
    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        ViewHolder viewHolder;
        Merchant m = merchants.get(position);

        if(rowView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.list_item_merchant, null);
            viewHolder = new ViewHolder(rowView);
            rowView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder)rowView.getTag();
        }

        viewHolder.imageView.setImageResource(R.drawable.logo);
        viewHolder.legalNameView.setText(m.getLegalName());
        viewHolder.categoryNameView.setText(m.getCategory());
        viewHolder.addressView.setText(m.getAddress());
        viewHolder.ratingView.setText(m.getReview());
        //.....
        return  rowView;
    }

    static class ViewHolder {
        public final ImageView imageView;
        public final TextView legalNameView;
        public final TextView categoryNameView;
        public final TextView addressView;
        public final TextView ratingView;

        public ViewHolder(View view){
            imageView = (ImageView)view.findViewById(R.id.list_item_merchant_image);
            legalNameView = (TextView)view.findViewById(R.id.list_item_merchant_legal_name);
            categoryNameView = (TextView) view.findViewById(R.id.list_item_merchant_category);
            addressView = (TextView)view.findViewById(R.id.list_item_merchant_contact_point);
            ratingView = (TextView)view.findViewById(R.id.list_item_merchant_aggregate_rating);

            //.....
        }
    }
}

