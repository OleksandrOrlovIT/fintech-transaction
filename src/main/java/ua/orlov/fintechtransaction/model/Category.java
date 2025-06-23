package ua.orlov.fintechtransaction.model;

public enum Category {
    FOOD, TRANSPORT, UNCATEGORIZED;

    public static Category fromString(String inputString) {
        return switch (inputString.toLowerCase()) {
            case "food" -> FOOD;
            case "transport" -> TRANSPORT;
            default -> UNCATEGORIZED;
        };
    }
}
