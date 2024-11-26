package com.example.bookmark.fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPageAdapter extends FragmentStateAdapter {
    public ViewPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new BookMarkFragment();
            case 1:
                return new BookMarkFragment();
            case 2:
                return new BookMarkFragment();
            case 3:
                return new UserFragment();

            default:
                return new BookMarkFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
