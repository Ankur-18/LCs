class Solution {
    public String makeFancyString(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int flag = 1;
        sb.append(s.charAt(0));

        for (int i = 1; i < n; i++) {
            if(s.charAt(i)==s.charAt(i-1))
            {
                flag++;
            }
            else{
                flag =1 ;
            }
            if(flag<3)
            {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();

    }
}