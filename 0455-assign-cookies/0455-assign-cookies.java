class Solution {
    public int findContentChildren(int[] g, int[] s) {
         Arrays.sort(s);
        Arrays.sort(g);
        int match =0;

        for(int i = 0,j =0 ; i<g.length && j<s.length ;j++ )
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