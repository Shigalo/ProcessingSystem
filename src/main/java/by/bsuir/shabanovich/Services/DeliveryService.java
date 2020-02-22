package by.bsuir.shabanovich.Services;

import by.bsuir.shabanovich.Entities.Delivery;
import by.bsuir.shabanovich.Entities.Waybill;
import by.bsuir.shabanovich.Entities.Worker;
import by.bsuir.shabanovich.Repositories.DeliveryRepository;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class DeliveryService {

    @Autowired
    DeliveryRepository deliveryRepository;

    public List<Delivery> findByWaybill(Waybill waybill) {
        return deliveryRepository.findByWaybill(waybill);
    }

}
