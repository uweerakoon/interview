package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MoviesOnFlight {

  public int[] moviesOnFlight(int[] movies, int flightDuration) {
    int[] output = new int[2];
    if(movies == null | movies.length==0){
      return output;
    }
    Arrays.sort(movies);
    int dur = 0;
    int i=0;
    int j= movies.length-1;
    while(i<j) {
      dur = movies[i] + movies[j];
      if (dur < (flightDuration-30)) {
        output[0] = movies[i];
        output[1] = movies[j];
        i++;
      } else if (dur > (flightDuration-30)) {
        j--;
      }
    }
    return output;
  }

  ArrayList<Integer> IDsOfSongs(int rideDuration, 
    ArrayList<Integer> songDurations)
  {
    // WRITE YOUR CODE HERE
    if(rideDuration <= 30 
        || songDurations == null
        || songDurations.isEmpty())
      return null;
    List<Song> songs = new ArrayList<>();
    
    for(int i = 0;i<songDurations.size(); i++) {
      songs.add(new Song(i, songDurations.get(i)));
    }
    Collections.sort(songs, new Comparator<Song>() {
      @Override
      public int compare(Song s1, Song s2) {
        return Integer.compare(s1.getLength(), s2.getLength());
      }
    });
    
    int limit = rideDuration - 30;
    int total = -1, i = 0, j = songDurations.size()-1, longSong = -1, x = -1, y = -1, diff = Integer.MAX_VALUE;
    while(i < j) {
      total = songs.get(i).getLength() + songs.get(j).getLength();
      if(total == limit) {
        int tempLong = songs.get(i).getLength() > songs.get(j).getLength() ? songs.get(i).getLength() : songs.get(j).getLength();
        diff = 0;
        if(tempLong > longSong) {
          longSong = tempLong;
          x = songs.get(i).getId();
          y = songs.get(j).getId();
        }
        i++;
      }
      else if(total < limit) {
        if(diff > (limit-total)) {
          diff = limit - total;
          x = songs.get(i).getId();
          y = songs.get(j).getId();
        }
        i++;
      }
      else {
        j--;
      }
    }
    ArrayList<Integer> output = new ArrayList<>();
    output.add(x); output.add(y);
    Collections.sort(output);
    return output;
  }

  public static void main(String[] args) {
    MoviesOnFlight moviesOnFlight = new MoviesOnFlight();
    ArrayList<Integer> movies = new ArrayList<>();
    movies.add(100);
    movies.add(180);
    movies.add(40);
    movies.add(120);
    movies.add(10);
//    movies.add(110);
    /*System.out.println(Arrays.toString(moviesOnFlight.moviesOnFlight(movies, 250)));*/
    ArrayList<Integer> result = moviesOnFlight.IDsOfSongs(250, movies);
    System.out.println("Result: "+result);
  }
}

class Song {
  private int id;
  private int length;
  public Song(int id, int length) {
    this.id = id;
    this.length = length;
  }
  public int getId() { return id; }
  public int getLength() { return length; }
}
