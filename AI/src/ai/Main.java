package ai;

import  transport.*;
import transport.Time;

import java.util.*;

class SimpleNode extends Node<SimpleNode> {
    SimpleNode(Settlement start, Time departure) {
        super(start, departure);
    }

    private SimpleNode(SimpleNode parent, SelectedTimeTableEntry selectedTimeTableEntry) {
        super(parent, selectedTimeTableEntry);
    }

    public SimpleNode createchild(SelectedTimeTableEntry selectedTimeTableEntry) {
        return new SimpleNode(this, selectedTimeTableEntry);
    }
}

public class Main {
    public static void main(String[] args) {
        Time a = new Time(6,00);
       Node n = new SimpleNode(Settlement.Budapest,a);
       for (int i = 0;i< n.successors().toArray().length;i++)
           System.out.println(n.successors().get(i));
        System.out.println(" ");
        System.out.println(search(Settlement.Budapest,Settlement.Debrecen,a));

//       Collections.sort(n.successors(),new SortbyDepTime());
//        for (int i = 0;i< n.successors().toArray().length;i++)
//            System.out.println(n.successors().get(i).getArrival().getMinute());
        //1st:IF the arrival time should be considered what should we do?

        //2nd:

        //3rd: Comparison between existing solution (eg. Google Map etc) written in 3-5 pages.-> Explain why did u use java.New java function can be explained also.
        //
    }
//Create the reverse timetable

    static List<SelectedTimeTableEntry> search(Settlement from,Settlement to,Time time) {



        SimpleNode start  = new SimpleNode(from, time);
        LinkedList<SimpleNode> frontier = new LinkedList<>();
        frontier.add(start);

        while (!frontier.isEmpty()) {
            SimpleNode selected = frontier.removeFirst();
            if ( selected.settlement == to ) {
                ArrayList<SelectedTimeTableEntry> result = new ArrayList<>();
                while (selected.parent != null ) {
                    result.add(0, selected.selectedTimeTableEntry);
                    selected = selected.parent;
                }
                return result;
            }
            System.out.println(selected.successors().size());
            for ( SimpleNode n: selected.successors() )
                frontier.add(n);
        }
        return null;
    }}
////
//class SortbyDepTime implements Comparator<Node> {
//    @Override
//    public int compare(Node a,Node b){
//        if()
//                }
//    }
