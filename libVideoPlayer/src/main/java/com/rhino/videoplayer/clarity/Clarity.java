package com.rhino.videoplayer.clarity;

/**
 * @author rhino
 * @since Create on 2018/12/08.
 **/
public class Clarity {

    /**
     * 清晰度等级
     */
    public String grade;
    /**
     * 270P、480P、720P、1080P、4K ...
     */
    public String p;
    /**
     * 视频链接地址
     */
    public String videoUrl;

    public Clarity(String grade, String p, String videoUrl) {
        this.grade = grade;
        this.p = p;
        this.videoUrl = videoUrl;
    }

}