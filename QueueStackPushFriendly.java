package dsa;

class QueueStackPushFriendly {

    int size = 100;
    int[] q1 = new int[size];
    int[] q2 = new int[size];
    int front1 = 0, rear1 = 0;
    int front2 = 0, rear2 = 0;

    // PUSH operation (easy)
    void push(int x) {
        q1[rear1++] = x;
        System.out.println(x + " pushed");
    }

    // POP operation (costly)
    int pop() {
        if (front1 == rear1) {
            System.out.println("Stack is empty");
            return -1;
        }

        // move elements except last
        while (front1 < rear1 - 1) {
            q2[rear2++] = q1[front1++];
        }

        int popped = q1[front1++];
        
        // reset q1
        front1 = 0;
        rear1 = 0;

        // swap q1 and q2
        int[] temp = q1;
        q1 = q2;
        q2 = temp;

        rear1 = rear2;
        front2 = rear2 = 0;

        return popped;
    }

    public static void main(String[] args) {
        QueueStackPushFriendly s = new QueueStackPushFriendly();
        s.push(50);
        s.push(70);
        s.push(90);

        System.out.println("Popped: " + s.pop());
    }
}