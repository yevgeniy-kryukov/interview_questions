package org.example;

class Account<I, S> {
    private final I id;
    private final S sum;

    Account(I id, S sum) {
        this.id = id;
        this.sum = sum;
    }

    public I getId() {
        return this.id;
    }

    public S getSum() {
        return this.sum;
    }

    public String toString() {
        return this.id + ": " + this.sum;
    }
}

public class Program1 {

    public static void main(String[] args) {
        Account<Integer, Integer> account1 = new Account<>(1, 10);
        Account<String, Double> account2 = new Account<>("2a", 250.55);
        System.out.println(account1);
        System.out.println(account2);
    }

}
