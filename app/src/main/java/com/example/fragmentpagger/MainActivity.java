package com.example.fragmentpagger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    PaggerFragment paggerFragment;
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    private boolean swipeEnabled = true;
    private int currentPosition = 0;

    private String[] titles = new String[] {"Home" , "Farmer"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        getSupportActionBar().hide();
        viewPager2 =findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);

//        tabLayout.addTab(tabLayout.newTab().setText("Home"));
//        tabLayout.addTab(tabLayout.newTab().setText("Farmer"));

        paggerFragment = new PaggerFragment(this);
        viewPager2.setAdapter(paggerFragment);
        tabLayout.setOnTabSelectedListener(null);

//        tabLayout.getTabAt(2).setText("Farmer");

//        new TabLayoutMediator(tabLayout,viewPager2,((tab, position) -> tab.setText(titles[position]))).attach();
        new TabLayoutMediator(tabLayout,viewPager2,((tab, position) -> tab.view.setClickable(false))).attach();
//        tabLayout.setClickable(false);

        /*new TabLayoutMediator(tabLayout, viewPager2,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(TabLayout.Tab tab, int position) {
                        tab.setText(titles[position]);
                        // Disable tab clicks
                        tab.view.setClickable(false);
                    }
                }).attach();*/

        // Set custom view for each tab and display tab names
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(R.layout.tab_item);
                TextView tabTitle = tab.getCustomView().findViewById(R.id.tabTitle);
                tabTitle.setText(getTabTitle(i));
            }
        }






        swipeEnabled = !swipeEnabled;
        viewPager2.setUserInputEnabled(swipeEnabled);


    }

    private String getTabTitle(int position) {
        switch (position) {
            case 0:
                return "Tab 1";
            case 1:
                return "Tab 2";
            case 2:
                return "Tab 3";
            default:
                return "";
        }
    }
    public void goLastTab(View view) {
        /*int currentTab = viewPager2.getCurrentItem();
        int nextTab = currentTab -1;
        if (nextTab >= viewPager2.getAdapter().getItemCount()){
            nextTab = 0;
        }
        viewPager2.setCurrentItem(nextTab);*/

        currentPosition--;
        if (currentPosition >= 0) {
            viewPager2.setCurrentItem(currentPosition);
        } else {
            currentPosition = 0;
        }

    }

    public void goNextTab(View view) {
        /*int currentTab = viewPager2.getCurrentItem();
        int nextTab = currentTab +1;
        if (nextTab >= viewPager2.getAdapter().getItemCount()){
            nextTab = 0;
        }
        viewPager2.setCurrentItem(nextTab);*/

        currentPosition++;
        if (currentPosition < paggerFragment.getItemCount()) {
            viewPager2.setCurrentItem(currentPosition);
        } else {
            currentPosition = paggerFragment.getItemCount() - 1;
        }
    }



}