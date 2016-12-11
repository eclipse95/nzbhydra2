package org.nzbhydra.springconfig;

import com.sun.xml.internal.bind.marshaller.NamespacePrefixMapper;
import org.nzbhydra.mapping.NewznabNamespacePrefixMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import javax.xml.bind.Marshaller;
import java.util.HashMap;
import java.util.Map;


@Configuration
public class AppConfig {

    @Bean
    public NamespacePrefixMapper getNamespacePrefixMapper() {
        return new NewznabNamespacePrefixMapper();
    }

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        Map<String, Boolean> map = new HashMap<>();
                map.put(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.setMarshallerProperties(map);
        marshaller.setPackagesToScan("org.nzbhydra");
        return marshaller;
    }




}
