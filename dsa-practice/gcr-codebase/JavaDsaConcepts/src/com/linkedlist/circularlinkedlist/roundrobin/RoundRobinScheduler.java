package com.linkedlist.circularlinkedlist.roundrobin;

public class RoundRobinScheduler {
    private Process head = null;

    public void addProcess(int id, int burstTime, int priority) {
        Process newProcess = new Process(id, burstTime, priority);

        if (head == null) {
            head = newProcess;
            newProcess.next = head;
            return;
        }

        Process temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newProcess;
        newProcess.next = head;
    }

    private void removeProcess(Process prev, Process curr) {
        if (curr == head && curr.next == head) {
            head = null;
            return;
        }

        if (curr == head) {
            Process last = head;
            while (last.next != head) {
                last = last.next;
            }
            head = head.next;
            last.next = head;
        } else {
            prev.next = curr.next;
        }
    }

    public void simulate(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int currentTime = 0;
        Process current = head;
        Process prev = null;
        int completed = 0;
        int totalProcesses = countProcesses();

        System.out.println("Starting Round Robin Scheduling...\n");

        while (completed < totalProcesses) {

            if (current.remainingTime > 0) {

                int execTime = Math.min(timeQuantum, current.remainingTime);
                current.remainingTime -= execTime;
                currentTime += execTime;

                Process temp = head;
                do {
                    if (temp != current && temp.remainingTime > 0) {
                        temp.waitingTime += execTime;
                    }
                    temp = temp.next;
                } while (temp != head);

                if (current.remainingTime == 0) {
                    current.turnaroundTime = currentTime;
                    completed++;

                    System.out.println("Process " + current.processId + " completed.");

                    removeProcess(prev, current);
                    current = (prev == null) ? head : prev.next;

                    displayProcesses();
                    continue;
                }
            }

            prev = current;
            current = current.next;
        }

        calculateAverageTimes(totalProcesses);
    }

    public void displayProcesses() {
        if (head == null) {
            System.out.println("No active processes.\n");
            return;
        }

        Process temp = head;
        System.out.println("Current Process Queue:");
        do {
            System.out.println(
                "PID: " + temp.processId +
                ", Remaining Time: " + temp.remainingTime +
                ", Priority: " + temp.priority
            );
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    private int countProcesses() {
        if (head == null) return 0;

        int count = 0;
        Process temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }

    private void calculateAverageTimes(int totalProcesses) {
        double totalWaiting = 0;
        double totalTurnaround = 0;

        Process temp = head;
        if (temp == null) {
            System.out.println("\nScheduling completed.");
            return;
        }

        do {
            totalWaiting += temp.waitingTime;
            totalTurnaround += temp.turnaroundTime;
            temp = temp.next;
        } while (temp != head);

        System.out.println("\nAverage Waiting Time: " + (totalWaiting / totalProcesses));
        System.out.println("Average Turnaround Time: " + (totalTurnaround / totalProcesses));
    }
}
