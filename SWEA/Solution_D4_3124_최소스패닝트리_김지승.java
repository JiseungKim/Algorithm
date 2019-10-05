import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Solution_D4_3124_최소스패닝트리_김지승 {
	//대표자를 저장하는 배열.
	private static int parents[];
	
	//집합 알아오기
	static int find(int a) {
		//자신이 루트이면 자신 리턴
		if(parents[a]<0) return a;
		//그게 아니라면
		return parents[a] = find(parents[a]);
	}
	
	//모든 원소를 개별적인 집합으로 생성
	static void make() {
		//부모가 없게 만들어줌.
		Arrays.fill(parents, -1);
	}
	
	//합치기
	static boolean union(int a, int b,int C) {
		int aRoot = find(a);
		int bRoot = find(b);
		//부모가 같다면 합치지 못함.
		if(aRoot==bRoot) return false;
		//다르다면, 한쪽의 대표자를 다른쪽 대표자로 만들어줌.
		parents[bRoot] = aRoot; //parnets[aRoot] = bRoot와 같은 결과.
		min += C;
		return true;
	}
	
	public static class Edge /*implements Comparable<Edge>*/{
		int V1;
		int V2;
		int C;
		public Edge(int V1,int V2,int C) {
			this.V1 = V1;
			this.V2 = V2;
			this.C = C;
		}
		/*
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return C-o.C;
		}*/
	}
	
	static long min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int V = Integer.parseInt(st.nextToken()); //정점
			int E = Integer.parseInt(st.nextToken()); //간선
			parents = new int[V+1];
			Edge[] edges = new Edge[E];
			
			min = 0;
			make();
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(in.readLine());
				int V1 = Integer.parseInt(st.nextToken());	//정점1
				int V2 = Integer.parseInt(st.nextToken());	//정점2
				int C = Integer.parseInt(st.nextToken());	//가중치
				edges[i] = new Edge(V1,V2,C);
			}
			Arrays.sort(edges, new Comparator<Edge>() {
				@Override
				public int compare(Edge e1, Edge e2) {
					// TODO Auto-generated method stub
					return e1.C-e2.C;  
				}
			});
			for (int i = 0; i < E; i++) {
				union(edges[i].V1,edges[i].V2,edges[i].C);
			}
//			for (Edge edge : edges) {
//				System.out.println(edge.V1 + " "+edge.V2 + " "+edge.C);
//			}
//			System.out.println(Arrays.toString(parents));
			System.out.println("#"+test_case+" "+min);
		}
	}

}
