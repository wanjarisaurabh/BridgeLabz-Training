package com.linkedlist.circularlinkedlist.roundrobin;

public class RoundRobinMain {
    public static void main(String[] args) {

        RoundRobinScheduler scheduler = new RoundRobinScheduler();
        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 1);
        scheduler.addProcess(4, 6, 3);

        int timeQuantum = 3;
        scheduler.displayProcesses();
        scheduler.simulate(timeQuantum);
    }
}
