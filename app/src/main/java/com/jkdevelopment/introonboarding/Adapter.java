package com.jkdevelopment.introonboarding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

public class Adapter extends PagerAdapter {

    MainActivity mainActivity;
    int[] bacground;
    int[] girlimage;
    String[] heading;
    String[] description;

    public Adapter(MainActivity mainActivity, int[] bacground, int[] girlimage, String[] heading, String[] description) {
        this.bacground = bacground;
        this.mainActivity = mainActivity;
        this.girlimage = girlimage;
        this.heading = heading;
        this.description = description;
    }

    @Override
    public int getCount() {
        return bacground.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = LayoutInflater.from(mainActivity).inflate(R.layout.item_pager_raw, container, false);

        ImageView girlimageView;
        ConstraintLayout bacgroundConstrainlayout;
        TextView headings;
        TextView descriptions;

        girlimageView = view.findViewById(R.id.pager_girlpng);
        bacgroundConstrainlayout = view.findViewById(R.id.pager_mainlayout);
        headings = view.findViewById(R.id.pager_heading);
        descriptions = view.findViewById(R.id.pager_description);

        girlimageView.setBackgroundResource(girlimage[position]);
        bacgroundConstrainlayout.setBackgroundResource(bacground[position]);
        headings.setText(heading[position]);
        descriptions.setText(description[position]);


        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View) object);

    }
}
