package com.example.studirep;

public class Workout {
    private  String title;
    private String wod;
    private String video;

    public Workout(String title, String wod, String video) {
        this.title = title;
        this.wod = wod;
        this.video = video;
    }

    public Workout() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWod() {
        return wod;
    }

    public void setWod(String wod) {
        this.wod = wod;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}

