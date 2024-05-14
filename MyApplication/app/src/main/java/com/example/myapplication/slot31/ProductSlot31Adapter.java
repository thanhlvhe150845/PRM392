package com.example.myapplication.slot31;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductSlot31Adapter extends BaseAdapter {
    private Context mContext;
    private List<ProductSlot31> mProductList;

    public ProductSlot31Adapter(Context context,
                                List<ProductSlot31> productList) {
        mContext = context;
        mProductList = productList;
    }

    @Override
    public int getCount() {
        return mProductList.size();
    }

    @Override
    public Object getItem(int position) {
        return mProductList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView,
                        ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext)
                    .inflate(R.layout.item_product_slot31, parent,
                            false);
            holder = new ViewHolder();
            holder.imageView = convertView
                    .findViewById(R.id.productImageView);
            holder.styleIdTextView = convertView
                    .findViewById(R.id.styleIdTextView);
            holder.brandTextView = convertView
                    .findViewById(R.id.brandTextView);
            holder.priceTextView = convertView
                    .findViewById(R.id.priceTextView);
            holder.additionalInfoTextView = convertView
                    .findViewById(R.id.additionalInfoTextView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ProductSlot31 product = mProductList.get(position);
//        if (product != null) {
//            Glide.with(mContext)
//                    .load(product.getSearchImage())
//                    .apply(new RequestOptions()
//                            .placeholder(R.drawable.ic_launcher_background) // Ảnh placeholder nếu không tải được ảnh từ URL
//                            .diskCacheStrategy(DiskCacheStrategy.ALL))
//                    .into(holder.imageView);
//            holder.styleIdTextView.setText(product.getStyleId());
//            holder.brandTextView.setText(product.getBrand());
//            holder.priceTextView.setText(product.getPrice());
//            holder.additionalInfoTextView.setText(product.getAdditionalInfo());
//        }

        if (product != null) {
            Picasso.get().load(product.getSearchImage())
                    .into(holder.imageView);
            holder.styleIdTextView.setText(product.getStyleId());
            holder.brandTextView.setText(product.getBrand());
            holder.priceTextView.setText(product.getPrice());
            holder.additionalInfoTextView.setText(product.getAdditionalInfo());
        }

        return convertView;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView styleIdTextView;
        TextView brandTextView;
        TextView priceTextView;
        TextView additionalInfoTextView;
    }
}
