import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlayList {

    private String title;

    private List<Song> songs;

    public PlayList(String title) {
        this.title = title;
        this.songs = new ArrayList<>();
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

        //     Boolean songExists=album.findSong(songName);  //o(N)
//     Song song;
//     if(songExists){
//         song=album.searchSong(songName);  //o(N)
//     }
//     }
        //both information found together //True/False and Song using Optional;
        Optional<Song> songOpt=album.searchSong(songName);
        if(songOpt.isEmpty()) return "Song not found in album"; //song not found
        Song songInAlbum=songOpt.get();  //return a song
        this.songs.add(songInAlbum);
        return "Song added Successfully";
    }






}