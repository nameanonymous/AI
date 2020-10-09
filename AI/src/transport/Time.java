package transport;

public class Time  implements Comparable<Time> {

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
}
