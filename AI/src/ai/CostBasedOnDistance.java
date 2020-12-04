package ai;

import transport.SelectedTimeTableEntry;
import transport.Settlement;

public class CostBasedOnDistance implements Cost {

    public double cost(Node node, SelectedTimeTableEntry selectedTimeTableEntry){
            return selectedTimeTableEntry.getTimeTable().getDistance();
    }
    public double estimation(Node node, Settlement target){
        int from = -1, to = -1;

        for ( int i=0; i<=Data.settlements.length; i++) {

            if ( Data.settlements[i] == node.settlement)
                from = i;
            if (Data.settlements[i] == target)
                to = i;
            if ( from != -1 && to !=-1 )
                return Data.FromTo[from][to];
            
        }
        throw new IllegalStateException("Settlement not found!");

    }

}
