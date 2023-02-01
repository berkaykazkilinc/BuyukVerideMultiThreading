package com.company.Searching;

import java.util.ArrayList;

public class syncEkle {

    public static int sonuc;
    public static ArrayList<Double> sonuclar = new ArrayList<Double>();
    public static ArrayList<Double> threadList = new ArrayList<Double>();

    synchronized void sum(int gelen,ArrayList<Double> gelenSonuclar, ArrayList<Double> threadSuresi){
        this.sonuc= sonuc+gelen;
        threadList.addAll(threadSuresi);
        sonuclar.addAll(gelenSonuclar);
        try {
            Thread.sleep(0,1);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
    }

    public static int getSonuc() {
        return sonuc;
    }

    public static void setSonuc(int sonuc) {
        syncEkle.sonuc = sonuc;
    }

    public ArrayList<Double> getThreadList() {
        return threadList;
    }

    public void setThreadList(ArrayList<Double> threadList) {
        this.threadList = threadList;
    }

    public static ArrayList<Double> getSonuclar() {
        return sonuclar;
    }

    public static void setSonuclar(ArrayList<Double> sonuclar) {
        syncEkle.sonuclar = sonuclar;
    }
    public static void emptySonuclar(){
        syncEkle.sonuclar.clear();
    }
}
