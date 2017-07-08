package com.example.arsalankhan.swiptodelete;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by Arsalan khan on 7/8/2017.
 */

public class SimpleTouchCallback extends ItemTouchHelper.Callback{

    private  ItemTouchListener itemTouchListener;
    SimpleTouchCallback(ItemTouchListener listener){
      itemTouchListener=listener;
    }
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {


        return makeMovementFlags(0,ItemTouchHelper.END);
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return false;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

        itemTouchListener.swipe(viewHolder.getLayoutPosition());
    }
}
