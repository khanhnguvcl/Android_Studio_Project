package com.example.tablayout_menuapp.tabfragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class TabViewPageAdapter extends FragmentStateAdapter {

    public TabViewPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position){
            case 0:
                return new tab1_fragment();
            case 1:
                return new tab2_fragment();
            case 2:
                return new tab3_fragment();
            default:
                return new tab1_fragment();
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }


    public String getTabTitle(int position) {
        switch (position){
            case 0:
                return "Họ và tên";

            case 1:
                return "Địa chỉ";
            case 2:
                return "Sở thích";
            default: return "Họ và tên";
        }
    }
}
