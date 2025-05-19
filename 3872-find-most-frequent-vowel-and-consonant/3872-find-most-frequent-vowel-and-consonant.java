class Solution 
{
    public int maxFreqSum(String s) 
    {
        HashMap<Character, Integer> vowels = new HashMap<>();
        HashMap<Character, Integer> conso  = new HashMap<>();

        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
         
            if (!Character.isLetter(c))
            {
                continue; 
            } 

            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            {
                vowels.put(c, vowels.getOrDefault(c, 0) + 1);
            }
            else
            {
                conso.put(c, conso.getOrDefault(c, 0) + 1);
            }
        }    

        int maxVowel = vowels.isEmpty() ? 0 : Collections.max(vowels.values());
        int maxConso = conso.isEmpty() ? 0 : Collections.max(conso.values());

        return maxVowel + maxConso;
    }
}