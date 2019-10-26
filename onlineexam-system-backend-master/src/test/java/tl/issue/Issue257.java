package tl.issue;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.DocxRenderData;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

public class Issue257 {

    @Test
    public void testDocxMerge() throws Exception {

        Map<String, Object> params = new HashMap<String, Object>();

        params.put("docx", new DocxRenderData(new File("src/test/resources/issue/257_MERGE.docx")));

        XWPFTemplate doc = XWPFTemplate.compile("src/test/resources/issue/257.docx");
        doc.render(params);

        FileOutputStream fos = new FileOutputStream("out_issue_257.docx");
        doc.write(fos);
        fos.flush();
        fos.close();

    }

}
