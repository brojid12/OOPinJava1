package academy.learnprogramming;

public class Song { //create song class as a "Song"
    private String title;
    private double duration;

    public Song(String title, double duration){
        this.title = title;
        this.duration = duration;
    }

    public String getTitle(){
        return title;
    }
    public double getDuration(){
        return duration;
    }

    @Override
    public String toString() { //to easily make or print whole needed word
        return title + " - with duration of - " + duration;
    }
}
