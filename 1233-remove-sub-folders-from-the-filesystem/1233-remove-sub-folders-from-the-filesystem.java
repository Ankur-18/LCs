class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Set<String> s = new HashSet<>(Arrays.asList(folder));
        List<String> ls = new ArrayList<>();

        for(String cf : folder)
        {
            boolean isSubFolder = false;
            String temp = cf;

            while(!cf.isEmpty())
            {
                int lastSlash = cf.lastIndexOf('/');
                if(lastSlash == -1){break;} // brek as no slashes are left 

                cf = cf.substring(0,lastSlash);
                if(s.contains(cf))
                {
                    isSubFolder = true ;
                    break;
                }

            }

            if(!isSubFolder)
            {
                ls.add(temp);
            }
        }

        return ls ;
    }
}