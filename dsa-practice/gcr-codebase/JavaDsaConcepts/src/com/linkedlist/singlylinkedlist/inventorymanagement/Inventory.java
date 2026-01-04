package com.linkedlist.singlylinkedlist.inventorymanagement;

class Inventory {
    private Item head = null;

    public void addAtBeginning(int id, String name, int qty, double price) {
        Item newItem = new Item(id, name, qty, price);
        newItem.next = head;
        head = newItem;
    }

    public void addAtEnd(int id, String name, int qty, double price) {
        Item newItem = new Item(id, name, qty, price);

        if (head == null) {
            head = newItem;
            return;
        }

        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    /* Add at specific position (1-based) */
    public void addAtPosition(int position, int id, String name, int qty, double price) {
        if (position <= 1 || head == null) {
            addAtBeginning(id, name, qty, price);
            return;
        }

        Item newItem = new Item(id, name, qty, price);
        Item temp = head;
        int count = 1;

        while (temp.next != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        newItem.next = temp.next;
        temp.next = newItem;
    }

    public void removeById(int id) {
        if (head == null) {
            System.out.println("Inventory empty.");
            return;
        }

        if (head.itemId == id) {
            head = head.next;
            System.out.println("Item removed.");
            return;
        }

        Item temp = head;
        while (temp.next != null && temp.next.itemId != id) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Item not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Item removed.");
        }
    }

    public void updateQuantity(int id, int newQty) {
        Item temp = head;

        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQty;
                System.out.println("Quantity updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    public void searchById(int id) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                displayItem(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    public void searchByName(String name) {
        Item temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(name)) {
                displayItem(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("Item not found.");
        }
    }

    public void calculateTotalValue() {
        double total = 0;
        Item temp = head;

        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }

        System.out.println("Total Inventory Value: ₹" + total);
    }

    /* prnt inventory */
    public void displayInventory() {
        if (head == null) {
            System.out.println("No items in inventory.");
            return;
        }

        Item temp = head;
        while (temp != null) {
            displayItem(temp);
            temp = temp.next;
        }
    }

    private void displayItem(Item item) {
        System.out.println(
            "ID: " + item.itemId +
            ", Name: " + item.itemName +
            ", Quantity: " + item.quantity +
            ", Price: ₹" + item.price
        );
    }


    public void sortByName(boolean ascending) {
        head = mergeSort(head, true, ascending);
    }

    public void sortByPrice(boolean ascending) {
        head = mergeSort(head, false, ascending);
    }

    private Item mergeSort(Item head, boolean sortByName, boolean ascending) {
        if (head == null || head.next == null)
            return head;

        Item middle = getMiddle(head);
        Item nextOfMiddle = middle.next;
        middle.next = null;

        Item left = mergeSort(head, sortByName, ascending);
        Item right = mergeSort(nextOfMiddle, sortByName, ascending);

        return sortedMerge(left, right, sortByName, ascending);
    }

    private Item sortedMerge(Item a, Item b, boolean sortByName, boolean ascending) {
        if (a == null) return b;
        if (b == null) return a;

        boolean condition;
        if (sortByName) {
            condition = ascending ?
                a.itemName.compareToIgnoreCase(b.itemName) <= 0 :
                a.itemName.compareToIgnoreCase(b.itemName) > 0;
        } else {
            condition = ascending ? a.price <= b.price : a.price > b.price;
        }

        if (condition) {
            a.next = sortedMerge(a.next, b, sortByName, ascending);
            return a;
        } else {
            b.next = sortedMerge(a, b.next, sortByName, ascending);
            return b;
        }
    }

    private Item getMiddle(Item head) {
        if (head == null) return head;

        Item slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
