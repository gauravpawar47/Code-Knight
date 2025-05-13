class Solution 
{
    public int halveArray(int[] nums) 
    {
        // Step 1 : Initialize the Priority Queue
        PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> Double.compare(b, a));

        // Step 2 : Declare the Iterators
        double sum = 0;

        // Step 3 : Adding elements in Max-Heap and calculating sum
        for(int n : nums)
        {
            sum += n;
            pq.add((double) n);
        }            

        // Step 4 : Initalizing op with 1 and calculating half
        double half = sum / 2.0;
        int op = 0;

        // Step 6 : Calculate the Least Half
        while(sum > half)
        {
            double reduce = pq.poll() / 2;
            sum -= reduce;

            pq.offer(reduce);
            op++;
        }

        return op;
    }
}