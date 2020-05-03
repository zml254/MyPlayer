package com.example.myplayer;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class FlameFragment extends Fragment {

    private List<Album> albums;

    @Override
    public void onStart() {
        super.onStart();
    }

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initList();
        View view = inflater.inflate(R.layout.fragment_flame, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment_flame_recommendations);
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {

            @Override

            public int getSpanSize(int position) {
                if (position == 0 || position == 1 || position == 2) {
                    return 2;
                }
                return 1;
            }
        });
        recyclerView.setLayoutManager(manager);
        View head = inflater.inflate(R.layout.item_album_title, recyclerView, false);
        View head1 = inflater.inflate(R.layout.item_album_newest_title, recyclerView, false);
        MyAdapter myAdapter = new MyAdapter(head, head1, albums);
        recyclerView.setAdapter(myAdapter);
        return view;
    }

    public void initList() {
        albums = new ArrayList<Album>();
        for (int a = 0; a < 20; a++) {
            Album album = new Album("1111", R.mipmap.easenet, "2222");
            albums.add(album);
        }
    }
}
