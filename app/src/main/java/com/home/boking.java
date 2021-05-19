package com.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class boking extends AppCompatActivity {

    private DatabaseReference DBKoneksi;
    private String DBpemesananId;

    TextView txtJumlah, txtHarga, txtGetNama, txttgl_boking, txt_menit;
    EditText edtNama;
    CheckBox cbx_studio, cbx_recording, cbx_stik;
    int jumlah, total, harga=0, studio, recording, stik;
    String nama, statusStudio = "tidak", statusStik= "tidak", statusRecording= "tidak";
    boolean iscbx_studio, isCbx_recording, isCbx_Stik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boking);
        txtJumlah     = findViewById(R.id.txt_jumlah);
        txtHarga      = findViewById(R.id.txt_price);
        edtNama       = findViewById(R.id.txt_nama);
        txtGetNama    = findViewById(R.id.txt_getNama);
        txttgl_boking = findViewById(R.id.txt_tglboking);
        txt_menit     = findViewById(R.id.txt_menit);
        cbx_studio    = findViewById(R.id.cbx_studio);
        cbx_recording = findViewById(R.id.cbx_recording);
        cbx_stik      = findViewById(R.id.cbx_stik);

        DBKoneksi     = FirebaseDatabase.getInstance().getReference("Boking");
        DBpemesananId= DBKoneksi.push().getKey();
    }

    public void Studio(){
        if (cbx_studio.isChecked()){
            iscbx_studio=true;
            statusStudio="Studio";
            studio=50000;
        }else{
            iscbx_studio=false;
            statusStudio="";
            studio=0;
        }
        if (cbx_stik.isChecked()){
            isCbx_Stik=true;
            statusStik="Sewa Stik Drum";
            stik=5000;
        }else{
            isCbx_Stik=false;
            statusStik="";
            stik=0;
        }
        if (cbx_recording.isChecked()){
            isCbx_recording=true;
            statusRecording="Recording";
            recording=100000;
        }else{
            isCbx_recording=false;
            statusRecording="";
            recording=0;
        }
    }
    public void tambah(View view) {
        jumlah = jumlah + 1;
        txtJumlah.setText("" + jumlah);
    }

    public void kurang(View view) {
        jumlah = 0;
        txtJumlah.setText("" + jumlah);
    }

    public void order(View view) {
        display(harga);
        simpanData();
    }

    private void simpanData() {
        dbpemsananId pemesanan = new dbpemsananId(DBpemesananId,
                edtNama.getText().toString(),
                txtJumlah.getText().toString(),
                txtHarga.getText().toString(),
                txtGetNama.getText().toString(),
                txttgl_boking.getText().toString(),
                txt_menit.getText().toString());
        Toast.makeText(getApplicationContext(), "Data Berhasil Di simpan!!", Toast.LENGTH_LONG).show();

        DBKoneksi.child(DBpemesananId).setValue(pemesanan);
    }
    public void display(int harga) {

        Studio();
        total = jumlah*harga;
        if (iscbx_studio){
            total += (jumlah * studio);
        }
        if (isCbx_recording) {
            total += (jumlah * recording);
        }
        if (isCbx_Stik) {
            total += (jumlah * stik);
        }
        Log.i("harga :", "" +total);
        nama = edtNama.getText().toString();
        txtGetNama.setText("Nama : " + nama + "\n" + statusStudio + "\n" + statusStik + "\n" + statusRecording );
        txtHarga.setText("Harga : Rp." +total );
    }

    public void cancel(View view) {
        startActivity(new Intent(getApplicationContext(), Home.class));
    }

    public void hapus(View view) {
        txtGetNama.setText(" ");
        txtHarga.setText(" ");
        Toast.makeText(getApplicationContext(), "Data Berhasil Dihapus", Toast.LENGTH_LONG).show();
    }

    public void btnmin(View view) {
        jumlah = 0;
        txt_menit.setText("" + jumlah);
    }

    public void btnplus(View view) {
        jumlah = jumlah + 1;
        txt_menit.setText("" + jumlah);
    }
}
