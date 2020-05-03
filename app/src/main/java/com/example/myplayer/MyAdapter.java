package com.example.myplayer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Album> albums;
    private View header, header1;

    public static final int VIEW_TYPE_ONE = 1;
    public static final int VIEW_TYPE_TWO = 2;
    public static final int VIEW_TYPE_THREE = 3;

    private static int count = 0;


    public MyAdapter(View header, View header1, List<Album> albums) {
        this.header1 = header1;
        this.header = header;
        this.albums = albums;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView albumName;
        private ImageView albumImage;
        private TextView writerName;
        private TextView seeAll = null;
        private TextView title = null;

        public ViewHolder(View view) {
            super(view);
            albumName = (TextView) view.findViewById(R.id.item_album_name_album);
            albumImage = (ImageView) view.findViewById(R.id.item_album_image_album);
            writerName = (TextView) view.findViewById(R.id.item_album_name_writer);
        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
            case VIEW_TYPE_ONE:
                if (count == 0) {
                    count++;
                    return new ViewHolder(header1);
                }
                if (count == 1) {
                    return new ViewHolder(header);
                }
            case VIEW_TYPE_TWO:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_album,
                        parent, false);
                break;
            case VIEW_TYPE_THREE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_album_newest,
                        parent, false);
                break;
        }
        if (view != null) {
            return new ViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (position == 0 || position == 1 || position == 2) {
            return;
        }
        Album album = albums.get(position - 3);
        holder.writerName.setText(album.writerName);
        holder.albumName.setText(album.albumName);
        holder.albumImage.setImageResource(album.albumImage);
        if (holder.seeAll != null && count == 0) {
            holder.seeAll.setVisibility(View.GONE);
            holder.title.setText("News Albums");
            count++;
        }
    }

    @Override
    public int getItemCount() {
        return albums.size() + 3;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0 || position == 2) {
            return 1;
        }
        if (position == 1) {
            return 3;
        }
        return albums.get(position - 3).getType();
    }
}
