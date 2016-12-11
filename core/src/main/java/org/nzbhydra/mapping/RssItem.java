package org.nzbhydra.mapping;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.Instant;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="item")
@Data
public class RssItem {


    @XmlElement(name = "title")
    private String title;

    @XmlElement(name = "link")
    private String link;

    @XmlElement(name = "pubDate")
    @XmlJavaTypeAdapter(JaxbPubdateAdapter.class)
    private Instant pubDate;

    @XmlElement(name= "guid")
    private RssGuid rssGuid;

    @XmlElement(name = "attr", namespace="http://www.newznab.com/DTD/2010/feeds/attributes/")
    private List<NewznabAttribute> attributes;

}
