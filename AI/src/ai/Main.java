package ai;
import ai.Node;
import  transport.*;
import transport.Time;

import java.util.Collections;
import java.util.Comparator;
import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        Time a = new Time(6,00);
       Node n = new Node(null,null,Settlement.Budapest,a);
       for (int i = 0;i< n.successors().toArray().length;i++)
           System.out.println(n.successors().get(i));
        System.out.println(" ");
//       Collections.sort(n.successors(),new SortbyDepTime());
//        for (int i = 0;i< n.successors().toArray().length;i++)
//            System.out.println(n.successors().get(i).getArrival().getMinute());
        //1st:IF the arrival time should be considered what should we do?

        //2nd:

        //3rd: Comparison between existing solution (eg. Google Map etc) written in 3-5 pages.-> Explain why did u use java.New java function can be explained also.
        //
    }
}
//
//class SortbyDepTime implements Comparator<Node> {
//    @Override
//    public int compare(Node a,Node b){
//        return a.getTimeTable().get;
//                }
//    }
