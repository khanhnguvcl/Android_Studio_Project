package com.example.bookmark;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookMarkAdapter extends RecyclerView.Adapter<BookMarkAdapter.BViewHolder> {
    private Context context;
    private List<Product> productList;


    public BookMarkAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public BViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_bookmark, parent, false);
        return new BViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.tvProductName.setText(product.getName());
        holder.tvPrice.setText(product.getPrice()+ "đồng");
        holder.imgProduct.setImageResource(product.getImageResId());

        holder.buynow.setOnClickListener(v -> {
            // Handle Buy Now action
        });

        holder.delete.setOnClickListener(v -> {
            // Handle Delete action
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

   public static class BViewHolder extends RecyclerView.ViewHolder{
        ImageView imgProduct;
        TextView tvProductName, tvPrice;
        Button buynow;
        ImageButton delete;


       public BViewHolder(@NonNull View itemView) {
           super(itemView);
           imgProduct = itemView.findViewById(R.id.imgProduct);
           tvProductName = itemView.findViewById(R.id.tvProductName);
           tvPrice = itemView.findViewById(R.id.tvPrice);
           buynow = itemView.findViewById(R.id.buynow);
           delete = itemView.findViewById(R.id.delete);
       }
   }

}
