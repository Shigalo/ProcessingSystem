package by.bsuir.shabanovich.Supporting;

import by.bsuir.shabanovich.Entities.Order;
import by.bsuir.shabanovich.Entities.Product;
import org.apache.poi.xwpf.usermodel.*;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class WordReportCreator {

    private String path;
    private String date;
    private ArrayList<DeliveryData> data;

    public WordReportCreator(String path, String date) {
        this.path = path;
        this.date = date;
        data = new ArrayList<>();
    }

    public void pushData(Order order, List<Product> products) {
        data.add(new DeliveryData(order, products));
    }

    public void Create() {
        try {
            XWPFDocument docxModel = new XWPFDocument();
            XWPFParagraph bodyParagraph = docxModel.createParagraph();
            bodyParagraph.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun paragraphConfig = bodyParagraph.createRun();
            paragraphConfig.setText(date);

            for(DeliveryData deliveryData : data) {
                XWPFParagraph customerBodyParagraph = docxModel.createParagraph();
                customerBodyParagraph.setAlignment(ParagraphAlignment.LEFT);
                XWPFRun customerParagraphConfig = bodyParagraph.createRun();
                customerParagraphConfig.setText(deliveryData.getCustomer());

                List<Product> products = deliveryData.getProducts();
                List<String> rowData = DeliveryData.GetLabels();

                XWPFTable tbl = docxModel.createTable(products.size()+1, rowData.size());
                int pad = (int) (.1 * 1440);
                tbl.setCellMargins(pad, pad, pad, pad);

                XWPFTableRow row = tbl.getRow(0);
                for(int j = 0; j < rowData.size(); j++) {
                    XWPFTableCell cell = row.getCell(j);
                    XWPFParagraph p = cell.getParagraphArray(0);
                    XWPFRun r = p.createRun();
                    r.setText(rowData.get(j));
                }

                for(int i = 0; i < products.size();) {
                    rowData = deliveryData.GetData(i);
                    row = tbl.getRow(++i);
                    for(int j = 0; j < rowData.size(); j++) {
                        XWPFTableCell cell = row.getCell(j);
                        XWPFParagraph p = cell.getParagraphArray(0);
                        XWPFRun r = p.createRun();
                        r.setText(rowData.get(j));
                    }
                }
            }

            FileOutputStream outputStream = new FileOutputStream(path);
            docxModel.write(outputStream);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Успешно записан в файл");
    }


}
