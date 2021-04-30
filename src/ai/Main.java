package ai;

import  transport.*;
import transport.Time;

import java.util.*;

import static java.lang.Integer.parseInt;


public class Main {
    public static void main(String[] args) {
        System.out.println("Put the value when you want to start");
        Scanner scan = new Scanner(System.in);
        System.out.println("Hour: ");
        String str1 = scan.next();
        System.out.println("Minute: ");
        String str2 = scan.next();
        int hour = parseInt(str1);
        System.out.println(hour);
        int minute = parseInt(str2);
        System.out.println(minute);
        if(hour > 24 || minute > 60 || minute < 0){
            System.out.println("THE VALUE IS NOT VALID!");
        }
        else{
            try{
                Time a = new Time(hour,minute);
                System.out.println("Which do you prefer?: Distance | Price | Duration");
                Scanner scan2 = new Scanner(System.in);
                String str3 = scan2.next();
                Cost cost = switch (str3){
                    case "Distance" ->  new CostBasedOnDistance();
                    case "Price" ->  new CostBasedOnPrice();
                    case "Duration" ->  new CostBasedOnDuration();
                    default -> throw new IllegalStateException("Unexpected value");
                };

                System.out.println(Astar.search(Settlement.Budapest,Settlement.Debrecen,a,cost));
            }
            catch (Exception ex){
                System.out.println(ex);
            }
        }
//        Time a = new Time(7,00);
//        Node n = new SimpleNode(Settlement.Budapest,a);
//        Cost cost = new CostBasedOnPrice();
//        for (int i = 0;i< n.successors().toArray().length;i++)
//           System.out.println(n.successors().get(i));































//       Collections.sort(n.successors(),new SortbyDepTime());
//        for (int i = 0;i< n.successors().toArray().length;i++)
//            System.out.println(n.successors().get(i).getArrival().getMinute());
        //1st:IF the arrival time should be considered what should we do?

        //2nd:

        //3rd: Comparison between existing solution (eg. Google Map etc) written in 3-5 pages.-> Explain why did u use java.New java function can be explained also.
        //
    }
//Create the reverse timetable
    /*
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
    }*/
}

/*
class SimpleNode extends Node<SimpleNode> {
    SimpleNode(Settlement start, Time departure) {
        super(start, departure);
        System.out.println("C");
    }

    private SimpleNode(SimpleNode parent, SelectedTimeTableEntry selectedTimeTableEntry) {
        super(parent, selectedTimeTableEntry);
        System.out.println("D");
    }

    public SimpleNode createchild(SelectedTimeTableEntry selectedTimeTableEntry) {
        System.out.println("A");
        return new SimpleNode(this, selectedTimeTableEntry);
    }
}
*/
