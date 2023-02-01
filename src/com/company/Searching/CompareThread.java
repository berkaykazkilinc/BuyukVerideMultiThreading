package com.company.Searching;

import com.company.models.Record;

import java.util.ArrayList;

public class CompareThread implements Runnable{

    private int startIndex, endIndex;
    private int whichRow;
    double treshold;
    private int threadNumber, totalThread, size;
    private long threadTime = System.currentTimeMillis();
    private syncEkle syncEkle = new syncEkle();
    public static long sayac = 0;
    public ArrayList<Double> sonuclar = new ArrayList<Double>();
    public ArrayList<Record> dizi;

    public CompareThread(int size, int totalThread, int threadNumber, int whichRow, ArrayList<Record> dizi, double treshold) {
        this.totalThread = totalThread;
        this.threadNumber = threadNumber;
        this.whichRow = whichRow;
        this.treshold = treshold;
        this.size = size;
        this.dizi = dizi;
        this.startIndex = (size / totalThread)*threadNumber;
        this.endIndex = (size / totalThread)*(threadNumber+1)-1;
        //Thread thread = new Thread(this);
        //thread.start();
    }

    @Override
    public void run() {

        switch (whichRow){
            case 0:
                compareProduct();
                System.out.println("compareProduct girdi");
                break;
            case 1:
                compareIssue();
                System.out.println("compareIssue girdi");
                break;
            case 2:
                compareCompany();
                System.out.println("compareCompany girdi");
                break;
            case 3:
                compareState();
                System.out.println("compareState girdi");
                break;
            case 4:
                compareZip_Code();
                System.out.println("compareZip_Code girdi");
                break;
            case 5:
                compareComplaint_Id();
                System.out.println("compareComplaint_id girdi");
                break;
        }

        /*
        int sayici = 0;
        for (int i = this.startIndex; i<=this.endIndex; i++){
            String[] words = dizi.get(i).getIssue().split("\\s+");

            for (int j = i+1; j<size; j++){
                double answ= 0;
                String[] words1 = dizi.get(j).getIssue().split("\\s+");
                double length = words.length;
                double length1 = words1.length;
                //System.out.println(words1[0]);
                int counter= 0;
                for (int a=0; a<words.length; a++){
                    for(int s=0; s<words1.length; s++){
                        if (words[a].equals(words1[s])){
                            //System.out.println(words[a] +" "+ words1[s]);
                            counter++;
                        }
                    }
                }
                if(length>=length1){
                    answ = (counter/length)*100;
                }else{
                    answ = (counter/length1)*100;
                }

                if(answ==treshold){

                    //syncEkle syncEkle = new syncEkle();
                    //syncEkle.sum();

                        sonuclar.add(Double.parseDouble(Integer.toString(i)));
                        sonuclar.add(Double.parseDouble(Integer.toString(j)));
                        sonuclar.add(answ);

                        sayici++;

                }
                //System.out.println(answ);
            }
        }

        syncEkle.sum(sayici,sonuclar);
        long threadEndTime = System.currentTimeMillis();
        System.out.println( "thread numarası : " + threadNumber +"  | " + (threadEndTime-threadTime));
        */
    }

    public void compareIssue(){

        int sayici = 0;
        for (int i = this.startIndex; i<=this.endIndex; i++){
            String[] words = dizi.get(i).getIssue().split("\\s+");

            for (int j = i+1; j<size; j++){
                double answ= 0;
                String[] words1 = dizi.get(j).getIssue().split("\\s+");
                double length = words.length;
                double length1 = words1.length;
                //System.out.println(words1[0]);
                int counter= 0;
                for (int a=0; a<words.length; a++){
                    for(int s=0; s<words1.length; s++){
                        if (words[a].equals(words1[s])){
                            //System.out.println(words[a] +" "+ words1[s]);
                            counter++;
                        }
                    }
                }
                if(length>=length1){
                    answ = (counter/length)*100;
                }else{
                    answ = (counter/length1)*100;
                }

                if(answ>=treshold){

                    //syncEkle syncEkle = new syncEkle();
                    //syncEkle.sum();

                    sonuclar.add(Double.parseDouble(Integer.toString(i)));
                    sonuclar.add(Double.parseDouble(Integer.toString(j)));
                    sonuclar.add(answ);

                    sayici++;

                }
                //System.out.println(answ);
            }
        }

        long threadEndTime = System.currentTimeMillis();
        ArrayList<Double> yollaThread = new ArrayList<Double>();
        yollaThread.add(Double.parseDouble(Integer.toString(threadNumber)));
        yollaThread.add(Double.parseDouble(Long.toString((threadEndTime-threadTime))));
        syncEkle.sum(sayici,sonuclar,yollaThread);
        //System.out.println( "thread numarası : " + threadNumber +"  | " + (threadEndTime-threadTime));

    }

