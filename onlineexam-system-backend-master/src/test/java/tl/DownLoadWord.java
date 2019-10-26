package tl;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.NumbericRenderData;
import com.deepoove.poi.data.TextRenderData;
import com.mwt.oes.service.TeacherBankManageService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tl.el.ExamModel;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.deepoove.poi.data.NumbericRenderData.FMT_UPPER_LETTER;

public class DownLoadWord {

    @Autowired
    private TeacherBankManageService teacherBankManageService;

    @Test //获取所有
    public void testRenderMap() throws Exception {

        //单选
        List<Map<String, Object>> singleList = teacherBankManageService.getSingleList();
        //多选
        List<Map<String, Object>> multipleList = teacherBankManageService.getMultipleList();
        //判断
        List<Map<String, Object>> judgeList = teacherBankManageService.getJudgeList();
        //天空
        List<Map<String, Object>> fillList = teacherBankManageService.getFillList();


        ExamModel examModel = new ExamModel();

        examModel.setFeature1(new NumbericRenderData(FMT_UPPER_LETTER, new ArrayList<TextRenderData>() {
            {
                add(new TextRenderData("Plug-in grammar, add new grammar by yourself"));
                add(new TextRenderData(
                        "Supports word text, local pictures, web pictures, table, list, header, footer..."));
                add(new TextRenderData("Templates, not just templates, but also style templates"));
                add(new TextRenderData("Plug-in grammar, add new grammar by yourself"));
                add(new TextRenderData(
                        "Supports word text, local pictures, web pictures, table, list, header, footer..."));
                add(new TextRenderData("Templates, not just templates, but also style templates"));
            }

        }));

        XWPFTemplate template = XWPFTemplate.compile("src/test/resources/template_exam.docx")
                .render(examModel);

        FileOutputStream out = new FileOutputStream("out_template_object_exam.docx");
        template.write(out);
        template.close();
        out.flush();
        out.close();


    }

    //根据试卷获取某个


}
