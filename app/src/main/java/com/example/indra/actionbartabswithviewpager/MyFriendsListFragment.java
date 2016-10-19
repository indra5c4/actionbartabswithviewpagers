package com.example.indra.actionbartabswithviewpager;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

    public class MyFriendsListFragment extends ListFragment {

        /** An array of items to display in ArrayList */
        String myfriends_list[] = new String[]{
                "Indra"
        };

        @Override
        public void onCreate(Bundle savedInstanceState) {
            // TODO Auto-generated method stub
            super.onCreate(savedInstanceState);
//	    	setRetainInstance(true);
        }

        @SuppressLint("NewApi")
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
            /** Creating array adapter to set data in listview */

            String[] strArr = new String[5];
            int pos = 0;
            for(String data : myfriends_list) {
                strArr[pos] = data + "_" +  getArguments().getInt("current_page");
                pos ++;
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, strArr);

            setListAdapter(adapter);

            return super.onCreateView(inflater, container, savedInstanceState);

        }

        @Override
        public void onStart() {
            super.onStart();
            /** Setting the multiselect choice mode for the listview */

        }
    }
