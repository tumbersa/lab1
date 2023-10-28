package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Container<String> test = new Container<>();
        test.add("l");
        test.add("e");
        test.add("n");
        test.add("'");
        System.out.println(test);
        Container<Integer> test2 = new Container<>();
        test2.add(11);
        test2.add(11);
        test2.add(322);
        test2.add(25);
        System.out.println(test2);
    }
}