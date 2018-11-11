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
import com.example.deepamgoel.tourguide.adapter.MustEatAdapter;
import com.example.deepamgoel.tourguide.model.ItemEatModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MustEatFragment extends Fragment {


    @BindView(R.id.recycler_view_fragment)
    RecyclerView recyclerView;
    private List<ItemEatModel> list = new ArrayList<>();

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

        MustEatAdapter adapter = new MustEatAdapter(getContext(), list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    private void addItem(List<ItemEatModel> list) {
        String[] urlArray = getResources().getStringArray(R.array.food_image_urls);
        String[] titleArray = getResources().getStringArray(R.array.food_title);
        String[] restaurantArray = getResources().getStringArray(R.array.restaurant);
        String[] descriptionArray = getResources().getStringArray(R.array.food_description);
        String[] priceArray = getResources().getStringArray(R.array.food_price);
        String[] whereArray = getResources().getStringArray(R.array.restaurant_where);
        String[] timingArray = getResources().getStringArray(R.array.restaurant_timing);

        list.clear();
        for (int i = 0; i < titleArray.length; i++) {
            list.add(
                    new ItemEatModel(
                            urlArray[i],
                            titleArray[i],
                            restaurantArray[i],
                            descriptionArray[i],
                            priceArray[i],
                            whereArray[i],
                            timingArray[i]
                    ));
        }
    }

}
