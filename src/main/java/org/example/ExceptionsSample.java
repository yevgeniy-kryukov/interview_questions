package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionsSample {
    class Parent {
        public void f() throws IOException {
        }
    }
    class Child extends Parent  {
        @Override
        public void f() throws FileNotFoundException {
            throw new RuntimeException("Child RuntimeException");
        }
    }

    public boolean run() throws FileNotFoundException {
         new Child().f();
         return true;
    }
}
