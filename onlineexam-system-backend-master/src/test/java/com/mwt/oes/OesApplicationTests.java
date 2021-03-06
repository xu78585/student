package com.mwt.oes;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.NumbericRenderData;
import com.deepoove.poi.data.TextRenderData;
import com.mwt.oes.service.StudentProfileService;
import com.mwt.oes.service.TeacherBankManageService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import tl.el.ExamModel;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.deepoove.poi.data.NumbericRenderData.FMT_UPPER_LETTER;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OesApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@WebAppConfiguration
public class OesApplicationTests {

    StudentProfileService studentProfileService;

    @Autowired
    private TeacherBankManageService teacherBankManageService;

    @Before
    public void init() {
        System.out.println("开始测试-----------------");
    }

    @After
    public void after() {
        System.out.println("测试结束-----------------");
    }

    @Test
    public void contextLoads() throws Exception {

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
				singleList.forEach(map->{
					add(new TextRenderData( ));
				});

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

}
