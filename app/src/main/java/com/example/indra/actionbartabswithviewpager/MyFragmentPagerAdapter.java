package com.example.indra.actionbartabswithviewpager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

    public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        final int PAGE_COUNT = 3;
        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        /** This method will be invoked when a page is requested to create */
        @Override
        public Fragment getItem(int position) {
            Log.i("MyFragmentPagerAdapter" , "position --------" + position);
            Bundle data = new Bundle();

            switch(position) {

                /** Android tab is selected */
                case 0:

                    MyFriendsListFragment myfriends1 = new MyFriendsListFragment();
                    data.putInt("current_page", position);
                    myfriends1.setArguments(data);
                    return myfriends1;
//		    createFragment(position);

                case 1:
                    MyFriendsListFragment myfriends2 = new MyFriendsListFragment();
                    data.putInt("current_page", position);
                    myfriends2.setArguments(data);
                    return myfriends2;
//		   createFragment(position);

                case 2:
                    MyFriendsListFragment myfriends3 = new MyFriendsListFragment();
                    data.putInt("current_page", position);
                    myfriends3.setArguments(data);
                    return myfriends3;
//		   createFragment(position);
            }

            return null;

        }

	 /*public void createFragment(int position) {
		 try {
			 	MyFriendsListFragment myfriends = new MyFriendsListFragment();
			 	Bundle data = new Bundle();
			    data.putInt("current_page", position + 1);
			    myfriends.setArguments(data);

		 } catch(Exception e) {
			e.printStackTrace();
		 }
	 }*/

        /** Returns the number of pages */
        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

    }
