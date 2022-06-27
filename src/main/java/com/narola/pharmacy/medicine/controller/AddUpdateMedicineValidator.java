package com.narola.pharmacy.medicine.controller;

import com.narola.pharmacy.medicine.model.MedicineBean;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import static com.narola.pharmacy.utility.UtilityMethods.isNumeric;

@Component
public class AddUpdateMedicineValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(MedicineBean.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MedicineBean medicineBean = (MedicineBean) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "medName", "Medicine name is mandatory");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "medPrice", "Medicine price is mandatory");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "medDiscount", "Medicine discount is mandatory");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "medManufacturer", "Medicine manufacturer is mandatory");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "medDescription", "Medicine description is mandatory");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "medMfgDate", "Medicine mfgdate is mandatory");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "medExpDate", "Medicine expdate is mandatory");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "quantity", "Medicine qty is mandatory");
        if (isNumeric(medicineBean.getMedPrice().toString())) {
            if (Double.valueOf(medicineBean.getMedPrice()) <= 0.0) {
                errors.rejectValue("medPrice", "Med price cannot be negative");
            }
        } else {
            errors.rejectValue("medPrice", "Medicine price must be numeric");
        }


        if (isNumeric(medicineBean.getMedDiscount().toString())) {
            if (Double.valueOf(medicineBean.getMedDiscount()) < 0.0 || Double.valueOf(medicineBean.getMedDiscount()) > 100.0)
                errors.rejectValue("medDiscount", "Medicine Discount must be between 0-100");

        } else {
            errors.rejectValue("medDiscount", "Medicine Discount must be numeric");
        }

    }
}
