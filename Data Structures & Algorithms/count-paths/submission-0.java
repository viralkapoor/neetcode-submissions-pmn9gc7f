class Solution {
    public int uniquePaths(int m, int n) {
        int prev[] = new int[m+1];
        Arrays.fill(prev, 0);
        int curr[] = new int[m+1];
        Arrays.fill(curr, 0);

        for(int i=0; i<n ;i++) {
            for(int j=1; j<=m; j++) {
                if(i==0 && j==1)
                    curr[j]=1;
                else 
                    curr[j] = prev[j] + curr[j-1];
            }
            prev = curr;
            curr = new int[m+1];
        }
        return prev[m];
    }
}
