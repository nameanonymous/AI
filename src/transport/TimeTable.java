package transport;

        import transport.Settlement;
        import transport.Time;
        import transport.Vehicle;

public interface TimeTable {
    public Vehicle getV();//Get the vhhicle type
    public Settlement getStart();//Get Currenct location
    public Settlement getEnd();//Get Destination
    public SelectedTimeTableEntry getNextTimeTableEntry(Time time);//Get the closest time which is next to the input time from timetable.
    public double getDistance();
    public int getPrice();//Get the price/cost
    public default double getPriceperKm(){return getPrice()/getDistance();}
}
