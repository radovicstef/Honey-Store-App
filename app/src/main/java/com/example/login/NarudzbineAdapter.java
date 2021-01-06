package com.example.login;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class NarudzbineAdapter extends ArrayAdapter<Narudzbina> {

    private Context context;

    public NarudzbineAdapter(Context context, ArrayList<Narudzbina> narudzbine){
        super(context, 0, narudzbine);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Narudzbina narudzbina = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.korpa_item, parent, false);
        }

        TextView productName = (TextView) convertView.findViewById(R.id.productNameKorpa);
        TextView price = (TextView) convertView.findViewById(R.id.priceKorpa);
        ImageView img = (ImageView) convertView.findViewById(R.id.imgKorpa);
        TextView seller = (TextView) convertView.findViewById(R.id.sellerKorpa);

        productName.setText(narudzbina.product.productName);
        price.setText(String.valueOf(narudzbina.overallPrice));
        seller.setText(narudzbina.product.seller);

        String uri = "@drawable/" + narudzbina.product.imagePath;  // where myresource (without the extension) is the file
        int imageResource = getContext().getResources().getIdentifier(uri, null, getContext().getPackageName());
        Drawable res = getContext().getResources().getDrawable(imageResource);
        img.setImageDrawable(res);

        return convertView;

    }
}
