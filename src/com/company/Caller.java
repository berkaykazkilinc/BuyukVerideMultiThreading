package com.company;

import com.company.FileRead.ReadCSV;
import com.company.Searching.CompareOneThread;
import com.company.Searching.CompareThread;
import com.company.Searching.syncEkle;
import com.company.models.Record;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Caller{


    public static void main(String[] args) {

    }

    public void arama2(double benzerlik_orani,String esitlik,int sutun,int thread_sayisi) {

        ReadCSV csv = new ReadCSV();
        ArrayList<Record> dizi = csv.getDizi();
        System.out.println(dizi.size());
        syncEkle myFirstThing = new syncEkle();
        ArrayList<Thread> myThreads = new ArrayList<Thread>();
        for (int i = 0; i<thread_sayisi; i++){
            CompareOneThread myThing = new CompareOneThread(10000, thread_sayisi, i, sutun, dizi, benzerlik_orani, esitlik);
            Thread myThread = new Thread(myThing);
            myThreads.add(myThread);
            myThread.start();
        }

        for (int i = 0; i < thread_sayisi; i++) {
            try {
                myThreads.get(i).join();
            }catch (InterruptedException e){
                System.out.println(e);
            }

        }
        /*
        Scanner klavye = new Scanner(System.in);
        String output = klavye.nextLine();
        */
        //System.out.println(myFirstThing.getSonuclar());
        System.out.println(myFirstThing.getThreadList());
    }

    public void arama1(double benzerlik_orani,int sutun,int thread_sayisi) {

        ReadCSV csv = new ReadCSV();
        ArrayList<Record> dizi = csv.getDizi();
        System.out.println(dizi.size());
        syncEkle myFirstThing = new syncEkle();
        ArrayList<Thread> myThreads = new ArrayList<Thread>();
        for (int i = 0; i<thread_sayisi; i++){
            CompareThread myThing = new CompareThread(100, thread_sayisi, i, sutun, dizi, benzerlik_orani);
            Thread myThread = new Thread(myThing);
            myThreads.add(myThread);
            myThread.start();
        }

        for (int i = 0; i < thread_sayisi; i++) {
            try {
                myThreads.get(i).join();
            }catch (InterruptedException e){
                System.out.println(e);
            }

        }
        /*
        Scanner klavye = new Scanner(System.in);
        String output = klavye.nextLine();
        */
        //System.out.println(myFirstThing.getSonuclar());
        System.out.println(myFirstThing.getThreadList());
    }

    public void arama3(double benzerlik_orani, double benzerlik_orani2, int sutun1, int sutun2,int thread_sayisi){
        long baslangic ,bitis;
        baslangic = System.currentTimeMillis();
        ReadCSV csv = new ReadCSV();
        ArrayList<Record> dizi = csv.getDizi();
        System.out.println(dizi.size());
        syncEkle myFirstThing = new syncEkle();
        ArrayList<Thread> myThreads = new ArrayList<Thread>();
        for (int i = 0; i<thread_sayisi; i++){
            CompareThread myThing = new CompareThread(500, thread_sayisi, i, sutun1, dizi, benzerlik_orani);
            Thread myThread = new Thread(myThing);
            myThreads.add(myThread);
            myThread.start();
        }
        bitis = System.currentTimeMillis();

        for (int i = 0; i < thread_sayisi; i++) {
            try {
                myThreads.get(i).join();
            }catch (InterruptedException e){
                System.out.println(e);
            }

        }
        //System.out.println(myFirstThing.getSonuclar());
        ArrayList<Record> secondArray = sonucDeneme();
        myFirstThing.emptySonuclar();
        myThreads.clear();
        for (int i = 0; i<thread_sayisi; i++){
            CompareThread myThing = new CompareThread(secondArray.size(), thread_sayisi, i, sutun2, secondArray, benzerlik_orani2);
            Thread myThread = new Thread(myThing);
            myThreads.add(myThread);
            myThread.start();
        }

        for (int i = 0; i < thread_sayisi; i++) {
            try {
                myThreads.get(i).join();
            }catch (InterruptedException e){
                System.out.println(e);
            }

        }
        System.out.println(myFirstThing.getSonuclar());
        System.out.println(myFirstThing.getSonuclar().size());

    }
    public ArrayList<Record> sonucDeneme(){
        ArrayList<Double> sonuc_dizisi = new ArrayList<Double>();
        ArrayList<Record> dizi= new ArrayList<>();
        ReadCSV a = new ReadCSV();
        dizi=a.getDizi();
        syncEkle deneme = new syncEkle();
        // Berkay deneme
        sonuc_dizisi=deneme.getSonuclar();
        ArrayList<Record> dizix = new ArrayList<>();
        for (int i = 0; i < sonuc_dizisi.size(); i=i+3) {
            //System.out.println("İlk İndex: "+sonuc_dizisi.get(i)+" İkinci İndex: "+sonuc_dizisi.get(i+1)+" Benzerlik: "+sonuc_dizisi.get(i+2));
            int ilk_index=sonuc_dizisi.get(i).intValue();
            int ikinci_index=sonuc_dizisi.get(i+1).intValue();
            //System.out.println("İlk İndex: "+deneme.getDizi().get(ilk_index).getIssue()+" İkinci İndex: "+deneme.getDizi().get(ikinci_index).getIssue());
            String ilk_index_string=sonuc_dizisi.get(i).toString();
            String ikinci_index_string=sonuc_dizisi.get(i+1).toString();
            String benzerlik_orani_string=sonuc_dizisi.get(i+2).toString();
            //loadBenzerlikSonuc(ilk_index_string,ikinci_index_string,benzerlik_orani_string,sonuc_dizisi.size());

            dizix.add(dizi.get(ilk_index));
            dizix.add(dizi.get(ikinci_index));

        }
        HashSet<Record> set = new HashSet<>(dizix);
        ArrayList<Record> result = new ArrayList<>(set);
        /*
        System.out.println(result);
        System.out.println(dizix.size());
        System.out.println(result.size());
        */
        return result;
    }
}
