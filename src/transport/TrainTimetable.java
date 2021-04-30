/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transport;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Masaya Misaizu
 */
public class TrainTimetable extends PublicTransportTimeTable {

    public TrainTimetable(Settlement start, Settlement end, TimeTableEntry[] entry, int price, int distance) {
        super(Vehicle.TRAIN, start, end, entry, price, distance);
    }


}


