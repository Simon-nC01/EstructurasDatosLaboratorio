package com.unal.colas;

public interface MyQueue<T> {

    void enqueue(T x);

    T dequeue();

    T front();

    boolean isEmpty();

    int size();

    boolean delete(T n);
}