import java.util.HashMap;
import java.util.Map;

public class Main {
    static String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
            "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut " +
            "enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut " +
            "aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit " +
            "in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur " +
            "sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt " +
            "mollit anim id est laborum.";

    public static void main(String[] args) {
        char[] allSymbols = text.toLowerCase().replaceAll("\\W", "").toCharArray();
        Map<Character, Integer> charMap = new HashMap<>();
        int countSymbol;

        for (char symbol : allSymbols) {
            if (charMap.containsKey(symbol)) {
                countSymbol = charMap.get(symbol) + 1;
                charMap.put(symbol, countSymbol);
            } else {
                charMap.put(symbol, 1);
            }
        }

        int maxValue = 0;
        int minValue = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> part : charMap.entrySet()) {
            Character key = part.getKey();
            Integer value = part.getValue();
            if (value > maxValue) {
                maxValue = value;
            } else if (value < minValue) {
                minValue = value;
            }
        }

        for (Character key : charMap.keySet()) {
            if (charMap.get(key) == maxValue) {
                System.out.println("Буква " + key + " встречается в тексте чаще всего, а именно: " + maxValue + " раз(а)");
            } else if (charMap.get(key) == minValue) {
                System.out.println("Буква " + key + " встречается в тексте реже всего, а именно: " + minValue + " раз(а)");
            }
        }
    }
}