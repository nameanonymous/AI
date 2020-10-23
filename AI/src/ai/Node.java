package ai;
import transport.*;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public Time getArrival() {
        return arrival;
    }

    public Node(Node parent, TimeTable timeTable, Settlement settlement, Time arrival){
        this.parent = parent;
        this.timeTable = timeTable;
        this.settlement = settlement;
        this.arrival = arrival;
    }
    Node parent;
    TimeTable timeTable;
    double cost;
    Settlement settlement;
    Time arrival;

    boolean isIncludeSettlement(Settlement s){
        if(settlement == s)
            return true;
        if(parent == null)
            return false;
        return parent.isIncludeSettlement(s);
        }

    @Override
    public String toString() {
        return "Node{" +
                "parent=" + parent +
                ", timeTable=" + timeTable +
                ", cost=" + cost +
                ", settlement=" + settlement +
                ", arrival=" + arrival +
                '}';
    }

    public TimeTable getTimeTable() {
        return timeTable;
    }

    List<Node> successors(){
        ArrayList<Node> succ = new ArrayList<>();
        for (TimeTable t : Data.TT){
            TimeTableEntry next = t.getNextTimeTableEntry(arrival);
            if(next != null){
            if(t.getStart() == settlement) {
                if (!isIncludeSettlement(t.getEnd())) {
                    Node n = new Node(this, t, t.getEnd(), next.getArrival());
                    succ.add(n);
                }
            }
            }
        }

            return succ;
        }

    }

