package com.example.login;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ProductsAdapter extends ArrayAdapter<Product> {

    private Context context;

    public ProductsAdapter(Context context, ArrayList<Product> products){
        super(context, 0, products);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Product product = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        TextView productName = (TextView) convertView.findViewById(R.id.productName);
        TextView price = (TextView) convertView.findViewById(R.id.price);
        ImageView img = (ImageView) convertView.findViewById(R.id.img);
        TextView seller = (TextView) convertView.findViewById(R.id.seller);

        productName.setText(product.productName);
        price.setText(product.price);
        seller.setText(product.seller);

        String uri = "@drawable/" + product.imagePath;  // where myresource (without the extension) is the file
        int imageResource = getContext().getResources().getIdentifier(uri, null, getContext().getPackageName());
        Drawable res = getContext().getResources().getDrawable(imageResource);
        img.setImageDrawable(res);

        Button button = (Button) convertView.findViewById(R.id.detalji);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i("MyApp","I am here" + position);
                Intent intent = new Intent(context, Detalji.class);
                Bundle b = new Bundle();
                b.putInt("key", position); //Your id
                intent.putExtras(b); //Put your id to your next Intent
                context.startActivity(intent);
            }
        });

        return convertView;

    }
}
