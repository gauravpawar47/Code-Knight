class Solution
{
    public void addFrequency(HashMap<Integer, Integer> map, HashSet<Integer> set)
    {
        for (Integer num : set)
        {
            map.put(num, map.getOrDefault(num, 0) + 1); // Increment frequency of the number
        }
        set.clear(); // Clear the set after processing
    }

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3)
    {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        // Add elements from nums1 to set and update the map
        for (int num : nums1)
        {
            set.add(num);
        }
        addFrequency(map, set);

        // Add elements from nums2 to set and update the map
        for (int num : nums2) 
        {
            set.add(num);
        }
        addFrequency(map, set);

        // Add elements from nums3 to set and update the map
        for (int num : nums3) 
        {
            set.add(num);
        }
        addFrequency(map, set);

        // Add values that appear in at least two of the three arrays
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) 
        {
            if (entry.getValue() >= 2) 
            {
                list.add(entry.getKey());
            }
        }

        return list;
    }
}