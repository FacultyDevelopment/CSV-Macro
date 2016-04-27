/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csv.macro.graduaciones;

import Clases.Graduando;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import com.csvreader.*;
import java.util.Comparator;

/**
 *
 * @author wcarrasco
 */
public class CSVMacroGraduaciones {

    static boolean csvLeido = false;
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Graduando> graduandosTotal = new ArrayList<Graduando>();
    static ArrayList<ArrayList> graduandosTotal2 = new ArrayList<ArrayList>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //System.out.println(menu());
        runCSV();

        for (int i = 0; i < graduandosTotal2.size(); i++) {
            for (int j = 0; j < graduandosTotal2.get(i).size(); j++) {
                Collections.sort(graduandosTotal2.get(i));
            }
        }

        /*Collections.sort(graduandosTotal, new Comparator<Graduando>(){
            public int compare(Graduando one, Graduando other){
                return one.getMasterDescription().compareTo(other.getMasterDescription());
            }
        });*/
 /*for (int i = 0; i < 10; i++) {
            System.out.println(graduandosTotal.get(i).getNombreCompleto());
        }*/
        saveCSV();
    }

    public static void runCSV() {
        String csvFile = "C:\\Users\\wcarrasco\\Desktop\\CSV COMPLETO.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";

        try {
            int pos = 1;
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                System.out.println("Entra al while");
                Graduando g = new Graduando();
                if (pos > 2) {
                    String[] ArregloGraduando = line.split(cvsSplitBy);
                    if (ArregloGraduando.length == 0) {
                        break;
                    } else {
                        g.setLastName(ArregloGraduando[0]);
                        g.setFirstName(ArregloGraduando[1]);
                        g.setNombreCompleto(ArregloGraduando[2]);
                        g.setEmail(ArregloGraduando[3]);
                        g.setCampus(ArregloGraduando[4]);
                        g.setUniversity(ArregloGraduando[5]);
                        g.setMasterDescription(ArregloGraduando[6]);
                        g.setProgramName(ArregloGraduando[7]);
                        g.setLanguage(ArregloGraduando[8]);
                        g.setFirstMod(ArregloGraduando[9]);
                        g.setHorasModulo1(ArregloGraduando[10]);
                        g.setHorasTotal(ArregloGraduando[11]);
                        g.setTrack(ArregloGraduando[12]);
                        g.setCourseKey(ArregloGraduando[13]);
                        g.setLearningStartDate(ArregloGraduando[14]);

                        boolean seAgrego = false;

                        if (graduandosTotal2.isEmpty()) {
                            ArrayList<Graduando> newArrayGrad = new ArrayList<>();
                            newArrayGrad.add(g);
                            graduandosTotal2.add(newArrayGrad);
                            System.out.println("Se agrego uno nuevo: " + g.getEmail());
                        } else {
                            System.out.println("Tanano: " + graduandosTotal2.size());
                            for (int i = 0; i < graduandosTotal2.size(); i++) {

                                if (((Graduando) graduandosTotal2.get(i).get(0)).getEmail().contentEquals(g.getEmail())) {
                                    graduandosTotal2.get(i).add(g);
                                    seAgrego = true;
                                    System.out.println("Se agrego uno que ya estaba a: " + g.getEmail());
                                }
                               

                                if (!seAgrego) {
                                    ArrayList<Graduando> newArrayGrad = new ArrayList<Graduando>();
                                    newArrayGrad.add(g);
                                    graduandosTotal2.add(newArrayGrad);
                                    System.out.println("Se agrego uno nuevo2: " + g.getEmail());
                                    break;
                                }

                                seAgrego = false;

                            }

                            //graduandosTotal.add(g);
                            pos++;
                        }
                    }
                } else {
                    pos++;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        int cantidad = 0;
        String correo;
        for (int i = 0; i < graduandosTotal.size(); i++) {
            correo = graduandosTotal.get(i).getEmail();
            for (int j = 0; j < graduandosTotal.size(); j++) {
                if (correo.contentEquals(graduandosTotal.get(i).getEmail())) {
                    cantidad++;
                }
            }
        }

        System.out.println(graduandosTotal.size());
    }

    public static int menu() {
        int opcion = 0;
        if (csvLeido) {
            System.out.println("1) Leer Otro CSV");
            System.out.println("2) Ordenar");
            System.out.println("3) Eliminar todo y dejar graduacion actual");
            System.out.println("4) Guardar CSV");
            System.out.println("5) Cerrar");
            opcion = sc.nextInt();
        } else {
            System.out.println("1) Leer CSV");
            System.out.println("2) Cerrar");
            opcion = sc.nextInt();
        }
        return opcion;
    }

    public static void saveCSV() {
        String outputFile = "C:\\Users\\wcarrasco\\Desktop\\CSV COMPLETO 2.csv";
        boolean alreadyExists = new File(outputFile).exists();

        if (alreadyExists) {
            File ArchivoEmpleados = new File(outputFile);
            ArchivoEmpleados.delete();
        }

        try {

            CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ';');

            csvOutput.write("Last Name");
            csvOutput.write("First Name");
            csvOutput.write("Nombre Completo");
            csvOutput.write("Email");
            csvOutput.write("Campus");
            csvOutput.write("University");
            csvOutput.write("Master Description");
            csvOutput.write("Program Name");
            csvOutput.write("Language");
            csvOutput.write("First Mod Term");
            csvOutput.write("Horas Modulo 1");
            csvOutput.write("Horas Total");
            csvOutput.write("Track");
            csvOutput.write("Course Key");
            csvOutput.write("Learning Start Date");

            csvOutput.endRecord();
            for (int i = 0; i < graduandosTotal2.size(); i++) {

                for (int j = 0; j < graduandosTotal2.get(i).size(); j++) {

                    csvOutput.write(((Graduando) graduandosTotal2.get(i).get(j)).getLastName());
                    csvOutput.write(((Graduando) graduandosTotal2.get(i).get(j)).getFirstName());
                    csvOutput.write(((Graduando) graduandosTotal2.get(i).get(j)).getNombreCompleto());
                    csvOutput.write(((Graduando) graduandosTotal2.get(i).get(j)).getEmail());
                    csvOutput.write(((Graduando) graduandosTotal2.get(i).get(j)).getCampus());
                    csvOutput.write(((Graduando) graduandosTotal2.get(i).get(j)).getUniversity());
                    csvOutput.write(((Graduando) graduandosTotal2.get(i).get(j)).getMasterDescription());
                    csvOutput.write(((Graduando) graduandosTotal2.get(i).get(j)).getProgramName());
                    csvOutput.write(((Graduando) graduandosTotal2.get(i).get(j)).getLanguage());
                    csvOutput.write(((Graduando) graduandosTotal2.get(i).get(j)).getFirstMod());
                    csvOutput.write(((Graduando) graduandosTotal2.get(i).get(j)).getHorasModulo1());
                    csvOutput.write(((Graduando) graduandosTotal2.get(i).get(j)).getHorasTotal());
                    csvOutput.write(((Graduando) graduandosTotal2.get(i).get(j)).getTrack());
                    csvOutput.write(((Graduando) graduandosTotal2.get(i).get(j)).getCourseKey());
                    csvOutput.write(((Graduando) graduandosTotal2.get(i).get(j)).getLearningStartDate());
                    csvOutput.endRecord();
                }

            }

            csvOutput.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
