package com.linkedlist.circularlinkedlist.ticketreservation;

class TaskScheduler {
    private Task head = null;
    private Task current = null;

    public void addAtBeginning(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head;
            current = head;
            return;
        }
        Task temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        newTask.next = head;
        temp.next = newTask;
        head = newTask;
    }

    /*add task at end */
    public void addAtEnd(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);

        if (head == null) {
            head = newTask;
            newTask.next = head;
            current = head;
            return;
        }

        Task temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newTask;
        newTask.next = head;
    }

    /*add task at specific position */
    public void addAtPosition(int position, int id, String name, int priority, String dueDate) {
        if (position <= 1 || head == null) {
            addAtBeginning(id, name, priority, dueDate);
            return;
        }

        Task newTask = new Task(id, name, priority, dueDate);
        Task temp = head;
        int count = 1;

        while (temp.next != head && count < position - 1) {
            temp = temp.next;
            count++;
        }

        newTask.next = temp.next;
        temp.next = newTask;
    }

    /*remove task by Task ID */
    public void removeByTaskId(int taskId) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        Task temp = head;
        Task prev = null;

        do {
            if (temp.taskId == taskId) {

                // Only one node
                if (temp == head && temp.next == head) {
                    head = null;
                    current = null;
                    return;
                }

                // Deleting head
                if (temp == head) {
                    Task last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    head = head.next;
                    last.next = head;
                    if (current == temp) current = head;
                    return;
                }

                prev.next = temp.next;
                if (current == temp) current = temp.next;
                return;
            }

            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Task not found.");
    }

    public void viewCurrentTask() {
        if (current == null) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("Current Task:");
        displayTask(current);
        current = current.next;
    }

    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }

        Task temp = head;
        System.out.println("Task List:");
        do {
            displayTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        Task temp = head;
        boolean found = false;

        do {
            if (temp.priority == priority) {
                displayTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No task found with priority " + priority);
        }
    }

    private void displayTask(Task task) {
        System.out.println(
            "ID: " + task.taskId +
            ", Name: " + task.taskName +
            ", Priority: " + task.priority +
            ", Due Date: " + task.dueDate
        );
    }
}
