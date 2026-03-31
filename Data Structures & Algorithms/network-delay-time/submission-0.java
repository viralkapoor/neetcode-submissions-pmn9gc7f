class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        int dist[] = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k]=0;
        pq.add(new int[]{0,k});
        boolean visited[] = new boolean[n+1];

        Map<Integer, List<int[]>> graph = createGraph(times);

        while(!pq.isEmpty()) {
            int curr[] = pq.poll();

            if(visited[curr[1]])
                continue;
            
            dist[curr[1]] = curr[0];

            List<int []> adjacent = graph.getOrDefault(curr[1], new ArrayList<>());

            for(int []next: adjacent) {
                if(dist[next[0]] > dist[curr[1]]+next[1])
                    pq.add(new int[]{dist[curr[1]]+next[1], next[0]});
            }
            visited[curr[1]] = true;
        }

        int max = -1;
        for(int i=1; i<=n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }
        return max;
    }

    public Map createGraph(int[][] edges) {
        Map<Integer, List<int []>> graph = new HashMap<>();

        for(int[] e: edges) {
            List<int []> adjacent = graph.getOrDefault(e[0], new ArrayList<>());
            adjacent.add(new int[]{e[1], e[2]});
            graph.put(e[0], adjacent);
        }

        return graph;
    }
}
