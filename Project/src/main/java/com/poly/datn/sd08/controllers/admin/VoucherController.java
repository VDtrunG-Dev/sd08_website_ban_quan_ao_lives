package com.poly.datn.sd08.controllers.admin;

import com.poly.datn.sd08.model.entities.TVoucher;
import com.poly.datn.sd08.services.VoucherService;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Controller
@RequestMapping("/admin/voucher/")
public class VoucherController {

    @Autowired
    private VoucherService voucherService;


    @PostMapping("export")
    public void exportToExcel(HttpServletResponse response) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();


        XSSFSheet sheet = workbook.createSheet("Danh sách hóa đơn");
        XSSFRow headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Mã Hóa Đơn");
        headerRow.createCell(1).setCellValue("Ngày Thanh Toán");
        headerRow.createCell(2).setCellValue("Tổng Tiền Sau Khi Giảm");
        headerRow.createCell(3).setCellValue("Trạng Thái");
        headerRow.createCell(4).setCellValue("Người Nhận");
        headerRow.createCell(5).setCellValue("Ngày nhận dự kiến");
        headerRow.createCell(6).setCellValue("Ngày Ship");


        List<TVoucher> vouchers = voucherService.getExcel();
        int rowNum = 1;
        for (TVoucher voucher : vouchers) {
            XSSFRow row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(voucher.getId());
            row.createCell(1).setCellValue(voucher.getVoucherCode());
            row.createCell(2).setCellValue(voucher.getQuantity());
            row.createCell(3).setCellValue(voucher.getReducedForm());
            row.createCell(4).setCellValue((RichTextString) voucher.getMaximumCostReduction());
            row.createCell(5).setCellValue((RichTextString) voucher.getMinimumOrder());
            row.createCell(6).setCellValue(voucher.getCreatedBy());
            row.createCell(7).setCellValue(voucher.getUpdatedBy());
            row.createCell(8).setCellValue(voucher.getUpdatedAt());
            row.createCell(9).setCellValue(voucher.getStatus());

        }


        response.setHeader("Content-Disposition", "attachment; filename=danhsachvoucher.xlsx");
        response.setContentType("application/vnd.ms-excel");

        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
    }

}
