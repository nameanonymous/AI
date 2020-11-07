package transport;

public class SelectedTimeTableEntry {
    @Override
    public String toString() {
        return "SelectedTimeTableEntry{" +
                "timeTable=" + timeTable.getV() +
                ", timeTableEntry=" + timeTableEntry +
                '}';
    }

    TimeTable timeTable;
    TimeTableEntry timeTableEntry;

    public SelectedTimeTableEntry(TimeTable timeTable, TimeTableEntry timeTableEntry) {
        this.timeTable = timeTable;
        this.timeTableEntry = timeTableEntry;
    }

    public TimeTable getTimeTable() {
        return timeTable;
    }

    public TimeTableEntry getTimeTableEntry() {
        return timeTableEntry;
    }

}
