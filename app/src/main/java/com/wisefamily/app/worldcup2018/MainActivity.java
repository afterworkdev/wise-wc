package com.wisefamily.app.worldcup2018;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.wisefamily.app.worldcup2018.fragment.GroupFragment;
import com.wisefamily.app.worldcup2018.fragment.ScheduleFragment;
import com.wisefamily.app.worldcup2018.fragment.TodayFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_frame)
    FrameLayout mainFrame;

    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    showFragments(todayFragment);
                    return true;
                case R.id.navigation_groups:
                    showFragments(groupFragment);
                    return true;
                case R.id.navigation_matches:
                    showFragments(scheduleFragment);
                    return true;
                case R.id.navigation_knockout:
                    return true;
                case R.id.navigation_grade:
                    return true;
            }
            return false;
        }
    };

    private TodayFragment todayFragment;
    private GroupFragment groupFragment;
    private ScheduleFragment scheduleFragment;

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        initFragments();
        showFragments(todayFragment);
    }

    private void initFragments() {
        fragmentManager = getSupportFragmentManager();

        todayFragment = new TodayFragment();
        groupFragment = new GroupFragment();
        scheduleFragment = new ScheduleFragment();
    }

    private void showFragments(Fragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }




}
