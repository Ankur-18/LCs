class Solution {
    public boolean isValid(String word) {
        if(word.length()<3)
        {
            return false;
        }

        boolean hasVowel = false;
        boolean hasConsonant = false;

        for(char c : word.toCharArray())
        {
            if (Character.isLetter(c)) {
                c = Character.toLowerCase(c);
                if(c=='a' || c== 'e'|| c== 'i' || c == 'o' || c == 'u')
                {
                    hasVowel = true;
                }
                else
                {
                    hasConsonant = true;
                }
            }
            else if(!Character.isDigit(c)){
                return false;
            }
        }

        return hasVowel && hasConsonant;
    }
}