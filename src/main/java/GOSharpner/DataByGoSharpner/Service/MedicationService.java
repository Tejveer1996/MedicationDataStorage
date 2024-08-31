package GOSharpner.DataByGoSharpner.Service;

import GOSharpner.DataByGoSharpner.Entity.AssociatedDrug;
import GOSharpner.DataByGoSharpner.Entity.ClassName;
import GOSharpner.DataByGoSharpner.Entity.Medication;
import GOSharpner.DataByGoSharpner.Entity.MedicationClass;
import GOSharpner.DataByGoSharpner.Repository.MedicationClassRepository;
import GOSharpner.DataByGoSharpner.Repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MedicationService {
    @Autowired
    private MedicationRepository medicationRepository;
    @Autowired
    private MedicationClassRepository medicationClassRepository;


    public Map<String, List<Map<String, Object>>> getAllMedication() {

        List<Medication> medications = medicationRepository.findAll();
        List<Map<String, Object>> medicationList = new ArrayList<>();

        for (Medication medication : medications) {
            Map<String, Object> medicationMap = new TreeMap<>();
            List<Map<String, Object>> medicationClassesList = new ArrayList<>();

            for (MedicationClass medicationClass : medication.getMedicationClasses()) {
                Map<String, Object> medicationClassMap = new TreeMap<>();

                for (ClassName className : medicationClass.getClassNames()) {
                    Map<String, Object> classNameMap = new TreeMap<>();
                    List<Map<String, Object>> associatedDrugsList = new ArrayList<>();
                    List<Map<String, Object>> associatedDrugsList2 = new ArrayList<>();

                    for (AssociatedDrug drug : className.getAssociatedDrugs()) {
                        Map<String, Object> drugMap = new TreeMap<>();
                        drugMap.put("name", drug.getName());
                        drugMap.put("dose", drug.getDose());
                        drugMap.put("strength", drug.getStrength());

                        if (drug.isSecondary()) {
                            associatedDrugsList2.add(drugMap);
                        } else {
                            associatedDrugsList.add(drugMap);
                        }
                    }

                    classNameMap.put("associatedDrug", associatedDrugsList);
                    classNameMap.put("associatedDrug#2", associatedDrugsList2);
                    medicationClassMap.put(className.getClassName(), Collections.singletonList(classNameMap));
                }

                medicationClassesList.add(medicationClassMap);
            }

            medicationMap.put("medicationsClasses", medicationClassesList);
            medicationList.add(medicationMap);
        }

        Map<String, List<Map<String, Object>>> response = new TreeMap<>();
        response.put("medications", medicationList);

        return response;
    }

}

