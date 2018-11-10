package com.example.deepamgoel.tourguide;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.deepamgoel.tourguide.adapter.ViewPagerAdapter;
import com.example.deepamgoel.tourguide.fragment.DestinationFragment;
import com.example.deepamgoel.tourguide.fragment.MustEatFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.viewpager)
    ViewPager mViewPager;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    @BindView(R.id.header)
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        mTabLayout.setTabRippleColor(null);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.new_delhi);
        }

        Glide.with(this)
                .asBitmap()
                .load(getResources().getStringArray(R.array.destination_image_urls)[6])
                .listener(new RequestListener<Bitmap>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
                        setPalette(resource);
                        return false;
                    }
                })
                .into(mImageView);

        setUpViewpager(mViewPager);

        mTabLayout.setupWithViewPager(mViewPager);

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case 0:
                // TODO: 10-11-2018
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setUpViewpager(ViewPager viewPager) {
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new DestinationFragment(), getString(R.string.destination));
        pagerAdapter.addFragment(new MustEatFragment(), getString(R.string.must_eat));
        viewPager.setAdapter(pagerAdapter);
    }

    private void setPalette(Bitmap bitmap) {
        try {
            Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                @Override
                public void onGenerated(@Nullable Palette palette) {
                    if (palette != null) {
                        int vibrantColor = palette.getVibrantColor(getResources().getColor(R.color.colorPrimary));
                        int vibrantDarkColor = palette.getDarkVibrantColor(getResources().getColor(R.color.colorPrimaryDark));
                        mCollapsingToolbarLayout.setContentScrimColor(vibrantColor);
                        mCollapsingToolbarLayout.setStatusBarScrimColor(vibrantDarkColor);
                    }
                }
            });
        } catch (Exception e) {
            Log.e(TAG, "onCreate: failed to create bitmap from background", e.fillInStackTrace());
            mCollapsingToolbarLayout.setContentScrimColor(getResources().getColor(R.color.colorPrimary));
            mCollapsingToolbarLayout.setStatusBarScrimColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }
}