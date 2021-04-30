package ai;

import transport.*;



public class Astarnode extends Node<Astarnode> implements Comparable<Astarnode>{

    Cost cost;
    double past,future;
    Settlement target;
    //Starting point(non-parent)
    public Astarnode(Settlement settlement, Time arrival, Cost cost,Settlement target){
        super(settlement, arrival);
        this.cost = cost;
        this.future = cost.estimation(this,target);
        this.past = 0;
        this.target = target;
    }
    //Others(parent exists)
    public Astarnode(Astarnode parent, SelectedTimeTableEntry selectedTimeTableEntry, Cost cost,Settlement target){
        super(parent, selectedTimeTableEntry);
        this.future = cost.estimation(this,target);
        this.past = parent.past + cost.cost(parent,selectedTimeTableEntry);
        this.target = target;
    }


    public Astarnode createchild(SelectedTimeTableEntry selectedTimeTableEntry){
        System.out.println("B");
        return new Astarnode(this,selectedTimeTableEntry, cost,target);
    };


    @Override
    public int compareTo(Astarnode o) {
        if(this.future+this.past > o.future+o.past){
            return 1;
        }
        else if(this.future+this.past < o.future+o.past){
            return -1;
        }
        return 0;
    }

/*    List<Astarnode> successors(Cost cost){
        ArrayList<Astarnode> succ = new ArrayList<>();
        for (TimeTable t : Data.TT){
            SelectedTimeTableEntry next = t.getNextTimeTableEntry(arrival);
            if(next != null){
                if(t.getStart() == settlement) {
                    if (!isIncludeSettlement(t.getEnd())) {
                        Astarnode n = new Astarnode(this, next, cost,target);
                        succ.add(n);
                    }
                }
            }
        }

        return succ;
    }
*/
    /*
    @Override
    public double cost(Node node, SelectedTimeTableEntry selectedTimeTableEntry) {
        double cost = new CostBasedOnDistance().cost(node, selectedTimeTableEntry);//For Distance
        return cost;
    }

    @Override
    public double estimation(Node node, Settlement target) {
        double estimation = new CostBasedOnDistance().estimation(node, target);//For distance
        return estimation;
    }*/
}
