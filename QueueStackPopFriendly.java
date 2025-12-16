/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsa;

class QueueStackPopFriendly {

    int size = 100;
    int[] q1 = new int[size];
    int[] q2 = new int[size];
    int front1 = 0, rear1 = 0;
    int front2 = 0, rear2 = 0;

    // PUSH operation (costly)
    void push(int x) {
        // Move all from q1 to q2
        while (front1 < rear1) {
            q2[rear2++] = q1[front1++];
        }

        // Insert new element
        q1[rear1++] = x;

        // Move back elements
        while (front2 < rear2) {
            q1[rear1++] = q2[front2++];
        }

        front1 = front2 = rear2 = 0;
        System.out.println(x + " pushed");
    }

    // POP operation (easy)
    int pop() {
        if (front1 == rear1) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q1[front1++];
    }

    public static void main(String[] args) {
        QueueStackPopFriendly s = new QueueStackPopFriendly();
        s.push(15);
        s.push(20);
        s.push(25);

        System.out.println("Popped: " + s.pop());
    }
}