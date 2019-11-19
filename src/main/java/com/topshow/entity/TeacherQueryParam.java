package com.topshow.entity;

public class TeacherQueryParam {
    private String keyType;
    private String keyWord;

    public String getKeyType() {
        return this.keyType;
    }

    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }

    public String getKeyWord() {
        return this.keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String toString() {
        return "UserQueryParam [keyType=" + this.keyType + ", keyWord=" + this.keyWord + "]";
    }
}
