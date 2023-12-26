package Game.domain;

public class Item {
    private final String name;
    private final int currencyValue;
    private final String description;

    public Item(String name, int currencyValue, String description) {
        this.name = name;
        this.currencyValue = currencyValue;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public int getValue() {
        return this.currencyValue;
    }

    public String getDescription() {
        return this.description;
    }
}
