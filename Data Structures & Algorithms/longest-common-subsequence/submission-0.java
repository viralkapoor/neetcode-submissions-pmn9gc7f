class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text2.length();
        int n = text1.length();

        int prev[] = new int[m+1];
        int curr[] = new int[m+1];

        for(int i=0; i<n; i++) {
            for(int j=1; j<=m; j++) {
                if(text1.charAt(i)==text2.charAt(j-1)) {
                    curr[j] = prev[j-1]+1;
                } else {
                    curr[j] = Math.max(curr[j-1], prev[j]);
                }
            }
            prev = curr;
            curr = new int[m+1];
        }

        return prev[m];
    }
}
