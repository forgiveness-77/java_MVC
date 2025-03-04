package com.pharmacy.dao;

import com.pharmacy.models.Medicine;

import java.util.List;

public interface MedicineDao {
    void addMedicine(Medicine medicine);
    List<Medicine> getAllMedicines();
    Medicine getMedicineById(int id);
    boolean updateMedicine(Medicine medicine);
    void deleteMedicine(int id);
}
