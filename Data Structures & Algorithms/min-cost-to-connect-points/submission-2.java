class Solution {
    public int minCostConnectPoints(int[][] points) {
        int edgesUsed = 0;
        int minCost = 0;
        boolean visited[] = new boolean[points.length];

        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.add(new int[]{0,0});

        while(edgesUsed<points.length) {
            int curr[] = pq.poll();

            if(visited[curr[0]])
                continue;
            
            minCost += curr[1];
            edgesUsed++;
            visited[curr[0]] = true;

            for(int v=0; v<points.length; v++) {
                if(!visited[v]) {
                    int dist = Math.abs(points[curr[0]][0] - points[v][0]) + 
                               Math.abs(points[curr[0]][1] - points[v][1]);
                    pq.offer(new int[]{v, dist});
                }
            }

        }
        return minCost;
    }
}
