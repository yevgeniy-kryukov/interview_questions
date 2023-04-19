package org.example;

import java.io.IOException;

public class ExceptionsSample {
    class Parent {
        public int f(int i, int j) throws IOException, InterruptedException {
            return i + j;
        }
    }
    class Child extends Parent {
        @Override
        public int f(int i, int j) throws IOException, InterruptedException {
            return (i * j) + 1;
        }
    }

    public int calc(int i, int j) throws IOException, InterruptedException {
         return new Child().f(i, j);
    }
}
