package com.example.aplikasimacam2kendaraan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Spinner spinnerku;
    TextView textku;
    ImageView imageku;
    TextView textcardku;

    String[] namakendaraan = {"Pesawat", "Ambulan", "Civic", "Corvette", "Damkar", "Ford", "Formula1", "Helikopter", "Pesawat Jet", "Mobil GT", "Moto GP", "Passat", "Polisi"};
    int[] gambarkendaraan = {R.drawable.airplane,R.drawable.ambulance,R.drawable.civic,R.drawable.corvette,R.drawable.firetruck,R.drawable.ford,R.drawable.formula1,R.drawable.helicopter,R.drawable.jet,R.drawable.mobilgt,R.drawable.motogp,R.drawable.passat,R.drawable.police};
    int[] suarakendaraan = {R.raw.airplane,R.raw.ambulance,R.raw.civic,R.raw.corvette,R.raw.firetruck,R.raw.ford,R.raw.formula1,R.raw.helicopter,R.raw.jet,R.raw.mobilgt,R.raw.motogp,R.raw.passat,R.raw.police};
    String[] pengertian = {"Pesawat terbang adalah pesawat udara yang lebih berat dari udara, bersayap tetap, dan dapat terbang dengan tenaga sendiri",
                           "Ambulans adalah kendaraan yang dilengkapi peralatan medis untuk mengangkut orang sakit atau korban kecelakaan",
                           "Civic adalah mobil yang diproduksi oleh Honda Motor Co. Pertama kali diperkenalkan pada Juli 1972 sebagai coupe 2 pintu, diikuti dengan versi hatchback 3 pintu pada September tahun itu juga. Mobil ini menganut sistem gerak roda depan, di mana mesinnya diletakan melintang, sehingga dapat menyediakan ruang interior yang cukup luas walaupun dimensi mobil terbilang kecil.",
                           "Corvette adalah mobil sport yang diproduksi oleh Chevrolet, salah satu divisi dari General Motors. Mobil ini sudah dibuat dalam 6 generasi. Model pertamanya, sebuah konvertibel, didesain oleh Harley Earl, dipertunjukkan ke publik di GM Motorama pada tahun 1953 sebagai mobil konsep. Myron Scott adalah orang yang mencetuskan nama Corvette untuk mobil ini.",
                           "Mobil pemadam kebakaran merupakan mobil yang di gunakan ketika kebakaran besar terjadi. Perlu diketahui bahwa pemadam kebakaran telah ada di Indonesia sejak tahun 1850. Namun saat itu keterbatasan alat pemadam kebakaran tidak membatasi para pemadam untuk tetap menaklukan api.",
                           "Ford Model T (bahasa sehari-hari dikenal sebagai Tin Lizzie, Leaping Lena, jitney atau flivver) adalah mobil yang diproduksi oleh Ford Motor Company dari 1 Oktober 1908 hingga 26 Mei 1927. Mobil ini umumnya dianggap sebagai mobil pertama yang terjangkau, yaitu mobil yang membuka perjalanan ke kelas menengah Amerika.",
                           "Formula1, disingkat F1 (atau bernama lengkap FIA Formula One World Championship), adalah kelas balapan mobil formula tempat duduk tunggal yang tertinggi. Terdiri dari sejumlah seri balapan yang dikenal dengan istilah Grand Prix. Balapan diselenggarakan di dalam sirkuit atau jalan umum dalam kota yang ditutup untuk umum.",
                           "Helikopter adalah pesawat udara yang lebih berat dari udara, bersayap putar yang rotornya digerakkan oleh mesin. Helikopter merupakan pesawat udara yang mengangkat dan terdorong oleh satu atau lebih rotor (propeller) horizontal besar. Helikopter diklasifikasikan sebagai pesawat bersayap putar untuk membedakannya dari pesawat bersayap tetap biasa lainnya.",
                           "Pesawat Jet adalah pesawat terbang yang menggunakan mesin jet. Tidak seperti pesawat baling-baling, pesawat jet umumnya terbang pada ketinggian 10.000 sampai 15.000 meter. Pada ketinggian ini, pesawat jet dapat mencapai efisiensi maksimum.",
                           "Mobil GT adalah mobil sport yang dibuat oleh Nissan, dikeluarkan di Jepang pada 6 Desember 2007, Amerika Serikat pada 7 Juli 2008, dan seluruh dunia pada Maret 2009. Nissan GT-R merupakan mobil sport terbaru yang dibuat di Jepang dan menggunakan mesin V6 Twin-Turbo, dan merupakan penerus dari jajaran Nissan Skyline GT-R",
                           "Moto GP, Kejuaraan Dunia MotoGP atau kerap disebut sebagai MotoGP saja atau nama resminya FIM MotoGP World Championship adalah kelas utama dari seri balapan Grand Prix Sepeda Motor. Dulunya kelas ini dikenal dengan nama kelas 500cc atau biasa disebut GP500 yang pertama kali digelar sejak musim 1949.",
                           "Passat, Volkswagen Passat adalah sebuah mobil keluarga besar yang diproduksi oleh Volkswagen Passenger Cars sejak tahun 1973. Dalam jajaran mobil Volkswagen saat ini, Passat berada di antara Volkswagen Golf / Volkswagen Jetta dan Volkswagen Phaeton. Di banyak negara lain, mobil ini juga diberi merek Dasher, Santana, Quantum, Magotan, Corsar dan Carat.",
                           "Mobil Polisi befungsi untuk menangkap para penjahat, membawa tahanan, berpatroli dan lain-lain. Polisi adalah suatu pranata umum sipil yang menjaga ketertiban, keamanan dan penegakan hukum diseluruh wilayah negara."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerku = (Spinner) findViewById(R.id.spnkendaraan);
        textku = (TextView) findViewById(R.id.txtspn);
        imageku = (ImageView) findViewById(R.id.gbrspn);
        textcardku = (TextView) findViewById(R.id.suarakendaraan);

        ArrayAdapter adapterkendaraan = new ArrayAdapter(this, android.R.layout.simple_spinner_item, namakendaraan);
        spinnerku.setAdapter(adapterkendaraan);
        spinnerku.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                textku.setText(namakendaraan[i]);
                textcardku.setText(pengertian[i]);
                imageku.setImageResource(gambarkendaraan[i]);
                MediaPlayer suara = MediaPlayer.create(MainActivity.this, suarakendaraan[i]);
                suara.start();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
