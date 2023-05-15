import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Album {
    private String title;

    private List<Song> songs;
    private String artist;

    public Album(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.songs=new ArrayList<>();
    }

    public Album(String title, List<Song> songs, String artist) {
        this.title = title;
        this.songs = songs;
        this.artist = artist;
    }

    public boolean findSong(Song songFind){
        for(Song song:songs){
            if(song.getName().equals(songFind.getName())&& song.getArtist().equals(songFind.getArtist())) return true;
        }
        return false;
    }

    public boolean findSong(String SongName){
        for(Song song:songs){
            if(song.getName().equals(SongName)) return true;
        }
        return false;
    }

    public String addSong(Song song){
       if(this.findSong(song)){
           return "Song already exists";
       }else{
           songs.add(song);
           return "Song Added";
       }
    }

//    Optional is a new type introduced in Java 8.
//    It is used to represent a value that may or may not be present.
//    In other words, an Optional object can either contain a non-null value (in which case it is considered present)
//    or it can contain no value at all (in which case it is considered empty).
    public Optional<Song> searchSong(String songName) {
       for(Song song:songs){
           if(song.getName().equals(songName)) return Optional.of(song);
       }
       return Optional.empty(); //song not found
    }
}
