package com.example.tablayout_menuapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.example.tablayout_menuapp.fragment.BookmarkFragment;
import com.example.tablayout_menuapp.fragment.HomeFragment;
import com.example.tablayout_menuapp.fragment.UserFragment;
import com.example.tablayout_menuapp.fragment.ViewPageAdapter;
import com.example.tablayout_menuapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.example.tablayout_menuapp.R;

public class MainActivity extends AppCompatActivity {
private ViewPager2 vp;
private BottomNavigationView bnv;

HomeFragment homeFragment=new HomeFragment();
BookmarkFragment bookmarkFragment=new BookmarkFragment();
UserFragment userFragment=new UserFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        vp=findViewById(R.id.view_page);
        bnv=findViewById(R.id.menu_bar);
        ViewPageAdapter vpa = new ViewPageAdapter(this);
        vp.setAdapter(vpa);
        vp.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch(position){
                    case 0:
                        bnv.getMenu().findItem(R.id.menu_home).setCheckable(true);
                        break;
                    case 1:
                        bnv.getMenu().findItem(R.id.menu_bookmark).setCheckable(true);
                        break;
                    case 2:
                        bnv.getMenu().findItem(R.id.menu_user).setCheckable(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });

//        getSupportFragmentManager().beginTransaction().replace(R.id.view_page, homeFragment).commit();

        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.menu_home) {
                    vp.setCurrentItem(0);
                    return true;
                } else if (item.getItemId() == R.id.menu_bookmark) {
                    vp.setCurrentItem(1);
                    return true;
                } else if (item.getItemId() == R.id.menu_user) {
                    vp.setCurrentItem(2);
                    return true;
                }
                return false;
            }
        });

    }
}