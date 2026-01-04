package com.linkedlist.singlylinkedlist.socialmediafriendconnections;

public class SocialMedia {
    private User head = null;

    public void addUser(int id, String name, int age) {
        User newUser = new User(id, name, age);

        if (head == null) {
            head = newUser;
            return;
        }

        User temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newUser;
    }

    private User findUserById(int id) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == id) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void searchByName(String name) {
        User temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                displayUser(temp);
                found = true;
            }
            temp = temp.next; 
            
        }

        if (!found) {
            System.out.println("User not found.");
        }
    }


    
    public void addFriendConnection(int id1, int id2) {
        User user1 = findUserById(id1);
        User user2 = findUserById(id2);
        

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        if (!user1.friends.contains(id2)) {
            user1.friends.add(id2);
        }
        if (!user2.friends.contains(id1)) {
            user2.friends.add(id1);
        }

        System.out.println("Friend connection added.");
    }


    public void removeFriendConnection(int id1, int id2) {
        User user1 = findUserById(id1);
        User user2 = findUserById(id2);

        if (user1 == null || user2 == null) {
        	
            System.out.println("One or both users not found.");
            return;
        }

        user1.friends.remove(Integer.valueOf(id2));
        user2.friends.remove(Integer.valueOf(id1));

        System.out.println("Friend connection removed.");
    }


    public void displayFriends(int userId) {
        User user = findUserById(userId);

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Friends of " + user.name + ":");
        if (user.friends.isEmpty()) {
            System.out.println("No friends.");
            return;
        }

        for (int fid : user.friends) {
            User friend = findUserById(fid);
            if (friend != null) {
                System.out.println(friend.userId + " - " + friend.name);
            }
        }
    }


    public void findMutualFriends(int id1, int id2) {
        User user1 = findUserById(id1);
        User user2 = findUserById(id2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        System.out.println("Mutual Friends:");
        boolean found = false;

        for (int f1 : user1.friends) {
            if (user2.friends.contains(f1)) {
                User mutual = findUserById(f1);
                if (mutual != null) {
                    System.out.println(mutual.userId + " - " + mutual.name);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No mutual friends.");
        }
    }


    public void countFriendsForEachUser() {
        User temp = head;

        while (temp != null) {
            System.out.println(
                temp.name + " has " + temp.friends.size() + " friend(s)."
            );
            temp = temp.next;
        }
    }


    private void displayUser(User user) {
        System.out.println(
            "ID: " + user.userId +
            ", Name: " + user.name +
            ", Age: " + user.age +
            ", Friends Count: " + user.friends.size()
        );
    }
}
