package academy.learnprogramming;

import java.util.ArrayList;
import java.util.LinkedList;


public class Main {

        //This code is for showing the workflow of OOP (Inheritance, Polymorphism, Encapsulation, etc.)
        //This syntax basically about 2 features of smartphone, which is ACCESSING CONTACT and PLAYING MUSIC
        //For ACCESSING CONTACT, you will shown the base flow or system in accessing phone contact
        //The contact consist of name and contact number that stored in an ArrayList
        //For PLAYING MUSIC, you have some song that contains of title and duration, the song can be stored in the album, and if the song already stored in an album...
        //it also can be stored in a playlist, that consist of several album as well for the songs.


    public static void main(String[] args) {

        //----------------------ACCESSING SONG----------------------------//
        AccessContact contactMajid = new AccessContact("Majid's Contact");
        //accessContact(contactMajid);

        //----------------------ACCESSING MUSIC PLAYER----------------------------//
        //song();

    }

    //METHOD FOR ACCESSING SONG --> ADD SONG TO ALBUM & ADD SONG TO PLAYLIST FIRST
    public static void song(){
        ArrayList<Album> thisAlbum = new ArrayList<Album>();

        Album myAlbum = new Album("fly on the wall","acdc");
        myAlbum.addSongToAlbum("first blood",5.4);
        myAlbum.addSongToAlbum("danger",3.4);
        myAlbum.addSongToAlbum("sink the pink",4.4);
        myAlbum.addSongToAlbum("stand up",5.1);
        thisAlbum.add(myAlbum);


        myAlbum = new Album("sounding the sevent trumpet songs", "avenged sevenfold");
        myAlbum.addSongToAlbum("darkness surrounding",4.3);
        myAlbum.addSongToAlbum("lips of deceit",6.1);
        myAlbum.addSongToAlbum("thick and thin",2.5);
        myAlbum.addSongToAlbum("streets",5.5);
        myAlbum.addSongToAlbum("forgotten faces",4.3);
        thisAlbum.add(myAlbum);

        Playlist play = new Playlist();
        LinkedList<Song> playlist = new LinkedList<Song>();

        thisAlbum.get(0).addSongToPlaylist("first blood",playlist);
        thisAlbum.get(0).addSongToPlaylist("sink the pink",playlist);
        thisAlbum.get(1).addSongToPlaylist("lips of deceit",playlist);
        thisAlbum.get(1).addSongToPlaylist("streets",playlist);
        thisAlbum.get(1).addSongToPlaylist("stand up",playlist);
        thisAlbum.get(0).addSongToPlaylist("danger",playlist);
        thisAlbum.get(1).addSongToPlaylist("forgotten faces",playlist);
        thisAlbum.get(1).addSongToPlaylist("thick and thin",playlist);

        play.play(playlist);
    }

    //METHOD FOR ACCESSING CONTACT
    public static void accessContact (AccessContact contact){
        contact.contacting(contact);
    }
}
