package ai;
import transport.Settlement;
import transport.Time;
import transport.TrainTimetable;
import  transport.BusTimetable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Node {
    public Node(Node parent,TrainTimetable Toperator,BusTimetable Boperator,Settlement settlement,Time arrival){
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

        List<Node> successors(){
        ArrayList<Node> succ = new ArrayList<>();
        for (TrainTimetable te : TrainTimetable.TTB){
            if(!isIncludeSettlement(te.getEnd())){
                Node n = new Node(this,te,null,te.getEnd(),te.getArrivalTT(arrival));
                succ.add(n);
            }
        }
        for (BusTimetable be : BusTimetable.BTB){
            if(!isIncludeSettlement(be.getEnd())){
                Node n = new Node(this,null,be,be.getEnd(),be.getArrivalTB(arrival));
            }
        }
            return succ;
        }

    }



