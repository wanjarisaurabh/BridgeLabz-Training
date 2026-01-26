package com.chatlogparser;

// generic interface to filter messages
public interface MessageFilter<T> {
    boolean shouldKeep(T message);
}