package christmas.View.inputView.Parser;

import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OrderParser {
    private static final String SEPARATOR = ",";
    private static final String CONNECTOR = "-";

    public static List<SimpleEntry<String, Integer>> parseMenus(String input) {
        return Arrays.stream(input.split(SEPARATOR))
                .map(item -> {
                    String[] parts = item.trim().split(CONNECTOR);
                    return new SimpleEntry<>(parts[0], Integer.parseInt(parts[1]));
                })
                .collect(Collectors.toList());
    }

}
