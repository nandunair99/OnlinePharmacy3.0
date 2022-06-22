package com.narola.pharmacy.medicine.controller;

import com.narola.pharmacy.exception.PharmacyServiceException;
import com.narola.pharmacy.medicine.model.MedicineBean;
import com.narola.pharmacy.medicine.service.IMedicineService;
import com.narola.pharmacy.utility.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
            ModelAndView modelAndView=new ModelAndView("medicinemain");
            modelAndView.addObject("MedicineList",list);
            return modelAndView;

    }

   // @PostMapping("/AddMedicineAction")
    @RequestMapping(value = "/AddMedicineAction",method = {RequestMethod.GET,RequestMethod.POST})
    public String addMedicine(MedicineBean medicineBean,HttpServletRequest request) throws PharmacyServiceException {

        //mb.setCatId(Integer.valueOf(request.getParameter(Constant.CONST_CATEGORY_NAME)));
//        mb.setMedName(request.getParameter(Constant.CTRL_MED_NAME));
//        mb.setMedPrice(Double.valueOf(request.getParameter(Constant.CTRL_MED_PRICE)));
//        mb.setMedDiscount(Double.valueOf(request.getParameter(Constant.CTRL_MED_DISCOUNT)));
//        mb.setMedManufacturer(request.getParameter(Constant.CTRL_MED_MANUFACTURER));
//        mb.setMedDescription(request.getParameter(Constant.CTRL_MED_DESCRIPTION));
//        mb.setMedMfgDate(LocalDate.parse(request.getParameter(Constant.CTRL_MED_MFGDATE)));
//        mb.setMedExpDate(LocalDate.parse(request.getParameter(Constant.CTRL_MED_EXPDATE)));
//        mb.setQuantity(Integer.valueOf(request.getParameter(Constant.CTRL_MED_QUANTITY)));
        medicineService.addMedicine(medicineBean, request);
        return "redirect:/medicine/ShowAllMedicine";
    }
    @RequestMapping(value = "/AddMedicineForm",method = {RequestMethod.GET})
    public String addMedicineForm()
    {
        return "addmedicine";
    }



}

