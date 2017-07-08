package com.example.arsalankhan.swiptodelete;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arsalan khan on 7/8/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ItemTouchListener{

    private static int FOOTER=1;
    private static int ITEM=0;
    private Context context;
    private List<String> arraylist;
    public MyAdapter(Context context, ArrayList<String> arrayList) {

        this.arraylist=arrayList;
        this.context=context;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if(arraylist==null || position < arraylist.size()){
            return ITEM;
        }else{
            return FOOTER;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

       if(viewType==FOOTER){
           LayoutInflater inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
           View view=inflater.inflate(R.layout.add_button,parent,false);
           return new FooterHolder(view);
       }
        else {
           LayoutInflater inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
           View view=inflater.inflate(R.layout.single_row,parent,false);
           return new MyviewHolder(view);
       }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof MyviewHolder){
            MyviewHolder holder1= (MyviewHolder) holder;

            holder1.textView.setText(arraylist.get(position));
        }
    }

    @Override
    public int getItemCount() {

        if(arraylist.isEmpty() || arraylist==null ){
            return 0;
        }else{
            return arraylist.size()+1;
        }


    }

    @Override
    public void swipe(int position) {
        arraylist.remove(position);
        notifyItemRemoved(position);
    }
}


class MyviewHolder extends RecyclerView.ViewHolder{

    TextView textView;
    public MyviewHolder(View itemView) {
        super(itemView);

        textView= (TextView) itemView.findViewById(R.id.tv_display);
    }
}

class FooterHolder extends RecyclerView.ViewHolder{

    Button button;
    public FooterHolder(View itemView) {
        super(itemView);
        button= (Button) itemView.findViewById(R.id.add_btn);
    }
}
