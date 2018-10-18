package org.demon.exception;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class BusinessException extends RuntimeException {

    @Getter
    @Setter
    private Integer code;

    public BusinessException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

}
