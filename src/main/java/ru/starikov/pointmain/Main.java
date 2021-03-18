package ru.starikov.pointmain;
//import com.opencsv.CSVReader;


import au.com.bytecode.opencsv.CSVReader;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        try (CSVReader reader = new CSVReader(new FileReader("/home/svyatoslav/monitor.csv"), ';')) {
            ReadCVS(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        try (BufferedReader br = new BufferedReader(new FileReader("/home/svyatoslav/monitor.csv"))) {
//            ReadBuffer(br);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try (Scanner scanner = new Scanner(new File("/home/svyatoslav/monitor.csv"))) {
//            ReadScanner(scanner);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

    }

    public static void ReadCVS(CSVReader reader) throws IOException {
        List<String[]> r;
        r = reader.readAll();

        int listIndex = 0;
        for (String[] arrays : r) {
            System.out.println("\nString[" + listIndex++ + "] : " + Arrays.toString(arrays));

            int index = 0;
            for (String array : arrays) {
                System.out.println(index++ + " : " + array);
            }
        }
    }

    public static void ReadBuffer(BufferedReader br) throws IOException {
        List<List<String>> records = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(";");
            records.add(Arrays.asList(values));
        }
        System.out.println(records);
    }

    public static void ReadScanner(Scanner scanner) {
        scanner.useDelimiter(";");
        while (scanner.hasNext()) {
            System.out.println(scanner.next() + "|");
        }
        scanner.close();
    }
}


