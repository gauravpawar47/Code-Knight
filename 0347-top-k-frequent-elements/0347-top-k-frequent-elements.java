class Solution 
{
    public int[] topKFrequent(int[] nums, int k) 
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int n : nums)
        {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        ArrayList<Map.Entry<Integer, Integer>> sorted = new ArrayList<>(map.entrySet());
        sorted.sort((a, b) -> b.getValue() - a.getValue());

        for(int i = 0; i < k && i < sorted.size(); i++)
        {
            list.add(sorted.get(i).getKey());
        }

        int[] arr = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
        {
            arr[i] = list.get(i);
        }

        return arr;
    }
}