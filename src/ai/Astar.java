package ai;

import transport.SelectedTimeTableEntry;
import transport.Settlement;
import transport.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Astar{

    static List<SelectedTimeTableEntry> search(Settlement from,Settlement to,Time time,Cost cost) {
        Astarnode start  = new Astarnode(from,time,cost,to);
        LinkedList<Astarnode> frontier = new LinkedList<>();
        frontier.add(start);
        while (!frontier.isEmpty()) {
            Collections.sort(frontier);
            Astarnode selected = frontier.removeFirst();
            if ( selected.settlement == to ) {
                ArrayList<SelectedTimeTableEntry> result = new ArrayList<>();
                while (selected.parent != null ) {
                    result.add(0, selected.selectedTimeTableEntry);
                    selected = selected.parent;
                }
                return result;
            }
            for ( Astarnode n : selected.successors() )
                frontier.add(n);
        }
        return null;
    }}