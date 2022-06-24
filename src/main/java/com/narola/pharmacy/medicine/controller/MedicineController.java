package com.narola.pharmacy.medicine.controller;

import com.narola.pharmacy.exception.PharmacyServiceException;
import com.narola.pharmacy.medicine.model.MedicineBean;
import com.narola.pharmacy.medicine.service.IMedicineService;
import com.narola.pharmacy.utility.Constant;
import com.narola.pharmacy.utility.ServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/medicine")
public class MedicineController {
    @Autowired
    private IMedicineService medicineService;

    @GetMapping("/ShowAllMedicine")
    public ModelAndView getAllMedicine(HttpServletRequest request, HttpServletResponse response) throws PharmacyServiceException {
        List<MedicineBean> list = medicineService.getAllMedicine(request);
        ModelAndView modelAndView = new ModelAndView("medicinemain");
        modelAndView.addObject("MedicineList", list);
        return modelAndView;

    }

    // @PostMapping("/AddMedicineAction")
    @RequestMapping(value = "/AddMedicineAction", method = {RequestMethod.GET, RequestMethod.POST})
    public String addMedicine(MedicineBean medicineBean, HttpServletRequest request, @RequestParam(name = "medMfgDatetxt") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate mfgDate, @RequestParam(name = "medMfgDatetxt") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                      LocalDate expDate) throws PharmacyServiceException {
        medicineBean.setMedMfgDate(mfgDate);
        medicineBean.setMedExpDate(expDate);
        medicineService.addMedicine(medicineBean, request);
        return "redirect:/medicine/ShowAllMedicine";
    }

    @RequestMapping(value = "/AddMedicineForm", method = {RequestMethod.GET})
    public String addMedicineForm() {
        return "addmedicine";
    }

    @PostMapping("/ManagePopularMedicineAction")
    public void managePopularMedicine(@RequestParam int medId, @RequestParam String action) throws PharmacyServiceException {
        medicineService.managePopularMedicine(medId, action);
    }

    @GetMapping("/RemoveMedicineAction")
    public String removeMedicine(@RequestParam int medId) throws PharmacyServiceException {
        medicineService.deleteMedicine(medId);
        return "redirect:/medicine/ShowAllMedicine";

    }
    @GetMapping("/UpdateMedicineAction")
    public String updateMedicine(MedicineBean medicineBean,@RequestParam("imagesToBeDeleted") String imagesToBeDeleted,HttpServletRequest request ) throws PharmacyServiceException {
        String fileName = medicineService.updateMedicine(request, medicineBean, imagesToBeDeleted);
        return "redirect:/medicine/ShowAllMedicine";
    }
    @GetMapping("/UpdateMedicineForm")
    public ModelAndView updateMedicineForm(@RequestParam("medId") int medId,HttpServletRequest request) throws PharmacyServiceException {
        File dir = new File(request.getServletContext().getRealPath("/") + Constant.MEDICINE_IMG_FOLDER + medId);
        ModelAndView modelAndView=new ModelAndView("medicine-update-form");
        modelAndView.addObject("FileList", dir.listFiles());
        modelAndView.addObject("MedicineBean", medicineService.updateMedicineForm(medId));
        return modelAndView;
    }

}

