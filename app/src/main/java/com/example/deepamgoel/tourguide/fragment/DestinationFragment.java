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
import com.example.deepamgoel.tourguide.model.ItemDestinationModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DestinationFragment extends Fragment {

    @BindView(R.id.recycler_view_fragment)
    RecyclerView recyclerView;
    private List<ItemDestinationModel> list = new ArrayList<>();

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

        DestinationAdapter adapter = new DestinationAdapter(getContext(), list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    private void addItem(List<ItemDestinationModel> list) {
        String[] urlArray = getResources().getStringArray(R.array.destination_image_urls);
        String[] titleArray = getResources().getStringArray(R.array.destination_title);
        String[] descriptionShortArray = getResources().getStringArray(R.array.destinationDescriptionShort);
        String[] descriptionLongArray = getResources().getStringArray(R.array.destinationDescriptionLong);
        String[] ratingArray = getResources().getStringArray(R.array.rating);

        list.clear();
        for (int i = 0; i < titleArray.length; i++) {
            list.add(
                    new ItemDestinationModel(
                            urlArray[i],
                            titleArray[i],
                            descriptionShortArray[i],
                            descriptionLongArray[i],
                            Float.parseFloat(ratingArray[i])
                    ));
        }
    }
}
