package com.example.login;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ProductsAdapter extends ArrayAdapter<Product> {

    public ProductsAdapter(Context context, ArrayList<Product> products){
        super(context, 0, products);
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

        return convertView;

    }
}
