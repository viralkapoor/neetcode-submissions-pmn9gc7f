class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int i=s1.length(), j=s2.length(), k=s3.length();
        if(i+j!=k)
            return false;

        Boolean dp[][] = new Boolean[i+1][j+1];
        return isInterleave(s1, s2, s3, i-1, j-1, k-1, dp);
    }

    public boolean isInterleave(String s1, String s2, String s3, int i, int j, int k, Boolean dp[][]) {
        if(i==-1 && j==-1)
            return true;
        
        if(dp[i+1][j+1]!=null)
            return dp[i+1][j+1];

        boolean one = false, two = false;
        if(i!=-1 && s1.charAt(i)==s3.charAt(k)) {
            one = isInterleave(s1, s2, s3, i-1, j, k-1, dp);
        }
        if(j!=-1 && s2.charAt(j)==s3.charAt(k)) {
            two = isInterleave(s1, s2, s3, i, j-1, k-1, dp);
        }
        dp[i+1][j+1]=one || two;
        return dp[i+1][j+1];
    }
}
