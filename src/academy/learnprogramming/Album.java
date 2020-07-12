package academy.learnprogramming;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    ArrayList<Song> album = new ArrayList<Song>();

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.album = new ArrayList<Song>();
    }

    public String getName() {
        return name;
    }
    public String getArtist() {
        return artist;
    }

    //Add Song to arraylist of Album
    public boolean addSongToAlbum(String title, double duration){
        if(checkExist(title) == null){
            album.add(new Song(title,duration));
            return true;
        }
        else{
            System.out.println("You already have the song you added");
            return false;
        }

    }

    //Check the song is already exist or not, If exist -> it wont add the song, If doesnt exist -> add the song to the album
    public Song checkExist(String title){
        for(Song exist: album){
            if(exist.getTitle().equals(title)){
                return exist;
            }
        }
        return null;
    }

    //Add song to playlist by using the title of the song
    public boolean addSongToPlaylist(String title, LinkedList<Song> playlist){
        Song existSong = checkExist(title);
        if(existSong != null){
            playlist.add(existSong);
            return true;
        }
        else{
            System.out.println("You dont have the song like this in your existing album");
            return false;
        }
    }

    //Add song to playlist by using song index
    public boolean addSongToPlaylist(int songNumber, LinkedList<Song> playlist){
        int index = songNumber-1;
        if((index>=0) && (index<=album.size())){
            playlist.add(album.get(index));
            return true;
        }
        System.out.println("You dont have a song with that index");
        return false;
    }
}
