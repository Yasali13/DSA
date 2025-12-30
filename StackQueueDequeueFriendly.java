/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsa;
import java.util.Stack;

/**
 *
 * @author Yasali
 */



public class StackQueueDequeueFriendly {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    // ENQUEUE - O(n)
    public void enqueue(int x) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        s1.push(x);

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    // DEQUEUE - O(1)
    public int dequeue() {
        if (s1.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return s1.pop();
    }

    public static void main(String[] args) {
        StackQueueDequeueFriendly q = new StackQueueDequeueFriendly();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        System.out.println(q.dequeue());
    }
}
