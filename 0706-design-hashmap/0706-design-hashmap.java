class MyHashMap
{
    private int[] arr;
    public MyHashMap()
    {
        arr = new int[1000001];
        Arrays.fill(arr, -1); // Use -1 to indicate the absence of a value
    }
    
    public void put(int key, int value)
    {
        arr[key] = value;
    }
    
    public int get(int key)
    {
        return arr[key];
    }
    
    public void remove(int key)
    {
        arr[key] = -1;
    }
}