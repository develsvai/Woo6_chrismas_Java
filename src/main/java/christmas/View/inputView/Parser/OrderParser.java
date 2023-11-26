package christmas.View.inputView.Parser;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderParser {
    private static final String SEPARATOR = ",";

    public static List<Map.Entry<String, Integer>> parseMenus(String input) {
        return Arrays.stream(input.split(SEPARATOR))
                .map(item -> {
                    String[] parts = item.trim().split(" ");
                    return new AbstractMap.SimpleEntry<>(parts[0], Integer.parseInt(parts[1]));
                })
                .collect(Collectors.toList());
    }

}
