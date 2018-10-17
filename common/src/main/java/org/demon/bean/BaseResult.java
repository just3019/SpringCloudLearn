package org.demon.bean;

import lombok.Data;


@Data
public class BaseResult<T> {
    private Integer status;
    private String msg;
    private T data;


}
