package com.linkedlist.singlylinkedlist.socialmediafriendconnections;

public class SocialMediaMain {
    public static void main(String[] args) {

        SocialMedia sm = new SocialMedia();

        sm.addUser(1, "Alice", 20);
        sm.addUser(2, "Bob", 22);
        sm.addUser(3, "Charlie", 21);
        
        sm.addUser(4, "Diana", 23);

        sm.addFriendConnection(1, 2);
        sm.addFriendConnection(1, 3);
        sm.addFriendConnection(2, 3);
        sm.addFriendConnection(3, 4);

        sm.displayFriends(1);

        System.out.println();
        sm.findMutualFriends(1, 2);
        System.out.println();
        sm.searchByName("Charlie");
        System.out.println();
        sm.countFriendsForEachUser();
        System.out.println();
        sm.removeFriendConnection(1, 3);
        sm.displayFriends(1);
    }
}
