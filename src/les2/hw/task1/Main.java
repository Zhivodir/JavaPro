package les2.hw.task1;

import java.text.ParseException;

/**
 * Created by User on 07.12.2016.
 */
public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        service.getSchedule();
        service.showFilterList();

        try{
        service.addTrainIntoXML(
                new Train("Uman", "Kiev",
                        service.getForDate().parse("07.12.2016"),
                        service.getForTime().parse("20:05")));

        }catch (ParseException e){e.printStackTrace();}
        service.getSchedule();
        service.showFilterList();
    }
}
