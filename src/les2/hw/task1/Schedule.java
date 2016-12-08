package les2.hw.task1;

import javax.xml.bind.annotation.*;
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

    public List<Train> getTrains() {
        return trains;
    }
}
