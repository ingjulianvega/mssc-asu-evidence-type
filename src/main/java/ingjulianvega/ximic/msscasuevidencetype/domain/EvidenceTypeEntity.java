package ingjulianvega.ximic.msscasuevidencetype.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class EvidenceTypeEntity extends BaseEntity {

    private String name;
}
