package com.haohao.poi;

import com.deepoove.poi.XWPFTemplate;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.*;
import java.util.HashMap;
import java.util.List;

/**
 * @author haohao
 */
public class TestPoi {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/haohao/temp/副本ReportTemplate (9)(1).docx");
        FileInputStream fileInputStream = new FileInputStream(file);
//        XWPFDocument xwpfDocument = new XWPFDocument(fileInputStream);

        XWPFTemplate template = XWPFTemplate.compile(fileInputStream).render(
                new HashMap<String, Object>(1) {{
                    put("title", "Hi, poi-tl Word模板引擎");
                    put("author", 1);
                    put("stockName", 2);
                    put("rangeDate", 3);
                    put("reportMessage", 4);
                }});
        template.writeAndClose(new FileOutputStream("/Users/haohao/temp/output.docx"));
    }
}
