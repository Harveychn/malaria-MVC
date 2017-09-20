package com.malaria.ssm.module.upload.pojo;

/**
 * Created by 郑晓辉 on 2016/10/6.
 */
public class RowDataSorted<T, F> {
    private Boolean hasError;
    private T correctData;
    private F errorData;

    public Boolean getHasError() {
        return hasError;
    }

    public void setHasError(Boolean hasError) {
        this.hasError = hasError;
    }

    public T getCorrectData() {
        return correctData;
    }

    public void setCorrectData(T correctData) {
        this.correctData = correctData;
    }

    public F getErrorData() {
        return errorData;
    }

    public void setErrorData(F errorData) {
        this.errorData = errorData;
    }
}
