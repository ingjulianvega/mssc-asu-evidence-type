package ingjulianvega.ximic.msscasuevidencetype.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EvidenceType implements Serializable {

    static final long serialVersionUID = -7309482740220635006L;

    @NotBlank
    private String name;

}
