package com.example.deepamgoel.tourguide.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.deepamgoel.tourguide.R;
import com.example.deepamgoel.tourguide.model.ItemModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DestinationAdapter extends RecyclerView.Adapter<DestinationAdapter.ViewHolder> {

    private Context context;
    private List<ItemModel> list;

    public DestinationAdapter(Context context, List<ItemModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_destination, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        ItemModel item = list.get(position);

        Glide.with(context)
                .load(item.getImageUrl())
                .into(viewHolder.imageView);
        viewHolder.titleTextView.setText(item.getTitle());
        viewHolder.ratingBar.setRating(item.getRating());
        viewHolder.ratingTextView.setText(String.valueOf(item.getRating()));
        viewHolder.descriptionTextView.setText(item.getDescription());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_image_view)
        ImageView imageView;
        @BindView(R.id.item_title_text_view)
        TextView titleTextView;
        @BindView(R.id.item_rating_bar)
        RatingBar ratingBar;
        @BindView(R.id.item_rating_text_view)
        TextView ratingTextView;
        @BindView(R.id.item_description_text_view)
        TextView descriptionTextView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}