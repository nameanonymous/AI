    package ai;
    import transport.*;
    
    import java.util.ArrayList;
    import java.util.List;
    
    abstract public class Node<T extends Node> {

        //For starting point (Node)
        public Node(Settlement settlement, Time arrival){
            this.settlement = settlement;
            this.arrival = arrival;
        }
        //Other usual Nodes
        public Node(T parent, SelectedTimeTableEntry selectedTimeTableEntry){
            this.parent = parent;
            this.settlement = selectedTimeTableEntry.getTimeTable().getEnd();
            this.selectedTimeTableEntry = selectedTimeTableEntry;
            this.arrival = selectedTimeTableEntry.getTimeTableEntry().getArrival();
        }
    
    
        T parent;
        SelectedTimeTableEntry selectedTimeTableEntry;
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

    abstract public T createchild(SelectedTimeTableEntry selectedTimeTableEntry);

    List<T> successors(){
        ArrayList<T> succ = new ArrayList<>();
        for (TimeTable t : Data.TT){
            SelectedTimeTableEntry next = t.getNextTimeTableEntry(arrival);
            if(next != null){
                if(t.getStart() == settlement) {
                    if (!isIncludeSettlement(t.getEnd())) {
                        System.out.println("E");
                        T n = createchild(next);
                        succ.add(n);
                    }
                }
            }
        }
        return succ;
    }


    }

