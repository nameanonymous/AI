package transport;

public class Time  implements Comparable<Time> {
    @Override
    public String toString() {
        return
                "Time:" + " " + minute/60 +":" + minute%60;
    }

    public int getMinute() {
        return minute;
    }

    int minute;

    public Time(int hour, int minute) {
        this.minute = hour * 60 + minute;
    }

    Time(int minute) {
        this.minute = minute;
    }

    Time add(int minutes) {
        return new Time(this.minute + minutes);
    }

    @Override
    public int compareTo(Time o) {
        return minute - ((Time)o).minute;
    }
}//How to compare between 23 oclock and 0 oclock?
