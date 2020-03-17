/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author School
 */
public class Problem {

    private Map<Resident, List<Hospital>> resPrefMap;
    private Map<Hospital, List<Resident>> hosPrefMap;
    private List<Resident> residentList;
    private Set<Hospital> hospitalSet;

    public Problem() {
    }

    public Problem(Map<Resident, List<Hospital>> resPrefMap, Map<Hospital, List<Resident>> hosPrefMap, List<Resident> residentList, Set<Hospital> hospitalSet) {
        this.resPrefMap = resPrefMap;
        this.hosPrefMap = hosPrefMap;
        this.residentList = residentList;
        this.hospitalSet = hospitalSet;
    }

    public void match(Map<Resident, List<Hospital>> resPrefMap, Map<Hospital, List<Resident>> hosPrefMap, List<Resident> residentList, Set<Hospital> hospitalSet) {
        /*
        *ia rezidentii si spitalele in ordinea introdusa, si daca primul spital dorit de rezident are locuri libere, ii este asignat, altfel merge la urmatorul pital din lista
        */
        Map<Resident, Hospital> match = new HashMap<>();
        for (Resident res : residentList) {
            for (Hospital hos : hospitalSet) {
                int i=hos.getCapacity();
                if (resPrefMap.get(res).contains(hos) && i > 0) {
                    match.put(res, hos);
                    hos.setCapacity(i-1);
                    break;
                }
            }
        }
        /**
         * afisam matching-ul
         */
        for (Map.Entry<Resident, Hospital> entry : match.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        }
    }
}
