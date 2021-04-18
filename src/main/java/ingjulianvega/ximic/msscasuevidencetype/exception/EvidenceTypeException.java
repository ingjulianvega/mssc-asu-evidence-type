package ingjulianvega.ximic.msscasuevidencetype.exception;

import lombok.Getter;

@Getter
public class EvidenceTypeException extends RuntimeException {

    private final String code;

    public EvidenceTypeException(final String code, final String message) {
        super(message);
        this.code = code;
    }
}

