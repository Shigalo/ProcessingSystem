package by.bsuir.shabanovich.Services;

import by.bsuir.shabanovich.Entities.Delivery;
import by.bsuir.shabanovich.Entities.Nomenclature;
import by.bsuir.shabanovich.Entities.Waybill;
import by.bsuir.shabanovich.Repositories.DeliveryRepository;
import by.bsuir.shabanovich.Repositories.NomenclatureRepository;
import by.bsuir.shabanovich.Repositories.WaybillRepository;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;

@Service
public class WaybillService {

    @Autowired
    WaybillRepository waybillRepository;

    @Autowired
    WorkerService workerService;

    @Autowired
    NomenclatureRepository nomenclatureRepository;

    @Autowired
    DeliveryRepository deliveryRepository;

    public void setDeliveries(MultipartFile file) throws IOException {

        Waybill waybill = new Waybill();
        waybill.setWorker(workerService.getCurrentUser());
        LocalDate date = LocalDate.now();
        waybill.setDate(date);
        waybill = waybillRepository.save(waybill);

        XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
        XSSFSheet worksheet = workbook.getSheetAt(0);

        for(int i=1; i < worksheet.getPhysicalNumberOfRows(); i++) {
            XSSFRow row = worksheet.getRow(i);

            int count = (int)row.getCell(1).getNumericCellValue();
            String article = row.getCell(0).getStringCellValue();
            Nomenclature nomenclature = nomenclatureRepository.findByArticle(article);

            Delivery delivery = new Delivery(count, waybill, nomenclature);
            deliveryRepository.save(delivery);
        }
    }
}
