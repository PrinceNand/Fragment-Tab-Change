package com.example.fragmentpagger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    PaggerFragment paggerFragment;
    TabLayout tabLayout;
    ViewPager2 viewPager2;

    private String[] titles = new String[] {"Home" , "Farmer"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        getSupportActionBar().hide();
        viewPager2 =findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);

        paggerFragment = new PaggerFragment(this);
        viewPager2.setAdapter(paggerFragment);

        new TabLayoutMediator(tabLayout,viewPager2,((tab, position) -> tab.setText(titles[position]))).attach();
        
    }

    public void goLastTab(View view) {
        int currentTab = viewPager2.getCurrentItem();
        int nextTab = currentTab -1;
        if (nextTab >= viewPager2.getAdapter().getItemCount()){
            nextTab = 0;
        }
        viewPager2.setCurrentItem(nextTab);

    }

    public void goNextTab(View view) {
        int currentTab = viewPager2.getCurrentItem();
        int nextTab = currentTab +1;
        if (nextTab >= viewPager2.getAdapter().getItemCount()){
            nextTab = 0;
        }
        viewPager2.setCurrentItem(nextTab);
    }
}