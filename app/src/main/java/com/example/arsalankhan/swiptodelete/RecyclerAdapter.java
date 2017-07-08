package com.example.arsalankhan.swiptodelete;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Arsalan khan on 7/8/2017.
 */

public class RecyclerAdapter extends RecyclerView {

    private List<View> NonEmptylist= Collections.emptyList();
    private List<View> Emptylist= Collections.emptyList();
    private AdapterDataObserver observer=new AdapterDataObserver() {
        @Override
        public void onChanged() {
            super.onChanged();
            toggleView();
        }

        @Override
        public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
            super.onItemRangeMoved(fromPosition, toPosition, itemCount);
            toggleView();
        }

        @Override
        public void onItemRangeInserted(int positionStart, int itemCount) {
            super.onItemRangeInserted(positionStart, itemCount);
            toggleView();
        }

        @Override
        public void onItemRangeRemoved(int positionStart, int itemCount) {
            super.onItemRangeRemoved(positionStart, itemCount);
            toggleView();
        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount, Object payload) {
            super.onItemRangeChanged(positionStart, itemCount, payload);
            toggleView();
        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount) {
            super.onItemRangeChanged(positionStart, itemCount);
            toggleView();
        }
    };


    public RecyclerAdapter(Context context) {
        super(context);
    }

    public RecyclerAdapter(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RecyclerAdapter(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    @Override
    public void setAdapter(Adapter adapter) {
        super.setAdapter(adapter);

        if(adapter!=null){
            adapter.registerAdapterDataObserver(observer);
        }
        observer.onChanged();
    }

        public void hideView(View ...hideView) {

            NonEmptylist= Arrays.asList(hideView);
    }

    public void showView(View ...empty_view) {
        Emptylist=Arrays.asList(empty_view);
    }

    private void toggleView() {

        if(getAdapter()!=null && !NonEmptylist.isEmpty() && !Emptylist.isEmpty()){

            if(getAdapter().getItemCount()==0){

                Util.hideView(NonEmptylist);

                setVisibility(View.GONE);

                Util.showView(Emptylist);

            }else{

                Util.showView(NonEmptylist);

                setVisibility(View.VISIBLE);

                Util.hideView(Emptylist);
            }
        }
    }

}
