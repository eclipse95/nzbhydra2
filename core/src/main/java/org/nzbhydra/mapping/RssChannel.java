package org.nzbhydra.mapping;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class RssChannel {

    private String title;
    private String description;
    private String link;
    private String language;
    private String webMaster;

    @XmlElement(name="response", namespace="http://www.newznab.com/DTD/2010/feeds/attributes/")
    private NewznabResponse newznabResponse;


    @XmlElement(name="item")
    private List<RssItem> items;


}
