package ai;

import transport.SelectedTimeTableEntry;
import transport.Settlement;
import transport.Time;
import transport.TimeTable;

import java.util.ArrayList;
import java.util.List;

public class Astarnode extends Node{
    double cost;
    public Astarnode(Node parent, SelectedTimeTableEntry selectedTimeTableEntry, Settlement settlement, Time arrival,double cost){
        super(parent, selectedTimeTableEntry, settlement, arrival);
        this.cost = cost;
    }

    List<Astarnode> successors(Cost cost){
        ArrayList<Astarnode> succ = new ArrayList<>();
        for (TimeTable t : Data.TT){
            SelectedTimeTableEntry next = t.getNextTimeTableEntry(arrival);
            if(next != null){
                if(t.getStart() == settlement) {
                    if (!isIncludeSettlement(t.getEnd())) {
                        Astarnode n = new Astarnode(this, next, t.getEnd(), next.getTimeTableEntry().getArrival(), this.cost+cost.cost(this,next));
                        succ.add(n);
                    }
                }
            }
        }

        return succ;
    }
}
