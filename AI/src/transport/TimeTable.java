package transport;

import transport.Settlement;
import transport.Time;
import transport.Vehicle;

public interface TimeTable {
    public Vehicle getV();
    public Settlement getStart();
    public Settlement getEnd();
    public TimeTableEntry getNextTimeTableEntry(Time time);
    public int getPrice();
}
