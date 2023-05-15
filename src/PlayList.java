import java.util.ArrayList;
import java.util.List;

public class PlayList {

    private String title;

    private List<Song> songs;

    public PlayList(String title) {
        this.title = title;
        this.songs=new ArrayList<>();
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
    public String addSongFromAlbum(Album album,String songName){
     Boolean songExists=album.findSong(songName);
     Song song;
     if(songExists){
         song=album.searchSong(songName);
     }
     }
}
