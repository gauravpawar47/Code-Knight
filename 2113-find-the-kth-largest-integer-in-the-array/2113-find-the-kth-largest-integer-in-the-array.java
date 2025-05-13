class Solution 
{
    public String kthLargestNumber(String[] nums, int k) 
    {

        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if(a.length() != b.length())
            {
                return b.length() - a.length();
            }
            else
            {
                return b.compareTo(a);
            }
        }); 

        for(String n : nums)
        {
            pq.add(n);
        }

        while(k > 1)
        {
            pq.remove();
            k--;
        }

        return pq.peek();
    }
}