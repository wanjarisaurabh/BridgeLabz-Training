package com.linkedlist.singlylinkedlist.socialmediafriendconnections;

import java.util.ArrayList;

public class User {
    int userId;
    String name;
    int age;
    ArrayList<Integer> friends;
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = new ArrayList<>();
        this.next = null;
    }
}
