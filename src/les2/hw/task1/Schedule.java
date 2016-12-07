package les2.hw.task1;

import javax.xml.bind.*;
import javax.xml.bind.annotation.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by User on 07.12.2016.
 */

@XmlRootElement(name = "trains")
public class Schedule {
    @XmlElement(name = "train")
    private List<Train> trains;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Schedule:" + System.lineSeparator());
        for(Train train:trains){
            sb.append("\t" + train + System.lineSeparator());
        }
        return sb.toString();
    }

    public void showFilterList(){
        Date fromTime = null;
        Date toTime = null;

        SimpleDateFormat forDate = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat forTime = new SimpleDateFormat("HH:mm");
        try {
            fromTime = forTime.parse("15:05");
            toTime = forTime.parse("21:05");
        }catch (ParseException e){e.printStackTrace();}
        for (Train train:trains) {
            if((forDate.format(train.getDate()).equals(forDate.format(new Date())))&&
                    (train.getDeparture().after(fromTime) && train.getDeparture().before(toTime) )){
                System.out.println(train);
            }
        }
    }

    public void addTrainIntoXML(Train newTrain){
        StringWriter writer = new StringWriter();
        trains.add(newTrain);

        try {
            JAXBContext context = JAXBContext.newInstance(Schedule.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(newTrain, writer);
        }catch(JAXBException e){e.printStackTrace();}
    }
}
