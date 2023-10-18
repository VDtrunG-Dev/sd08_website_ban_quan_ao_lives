package com.poly.datn.sd08.controllers.admin;

import com.poly.datn.sd08.model.entities.TVoucher;
import com.poly.datn.sd08.services.VoucherService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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


    @GetMapping("view")
    public String hienThi(Model model) {
        List<TVoucher> list = voucherService.getAll();
        model.addAttribute("list", list);
        return "admin/voucher/view";
    }


    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id, Model model, HttpSession session) {
        voucherService.deleteById(id);
        session.setAttribute("successMessage", "Xóa thành công !");
        return "redirect:/admin/voucher/view";

    }





    @PostMapping("export")
    public void exportToExcel(HttpServletResponse response) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();


        XSSFSheet sheet = workbook.createSheet("Danh sách voucher");
        XSSFRow headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Mã Voucher");
        headerRow.createCell(1).setCellValue("Số Lượng");
        headerRow.createCell(2).setCellValue("Hình thức giảm");
        headerRow.createCell(3).setCellValue("Mức giảm tối đa");
        headerRow.createCell(4).setCellValue("Đơn hàng tối thiểu");
        headerRow.createCell(5).setCellValue("Người tạo");
        headerRow.createCell(6).setCellValue("Người sửa");
        headerRow.createCell(7).setCellValue("Thời gian tạo");
        headerRow.createCell(8).setCellValue("Thời gian sửa");
        headerRow.createCell(9).setCellValue("Trạng Thái");


        List<TVoucher> vouchers = voucherService.getExcel();
        int rowNum = 1;
        for (TVoucher voucher : vouchers) {
            XSSFRow row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(voucher.getVoucherCode());
            row.createCell(1).setCellValue(voucher.getQuantity());
            row.createCell(2).setCellValue(voucher.getReducedForm());
            row.createCell(3).setCellValue(voucher.getMaximumCostReduction().toString());
            row.createCell(4).setCellValue(voucher.getMinimumOrder().toString());
            row.createCell(5).setCellValue(voucher.getCreatedBy());
            row.createCell(6).setCellValue(voucher.getUpdatedBy());
            row.createCell(7).setCellValue(voucher.getCreatedAt());
            row.createCell(8).setCellValue(voucher.getUpdatedAt());
            row.createCell(9).setCellValue(voucher.getStatus() == 1 ? "Còn áp dụng" : "Không áp dụng");

        }



        response.setHeader("Content-Disposition", "attachment; filename=Danh Sách Voucher.xlsx");
        response.setContentType("application/vnd.ms-excel");

        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
    }

}
