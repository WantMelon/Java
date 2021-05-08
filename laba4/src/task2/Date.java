package task2;

public class Date {
    int day;
    int month;
    int year;

    public Date(int year, int month, int day) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Date(String date) {
        String[] dateArr = date.split(":");
        year = Integer.parseInt(dateArr[0]);
        month = Integer.parseInt(dateArr[1]);
        day = Integer.parseInt(dateArr[2]);
    }

    @Override
    public String toString() {
        return year + ":" + month + ":" + day;
    }
}
