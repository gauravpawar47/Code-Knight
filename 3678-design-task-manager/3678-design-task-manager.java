class TaskManager 
{
    // Task class to store userId, taskId, and priority
    public static class Task implements Comparable<Task> 
    {
        int userId;
        int taskId;
        int priority;

        public Task(int userId, int taskId, int priority) 
        {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }

        // Compare tasks by priority (descending) and taskId (descending)
        @Override
        public int compareTo(Task other) 
        {
            if (this.priority != other.priority) 
            {
                return other.priority - this.priority; // Higher priority first
            } 
            else 
            {
                return other.taskId - this.taskId; // Higher taskId first if priorities are equal
            }
        }
    }

    // HashMap to store tasks by taskId
    public HashMap<Integer, Task> taskMap;

    // TreeSet to store tasks in sorted order
    public TreeSet<Task> taskSet;

    public TaskManager(List<List<Integer>> tasks) 
    {
        taskMap = new HashMap<>();
        taskSet = new TreeSet<>();

        // Initialize with the given tasks
        for (List<Integer> task : tasks) 
        {
            int userId = task.get(0);
            int taskId = task.get(1);
            int priority = task.get(2);
            add(userId, taskId, priority);
        }
    }

    public void add(int userId, int taskId, int priority) 
    {
        Task task = new Task(userId, taskId, priority);
        taskMap.put(taskId, task);
        taskSet.add(task);
    }

    public void edit(int taskId, int newPriority) 
    {
        if (taskMap.containsKey(taskId)) 
        {
            Task oldTask = taskMap.get(taskId);
            taskSet.remove(oldTask); // Remove the old task from the TreeSet

            // Create a new task with the updated priority
            Task newTask = new Task(oldTask.userId, taskId, newPriority);
            taskMap.put(taskId, newTask);
            taskSet.add(newTask); // Add the updated task to the TreeSet
        }
    }

    public void rmv(int taskId) 
    {
        if (taskMap.containsKey(taskId)) 
        {
            Task task = taskMap.get(taskId);
            taskSet.remove(task); // Remove the task from the TreeSet
            taskMap.remove(taskId); // Remove the task from the HashMap
        }
    }

    public int execTop() 
    {
        if (taskSet.isEmpty()) 
        {
            return -1; // No tasks available
        }

        Task task = taskSet.pollFirst(); // Retrieve and remove the top task
        taskMap.remove(task.taskId); // Remove the task from the HashMap
        return task.userId; // Return the userId of the executed task
    }
}