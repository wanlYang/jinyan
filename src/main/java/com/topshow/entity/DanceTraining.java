package com.topshow.entity;

/**
 * 培训舞蹈项目实体类
 * @author Administrator
 *
 */
public class DanceTraining {
    
    //ID
    private String id;
    //英文名字
    private String englishName;
    //舞蹈名称
    private String danceName;
    //舞蹈图片
    private String danceImg;
    //舞蹈简介
    private String danceDetail;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDanceName() {
        return danceName;
    }
    public void setDanceName(String danceName) {
        this.danceName = danceName;
    }
    public String getDanceImg() {
        return danceImg;
    }
    public void setDanceImg(String danceImg) {
        this.danceImg = danceImg;
    }
    public String getDanceDetail() {
        return danceDetail;
    }
    public void setDanceDetail(String danceDetail) {
        this.danceDetail = danceDetail;
    }
    public String getEnglishName() {
        return englishName;
    }
    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }
    @Override
    public String toString() {
        return "DanceTraining [id=" + id + ", englishName=" + englishName + ", danceName=" + danceName + ", danceImg="
                + danceImg + ", danceDetail=" + danceDetail + "]";
    }
    
    

}
