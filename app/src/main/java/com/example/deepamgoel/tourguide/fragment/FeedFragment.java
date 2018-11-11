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
import com.example.deepamgoel.tourguide.adapter.FeedAdapter;
import com.example.deepamgoel.tourguide.model.ItemFeedModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FeedFragment extends Fragment {


    @BindView(R.id.recycler_view_fragment)
    RecyclerView recyclerView;
    private List<ItemFeedModel> list = new ArrayList<>();

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

        FeedAdapter adapter = new FeedAdapter(getContext(), list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    private void addItem(List<ItemFeedModel> list) {
        String[] feedUrlArray = getResources().getStringArray(R.array.feed_link_urls);
        String[] imageUrlArray = getResources().getStringArray(R.array.feed_image_urls);
        String[] titleArray = getResources().getStringArray(R.array.feed_title);
        String[] descriptionArray = getResources().getStringArray(R.array.feedDescription);
        String[] authorArray = getResources().getStringArray(R.array.feed_author);

        list.clear();
        for (int i = 0; i < titleArray.length; i++) {
            list.add(
                    new ItemFeedModel(
                            feedUrlArray[i],
                            imageUrlArray[i],
                            titleArray[i],
                            descriptionArray[i],
                            authorArray[i]
                    ));
        }
    }

}
