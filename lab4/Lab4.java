/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


/**
 *
 * @author School
 */
public class Lab4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        var r = IntStream.rangeClosed(0, 3)
//                .mapToObj(i -> new Resident("R" + i))
//                .toArray(Resident[]::new);
        Resident r[] = new Resident[4];
        r[0] = new Resident("R0");
        r[1] = new Resident("R1");
        r[2] = new Resident("R2");
        r[3] = new Resident("R3");

        List<Resident> residentList = new ArrayList<>();
        residentList.addAll(Arrays.asList(r));

        Hospital h[] = new Hospital[3];
        h[0] = new Hospital(1, "H0");
        h[1] = new Hospital(2, "H1");
        h[2] = new Hospital(2, "H2");

        Set<Hospital> hospitalSet = new TreeSet<>();
        hospitalSet.add(h[0]);
        hospitalSet.add(h[1]);
        hospitalSet.add(h[2]);

        System.out.println("\nRezidentii ordonati dupa nume:");
        Collections.sort(residentList,
                Comparator.comparing(Resident::getName));
        for (Resident res : residentList) {
            System.out.println(res.toString());
        }
        
        System.out.println("Spitale:");
        for (Hospital hos : hospitalSet) {
            System.out.println(hos.toString());
        }

        Map<Resident, List<Hospital>> resPrefMap = new HashMap<>();
        List<Hospital> prefList = new ArrayList<>();
        prefList.add(h[0]);
        prefList.add(h[1]);
        prefList.add(h[2]);
        resPrefMap.put(r[0], prefList);
        resPrefMap.put(r[1], prefList);
        List<Hospital> prefList1 = new ArrayList<>();
        prefList1.add(h[0]);
        prefList1.add(h[1]);
        resPrefMap.put(r[2], prefList1);
        List<Hospital> prefList2 = new ArrayList<>();
        prefList2.add(h[0]);
        prefList2.add(h[2]);
        resPrefMap.put(r[3], prefList2);

        Map<Hospital, List<Resident>> hosPrefMap = new HashMap<>();
        hosPrefMap.put(h[0], Arrays.asList(r[3], r[0], r[1], r[2]));
        hosPrefMap.put(h[1], Arrays.asList(r[0], r[2], r[1]));
        hosPrefMap.put(h[2], Arrays.asList(r[0], r[1], r[3]));

        System.out.println("Rezideti care accepta h0: ");
        residentList.stream()
                .filter(res -> resPrefMap.get(res).contains(h[0]))
                .forEach(System.out::println);

        System.out.println("Rezideti care accepta h2: ");
        residentList.stream()
                .filter(res -> resPrefMap.get(res).contains(h[2]))
                .forEach(System.out::println);
        
        System.out.println("Spitalalele care au R0 ca preferinta de top: ");
        hospitalSet.stream()
                .filter(hos -> hosPrefMap.get(hos).get(0).equals(r[0]))
                .forEach(System.out::println);
        
        Problem p=new Problem();
        p.match(resPrefMap, hosPrefMap, residentList, hospitalSet);
    }
}
