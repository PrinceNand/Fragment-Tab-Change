package com.example.fragmentpagger;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PaggerFragment extends FragmentStateAdapter {

    private String[] titles = new String[] {"Home" , "Farmer"};
    public PaggerFragment(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new FarmerFragment();
        }

        return new HomeFragment();
    }



    @Override
    public int getItemCount() {
        return titles.length;
    }
}
