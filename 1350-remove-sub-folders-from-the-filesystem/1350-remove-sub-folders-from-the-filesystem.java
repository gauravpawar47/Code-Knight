class Solution 
{
    public List<String> removeSubfolders(String[] folder)
    {
        // Step 1: Sort the folders
        Arrays.sort(folder);

        // Step 2: Create a result list
        List<String> result = new ArrayList<>();
        String prev = "";

        // Step 3: Loop through each folder in the sorted list
        for (String curr : folder) 
        {
            if (prev.isEmpty() || !curr.startsWith(prev + "/")) 
            {
                result.add(curr);
                prev = curr;
            }
        }

        // Step 4: Return the result
        return result;
    }
}