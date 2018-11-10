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
import com.example.deepamgoel.tourguide.adapter.DestinationAdapter;
import com.example.deepamgoel.tourguide.model.ItemModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DestinationFragment extends Fragment {

    @BindView(R.id.recycler_view_destination_fragment)
    RecyclerView recyclerView;
    private List<ItemModel> list = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);

        addItem(list);

        DestinationAdapter adapter = new DestinationAdapter(getContext(), list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    private void addItem(List<ItemModel> list) {
        String[] urlArray = getResources().getStringArray(R.array.image_urls);
        String[] titleArray = getResources().getStringArray(R.array.title);
        String[] descriptionArray = getResources().getStringArray(R.array.description);
        String[] ratingArray = getResources().getStringArray(R.array.rating);
        for (int i = 0; i < titleArray.length; i++) {
            list.add(
                    new ItemModel(
                            urlArray[i],
                            titleArray[i],
                            descriptionArray[i],
                            Float.parseFloat(ratingArray[i])
                    ));
        }
    }
}
