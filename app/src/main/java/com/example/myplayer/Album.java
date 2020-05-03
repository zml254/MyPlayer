package com.example.myplayer;

public class Album {
    String albumName;
    int albumImage;
    String writerName;

    public Album(String albumName, int albumImage, String writerName) {
        this.albumName = albumName;
        this.albumImage = albumImage;
        this.writerName = writerName;
    }

    public int getType() {
        return 2;
    }

}
