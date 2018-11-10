package com.example.deepamgoel.tourguide.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.deepamgoel.tourguide.R;
import com.example.deepamgoel.tourguide.model.ItemEatModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MustEatAdapter extends RecyclerView.Adapter<MustEatAdapter.ViewHolder> {

    private Context context;
    private List<ItemEatModel> list;

    public MustEatAdapter(Context context, List<ItemEatModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_must_eat, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        ItemEatModel item = list.get(position);

        Glide.with(context)
                .load(item.getImageUrl())
                .into(viewHolder.imageView);
        viewHolder.titleTextView.setText(item.getTitle());
        viewHolder.restaurantTextView.setText(item.getRestaurant());
        viewHolder.descriptionTextView.setText(item.getDescription());
        viewHolder.priceTextView.setText(Html.fromHtml(item.getPrice()));
        viewHolder.whereTextView.setText(Html.fromHtml(item.getWhere()));
        viewHolder.timingTextView.setText(Html.fromHtml(item.getTiming()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_eat_image_view)
        ImageView imageView;
        @BindView(R.id.item_eat_title_text_view)
        TextView titleTextView;
        @BindView(R.id.item_eat_restaurant_text_view)
        TextView restaurantTextView;
        @BindView(R.id.item_eat_description_text_view)
        TextView descriptionTextView;
        @BindView(R.id.item_eat_price_text_view)
        TextView priceTextView;
        @BindView(R.id.item_eat_where_text_view)
        TextView whereTextView;
        @BindView(R.id.item_eat_timing_text_view)
        TextView timingTextView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
