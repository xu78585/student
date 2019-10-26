package tl.exam;

import com.deepoove.poi.config.Name;
import com.deepoove.poi.data.DocxRenderData;

public class ExamData {

    @Name("exam_name")
    private String examName;
    @Name("exam_author")
    private String examAuthor;
    @Name("single_title")
    private String singleTitle;
    @Name("single_segment")
    private DocxRenderData singleSegment;

    @Name("fill_title")
    private String fillTitle;
    @Name("fill_segment")
    private DocxRenderData fillSegment;

    @Name("exam_source")
    private String examSource;
    private String summary;

    public String getFillTitle() {
        return fillTitle;
    }

    public void setFillTitle(String fillTitle) {
        this.fillTitle = fillTitle;
    }

    public DocxRenderData getFillSegment() {
        return fillSegment;
    }

    public void setFillSegment(DocxRenderData fillSegment) {
        this.fillSegment = fillSegment;
    }

    public String getSingleTitle() {
        return singleTitle;
    }

    public void setSingleTitle(String singleTitle) {
        this.singleTitle = singleTitle;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getExamAuthor() {
        return examAuthor;
    }

    public void setExamAuthor(String examAuthor) {
        this.examAuthor = examAuthor;
    }

    public DocxRenderData getSingleSegment() {
        return singleSegment;
    }

    public void setSingleSegment(DocxRenderData singleSegment) {
        this.singleSegment = singleSegment;
    }

    public String getExamSource() {
        return examSource;
    }

    public void setExamSource(String examSource) {
        this.examSource = examSource;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
