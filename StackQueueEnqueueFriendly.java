/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsa;

class StackQueueEnqueueFriendly {

    int size = 100;
    int[] s1 = new int[size];
    int[] s2 = new int[size];
    int top1 = -1;
    int top2 = -1;

    // ENQUEUE operation (easy)
    void enqueue(int x) {
        s1[++top1] = x;
        System.out.println(x + " enqueued");
    }

    // DEQUEUE operation (costly)
    int dequeue() {
        if (top1 == -1) {
            System.out.println("Queue is empty");
            return -1;
        }

        while (top1 != -1) {
            s2[++top2] = s1[top1--];
        }

        int dequeued = s2[top2--];

        while (top2 != -1) {
            s1[++top1] = s2[top2--];
        }

        return dequeued;
    }

    public static void main(String[] args) {
        StackQueueEnqueueFriendly q = new StackQueueEnqueueFriendly();
        q.enqueue(50);
        q.enqueue(70);
        q.enqueue(90);

        System.out.println("Dequeued: " + q.dequeue());
    }
}