/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transport;

import java.util.Map;

/**
 *
 * @author Masaya Misaizu
// */
public class BusTimetable extends PublicTransportTimeTable {

    public BusTimetable(Settlement start, Settlement end, TimeTableEntry[] entry, int price, int distance) {
        super(Vehicle.BUS,start,end, entry,price,distance);
    }

}