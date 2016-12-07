package les2.hw.task1;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by User on 07.12.2016.
 */
public class AdapterForDate extends XmlAdapter<String, Date> {
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yy");

    @Override
    public Date unmarshal(String v) throws Exception {
        return simpleDateFormat.parse(v);
    }

    @Override
    public String marshal(Date v) throws Exception {
        return simpleDateFormat.format(v);
    }
}
