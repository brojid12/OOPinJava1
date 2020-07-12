package academy.learnprogramming;

import java.lang.reflect.Array;
import java.util.*;

public class Playlist {
    //Play (Next, Previous, Replay, Shuffle Mode, Remove, Show list of playlist,  show album name, quit)
    //Show option
    LinkedList <Song> playlist;

    public Playlist() {
        this.playlist = new LinkedList<Song>();
    }

    public void showOption(){
        System.out.println("1. Next Song\n"+
                "2. Previous Song\n"+
                "3. Replay this current song\n"+
                "4. Shuffle playing\n"+
                "5. Remove song\n"+
                "6. Show songs of the playlist\n" +
                "7. Show option\n" +
                "8. Quit");
    }

    public void play(LinkedList<Song> titlePlaylist){
        Scanner scanner = new Scanner(System.in);
        ListIterator<Song> listIterator = titlePlaylist.listIterator();
        if(titlePlaylist.size() == 0){
            System.out.println("You haven't got any playlist yet");
        }else{
            System.out.println("You are currently playing - " + listIterator.next().toString());
        }



        boolean forward = true; //as a parameter for LinkedList
        boolean quit = false; //parameter for looping

        while(!quit){
            System.out.println("So what you want to do next? ");
            showOption();
            int option = scanner.nextInt();
            scanner.nextLine();
            switch(option){
                case 1: //Next Song
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("You just change to the next song - " + listIterator.next());
                    }
                    else{
                        System.out.println("You just at the end of the playlist");
                        forward = false;
                    }
                    break;

                case 2: //Previous Song
                    if(forward){ //move to the previous
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }

                    if(listIterator.hasPrevious()){
                        System.out.println("You just change to the previous song - " + listIterator.previous());
                    }
                    else{
                        System.out.println("You just at the start of the playlist");
                        forward = true;
                    }
                    break;

                case 3: //Replay Song
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now replaying - " + listIterator.previous().toString());
                            forward = false;
                        }
                    }
                    else{
                        if(listIterator.hasNext()){
                            System.out.println("Now replaying - " + listIterator.next().toString());
                            forward = true;
                        }
                    }
                    break;

                case 4: //shuffle song
                    if(titlePlaylist.size() > 0){
                        Collections.shuffle(titlePlaylist);
                        System.out.println("You just shuffled the song and currently play - " + listIterator.next().getTitle());
                    }
                    else{
                        System.out.println("You dont have song in current playlist yet");
                    }
                    break;

                case 5: //Remove song
                    if(titlePlaylist.size() >0){
                        listIterator.remove();
                    }
                    if(listIterator.hasNext()){
                        System.out.printf("Now playing " + listIterator.next().toString());
                    }
                    else if (listIterator.hasPrevious()){
                        System.out.println("Now playing previous song " + listIterator.previous().toString());
                    }
                    break;

                case 6: //Show song on your playlist
                    System.out.println("Here is the songs in your current playlist: ");
                    Iterator<Song> iterator = titlePlaylist.iterator();
                    System.out.println("===================");
                    while(iterator.hasNext()){
                        System.out.println(iterator.next());
                    }
                    System.out.println("===================");

                    break;


                case 8: //Show option
                    showOption();
                    break;

                case 9:
                    quit = true;
                    break;
            }
        }

    }

}
