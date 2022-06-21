package com.bjpowernode.exception;

/**
 * @author cty
 * @date 2021/12/9 18:40
 */
public class CrmException extends RuntimeException{
    private CrmEnum crmEnum;

    public CrmException(CrmEnum crmEnum) {
        super(crmEnum.getMessage());
        this.crmEnum = crmEnum;
    }
}
