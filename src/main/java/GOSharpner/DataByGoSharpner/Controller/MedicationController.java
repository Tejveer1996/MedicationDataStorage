package GOSharpner.DataByGoSharpner.Controller;

import GOSharpner.DataByGoSharpner.Entity.AssociatedDrug;
import GOSharpner.DataByGoSharpner.Entity.ClassName;
import GOSharpner.DataByGoSharpner.Entity.Medication;
import GOSharpner.DataByGoSharpner.Entity.MedicationClass;
import GOSharpner.DataByGoSharpner.Service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api/medications")
public class MedicationController {
    @Autowired
    private MedicationService medicationService;


    @GetMapping
    public ResponseEntity<Map<String, List<Map<String, Object>>>> getAllMedications() {
        return ResponseEntity.ok(medicationService.getAllMedication());
    }
}

