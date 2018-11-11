package com.example.deepamgoel.tourguide.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.deepamgoel.tourguide.R;
import com.example.deepamgoel.tourguide.model.ItemFeedModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {

    private Context context;
    private List<ItemFeedModel> list;

    public FeedAdapter(Context context, List<ItemFeedModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_feed, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final ItemFeedModel item = list.get(position);

        Glide.with(context)
                .load(item.getImageUrl())
                .into(viewHolder.imageView);
        viewHolder.autorTextView.setText(item.getAuthor());
        viewHolder.titleTextView.setText(item.getTitle());
        viewHolder.descriptionTextView.setText(item.getDescription());

        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(item.getLinkUrl()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_feed_card_view)
        CardView cardView;
        @BindView(R.id.item_feed_image_view)
        ImageView imageView;
        @BindView(R.id.item_feed_title_text_view)
        TextView titleTextView;
        @BindView(R.id.item_feed_author_text_view)
        TextView autorTextView;
        @BindView(R.id.item_feed_description_text_view)
        TextView descriptionTextView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
