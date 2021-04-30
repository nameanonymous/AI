package ai;

import transport.SelectedTimeTableEntry;
import transport.Settlement;
import transport.TimeTableEntry;

public interface Cost {
    public double cost(Node node, SelectedTimeTableEntry selectedTimeTableEntry);
    public double estimation(Node node, Settlement target);

}
