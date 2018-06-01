package com.wisefamily.app.worldcup2018;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.wisefamily.app.worldcup2018.fragment.GroupFragment;
import com.wisefamily.app.worldcup2018.fragment.ScheduleFragment;
import com.wisefamily.app.worldcup2018.fragment.TodayFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.pager)
    ViewPager viewPager;

    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.navigation_groups:
                    viewPager.setCurrentItem(1);
                    break;
                case R.id.navigation_matches:
                    viewPager.setCurrentItem(2);
                    break;
                case R.id.navigation_knockout:
                    viewPager.setCurrentItem(3);
                    break;
                case R.id.navigation_grade:
                    viewPager.setCurrentItem(4);
                    break;
            }
            return false;
        }
    };

//    private TodayFragment todayFragment;
//    private GroupFragment groupFragment;
//    private ScheduleFragment scheduleFragment;
    private MenuItem prevMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                }
                else {
                    navigation.getMenu().getItem(0).setChecked(false);
                }
                navigation.getMenu().getItem(position).setChecked(true);
                prevMenuItem = navigation.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        setupViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager)
    {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

//        todayFragment = new TodayFragment();
//        groupFragment = new GroupFragment();
//        scheduleFragment = new ScheduleFragment();
//        adapter.addFragment(todayFragment);
//        adapter.addFragment(groupFragment);
//        adapter.addFragment(scheduleFragment);

        adapter.addFragment(new TodayFragment());
        adapter.addFragment(new GroupFragment());
        adapter.addFragment(new ScheduleFragment());
        adapter.addFragment(new TodayFragment());
        adapter.addFragment(new ScheduleFragment());
        viewPager.setAdapter(adapter);
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment) {
            mFragmentList.add(fragment);
        }

    }

}
