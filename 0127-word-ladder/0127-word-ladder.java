class Solution 
{
    public int ladderLength(String beginWord, String endWord, List<String> wordList) 
    {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord))
        {
            return 0;
        }       

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int steps = 1;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int s = 0; s < size; s++)
            {
                String word = queue.poll();
                if(word.equals(endWord))
                {
                    return steps;
                }

                for(String neigh : getNeighbors(word, wordSet))
                {
                    queue.offer(neigh);
                    wordSet.remove(neigh);
                }
            }

            steps++;
        }

        return 0;
    }

    public List<String> getNeighbors(String word, HashSet<String> wordSet)
    {
        ArrayList<String> neigh = new ArrayList<>();
        char[] chars = word.toCharArray();

        for(int i = 0; i < chars.length; i++)
        {
            char old = chars[i];
            for(char c = 'a'; c <= 'z'; c++)
            {
                if(c == old)
                {
                    continue;
                }

                chars[i] = c;
                String newWord = new String(chars);
                
                if(wordSet.contains(newWord))
                {
                    neigh.add(newWord);
                }
            }

            chars[i] = old;
        }

        return neigh;
    }
}