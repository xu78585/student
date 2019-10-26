package tl.exam;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.DocxRenderData;
import com.mwt.oes.OesApplication;
import com.mwt.oes.service.TeacherBankManageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OesApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ExamExample {

    @Autowired
    private TeacherBankManageService teacherBankManageService;


    @Test
    public void testExamExample() throws Exception {

        String[] UP_CH_NUM = {"一", "二", "三", "四", "五", "六", "七"};
        int up_index = 0;

        ExamData data = new ExamData();
        data.setExamName("模拟考试");
        data.setExamAuthor("demo");
        data.setExamSource("模拟考试系统");
        //data.setSummary("你现在每一次的后悔遗憾，都有一个过去讨厌的自己。如果你对现在的自己不满意，那就勇敢地对过去种种讨厌的行为say-goodbye吧。很快，你就会发现，一个人见人爱的自己！");

        List<SingleSegmentData> singleSegments = new ArrayList<SingleSegmentData>();
//单选
        List<Map<String, Object>> singleList = teacherBankManageService.getSingleList();
        if (singleList.size() > 0) {
            data.setSingleTitle(UP_CH_NUM[up_index] + ": 选择题.");
            up_index++;

            singleList.forEach(map -> {
                SingleSegmentData s1 = new SingleSegmentData();
                s1.setSingleName(singleSegments.size() + 1 + "." + map.get("content"));
                StringBuilder sb = new StringBuilder();
                String[] str = {"choiceA", "choiceB", "choiceC", "choiceD", "choiceE", "choiceF", "choiceG"};
                for (String s : str) {
                    if (map.get(s) != null) {
                        sb.append(map.get(s) + "\n");
                    }
                }
                s1.setSingleContent(sb.substring(0, sb.length() - 2));
                singleSegments.add(s1);
            });
            DocxRenderData singleSegment = new DocxRenderData(new File("src/test/resources/exam/single.docx"), singleSegments);
            data.setSingleSegment(singleSegment);
        }
//填空
        List<Map<String, Object>> fillList = teacherBankManageService.getFillList();
        Boolean is_fill_ans_show = false;//是否显示填空题答案
        if (fillList.size() > 0) {
            data.setFillTitle(UP_CH_NUM[up_index] + ": 填空或者简答题.");
            up_index++;
            List<SingleSegmentData> fillSegments = new ArrayList<SingleSegmentData>();

            fillList.forEach(map -> {
                SingleSegmentData s1 = new SingleSegmentData();
                s1.setSingleName(fillSegments.size() + 1 + "." + map.get("content"));
                if (is_fill_ans_show) {
                    s1.setSingleContent(map.get("fillAnswer").toString());
                } else {
                    s1.setSingleContent("\n" + "\n" + "\n");
                }
                fillSegments.add(s1);
            });
            DocxRenderData fillSegment = new DocxRenderData(new File("src/test/resources/exam/single.docx"), fillSegments);
            data.setFillSegment(fillSegment);
        }

        XWPFTemplate template = XWPFTemplate.compile("src/test/resources/exam/exam.docx").render(data);

        FileOutputStream out = new FileOutputStream("out_exam.docx");
        template.write(out);
        out.flush();
        out.close();
        template.close();

    }

}

