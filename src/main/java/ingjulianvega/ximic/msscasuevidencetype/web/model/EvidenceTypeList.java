package ingjulianvega.ximic.msscasuevidencetype.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EvidenceTypeList implements Serializable {

    static final long serialVersionUID = -8780904245399201053L;

    public ArrayList<EvidenceTypeDto> genderList;
}
