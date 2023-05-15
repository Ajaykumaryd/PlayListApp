import java.util.ArrayList;
import java.util.List;

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

    public boolean findSong(Song songTofind){
        for(Song song:songs){
            if(song.getName().equals(songTofind.getName())&& song.getArtist().equals(songTofind.getArtist())) return true;
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
}
