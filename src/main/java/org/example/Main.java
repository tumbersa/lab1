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
        test.removeValue("e");
        test.removeIndex(3);
        System.out.println(test);
        System.out.println(test.size());
        System.out.println(test.get(0));
        Container<Integer> test2 = new Container<>();
        test2.add(11);
        test2.add(11);
        test2.add(322);
        System.out.println(test2);
    }
}