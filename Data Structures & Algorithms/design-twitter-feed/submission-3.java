class Twitter {
    int time;
    Map<Integer, Set<Integer>> followerMap;
    Map<Integer, List<int[]>> tweetMap;

    public Twitter() {
        followerMap = new HashMap<>();
        tweetMap = new HashMap<>();
        time=0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new int[]{time++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        followerMap.putIfAbsent(userId, new HashSet<>());
        followerMap.get(userId).add(userId);
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> b[0]-a[0]);

        for(int followee: followerMap.get(userId)) {
            List<int []> tweets = tweetMap.get(followee);
            if (tweets == null || tweets.isEmpty()) continue;
            int idx = tweets.size()-1;
            int[] tweet = tweets.get(idx);
            pq.add(new int[] {tweet[0], tweet[1], followee, idx-1});
        }

        while(!pq.isEmpty() && res.size()<10) {
            int[] curr = pq.poll();
            res.add(curr[1]);

            int followee = curr[2];
            int idx = curr[3];

            if (idx >= 0) {
                int[] tweet = tweetMap.get(followee).get(idx);
                pq.offer(new int[]{
                    tweet[0], tweet[1], followee, idx - 1
                });
            }
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followerMap.putIfAbsent(followerId, new HashSet<>());
        followerMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerMap.containsKey(followerId))
            followerMap.get(followerId).remove(followeeId);
    }
}
