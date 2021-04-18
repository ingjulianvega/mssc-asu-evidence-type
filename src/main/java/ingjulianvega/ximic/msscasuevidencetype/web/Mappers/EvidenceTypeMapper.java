package ingjulianvega.ximic.msscasuevidencetype.web.Mappers;


import ingjulianvega.ximic.msscasuevidencetype.domain.EvidenceTypeEntity;
import ingjulianvega.ximic.msscasuevidencetype.web.model.EvidenceTypeDto;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(uses = DateMapper.class)
public interface EvidenceTypeMapper {
    EvidenceTypeDto evidenceTypeEntityToEvidenceTypeDto(EvidenceTypeEntity evidenceEntity);

    EvidenceTypeEntity evidenceTypeDtoToEvidenceTypeEntity(EvidenceTypeDto evidenceDto);

    ArrayList<EvidenceTypeDto> evidenceTypeEntityListToEvidenceTypeDtoList(List<EvidenceTypeEntity> evidenceEntityList);
}
