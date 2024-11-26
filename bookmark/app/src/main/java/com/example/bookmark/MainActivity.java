package com.example.bookmark;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.bookmark.fragment.BookMarkFragment;
import com.example.bookmark.fragment.ViewPageAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bnv;
    private ViewPager2 vp;
    private BookMarkAdapter adapter;
    BookMarkFragment bookmarkFragment=new BookMarkFragment();


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
//        RecyclerView recyclerView = findViewById(R.id.recycleview);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        List<Product> productList = new ArrayList<>();
//        productList.add(new Product("Gà quay", 10000, R.raw.gaquay ));
//        productList.add(new Product("Gà luộc", 10000, R.raw.gaquay ));
//        BookMarkAdapter adapter = new BookMarkAdapter(this, productList);
//        recyclerView.setAdapter(adapter);
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
                        //bnv.getMenu().findItem(R.id.menu_home).setCheckable(true);
                        bnv.getMenu().getItem(position).setChecked(true);
                        break;
                    case 1:
                        //bnv.getMenu().findItem(R.id.menu_bookmark).setCheckable(true);
                        bnv.getMenu().getItem(position).setChecked(true);
                        break;
                    case 2:
                        //bnv.getMenu().findItem(R.id.menu_user).setCheckable(true);
                        bnv.getMenu().getItem(position).setChecked(true);
                        break;
                    case 3:
                        //bnv.getMenu().findItem(R.id.menu_user).setCheckable(true);
                        bnv.getMenu().getItem(position).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });




        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.menu_home) {
                    vp.setCurrentItem(0);
                    Toast.makeText(MainActivity.this, "home", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (item.getItemId() == R.id.menu_cup) {
                    vp.setCurrentItem(1);
                    Toast.makeText(MainActivity.this, "leaderboard", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (item.getItemId() == R.id.menu_bookmark) {
                    vp.setCurrentItem(2);
                    Toast.makeText(MainActivity.this, "bookmark", Toast.LENGTH_SHORT).show();
                    return true;
                }
                else if (item.getItemId() == R.id.menu_user) {
                    vp.setCurrentItem(3);
                    Toast.makeText(MainActivity.this, "user", Toast.LENGTH_SHORT).show();
                    return true;
                } else {
                    return false;
                }
            }
        });


    }
}