import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class 해시_Lv3_베스트앨범 {

	public static void main(String[] args) {
		String[] genres = {"classic","pop","classic","classic","pop"};
		int[] plays = {500,600,150,800,2500};
		System.out.println(Arrays.toString(solution(genres, plays)));
		System.out.println("답:"+"[4,1,3,0]");
	}
	static class Genre implements Comparable<Genre> {
		String name;
		int playSum;
		ArrayList<Music> musics;
		public Genre(String name, int playSum, ArrayList<Music> musics) {
			this.name = name;
			this.playSum = playSum;
			this.musics = musics;
		}
		@Override
		public int compareTo(Genre other) {
			return other.playSum-this.playSum;
		}
	}
	static class Music implements Comparable<Music> {
		int index;
		int play;
		public Music(int index, int play) {
			this.index = index;
			this.play = play;
		}
		@Override
		public int compareTo(Music other) {
			if(this.play == other.play) return this.index-other.index; 
			return other.play-this.play;
		}
	};
	public static int[] solution(String[] genres, int[] plays) {
		HashMap<String, Integer> playCount = new HashMap<>();
		for (int i = 0; i < plays.length; i++) {
			playCount.put(genres[i], playCount.getOrDefault(genres[i], 0) + plays[i]);
		}
		
		ArrayList<Genre> genreList = new ArrayList<>();
		for (String name : playCount.keySet()) {
			ArrayList<Music> musics = new ArrayList<>();
			genreList.add(new Genre(name, playCount.get(name), musics));
		}
		
		for (int i = 0; i < plays.length; i++) {
			for (int j = 0; j < genreList.size() ; j++) {
				Genre genre = genreList.get(j);
				if(genre.name.equals(genres[i])) {
					genre.musics.add(new Music(i,plays[i]));
					break;
				}
			}
		}
		
		// 각 장르별 플레이 많은 순 정렬
		Collections.sort(genreList);
		for (int i = 0; i < genreList.size(); i++) {
			// 각 음악별 플레이 많은 순 정렬
			Collections.sort(genreList.get(i).musics);
		}
		
		
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < genreList.size(); i++) {
			Genre genre = genreList.get(i);
			
			// 정렬된 노래 중 가장 플레이 횟수 많은 노래 저장
			list.add(genre.musics.get(0).index);
			if(genre.musics.size() > 1) {
				// 1개보다 많다면 정렬된 노래 중 두번째로 플레이 횟수 많은 노래 저장
				list.add(genre.musics.get(1).index);
			}
		}
		
		int[] answer = new int[list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
		
		return answer;
    }
}
