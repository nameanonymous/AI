package ai;
import transport.*;

import java.util.ArrayList;
import java.util.List;

public class Node {

    public Node(Node parent, SelectedTimeTableEntry selectedTimeTableEntry, Settlement settlement, Time arrival){
        this.parent = parent;
        this.settlement = settlement;
        this.selectedTimeTableEntry = selectedTimeTableEntry;
        this.arrival = arrival;
    }
    Node parent;
    SelectedTimeTableEntry selectedTimeTableEntry;
    double cost;
    Settlement settlement;
    Time arrival;

    public Time getArrival() {
        return arrival;
    }

    boolean isIncludeSettlement(Settlement s){
        if(settlement == s)
            return true;
        if(parent == null)
            return false;
        return parent.isIncludeSettlement(s);
        }




    List<Node> successors(){
        ArrayList<Node> succ = new ArrayList<>();
        for (TimeTable t : Data.TT){
            SelectedTimeTableEntry next = t.getNextTimeTableEntry(arrival);
            if(next != null){
            if(t.getStart() == settlement) {
                if (!isIncludeSettlement(t.getEnd())) {
                    Node n = new Node(this, next, t.getEnd(), next.getTimeTableEntry().getArrival());
                    succ.add(n);
                }
            }
            }
        }

            return succ;
        }

    }

