package com.example.demo.test.aop.demo1;

/**
 * Created by louyuting on 17/1/20.
 * 使用AOP
 */
public class Singer {

    private Song song=null;

    public Singer() {
    }

    public Singer(Song song) {
        this.song = song;
    }

    public void singSong(){
        System.out.println(song.toString());
    }

}
