package ua.orlov.fintechtransaction.model;

import java.util.Set;

public enum Category {
    FOOD, TRANSPORT, UNCATEGORIZED;

    private static final Set<String> FOOD_KEYWORDS = Set.of("coffee", "starbucks", "sushi", "pizza");
    private static final Set<String> TRANSPORT_KEYWORDS = Set.of("plane", "train", "car", "taxi");

    public static Category fromDescription(String inputString) {
        String[] words = inputString.split(" ");

        Category category = UNCATEGORIZED;

        for (String word : words) {
            if (FOOD_KEYWORDS.contains(word)) {
                category = FOOD;
                break;
            } else if (TRANSPORT_KEYWORDS.contains(word)) {
                category = TRANSPORT;
                break;
            }
        }

        return category;
    }

    public static Category fromString(String inputString) {
        return switch (inputString.toLowerCase()) {
            case "food" -> FOOD;
            case "transport" -> TRANSPORT;
            default -> UNCATEGORIZED;
        };
    }
}
