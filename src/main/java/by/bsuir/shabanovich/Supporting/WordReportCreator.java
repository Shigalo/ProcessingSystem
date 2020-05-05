package by.bsuir.shabanovich.Supporting;

import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGrid;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGridCol;

import java.io.FileOutputStream;
import java.math.BigInteger;
import java.util.ArrayList;

public class WordReportCreator {

    private String path;
    private ArrayList<DeliveryData> data;

    public WordReportCreator(String path) {
        this.path = path;
        data = new ArrayList<>();
    }

    public void PushData(String address, String customer) {
        DeliveryData newData = new DeliveryData(data.size(), address, customer);
        data.add(newData);
    }

    public void Create() {
        try {
            XWPFDocument docxModel = new XWPFDocument();
            XWPFTable tbl = docxModel.createTable(data.size()+1, data.get(0).GetData().size());
            int pad = (int) (.1 * 1440);
            tbl.setCellMargins(pad, pad, pad, pad);

            XWPFTableRow row = tbl.getRow(0);
            ArrayList<String> rowData = DeliveryData.GetLabels();
            for(int j = 0; j < rowData.size(); j++) {
                XWPFTableCell cell = row.getCell(j);
                XWPFParagraph p = cell.getParagraphArray(0);
                XWPFRun r = p.createRun();
                r.setText(rowData.get(j));
            }

            for(int i = 0; i < data.size();) {
                rowData = data.get(i).GetData();
                row = tbl.getRow(++i);
                for(int j = 0; j < rowData.size(); j++) {
                    XWPFTableCell cell = row.getCell(j);
                    XWPFParagraph p = cell.getParagraphArray(0);
                    XWPFRun r = p.createRun();
                    r.setText(rowData.get(j));
                }
            }

            FileOutputStream outputStream = new FileOutputStream(/*"D:/Sasha/Word Test.docx"*/path);
            docxModel.write(outputStream);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Успешно записан в файл");
    }
 }
