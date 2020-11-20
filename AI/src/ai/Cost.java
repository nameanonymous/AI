package ai;

import transport.SelectedTimeTableEntry;
import transport.TimeTableEntry;

public interface Cost {
    public double cost(Node node, SelectedTimeTableEntry selectedTimeTableEntry);
}
