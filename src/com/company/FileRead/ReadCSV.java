package com.company.FileRead;

//import com.company.Searching.Compare;
import com.company.models.Record;
import com.company.View.mainPageGUI;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class ReadCSV
{
    public static ArrayList<Record> dizi = new ArrayList<Record>();
    public static ArrayList<Double> sonuc_dizisi = new ArrayList<Double>();
    /*public static void main(String[] args) throws Exception {
        //parsing a CSV file into Scanner class constructor
        Scanner sc = new Scanner(new File("D:\\yazlab-1\\untitled - Kopya\\src\\com\\company\\FileRead\\veri.csv"));
        //Scanner sc = new Scanner(new File("/Users/berkaykazkilinc/Desktop/company/FileRead/veri.csv"));
        sc.useDelimiter(",|\\r\\n");   //sets the delimiter pattern
        int counter = 0;

        while (sc.hasNext())  //returns a boolean value
        {
            Record myRecord = new Record();

            for (int i = 0; i < 8 ; i++) {

            //System.out.print(sc.next()+" | ");  //find and returns the next complete token from this scanner4

            //System.out.print(gelen+ " | ");

                if(i==0 && sc.hasNext()){
                    String gelen = sc.next();
                }
            if(i==1 && sc.hasNext()){
                String gelen = sc.next();
                myRecord.setProduct(gelen);
            }
            if(i==2 && sc.hasNext()){
                String gelen = sc.next();
                myRecord.setIssue(gelen);
            }
            if(i==3 && sc.hasNext()){
                String gelen = sc.next();
                myRecord.setCompany(gelen);
            }
            if(i==4 && sc.hasNext()){
                String gelen = sc.next();
                myRecord.setState(gelen);
            }
            if(i==5 && sc.hasNext()){
                String gelen = sc.next();
                myRecord.setZip_code(gelen);
            }
            if(i==6 && sc.hasNext()){
                String gelen = sc.next();
                myRecord.setComplaint_id(gelen);
            }

            if (i == 7){
                dizi.add(myRecord);
                //System.out.println();
            }
            }
        }
        sc.close();  //closes the scanner
        Compare deneme = new Compare();
        deneme.setDizi(dizi);
        for (int k=0; k<5; k++){
            System.out.println(deneme.getDizi().get(k).toString());
        }

        //System.out.println(dizi.get(4).getIssue());
        deneme.compareRows();
        //System.out.println(dizi);

        // Berkay deneme
        sonuc_dizisi=deneme.compareRows2();
        double istenen_benzerlik_orani;
        istenen_benzerlik_orani=30;
        for (int i = 0; i < sonuc_dizisi.size(); i=i+3) {
            if(sonuc_dizisi.get(i+2)>=istenen_benzerlik_orani){
                System.out.println("İlk İndex: "+sonuc_dizisi.get(i)+" İkinci İndex: "+sonuc_dizisi.get(i+1)+" Benzerlik: "+sonuc_dizisi.get(i+2));
                int ilk_index=sonuc_dizisi.get(i).intValue();
                int ikinci_index=sonuc_dizisi.get(i+1).intValue();
                double benzerlik_orani=sonuc_dizisi.get(i+2).intValue();
                System.out.println("İlk İndex: "+deneme.getDizi().get(ilk_index).getIssue()+" İkinci İndex: "+deneme.getDizi().get(ikinci_index).getIssue());
                String ilk_index_string=sonuc_dizisi.get(i).toString();
                String ikinci_index_string=sonuc_dizisi.get(i+1).toString();
                String benzerlik_orani_string=sonuc_dizisi.get(i+2).toString();
                //mainPageGUI.loadBenzerlikSonuc(ilk_index_string,ikinci_index_string,benzerlik_orani_string);
            }
        }

    }*/
    public ArrayList<Record> getDizi(){
        try {
            Scanner sc = new Scanner(new File("D:\\yazlab-1\\untitled2\\src\\com\\company\\FileRead\\yeniveri.csv"));
            //Scanner sc = new Scanner(new File("/Users/berkaykazkilinc/Desktop/company/FileRead/veri.csv"));
            sc.useDelimiter(",|\\r\\n");   //sets the delimiter pattern
            int counter = 0;

            while (sc.hasNext())  //returns a boolean value
            {
                Record myRecord = new Record();

                for (int i = 0; i < 8; i++) {

                    //System.out.print(sc.next()+" | ");  //find and returns the next complete token from this scanner4

                    //System.out.print(gelen+ " | ");

                    if (i == 0 && sc.hasNext()) {
                        String gelen = sc.next();
                    }
                    if (i == 1 && sc.hasNext()) {
                        String gelen = sc.next();
                        myRecord.setProduct(gelen);
                    }
                    if (i == 2 && sc.hasNext()) {
                        String gelen = sc.next();
                        myRecord.setIssue(gelen);
                    }
                    if (i == 3 && sc.hasNext()) {
                        String gelen = sc.next();
                        myRecord.setCompany(gelen);
                    }
                    if (i == 4 && sc.hasNext()) {
                        String gelen = sc.next();
                        myRecord.setState(gelen);
                    }
                    if (i == 5 && sc.hasNext()) {
                        String gelen = sc.next();
                        myRecord.setZip_code(gelen);
                    }
                    if (i == 6 && sc.hasNext()) {
                        String gelen = sc.next();
                        myRecord.setComplaint_id(gelen);
                    }

                    if (i == 7) {
                        dizi.add(myRecord);
                        //System.out.println();
                    }
                }
            }
            sc.close();  //closes the scanner
        }catch (Exception e){
            System.out.println(e);
        }
        return dizi;
    }
}