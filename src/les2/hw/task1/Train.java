package les2.hw.task1;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by User on 07.12.2016.
 */


@XmlRootElement(name = "train")
public class Train {

    private String from;
    private String to;

    private Date date;
    private Date departure;

    public Train() {
    }

    public Train( String from, String to, Date date, Date departure) {
        this.from = from;
        this.to = to;
        this.date = date;
        this.departure = departure;
    }


    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Date getDate() {
        return date;
    }

    @XmlJavaTypeAdapter(AdapterForDate.class)
    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDeparture() {
        return departure;
    }

    @XmlJavaTypeAdapter(AdapterForTime.class)
    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    @Override
    public String toString() {
        SimpleDateFormat forDate = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat forTime = new SimpleDateFormat("HH:mm");
        return "Train{" + from + " - " + to + "  " + forDate.format(date) + " " + forTime.format(departure) + '}';
    }
}
