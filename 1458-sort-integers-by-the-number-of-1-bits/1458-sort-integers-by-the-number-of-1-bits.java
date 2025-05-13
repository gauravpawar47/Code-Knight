class Solution 
{
    public class Pair
    {
        int n;
        int count;

        Pair(int n, int count)
        {
            this.n = n;
            this.count = count;
        }
    } 
    
    public int[] sortByBits(int[] arr) 
    {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if(a.count != b.count)
            {
                return a.count - b.count;
            }
            else
            {
                return a.n - b.n;
            }
        });

        for(int n : arr)
        {
            pq.add(new Pair(n, Integer.bitCount(n)));
        }    

        for(int i = 0; i < arr.length; i++)
        {
            arr[i] = pq.remove().n;
        }

        return arr;
    }
}