package ai;

import transport.SelectedTimeTableEntry;
import transport.Settlement;
import transport.TimeTable;

import java.util.Arrays;

public class CostBasedOnPrice implements Cost{
    public double cost(Node node, SelectedTimeTableEntry selectedTimeTableEntry){
        return selectedTimeTableEntry.getTimeTable().getPrice();
    }

    public double estimation(Node node, Settlement target){
        return costBasedOnDistance.estimation(node,target)*Data.HUFperkm;
         }

    private CostBasedOnDistance costBasedOnDistance = new CostBasedOnDistance();

}
