package les2.hw.task3;

import javax.xml.bind.annotation.XmlElement;

public class Query {
    public int count;
    public String created;
    public String lang;
    @XmlElement
    public Results results;
}
