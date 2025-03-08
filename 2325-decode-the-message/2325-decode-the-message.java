class Solution 
{
    public String decodeMessage(String key, String message) 
    {
        HashMap<Character, Character> map = new HashMap<>();
        char ch = 'a';
        for(int i = 0; i < key.length(); i++)
        {
            char curr = key.charAt(i);
            if(curr != ' ' && !map.containsKey(curr))
            {
                map.put(curr, ch);
                ch++;
            }
        }    
    
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < message.length(); i++)
        {
            if(message.charAt(i) == ' ')
            {
                sb.append(" ");
            }
            else
            {
                sb.append(map.get(message.charAt(i)));
            }
        }

        return sb.toString();
    }
}