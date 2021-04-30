package ai;

import transport.SelectedTimeTableEntry;
import transport.Settlement;

public class CostBasedOnDistance implements Cost {
    @Override
    public double cost(Node node, SelectedTimeTableEntry selectedTimeTableEntry){
        System.out.println(node + " " +selectedTimeTableEntry.getTimeTable().getDistance());
            return selectedTimeTableEntry.getTimeTable().getDistance();
    }
    @Override
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
