package com.example.arsalankhan.swiptodelete;

import android.view.View;

import java.util.List;

/**
 * Created by Arsalan khan on 7/8/2017.
 */

public class Util {

    public static void hideView(List<View> view){

        for(View hideView: view){
            hideView.setVisibility(View.GONE);
        }
    }


    public static void showView(List<View> view){

        for(View View : view ){

            View.setVisibility(View.VISIBLE);
        }
    }
}
