package com.bjpowernode.base.exception;

/**
 * @author cty
 * @date 2021/10/24 22:36
 */
public class CrmException extends RuntimeException {
    private CrmEnum crmEnum;

    public CrmException(CrmEnum crmEnum) {
        super(crmEnum.getMessage());
        this.crmEnum = crmEnum;
    }
}
