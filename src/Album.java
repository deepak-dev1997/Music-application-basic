import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private List<Song> songs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs=new ArrayList<>();


    }
    boolean findSong(String s){
        for(Song a : songs){
            if(a.getTitle().equals(s)){

                return true;
            }
        }
        return false;
    }
    void addSonginAlbum(String title, double duration){

        Song s=new Song(title, duration);
        if(findSong(s.getTitle())==true){
            System.out.println("Song already exist in album");
        }
        else{
            songs.add(s);
            System.out.println("Song added to album");
        }


    }


    public void addtoplayList(String title , LinkedList<Song> l){
        for(Song s : songs){
            if(title.equals(s.getTitle())){
                l.add(s);
                System.out.println("Song has been added to your playList");
                return;
            }
        }
        System.out.println("Song does not exists in album");
    }
    public void addtoplayList(int track_no, LinkedList<Song> l){
        track_no=track_no-1;
        if(track_no<0 || track_no>= songs.size()){
            System.out.println("Track No entered by you is invalid");
        }
        else {
            l.add(songs.get(track_no));
            System.out.println("song has been added to your playlist");
        }
    }
}
