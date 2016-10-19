package com.example.indra.actionbartabswithviewpager;



import java.lang.reflect.Method;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.example.actionbartabswithviewpager.R;

@SuppressLint("NewApi")
public class MainActivity extends FragmentActivity implements ActionBar.TabListener {

    ViewPager viewpager = null;
    ActionBar actionBar = null;
    String TAG = "MainActivity";
    private static final String TAG_TASK_FRAGMENT = "current_page";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("TAG", "getConfiguration onCreate --11111111111-" + savedInstanceState);
        setContentView(R.layout.activity_main);

        viewpager = (ViewPager)findViewById(R.id.pager);

        actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        actionBar.addTab(actionBar.newTab().setText("APPS").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("GAMES").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("MOVIES").setTabListener(this));


        Log.i("TAG", "onCreate ---");
//		tabsFixedOrientationChange();


        FragmentManager fm = getSupportFragmentManager();

        MyFriendsListFragment mTaskFragment = (MyFriendsListFragment) fm.findFragmentByTag(TAG_TASK_FRAGMENT);

        if (mTaskFragment == null) {

            mTaskFragment = new MyFriendsListFragment();
           fm.beginTransaction().add(mTaskFragment, TAG_TASK_FRAGMENT).commit();
    }

        /** Defining a listener for pageChange */
        ViewPager.SimpleOnPageChangeListener pageChangeListener = new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                Log.i("TAG", "Position ---" + position);
                actionBar.setSelectedNavigationItem(position);
            }
        };

        /** Setting the pageChange listner to the viewPager */
        viewpager.setOnPageChangeListener(pageChangeListener);
        /** Creating an instance of FragmentPagerAdapter */
        MyFragmentPagerAdapter fragmentPagerAdapter = new MyFragmentPagerAdapter(fm);
        viewpager.setAdapter(fragmentPagerAdapter);
        actionBar.setDisplayShowTitleEnabled(true);
        Log.i("FragmentActiivty", "TAb selected ---" + getActionBar().getSelectedNavigationIndex());
    }
    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
        // TODO Auto-generated method stub

    }
    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        // TODO Auto-generated method stub
        Log.i(TAG, "onTabSelected() -------------");
        viewpager.setCurrentItem(tab.getPosition());

    }
    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        // TODO Auto-generated method stub
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            tabsFixedOrientationChange();
        }
    }

    private void tabsFixedOrientationChange() {
        try {
            Log.i("TAG", "tabsFixedOrientationChange ---");
            Method setHasEmbeddedTabsMethod;
            // These lines for fixes the tabs below the actionBar in both landscape and portrait orientations
            setHasEmbeddedTabsMethod = actionBar.getClass().getDeclaredMethod("setHasEmbeddedTabs", boolean.class);
            setHasEmbeddedTabsMethod.setAccessible(true);
            setHasEmbeddedTabsMethod.invoke(actionBar, false);

        } catch(Exception e) {
            Log.e("MainActivity", "Exception in tabsFixedOrientationChange ---------- " + e);
        }
    }

}
