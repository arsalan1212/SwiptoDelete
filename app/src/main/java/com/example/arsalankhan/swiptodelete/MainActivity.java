package com.example.arsalankhan.swiptodelete;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerAdapter recyclerView;
    private ArrayList<String> arrayList=new ArrayList<>();
    private View empty_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        empty_view=findViewById(R.id.emptyview);

        recyclerView= (RecyclerAdapter) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        fillArraylist();

        MyAdapter adapter=new MyAdapter(this,arrayList);
        recyclerView.setAdapter(adapter);

        recyclerView.hideView(toolbar);
        recyclerView.showView(empty_view);
        SimpleTouchCallback callback=new SimpleTouchCallback(adapter);
        ItemTouchHelper helper=new ItemTouchHelper(callback);
        helper.attachToRecyclerView(recyclerView);
    }

    private void fillArraylist() {
        for(int i=0;i<10;i++){
            arrayList.add("Item "+i);
        }
    }
}
