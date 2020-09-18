package com.jkdevelopment.introonboarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabIndicator;
    int postion = 0;
    Button nextBtn;
    ViewPager viewPager;
    int bacground[] = {R.drawable.screen1_bac, R.drawable.screen2_bac, R.drawable.screen3_bac};
    int girlimage[] = {R.drawable.girl1, R.drawable.girl2, R.drawable.girl3};
    String heading[] = {"Heading 1", "Heading 2", "heading 3"};
    String description[] = {
            "ontaining Lorem Ipsum passages, and more recently with desktop publishing",
            " versions have evolved over the years, sometimes by accident",
            "Ipsum which looks reasonable. The generated Lorem Ipsum is"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabIndicator = findViewById(R.id.tabIndicator);
        viewPager = findViewById(R.id.viewPager);
        Adapter adapter = new Adapter(MainActivity.this, bacground, girlimage, heading, description);
        viewPager.setAdapter(adapter);
        tabIndicator.setupWithViewPager(viewPager);

        nextBtn = findViewById(R.id.nextBtn);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                postion = viewPager.getCurrentItem();
                if (postion < bacground.length) {
                    postion++;
                    viewPager.setCurrentItem(postion);
                }
                if (postion == 3) {
                    intentTomainScreen();
                }
                if(postion==bacground.length-1)
                {
                    nextBtn.setText("Start");
                }


            }



            private void intentTomainScreen() {

                Intent MainIntent = new Intent(MainActivity.this, HomePage.class);
                startActivity(MainIntent);
                finish();
            }
        });

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(position==2)
                {
                    nextBtn.setText("Start");
                }
                else
                {
                    nextBtn.setText("Next");
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }



}