package com.company.View;

import com.company.Caller;
import com.company.FileRead.ReadCSV;

import com.company.Helper.Helper;

import com.company.Searching.syncEkle;
import com.company.models.Record;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class mainPageGUI extends JFrame {
    private JPanel wrapper;

    private JTabbedPane tab_multiThread;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JPanel pnl_search;
    private JButton btn_search;
    private JTextField fld_benzerlik_oran;
    private JTextField fld_sutun_1;
    private JTextField fld_customer_tcno;
    private JTextField fld_sutun_2;
    private JTextField fld_customer_password;
    private JLabel lbl_sutun1;
    private JLabel lbl_benzerlik_oran;
    private JTextField fld_thread_number;
    private JLabel lbl_thread_number;
    private JPanel pnl_threads;
    private JScrollPane scrl_threads;
    private JTable tbl_threads;
    private JTable tbl_hesap_talep;
    private  JTable tbl_sonuc;
    private JPanel pnl_sonuc;
    private JScrollPane scrl_sonuc;
    private JTable tbl_musteri_islemgecmisi;
    private JComboBox sutun1Box;
    private JTextField fld_toplam_sure;
    private JLabel toplam_sure;
    private JPanel pnl_arama_2;
    private JButton btn_search_arama2;
    private JLabel lbl_benzerlik_orani_arama2;
    private JTextField fld_benzerlik_oran_arama2;
    private JLabel lbl_sutun1_arama2;
    private JLabel lbl_sutun2_arama2;
    private JTextField fld_sutun1_arama2;
    private JTextField fld_sutun2_arama2;
    private JLabel lbl_thread_arama2;
    private JTextField fld_thread_arama2;
    private JTextField fld_esitlik_arama2;
    private JLabel lbl_esitlik_arama2;
    private JPanel pnl_arama_3;
    private JLabel lbl_benzerlik_arama3;
    private JTextField fld_benzerlik_arama3;
    private JLabel lbl_benzerlik2_arama3;
    private JTextField fld_benzerlik2_arama3;
    private JLabel lbl_sutun1_arama3;
    private JTextField fld_sutun1_arama3;
    private JLabel lbl_sutun2_arama3;
    private JTextField fld_sutun2_arama3;
    private JLabel lbl_thread_arama3;
    private JTextField fld_thread_arama3;
    private JButton btn_search_arama3;
    private JButton btn_reddet;
    private JButton btn_onayla;
    private JTextField fld_islemid;
    private DefaultTableModel mdl_thread;
    private DefaultTableModel mdl_hesap_taleplist;
    private  DefaultTableModel mdl_sonuc_list;
    private DefaultTableModel mdl_musteri_islemgecmisilist;
    private Object[] row_thread;
    private Object[] row_sonuc_list;
    private Object[] row_kredi_taleplist;
    private Object[] row_musteri_islemgecmisilist;

    public mainPageGUI() {


        this.add(wrapper);
        setSize(700, 550);
        int x = Helper.screenLocationCenter("x", getSize());
        int y = Helper.screenLocationCenter("y", getSize());
        setLocation(x, y);
        //setTitle(Config.PROJECT_TITTLE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);


        syncEkle syncEkle = new syncEkle();

        sutun1Box.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(sutun1Box.getSelectedIndex());
            }
        });



        // threadler
        mdl_thread = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 5 || column == 2) {
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };
        Object[] col_thread = {"Thread ID", "Çalışma Süresi"};
        mdl_thread.setColumnIdentifiers(col_thread);

        row_thread = new Object[col_thread.length];

        tbl_threads.setModel(mdl_thread);
        tbl_threads.getTableHeader().setReorderingAllowed(false);

        //loadBenzerlikSonuc("11","4","32");

        

        // sonuclar
        mdl_sonuc_list = new DefaultTableModel();
        Object[] col_sonuclist = {"Sutun 1", "Sutun 2", "Benzerlik Oranı"};
        mdl_sonuc_list.setColumnIdentifiers(col_sonuclist);

        row_sonuc_list = new Object[col_sonuclist.length];

        tbl_sonuc.setModel(mdl_sonuc_list);
        tbl_sonuc.getTableHeader().setReorderingAllowed(false);





        btn_search.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_benzerlik_oran)) {
                Helper.showMessage("fill");
            } else {

                String benzerlik_orani = fld_benzerlik_oran.getText();
                String sutun = sutun1Box.getSelectedItem().toString();
                String thread_sayisi = fld_thread_number.getText();
                if(thread_sayisi.isEmpty()){
                    thread_sayisi="1";
                }
                int secim = secimBelirleme(sutun);
                System.out.println(benzerlik_orani +" "+ sutun + " "  + thread_sayisi);
                //////////

                double benzerlik = Double.parseDouble(benzerlik_orani);
                int sutun_int = secim;
                int thread_say = Integer.parseInt(thread_sayisi);

                ArrayList<Double> sonuc_dizisi = new ArrayList<Double>();
                ArrayList<String> dizix = new ArrayList<>();
                ArrayList<Record> dizi= new ArrayList<>();
                ReadCSV a = new ReadCSV();
                dizi=a.getDizi();

                Caller caller = new Caller();
                long baslangic = System.currentTimeMillis();
                caller.arama1(benzerlik,sutun_int,thread_say);
                long bitis = System.currentTimeMillis();
                fld_toplam_sure.setText(Long.toString((bitis-baslangic)));
                sonuc_dizisi=syncEkle.getSonuclar();


                for (int i = 0; i < sonuc_dizisi.size(); i=i+3) {

                    int ilk_index= syncEkle.getSonuclar().get(i).intValue();
                    int ikinci_index=syncEkle.getSonuclar().get(i+1).intValue();
                    String ilk_index_string=syncEkle.getSonuclar().get(i).toString();
                    String ikinci_index_string=syncEkle.getSonuclar().get(i+1).toString();
                    String benzerlik_orani_string=syncEkle.getSonuclar().get(i+2).toString();
                    //loadBenzerlikSonuc(ilk_index_string,ikinci_index_string,benzerlik_orani_string,sonuc_dizisi.size());


                    switch (secim) {
                        case 1 :
                            dizix.add(dizi.get(ilk_index).getIssue());
                            dizix.add(dizi.get(ikinci_index).getIssue());
                            dizix.add(benzerlik_orani_string);
                            loadArama2Sonuc(dizix);
                            loadThreadSonuc(syncEkle.getThreadList());
                            break;

                        case 2 :
                            dizix.add(dizi.get(ilk_index).getCompany());
                            dizix.add(dizi.get(ikinci_index).getCompany());
                            dizix.add(benzerlik_orani_string);
                            loadArama2Sonuc(dizix);
                            loadThreadSonuc(syncEkle.getThreadList());
                            //loadThreadSonuc(syncEkle.getThreadList());
                            break;

                        case 3 :
                            dizix.add(dizi.get(ilk_index).getState());
                            dizix.add(dizi.get(ikinci_index).getState());
                            dizix.add(benzerlik_orani_string);
                            loadArama2Sonuc(dizix);
                            loadThreadSonuc(syncEkle.getThreadList());
                            //loadThreadSonuc(syncEkle.getThreadList());
                            break;


                        case 4:
                            dizix.add(dizi.get(ilk_index).getZip_code());
                            dizix.add(dizi.get(ikinci_index).getZip_code());
                            dizix.add(benzerlik_orani_string);
                            loadArama2Sonuc(dizix);
                            loadThreadSonuc(syncEkle.getThreadList());
                            //loadThreadSonuc(syncEkle.getThreadList());
                            break;

                        case 5:
                            dizix.add(dizi.get(ilk_index).getComplaint_id());
                            dizix.add(dizi.get(ikinci_index).getComplaint_id());
                            dizix.add(benzerlik_orani_string);
                            loadArama2Sonuc(dizix);
                            loadThreadSonuc(syncEkle.getThreadList());
                            //loadThreadSonuc(syncEkle.getThreadList());
                            break;
                        default :
                            dizix.add(dizi.get(ilk_index).getProduct());
                            dizix.add(dizi.get(ikinci_index).getProduct());
                            dizix.add(benzerlik_orani_string);
                            loadArama2Sonuc(dizix);
                            loadThreadSonuc(syncEkle.getThreadList());
                            //loadThreadSonuc(syncEkle.getThreadList());
                            break;
                    }

                }


            }
        });

        btn_search_arama2.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_benzerlik_oran_arama2)  || Helper.isFieldEmpty(fld_sutun2_arama2)) {
                Helper.showMessage("fill");
            } else {

                String benzerlik_orani = fld_benzerlik_oran_arama2.getText();
                String sutun1 = fld_sutun1_arama2.getText();
                String sutun2 = fld_sutun2_arama2.getText();
                String esitlik = fld_esitlik_arama2.getText();
                String thread_sayisi = fld_thread_arama2.getText();
                if(thread_sayisi.isEmpty()){
                    thread_sayisi="1";
                }
                int secim = secimBelirleme(sutun2);


                System.out.println(benzerlik_orani+" "+" "+ sutun1 +" "+ esitlik +" "+ sutun2 +" "+ thread_sayisi);

                double benzerlik = Double.parseDouble(benzerlik_orani);
                int sutun = secim;
                int thread_say = Integer.parseInt(thread_sayisi);
                Caller caller = new Caller();

                ArrayList<Double> sonuc_dizisi = new ArrayList<Double>();
                ArrayList<String> dizix = new ArrayList<>();
                ArrayList<Record> dizi= new ArrayList<>();
                ReadCSV a = new ReadCSV();
                dizi=a.getDizi();
                syncEkle.emptySonuclar();
                long baslangic = System.currentTimeMillis();
                caller.arama2(benzerlik,esitlik,sutun,thread_say);
                long bitis = System.currentTimeMillis();
                fld_toplam_sure.setText(Long.toString((bitis-baslangic)));
                sonuc_dizisi=syncEkle.getSonuclar();


                for (int i = 0; i < sonuc_dizisi.size(); i=i+3) {

                        int ilk_index= syncEkle.getSonuclar().get(i).intValue();
                        int ikinci_index=syncEkle.getSonuclar().get(i+1).intValue();
                        String ilk_index_string=syncEkle.getSonuclar().get(i).toString();
                        String ikinci_index_string=syncEkle.getSonuclar().get(i+1).toString();
                        String benzerlik_orani_string=syncEkle.getSonuclar().get(i+2).toString();
                        //loadBenzerlikSonuc(ilk_index_string,ikinci_index_string,benzerlik_orani_string,sonuc_dizisi.size());


                        switch (secim) {
                        case 1 :
                            dizix.add(dizi.get(ilk_index).getIssue());
                            dizix.add(dizi.get(ikinci_index).getIssue());
                            dizix.add(benzerlik_orani_string);
                            loadArama2Sonuc(dizix);
                            loadThreadSonuc(syncEkle.getThreadList());
                            break;

                        case 2 :
                            dizix.add(dizi.get(ilk_index).getCompany());
                            dizix.add(dizi.get(ikinci_index).getCompany());
                            dizix.add(benzerlik_orani_string);
                            loadArama2Sonuc(dizix);
                            loadThreadSonuc(syncEkle.getThreadList());
                            break;

                        case 3 :
                            dizix.add(dizi.get(ilk_index).getState());
                            dizix.add(dizi.get(ikinci_index).getState());
                            dizix.add(benzerlik_orani_string);
                            loadArama2Sonuc(dizix);
                            loadThreadSonuc(syncEkle.getThreadList());
                            break;


                        case 4:
                            dizix.add(dizi.get(ilk_index).getZip_code());
                            dizix.add(dizi.get(ikinci_index).getZip_code());
                            dizix.add(benzerlik_orani_string);
                            loadArama2Sonuc(dizix);
                            loadThreadSonuc(syncEkle.getThreadList());
                            break;

                        case 5:
                            dizix.add(dizi.get(ilk_index).getComplaint_id());
                            dizix.add(dizi.get(ikinci_index).getComplaint_id());
                            dizix.add(benzerlik_orani_string);
                            loadArama2Sonuc(dizix);
                            loadThreadSonuc(syncEkle.getThreadList());
                             break;
                        default :
                            dizix.add(dizi.get(ilk_index).getProduct());
                            dizix.add(dizi.get(ikinci_index).getProduct());
                            dizix.add(benzerlik_orani_string);
                            loadThreadSonuc(syncEkle.getThreadList());
                            loadArama2Sonuc(dizix);
                            break;
                         }

                    }



            }
        });

        btn_search_arama3.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_benzerlik_arama3) || Helper.isFieldEmpty(fld_sutun1_arama3) || Helper.isFieldEmpty(fld_sutun2_arama3)) {
                Helper.showMessage("fill");
            } else {

                String benzerlik_orani1 = fld_benzerlik_arama3.getText();
                String benzerlik_orani2 = fld_benzerlik2_arama3.getText();
                String sutun1 = fld_sutun1_arama3.getText();
                String sutun2 = fld_sutun2_arama3.getText();
                String thread_sayisi = fld_thread_arama3.getText();
                if(thread_sayisi.isEmpty()){
                    thread_sayisi="1";
                }
                int secim1 = secimBelirleme(sutun1);
                int secim2=  secimBelirleme(sutun2);
                System.out.println(benzerlik_orani1+" "+benzerlik_orani2 +" "+ sutun1 +" "+ sutun2 +" "+ thread_sayisi);

                /////////
                double benzerlik1 = Double.parseDouble(benzerlik_orani1);
                double benzerlik2 = Double.parseDouble(benzerlik_orani2);
                int sutun1_int = secim1;
                int sutun2_int = secim2;
                int thread_say = Integer.parseInt(thread_sayisi);

                ArrayList<Double> sonuc_dizisi = new ArrayList<Double>();
                ArrayList<String> dizix = new ArrayList<>();
                ArrayList<Record> dizi= new ArrayList<>();
                ReadCSV a = new ReadCSV();
                dizi=a.getDizi();
                Caller caller = new Caller();
                long baslangic = System.currentTimeMillis();
                caller.arama3(benzerlik1,benzerlik2,sutun1_int,sutun2_int,thread_say);
                long bitis = System.currentTimeMillis();
                fld_toplam_sure.setText(Long.toString((bitis-baslangic)));
                sonuc_dizisi=syncEkle.getSonuclar();


                for (int i = 0; i < sonuc_dizisi.size(); i=i+3) {

                    int ilk_index= syncEkle.getSonuclar().get(i).intValue();
                    int ikinci_index=syncEkle.getSonuclar().get(i).intValue();
                    String ilk_index_string=syncEkle.getSonuclar().get(i).toString();
                    String ikinci_index_string=syncEkle.getSonuclar().get(i+1).toString();
                    String benzerlik_orani_string=syncEkle.getSonuclar().get(i+2).toString();
                    //loadBenzerlikSonuc(ilk_index_string,ikinci_index_string,benzerlik_orani_string,sonuc_dizisi.size());

                    int secim = secimBelirleme(sutun2);

                    switch (secim) {
                        case 1 :
                            dizix.add(dizi.get(ilk_index).getIssue());
                            dizix.add(dizi.get(ikinci_index).getIssue());
                            dizix.add(benzerlik_orani_string);
                            loadArama2Sonuc(dizix);
                            loadThreadSonuc(syncEkle.getThreadList());
                            break;

                        case 2 :
                            dizix.add(dizi.get(ilk_index).getCompany());
                            dizix.add(dizi.get(ikinci_index).getCompany());
                            dizix.add(benzerlik_orani_string);
                            loadArama2Sonuc(dizix);
                            loadThreadSonuc(syncEkle.getThreadList());
                            break;

                        case 3 :
                            dizix.add(dizi.get(ilk_index).getState());
                            dizix.add(dizi.get(ikinci_index).getState());
                            dizix.add(benzerlik_orani_string);
                            loadArama2Sonuc(dizix);
                            loadThreadSonuc(syncEkle.getThreadList());
                            break;


                        case 4:
                            dizix.add(dizi.get(ilk_index).getZip_code());
                            dizix.add(dizi.get(ikinci_index).getZip_code());
                            dizix.add(benzerlik_orani_string);
                            loadArama2Sonuc(dizix);
                            loadThreadSonuc(syncEkle.getThreadList());
                            break;

                        case 5:
                            dizix.add(dizi.get(ilk_index).getComplaint_id());
                            dizix.add(dizi.get(ikinci_index).getComplaint_id());
                            dizix.add(benzerlik_orani_string);
                            loadArama2Sonuc(dizix);
                            loadThreadSonuc(syncEkle.getThreadList());
                            break;
                        default :
                            dizix.add(dizi.get(ilk_index).getProduct());
                            dizix.add(dizi.get(ikinci_index).getProduct());
                            dizix.add(benzerlik_orani_string);
                            loadArama2Sonuc(dizix);
                            loadThreadSonuc(syncEkle.getThreadList());
                            break;
                    }

                }
                /////////



            }
        });


    }


    public int secimBelirleme(String secim_string){
        int secim=0;
        secim_string=secim_string.toUpperCase();
        switch (secim_string) {
            case "ISSUE" :
                secim=1;
                break;

            case "COMPANY" :
                secim=2;
                break;

            case "STATE" :
                secim=3;
                break;


            case "ZIP CODE":
                secim=4;
                break;

            case "COMPLAINT ID":
                secim=5;
                break;

        }
        return secim;
    }


    //Sonuc Listeleme
