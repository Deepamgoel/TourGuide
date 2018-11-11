package com.example.deepamgoel.tourguide.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.deepamgoel.tourguide.R;
import com.example.deepamgoel.tourguide.adapter.ShopAdapter;
import com.example.deepamgoel.tourguide.model.ItemShopModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShopFragment extends Fragment {


    @BindView(R.id.recycler_view_fragment)
    RecyclerView recyclerView;
    private List<ItemShopModel> list = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        ButterKnife.bind(this, view);

        addItem(list);

        ShopAdapter adapter = new ShopAdapter(getContext(), list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    private void addItem(List<ItemShopModel> list) {
        String[] urlArray = getResources().getStringArray(R.array.shop_image_urls);
        String[] titleArray = getResources().getStringArray(R.array.shop_title);
        String[] descriptionShortArray = getResources().getStringArray(R.array.shopDescriptionShort);
        String[] descriptionLongArray = getResources().getStringArray(R.array.shopDescriptionLong);

        for (int i = 0; i < titleArray.length; i++) {
            list.add(
                    new ItemShopModel(
                            urlArray[i],
                            titleArray[i],
                            descriptionShortArray[i],
                            descriptionLongArray[i]
                    ));
        }
    }

}
