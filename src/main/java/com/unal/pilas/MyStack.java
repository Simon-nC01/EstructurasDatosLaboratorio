package com.unal.pilas;

public interface MyStack<T> {

    void push(T x);

    T pop();

    T peek();

    boolean isEmpty();

    int size();

    boolean delete(T n);
}