    public void compareProduct(){

        int sayici = 0;
        for (int i = this.startIndex; i<=this.endIndex; i++){
            String[] words = dizi.get(i).getProduct().split("\\s+");

            for (int j = i+1; j<size; j++){
                double answ= 0;
                String[] words1 = dizi.get(j).getProduct().split("\\s+");
                double length = words.length;
                double length1 = words1.length;
                //System.out.println(words1[0]);
                int counter= 0;
                for (int a=0; a<words.length; a++){
                    for(int s=0; s<words1.length; s++){
                        if (words[a].equals(words1[s])){
                            //System.out.println(words[a] +" "+ words1[s]);
                            counter++;
                        }
                    }
                }
                if(length>=length1){
                    answ = (counter/length)*100;
                }else{
                    answ = (counter/length1)*100;
                }

                if(answ==treshold){

                    //syncEkle syncEkle = new syncEkle();
                    //syncEkle.sum();

                    sonuclar.add(Double.parseDouble(Integer.toString(i)));
                    sonuclar.add(Double.parseDouble(Integer.toString(j)));
                    sonuclar.add(answ);

                    sayici++;

                }
                //System.out.println(answ);
            }
        }

        long threadEndTime = System.currentTimeMillis();
        ArrayList<Double> yollaThread = new ArrayList<Double>();
        yollaThread.add(Double.parseDouble(Integer.toString(threadNumber)));
        yollaThread.add(Double.parseDouble(Long.toString((threadEndTime-threadTime))));
        syncEkle.sum(sayici,sonuclar,yollaThread);
        //System.out.println( "thread numarası : " + threadNumber +"  | " + (threadEndTime-threadTime));

    }

    public void compareCompany(){

        int sayici = 0;
        for (int i = this.startIndex; i<=this.endIndex; i++){
            String[] words = dizi.get(i).getCompany().split("\\s+");

            for (int j = i+1; j<size; j++){
                double answ= 0;
                String[] words1 = dizi.get(j).getCompany().split("\\s+");
                double length = words.length;
                double length1 = words1.length;
                //System.out.println(words1[0]);
                int counter= 0;
                for (int a=0; a<words.length; a++){
                    for(int s=0; s<words1.length; s++){
                        if (words[a].equals(words1[s])){
                            //System.out.println(words[a] +" "+ words1[s]);
                            counter++;
                        }
                    }
                }
                if(length>=length1){
                    answ = (counter/length)*100;
                }else{
                    answ = (counter/length1)*100;
                }

                if(answ==treshold){

                    //syncEkle syncEkle = new syncEkle();
                    //syncEkle.sum();

                    sonuclar.add(Double.parseDouble(Integer.toString(i)));
                    sonuclar.add(Double.parseDouble(Integer.toString(j)));
                    sonuclar.add(answ);

                    sayici++;

                }
                //System.out.println(answ);
            }
        }

        long threadEndTime = System.currentTimeMillis();
        ArrayList<Double> yollaThread = new ArrayList<Double>();
        yollaThread.add(Double.parseDouble(Integer.toString(threadNumber)));
        yollaThread.add(Double.parseDouble(Long.toString((threadEndTime-threadTime))));
        syncEkle.sum(sayici,sonuclar,yollaThread);
        //System.out.println( "thread numarası : " + threadNumber +"  | " + (threadEndTime-threadTime));

    }

    public void compareState(){

        int sayici = 0;
        for (int i = this.startIndex; i<=this.endIndex; i++){
            String[] words = dizi.get(i).getState().split("\\s+");

            for (int j = i+1; j<size; j++){
                double answ= 0;
                String[] words1 = dizi.get(j).getState().split("\\s+");
                double length = words.length;
                double length1 = words1.length;
                //System.out.println(words1[0]);
                int counter= 0;
                for (int a=0; a<words.length; a++){
                    for(int s=0; s<words1.length; s++){
                        if (words[a].equals(words1[s])){
                            //System.out.println(words[a] +" "+ words1[s]);
                            counter++;
                        }
                    }
                }
                if(length>=length1){
                    answ = (counter/length)*100;
                }else{
                    answ = (counter/length1)*100;
                }

                if(answ==treshold){

                    //syncEkle syncEkle = new syncEkle();
                    //syncEkle.sum();

                    sonuclar.add(Double.parseDouble(Integer.toString(i)));
                    sonuclar.add(Double.parseDouble(Integer.toString(j)));
                    sonuclar.add(answ);

                    sayici++;

                }
                //System.out.println(answ);
            }
        }

        long threadEndTime = System.currentTimeMillis();
        ArrayList<Double> yollaThread = new ArrayList<Double>();
        yollaThread.add(Double.parseDouble(Integer.toString(threadNumber)));
        yollaThread.add(Double.parseDouble(Long.toString((threadEndTime-threadTime))));
        syncEkle.sum(sayici,sonuclar,yollaThread);
        //System.out.println( "thread numarası : " + threadNumber +"  | " + (threadEndTime-threadTime));

    }

