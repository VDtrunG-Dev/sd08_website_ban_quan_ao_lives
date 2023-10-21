package com.poly.datn.sd08.controllers.admin;

import com.poly.datn.sd08.model.entities.TRank;

import com.poly.datn.sd08.services.impl.RankServiceImpl;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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
@RequestMapping("/admin/rank/")
public class RankController {

    @Autowired
    private RankServiceImpl rankService;


    @GetMapping("view")
    public String hienThi(Model model) {
        List<TRank> listRank = rankService.getAll();
        model.addAttribute("listRank", listRank);
        return "admin/rank/view";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id, HttpSession session) {
        rankService.deleteById(id);
        session.setAttribute("successMessage", "Xóa thành công !");
        return "redirect:/admin/rank/view";

    }


    @GetMapping("create")
    public String showCreateForm(Model model) {
        model.addAttribute("rank", new TRank());
        return "admin/rank/add";
    }

    @PostMapping("create")
    public String create(TRank rank, HttpSession session) {
        rankService.save(rank);
        session.setAttribute("successMessage", "Tạo mới thành công !");
        return "redirect:/admin/rank/view";
    }

    @GetMapping("update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        TRank rank = rankService.getById(id);
        model.addAttribute("rank", rank);
        return "admin/rank/update";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable Long id, TRank rank, HttpSession session) {
        rankService.update(id, rank);
        session.setAttribute("successMessage", "Cập nhật thành công !");
        return "redirect:/admin/rank/view";
    }


    @PostMapping("export")
    public void exportToExcel(HttpServletResponse response) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();


        XSSFSheet sheet = workbook.createSheet("Danh sách rank");
        XSSFRow headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Tên Rank");
        headerRow.createCell(1).setCellValue("Số điểm tối thiểu");
        headerRow.createCell(2).setCellValue("Trạng Thái");

        List<TRank> ranks = rankService.getExcel();
        int rowNum = 1;
        for (TRank rank : ranks) {
            XSSFRow row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(rank.getRankName());
            row.createCell(1).setCellValue(rank.getMinimumPoints());
            row.createCell(2).setCellValue(rank.getStatus());

        }

        response.setHeader("Content-Disposition", "attachment; filename=Danh Sách Rank.xlsx");
        response.setContentType("application/vnd.ms-excel");

        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
    }
}