/*
    public void SonucDeneme(){
        ArrayList<Double> sonuc_dizisi = new ArrayList<Double>();
        ArrayList<Record> dizi= new ArrayList<>();
        ReadCSV a = new ReadCSV();
        dizi=a.getDizi();
        Compare deneme = new Compare();
        deneme.setDizi(dizi);
        // Berkay deneme
        sonuc_dizisi=deneme.compareRows2();
        double istenen_benzerlik_orani;
        istenen_benzerlik_orani=0.0;
        ArrayList<String> dizix = new ArrayList<>();
        for (int i = 0; i < sonuc_dizisi.size(); i=i+3) {
            if(sonuc_dizisi.get(i+2)>=istenen_benzerlik_orani){
                System.out.println("İlk İndex: "+sonuc_dizisi.get(i)+" İkinci İndex: "+sonuc_dizisi.get(i+1)+" Benzerlik: "+sonuc_dizisi.get(i+2));
                int ilk_index=sonuc_dizisi.get(i).intValue();
                int ikinci_index=sonuc_dizisi.get(i+1).intValue();
                System.out.println("İlk İndex: "+deneme.getDizi().get(ilk_index).getIssue()+" İkinci İndex: "+deneme.getDizi().get(ikinci_index).getIssue());
                String ilk_index_string=sonuc_dizisi.get(i).toString();
                String ikinci_index_string=sonuc_dizisi.get(i+1).toString();
                String benzerlik_orani_string=sonuc_dizisi.get(i+2).toString();
                //loadBenzerlikSonuc(ilk_index_string,ikinci_index_string,benzerlik_orani_string,sonuc_dizisi.size());

                dizix.add(deneme.getDizi().get(ilk_index).getIssue());
                dizix.add(deneme.getDizi().get(ikinci_index).getIssue());
                dizix.add(benzerlik_orani_string);
                loadBenzerlikSonucX(dizix);
            }
        }
    }
    */
    public void loadBenzerlikSonuc(String ilk_index, String ikinci_index, String benzerlik_orani,int dizi_uzunlugu) {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_sonuc.getModel();
        clearModel.setRowCount(0);

        /*for () {


            row_sonuc_list[0] = obj.getIstek_id();
            row_sonuc_list[1] = obj.getHesap_no();
            row_sonuc_list[2] = obj.getTc_no();
            row_sonuc_list[3] = obj.getIstek_turu();
            row_sonuc_list[4] = obj.getDoviz_turu();
            row_sonuc_list[5] = obj.getOnay_durumu();
            mdl_hesap_taleplist.addRow(row_sonuc_list);

        }*/
        for (int i = 0; i < dizi_uzunlugu; i++) {
            row_sonuc_list[0]= ilk_index;
            row_sonuc_list[1]= ikinci_index;
            row_sonuc_list[2]= "% "+benzerlik_orani;
            mdl_sonuc_list.addRow(row_sonuc_list);
        }

    }
    public void loadBenzerlikSonucX(ArrayList<String>dizi) {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_sonuc.getModel();
        clearModel.setRowCount(0);

        /*for () {


            row_sonuc_list[0] = obj.getIstek_id();
            row_sonuc_list[1] = obj.getHesap_no();
            row_sonuc_list[2] = obj.getTc_no();
            row_sonuc_list[3] = obj.getIstek_turu();
            row_sonuc_list[4] = obj.getDoviz_turu();
            row_sonuc_list[5] = obj.getOnay_durumu();
            mdl_hesap_taleplist.addRow(row_sonuc_list);

        }*/
        for (int i = 0; i < dizi.size(); i=i+3) {
            row_sonuc_list[0]= dizi.get(i);
            row_sonuc_list[1]= dizi.get(i+1);
            row_sonuc_list[2]= "% "+dizi.get(i+2);
            mdl_sonuc_list.addRow(row_sonuc_list);
        }

    }



    //ARAMA 2 SONUC
    public void loadArama2Sonuc(ArrayList<String>dizi) {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_sonuc.getModel();
        clearModel.setRowCount(0);


        for (int i = 0; i < dizi.size(); i=i+3) {
            row_sonuc_list[0]= dizi.get(i);
            row_sonuc_list[1]= dizi.get(i+1);
            row_sonuc_list[2]= "% "+dizi.get(i+2);
            mdl_sonuc_list.addRow(row_sonuc_list);
        }

    }

    //THREAD SONUC
    public void loadThreadSonuc(ArrayList<Double>dizi) {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_threads.getModel();
        clearModel.setRowCount(0);


        for (int i = 0; i < dizi.size(); i=i+3) {
            if(i+1 < dizi.size()){
                row_thread[0]= dizi.get(i);
                row_thread[1]= dizi.get(i+1);

                mdl_thread.addRow(row_thread);
            }

        }

    }










    public static void main(String[] args) {
        Helper.setLayout();

        mainPageGUI cRepGUI = new mainPageGUI();


    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        String sutunlar [] = {"Product","Issue","Company","State","Zip-Code","Complaint ID"};
        sutun1Box=new JComboBox(sutunlar);
    }
}

