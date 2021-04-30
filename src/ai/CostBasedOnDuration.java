package ai;

import transport.SelectedTimeTableEntry;
import transport.Settlement;

public class CostBasedOnDuration implements Cost {

    public double cost(Node node, SelectedTimeTableEntry selectedTimeTableEntry){
          return  selectedTimeTableEntry.getTimeTableEntry().getDeparture().getMinute()-selectedTimeTableEntry.getTimeTableEntry().getArrival().getMinute();
    }
    private CostBasedOnDistance costBasedOnDistance = new CostBasedOnDistance();

    public double estimation(Node node, Settlement target){
        return costBasedOnDistance.estimation(node,target);
    }

}
