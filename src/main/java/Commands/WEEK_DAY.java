package Commands;

public enum WEEK_DAY {
    MONDAY("Понедельник"), TUESDAY("Вторник"), WEDNESDAY("Среда"), THURSDAY("Четверг"), FRIDAY("Пятница"), SATURDAY("Суббота");
    private String description;

    WEEK_DAY(String day) {
        description = day;
    }

    public String getDescription() {
        return description;
    }
}
