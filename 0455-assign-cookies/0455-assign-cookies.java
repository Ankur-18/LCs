class Solution {
    public int findContentChildren(int[] g, int[] s) {
         Arrays.sort(s);
        Arrays.sort(g);
        int match =0;
        int m = g.length;
        int n = s.length;

        for(int i = 0,j =0 ; i<m && j<n ;j++ )
        {
            if(g[i] <= s[j])
            {
                match++;
                i++;
            }
        }

        return match;
    }
}