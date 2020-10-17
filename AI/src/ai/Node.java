package ai;
import transport.Settlement;
import transport.Time;
import transport.TrainTimetable;
import  transport.BusTimetable;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public Time getArrival() {
        return arrival;
    }

    public Node(Node parent, TrainTimetable Toperator, BusTimetable Boperator, Settlement settlement, Time arrival){
        this.parent = parent;
        this.Toperator = Toperator;
        this.Boperator = Boperator;
        this.settlement = settlement;
        this.arrival = arrival;
    }
    Node parent;
    TrainTimetable Toperator;
    BusTimetable Boperator;
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
                ", Toperator=" + Toperator +
                ", Boperator=" + Boperator +
                ", cost=" + cost +
                ", settlement=" + settlement +
                ", arrival=" + arrival +
                '}';
    }

    List<Node> successors(){
        ArrayList<Node> succ = new ArrayList<>();
        for (TrainTimetable te : TrainTimetable.TTB){
            if(te.getStart() == settlement && te.getDeparture().compareTo(arrival) >=0) {
                if (!isIncludeSettlement(te.getEnd())) {
                    Node n = new Node(this, te, null, te.getEnd(), te.getArrivalTT(arrival));
                    succ.add(n);
                }
            }
        }
        for (BusTimetable be : BusTimetable.BTB){
            if(be.getStart() == settlement && be.getDeparture().compareTo(arrival) >=0) {
                if (!isIncludeSettlement(be.getEnd())) {
                    Node n = new Node(this, null, be, be.getEnd(), be.getArrivalTB(arrival));
                    succ.add(n);
                }
            }
        }
            return succ;
        }

    }



