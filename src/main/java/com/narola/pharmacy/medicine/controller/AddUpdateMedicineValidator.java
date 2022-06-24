package com.narola.pharmacy.medicine.controller;

import com.narola.pharmacy.medicine.model.MedicineBean;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class AddUpdateMedicineValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(MedicineBean.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MedicineBean medicineBean=(MedicineBean) target;

    }
}
