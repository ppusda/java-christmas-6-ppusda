package christmas.system;

public enum Badge {
    NONE("없음", 0),
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000);

    Badge(String name, int conditionAmount) {
        this.name = name;
        this.conditionAmount = conditionAmount;
    }

    public String getName() {
        return name;
    }

    public int getConditionAmount() {
        return conditionAmount;
    }

    private final String name;
    private final int conditionAmount;
}
