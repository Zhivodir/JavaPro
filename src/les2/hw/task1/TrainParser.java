package les2.hw.task1;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by User on 07.12.2016.
 */
public class TrainParser {

    public static void main(String[] args) {
        String content = readFromFile("c:/DevKit/Temp/trains1.xml");
        StringReader reader = new StringReader(content);

        try {
            JAXBContext context = JAXBContext.newInstance(Train.class, Schedule.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            Schedule schedule = (Schedule) unmarshaller.unmarshal(reader);
            System.out.println(schedule);
            schedule.showFilterList();

            SimpleDateFormat forDate = new SimpleDateFormat("dd.MM.yyyy");
            SimpleDateFormat forTime = new SimpleDateFormat("HH:mm");

            schedule.addTrainIntoXML(new Train("Uman", "Kiev", forDate.parse("07.12.2016"), forTime.parse("20:05")));
            schedule = (Schedule) unmarshaller.unmarshal(reader);
            System.out.println(schedule);
        }catch(JAXBException e){e.printStackTrace();}
        catch (ParseException e){e.printStackTrace();}
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
}
