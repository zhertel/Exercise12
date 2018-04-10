package com.hertel.exercise12;

class StackFullException extends Exception {}

class StackEmptyException extends Exception {}


class Stack<E> {
    private E[] elements;
    private int index = 0;
    private int size;

    Stack(int size) {
        elements = (E[]) new Object[size];
        this.size = size;
    }

    void push(E element ) throws StackFullException {
        if (index >= size) {
            throw new StackFullException();
        }

        elements[index] = element;
        index++;
    }

    E pop () throws StackEmptyException {
        if (index == 0) {
            throw new StackEmptyException();
        }

        E returnElement = elements[index - 1];
        index--;
        return returnElement;
    }
}

class Queue<E> {
    private E[] elements;
    private int index = 0;
    private int size;

    Queue(int size) {
        elements = (E[]) new Object[size];
        this.size = size;
    }

    void enqueue(E element ) throws StackFullException {
        if (index >= size) {
            throw new StackFullException();
        }

        elements[index] = element;
        index++;
    }

    E dequeue () throws StackEmptyException {
        if (index == 0) {
            throw new StackEmptyException();
        }

        E returnElement = elements[this.size-index];
        index--;
        return returnElement;
    }
}


public class Main {
    public static void main(String[] agrs) {
        Stack<String> strings = new Stack<>(2);
        Queue<Integer> integers = new Queue<>(5);
        try {
            /*strings.push("Hello");
            strings.push("World");
            System.out.println(strings.pop());
            System.out.println(strings.pop());*/

            integers.enqueue(1);
            integers.enqueue(2);
            integers.enqueue(3);
            integers.enqueue(4);
            integers.enqueue(5);
            System.out.println(integers.dequeue());
            System.out.println(integers.dequeue());
            System.out.println(integers.dequeue());
            System.out.println(integers.dequeue());
            System.out.println(integers.dequeue());

        } catch (StackFullException | StackEmptyException e) {
            e.printStackTrace();
        }

    }
}