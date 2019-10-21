package ua.mycompany.stream;


import java.util.HashMap;
import java.util.Map;

public class FibonacciTask {
    private static Map<Integer, Long> countToValue = new HashMap<>(20);
    static
    {
        countToValue.put(0, 0L);
        countToValue.put(1, 1L);
        countToValue.put(2, 1L);
    }

    private static long fibonacci(int x)
    {
        return countToValue.computeIfAbsent(x, n -> fibonacci(n - 2) + fibonacci(n - 1));
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(6));
    }
}
