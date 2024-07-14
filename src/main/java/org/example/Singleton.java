package org.example;

public class Singleton {
    private volatile Singleton instance;

    private void Singleton() {
    }

    public Singleton getInstance() {
        if (instance == null) {
            synchronized (this) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
