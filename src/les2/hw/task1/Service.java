package les2.hw.task1;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by User on 07.12.2016.
 */
public class Service {
    private Schedule schedule;
    private final SimpleDateFormat forDate = new SimpleDateFormat("dd.MM.yyyy");
    private final SimpleDateFormat forTime = new SimpleDateFormat("HH:mm");

    public Service() {
        unmarshalling();
    }

    public Schedule unmarshalling(){
        String content = readFromFile("c:/DevKit/Temp/trains1.xml");
        StringReader reader = new StringReader(content);
        try {
            JAXBContext context = JAXBContext.newInstance(Train.class, Schedule.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            schedule = (Schedule) unmarshaller.unmarshal(reader);
        }catch(JAXBException e){e.printStackTrace();}
        return schedule;
    }

    public void showFilterList(){
        Date fromTime = null;
        Date toTime = null;

        try {
            fromTime = forTime.parse("15:00");
            toTime = forTime.parse("21:00");
        }catch (ParseException e){e.printStackTrace();}
        for (Train train : schedule.getTrains()) {
            if((forDate.format(train.getDate()).equals(forDate.format(new Date())))&&
                    (train.getDeparture().after(fromTime) && train.getDeparture().before(toTime) )){
                System.out.println(train);
            }
        }
    }

    public void addTrainIntoXML(Train newTrain){
        StringWriter writer = new StringWriter();
        schedule.getTrains().add(newTrain);
        try {
            JAXBContext context = JAXBContext.newInstance(Schedule.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(newTrain, writer);
        }catch(JAXBException e){e.printStackTrace();}
    }

    public static String readFromFile(String path){
        StringBuilder sb = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            String text;
            while((text = reader.readLine()) != null  ) {
                sb.append(text);
            }
        } catch(IOException e){ e.printStackTrace(); }
        return sb.toString();
    }

    public void getSchedule() {
        System.out.println(schedule);
    }

    public SimpleDateFormat getForDate() {
        return forDate;
    }

    public SimpleDateFormat getForTime() {
        return forTime;
    }
}
