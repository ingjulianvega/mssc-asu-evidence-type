package ingjulianvega.ximic.msscasuevidencetype.services;


import ingjulianvega.ximic.msscasuevidencetype.web.model.EvidenceType;
import ingjulianvega.ximic.msscasuevidencetype.web.model.EvidenceTypeDto;
import ingjulianvega.ximic.msscasuevidencetype.web.model.EvidenceTypeList;

import java.util.UUID;

public interface EvidenceTypeService {
    EvidenceTypeList get();

    EvidenceTypeDto getById(UUID id);

    void create(EvidenceType evidence);

    void updateById(UUID id, EvidenceType evidence);

    void deleteById(UUID id);
}
