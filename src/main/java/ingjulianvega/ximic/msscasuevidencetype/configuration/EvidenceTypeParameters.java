package ingjulianvega.ximic.msscasuevidencetype.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "evidence-type")
public class EvidenceTypeParameters {

    private String api;
}
