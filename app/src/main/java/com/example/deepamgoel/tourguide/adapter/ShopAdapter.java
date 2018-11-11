package com.example.deepamgoel.tourguide.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.deepamgoel.tourguide.R;
import com.example.deepamgoel.tourguide.model.ItemShopModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder> {
    private Context context;
    private List<ItemShopModel> list;

    public ShopAdapter(Context context, List<ItemShopModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_shop, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int position) {
        ItemShopModel item = list.get(position);

        Glide.with(context)
                .load(item.getImageUrl())
                .into(viewHolder.imageView);
        viewHolder.titleTextView.setText(item.getTitle());
        viewHolder.descriptionShortTextView.setText(item.getDescriptionShort());
        viewHolder.descriptionLongTextView.setText(item.getDescriptionLong());

        viewHolder.descriptionLongTextView.setVisibility(View.GONE);
        viewHolder.moreButton.setText(R.string.more);

        viewHolder.moreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (viewHolder.descriptionLongTextView.getVisibility()) {
                    case View.VISIBLE:
                        viewHolder.moreButton.setText(R.string.more);
                        viewHolder.descriptionLongTextView.setVisibility(View.GONE);
                        break;
                    case View.GONE:
                        viewHolder.moreButton.setText(R.string.less);
                        viewHolder.descriptionLongTextView.setVisibility(View.VISIBLE);
                        break;
                    case View.INVISIBLE:
                        break;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_shop_image_view)
        ImageView imageView;
        @BindView(R.id.item_shop_title_text_view)
        TextView titleTextView;
        @BindView(R.id.item_shop_description_short_text_view)
        TextView descriptionShortTextView;
        @BindView(R.id.item_shop_more_button)
        TextView moreButton;
        @BindView(R.id.item_shop_description_long_text_view)
        TextView descriptionLongTextView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
