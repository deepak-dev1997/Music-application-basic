import java.util.*;

public class Main {
    public static List<Album> albums=new ArrayList<>();
    public static void main(String[] args) {

        Album album1=new Album("hiphop","honeysingh");
        album1.addSonginAlbum("blue h paani paani ",5.5);
        album1.addSonginAlbum("brown rang",3.3);
        album1.addSonginAlbum("khadke ", 5.6);

        Album album2=new Album("gym motivation", "various");
        album2.addSonginAlbum("mai ladd jaana ",4.5);
        album2.addSonginAlbum("bhaag milkha title track",4.5);
        album2.addSonginAlbum("thukra ke mera pyar",3.6);

        albums.add(album1);
        albums.add(album2);

        System.out.println(album1.findSong("mai ladd jaana"));
        System.out.println(album2.findSong("lalala"));

        LinkedList<Song> playlist=new LinkedList<>();

        album1.addtoplayList("brown rang",playlist);
        album2.addtoplayList(5,playlist);
        album2.addtoplayList("mai ladd jaana",playlist);
        album2.addtoplayList("bhaag milkha title track", playlist);
        album1.addtoplayList("blue h paani paani ", playlist);
        Song sample=new Song("abc",6);
        System.out.println(sample);
        play(playlist);

    }
    public static void play(LinkedList<Song> playlist){

        Scanner sc=new Scanner(System.in);
        ListIterator itr= playlist.listIterator();
        boolean direction= true;
        if(playlist.size()>0){
            System.out.println(itr.next());
            direction =true;
        }
        else{
            System.out.println("playlist is empty");
            return;
        }
        printMenu();
        boolean quit=false;
        while(quit==false){
            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    if(direction==false){
                        itr.next();
                        direction=true;
                    }
                    if(itr.hasNext()){
                        System.out.println(itr.next());

                    }
                    else{
                        System.out.println("you have reached the end of the playList");
                    }
                    break;
                case 2:
                    if(direction==true){
                        itr.previous();
                        direction=false;
                    }
                    if(itr.hasPrevious()){
                        System.out.println(itr.previous());
                    }
                    else{
                        System.out.println("you are at the start of playlist nothing in previous");
                    }
                    break;
                case 3:
                    if(direction==true){
                        if(itr.hasPrevious()) {
                            System.out.println(itr.previous());
                            direction = false;
                        }
                        else{
                            System.out.println("song does not exist");
                        }
                    }
                    else{
                        if(itr.hasNext()) {
                            System.out.println(itr.next());
                            direction = true;
                        }
                        else{
                            System.out.println("song does not exists");
                        }
                    }
                    break;
                case 4:
                    printMenu();
                    break;
                case 5:
                    System.out.println("select which song your want to delete");
                    printSongs(playlist);
                    int n=sc.nextInt();
                    if(n<=0 || n> playlist.size()){
                        System.out.println("invalid input");
                        printMenu();
                    }
                    else{
                        ListIterator itr2= playlist.listIterator();
                        for(int a=1;a<n;a++){
                            itr2.next();
                        }
                        playlist.remove(itr2.next());
                        System.out.println("song has been removed");
                        printMenu();


                    }
                    break;
                case 6:
                    printSongs(playlist);
                    break;
                case 7:
                    quit=true;
                    break;
            }
        }
        return;
    }
    public static void printSongs(LinkedList<Song> playlist){
        int temp=1;
        for(Song s: playlist){
            System.out.println(temp+". "+ s.getTitle());
            temp++;
        }
    }
    public static void printMenu(){
        System.out.println("Select your choice-");
        System.out.println("1. play next song");
        System.out.println("2. play previous song");
        System.out.println("3. repeat current song");
        System.out.println("4. show menu again");
        System.out.println("5- delete the current song");
        System.out.println("6- print all the songs of playlist");
        System.out.println("7- exit");
    }
}