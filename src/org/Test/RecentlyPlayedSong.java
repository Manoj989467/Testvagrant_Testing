package org.Test;



import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RecentlyPlayedSong {
	 int limit;
	 Map<String, LinkedList<String>> userTunesMap;

	public RecentlyPlayedSong(int limit) {
		this.limit = limit;
		this.userTunesMap = new HashMap<>();
	}

	public void playedSong(String user, String song) {
       
        if (!userTunesMap.containsKey(user)) {
            userTunesMap.put(user, new LinkedList<>());
        }

        LinkedList<String> songs = userTunesMap.get(user);
        songs.remove(song);

        if (songs.size() == limit) {
            songs.removeLast();
        }

        songs.addFirst(song);
    }
	public List<String> LastPlayedSongs(String user) {
		return userTunesMap.getOrDefault(user, new LinkedList<>());
	}

	public static void main(String[] args) {
		RecentlyPlayedSong music = new RecentlyPlayedSong(3);

		music.playedSong("user1", "Song1");
		music.playedSong("user1", "Song2");
		music.playedSong("user1", "Song3");
		System.out.println(music.LastPlayedSongs("user1"));

		music.playedSong("user1", "Song4");
		System.out.println(music.LastPlayedSongs("user1"));

		music.playedSong("user1", "Song2");
		System.out.println(music.LastPlayedSongs("user1"));

		music.playedSong("user1", "Song1");
		System.out.println(music.LastPlayedSongs("user1"));
	}
}

