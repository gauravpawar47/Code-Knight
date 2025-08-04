public class Solution 
{
    public int totalFruit(int[] fruits) 
    {
        Map<Integer, Integer> basket = new HashMap<>();
        int maxFruits = 0;
        int start = 0;

        for (int end = 0; end < fruits.length; end++) 
        {
            int fruit = fruits[end];
            basket.put(fruit, basket.getOrDefault(fruit, 0) + 1);

            // If more than 2 types of fruit, shrink window from the left
            while (basket.size() > 2) 
            {
                int leftFruit = fruits[start];
                basket.put(leftFruit, basket.get(leftFruit) - 1);
                if (basket.get(leftFruit) == 0) 
                {
                    basket.remove(leftFruit);
                }
                start++;
            }

            maxFruits = Math.max(maxFruits, end - start + 1);
        }

        return maxFruits;
    }
}