package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionsSample {
    class Parent {
        public int f(int i, int j) throws RuntimeException {
            return i + j;
        }
    }
    class Child extends Parent  {
        @Override
        public int f(int i, int j) throws ArithmeticException {
            return (i * j) + 1;
        }
    }

    public int calc(int i, int j)  {
         return new Child().f(i, j);
    }
}
