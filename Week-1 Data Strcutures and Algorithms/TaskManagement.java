class Task {
    private String taskId;
    private String taskName;
    private String status;

    public Task(String taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public String getTaskId() { return taskId; }
    public String getTaskName() { return taskName; }
    public String getStatus() { return status; }

    @Override
    public String toString() {
        return "Task [ID=" + taskId + ", Name=" + taskName + ", Status=" + status + "]";
    }
}

class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

public class TaskManagement {
    private Node head;

    public TaskManagement() {
        this.head = null;
    }

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public Task searchTask(String taskId) {
        Node temp = head;
        while (temp != null) {
            if (temp.task.getTaskId().equals(taskId)) {
                return temp.task;
            }
            temp = temp.next;
        }
        return null;
    }

    public void deleteTask(String taskId) {
        Node temp = head;
        Node prev = null;
        while (temp != null && !temp.task.getTaskId().equals(taskId)) {
            prev = temp;
            temp = temp.next;
        }

        if (temp != null) {
            if (prev == null) {
                head = temp.next;
            } else {
                prev.next = temp.next;
            }
        }
    }

    public void displayTasks() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.task);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        TaskManagement management = new TaskManagement();
        Task t1 = new Task("501", "Design UI", "In Progress");
        Task t2 = new Task("502", "Implement Backend", "Not Started");
        management.addTask(t1);
        management.addTask(t2);

        management.displayTasks();

        Task found = management.searchTask("501");
        System.out.println("Search Result: " + (found != null ? found : "Task not found"));

        management.deleteTask("501");
        management.displayTasks();
    }
}
