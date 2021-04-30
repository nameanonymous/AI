package ai;

import transport.*;
import java.util.Arrays;

public class Data {
    public static TimeTable[] TT = {
            new TrainTimetable( Settlement.Budapest, Settlement.Debrecen, new TimeTableEntry[]{
                    new TimeTableEntry(new Time(6,23),new Time(8,48)),
                    new TimeTableEntry(new Time(7,23),new Time(9,48)),
                    new TimeTableEntry(new Time(8,23),new Time(10,48)),

            }, 5100,220),//InterCity
            new TrainTimetable(Settlement.Budapest,Settlement.Debrecen,new TimeTableEntry[]{
                    new TimeTableEntry(new Time(6,34),new Time(9,21)),
                    new TimeTableEntry(new Time(8,34),new Time(11,22)),
            },3600,220),//Local
            new BusTimetable(Settlement.Budapest, Settlement.Eger,new TimeTableEntry[]{
                    new TimeTableEntry(new Time(8,23),new Time(10,23)),
                    new TimeTableEntry(new Time(9,23),new Time(11,23))
            }, 5100, 120),//Bus
            new CarTimetable(Settlement.Budapest,Settlement.Debrecen,6000,230,150)
    };
    public static Settlement settlements[] = { Settlement.Budapest, Settlement.Debrecen, Settlement.Eger };
    public static double FromTo[][] = {
            {0,194.14,109.42},//Budapest/Budapest,Debrecen,Eger
            {194.14,0,102.30},//Debrecen/
            {109.42,102.30,0}//Eger/
    };
    public static double HUFperkm = Arrays.stream(TT).mapToDouble(TimeTable::getPriceperKm).min().getAsDouble();

}
