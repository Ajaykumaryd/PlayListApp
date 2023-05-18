import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

public class PlayList {

    private String title;

    private List<Song> songs;

    private boolean wasNext=false;

    private ListIterator<Song> itr;
    public PlayList(String title) {
        this.title = title;
        this.songs = new ArrayList<>();
        itr=songs.listIterator();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Song> getSongs() {
        return songs;
    }

    //    add song from album to PlayList
    public String addSongFromAlbum(Album album,String songName) {

        //Boolean songExists=album.findSong(songName);  //o(N)
//     Song song;
//     if(songExists){
//         song=album.searchSong(songName);  //o(N)
//     }
//     }
        //both information found together //True/False and Song using Optional;
        //    Optional is a new type introduced in Java 8.
//    It is used to represent a value that may or may not be present.
//    In other words, an Optional object can either contain a non-null value (in which case it is considered present)
//    or it can contain no value at all (in which case it is considered empty).
        Optional<Song> songOpt=album.searchSong(songName);
        if(songOpt.isEmpty()) return "Song not found in album"; //song not found
        Song songInAlbum=songOpt.get();  //return a song
        this.songs.add(songInAlbum);
        itr=songs.listIterator(); //updates the list iterator
        return "Song added Successfully";
    }

//    wasNext=true; it means itr is on the next
//    wasNext=false;it means itr is on the previous
     public  String playNext(){
      if(wasNext){ //it means we are one current song

      }

      if(!wasNext){    //itr is on the previous
         wasNext=true;
         itr.next();  //we move the song to current one
      }

      if(itr.hasNext()){
          wasNext=true;
          Song song=itr.next();  //to play the next Song
          return "Next Song is:"+song;
      }
      return "You have reached the end of playList";
     }

    public  String playPrevious(){
        if(!wasNext){ //it means we are one previous

        }

        if(wasNext){    //itr is on the previous
            wasNext=false;
            itr.previous();  //we move the song to current one
        }

        if(itr.hasPrevious()){
            wasNext=false;
            Song song=itr.previous();  //to play the next Song
            return "Prevois Song is:"+song;
        }
        return "You have reached the Start of playList";
    }

    public String playCurrent(){
        if(wasNext){
            wasNext=false;
           return "current song is " +itr.previous();
        }else{
            wasNext=true;
            return "current song is"+ itr.next();
        }
    }
    
}