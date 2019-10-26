package tl.el;

import com.deepoove.poi.config.Name;
import com.deepoove.poi.data.MiniTableRenderData;
import com.deepoove.poi.data.NumbericRenderData;
import com.deepoove.poi.data.PictureRenderData;

public class ExamModel {


    private String word;
    private String time;
    private String what;

    private NumbericRenderData feature1;//单选
    private NumbericRenderData feature2;//多选
    private NumbericRenderData feature3;//判断
    private NumbericRenderData feature4;//填空

    @Name("solution_compare")
    private MiniTableRenderData solutionCompare;//表格

    private PictureRenderData portrait;//头像

    private String author;
    private String introduce;
    private String header;


    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public NumbericRenderData getFeature1() {
        return feature1;
    }

    public void setFeature1(NumbericRenderData feature1) {
        this.feature1 = feature1;
    }

    public NumbericRenderData getFeature2() {
        return feature2;
    }

    public void setFeature2(NumbericRenderData feature2) {
        this.feature2 = feature2;
    }

    public NumbericRenderData getFeature3() {
        return feature3;
    }

    public void setFeature3(NumbericRenderData feature3) {
        this.feature3 = feature3;
    }

    public NumbericRenderData getFeature4() {
        return feature4;
    }

    public void setFeature4(NumbericRenderData feature4) {
        this.feature4 = feature4;
    }

    public MiniTableRenderData getSolutionCompare() {
        return solutionCompare;
    }

    public void setSolutionCompare(MiniTableRenderData solutionCompare) {
        this.solutionCompare = solutionCompare;
    }

    public PictureRenderData getPortrait() {
        return portrait;
    }

    public void setPortrait(PictureRenderData portrait) {
        this.portrait = portrait;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
}
