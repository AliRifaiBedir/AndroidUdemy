package com.example.receyclerview;

public class MesajmModel {

        private  String MesajIcerik;
        private  String Kisi;
        private int ResimId;

        public String getMesajIcerik() {
            return MesajIcerik;
        }

        public void setMesajIcerik(String mesajIcerik) {
            MesajIcerik = mesajIcerik;
        }

        public String getKisi() {
            return Kisi;
        }

        public void setKisi(String kisi) {
            Kisi = kisi;
        }

        public int getResimId() {
            return ResimId;
        }

        public void setResimId(int resimId) {
            ResimId = resimId;
        }

        public MesajmModel(String mesajIcerik, String kisi, int resimId) {
            this.MesajIcerik = mesajIcerik;
            this.Kisi = kisi;
            this.ResimId = resimId;
        }
    }


