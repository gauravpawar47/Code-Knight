class Solution 
{
    public int countPoints(String rings) 
    {
        Map<Integer, List<Integer>> map = new HashMap<>();
        String color = "RGB";

        for (int i = 0; i < rings.length(); i += 2) 
        {
            char c = rings.charAt(i);         
            int rod = rings.charAt(i + 1) - '0'; 
            int colorIdx = color.indexOf(c);  

            map.putIfAbsent(rod, Arrays.asList(0, 0, 0)); // Initialize with [0, 0, 0]
            
            // Since Arrays.asList returns a fixed-size list, we create a modifiable one
            List<Integer> counts = new ArrayList<>(map.get(rod));
            counts.set(colorIdx, counts.get(colorIdx) + 1); // Increment the count
            map.put(rod, counts); // Update map
        }

        int count = 0;
        for (List<Integer> counts : map.values()) 
        {
            if (counts.get(0) > 0 && counts.get(1) > 0 && counts.get(2) > 0) 
            {
                count++;
            }
        }

        return count;
    }
}