    private void compareZip_Code(){

        int sayici = 0;
        for (int i = this.startIndex; i<=this.endIndex; i++){
            String[] words = dizi.get(i).getZip_code().split("\\s+");

            for (int j = i+1; j<size; j++){
                double answ= 0;
                String[] words1 = dizi.get(j).getZip_code().split("\\s+");
                double length = words.length;
                double length1 = words1.length;
                //System.out.println(words1[0]);
                int counter= 0;
                for (int a=0; a<words.length; a++){
                    for(int s=0; s<words1.length; s++){
                        if (words[a].equals(words1[s])){
                            //System.out.println(words[a] +" "+ words1[s]);
                            counter++;
                        }
                    }
                }
                if(length>=length1){
                    answ = (counter/length)*100;
                }else{
                    answ = (counter/length1)*100;
                }

                if(answ==treshold){

                    //syncEkle syncEkle = new syncEkle();
                    //syncEkle.sum();

                    sonuclar.add(Double.parseDouble(Integer.toString(i)));
                    sonuclar.add(Double.parseDouble(Integer.toString(j)));
                    sonuclar.add(answ);

                    sayici++;

                }
                //System.out.println(answ);
            }
        }

        long threadEndTime = System.currentTimeMillis();
        ArrayList<Double> yollaThread = new ArrayList<Double>();
        yollaThread.add(Double.parseDouble(Integer.toString(threadNumber)));
        yollaThread.add(Double.parseDouble(Long.toString((threadEndTime-threadTime))));
        syncEkle.sum(sayici,sonuclar,yollaThread);
        //System.out.println( "thread numarası : " + threadNumber +"  | " + (threadEndTime-threadTime));

    }

    private void compareComplaint_Id(){

        int sayici = 0;
        for (int i = this.startIndex; i<=this.endIndex; i++){
            String[] words = dizi.get(i).getComplaint_id().split("\\s+");

            for (int j = i+1; j<size; j++){
                double answ= 0;
                String[] words1 = dizi.get(j).getComplaint_id().split("\\s+");
                double length = words.length;
                double length1 = words1.length;
                //System.out.println(words1[0]);
                int counter= 0;
                for (int a=0; a<words.length; a++){
                    for(int s=0; s<words1.length; s++){
                        if (words[a].equals(words1[s])){
                            //System.out.println(words[a] +" "+ words1[s]);
                            counter++;
                        }
                    }
                }
                if(length>=length1){
                    answ = (counter/length)*100;
                }else{
                    answ = (counter/length1)*100;
                }

                if(answ==treshold){

                    //syncEkle syncEkle = new syncEkle();
                    //syncEkle.sum();

                    sonuclar.add(Double.parseDouble(Integer.toString(i)));
                    sonuclar.add(Double.parseDouble(Integer.toString(j)));
                    sonuclar.add(answ);

                    sayici++;

                }
                //System.out.println(answ);
            }
        }

        long threadEndTime = System.currentTimeMillis();
        ArrayList<Double> yollaThread = new ArrayList<Double>();
        yollaThread.add(Double.parseDouble(Integer.toString(threadNumber)));
        yollaThread.add(Double.parseDouble(Long.toString((threadEndTime-threadTime))));
        syncEkle.sum(sayici,sonuclar,yollaThread);
        //System.out.println( "thread numarası : " + threadNumber +"  | " + (threadEndTime-threadTime));

    }

    public ArrayList<Double> getSonuclar() {
        return sonuclar;
    }

    public void setSonuclar(ArrayList<Double> sonuclar) {
        this.sonuclar = sonuclar;
    }

    public ArrayList<Record> getDizi() {
        return dizi;
    }

    public void setDizi(ArrayList<Record> dizi) {
        this.dizi = dizi;
    }

}
