package pages.factory;

public enum City {
    SPB("Санкт-Петербург"),
    KAZAN("Казань");

    private final String displayName;

    City(String displayName) {
        this.displayName = displayName;
    }
}
