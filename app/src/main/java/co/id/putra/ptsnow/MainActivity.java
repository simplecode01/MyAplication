package co.id.putra.ptsnow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import co.id.putra.ptsnow.penampiluser.MenampilkanUser;

public class MainActivity extends AppCompatActivity {
    ListView ListSiswa;

    HashMap<String, String> map;

    SimpleAdapter adapter;

    ArrayList<HashMap<String, String>> mylist;

    String[] namasiswa ={
            "Putra",
            "Hikaru",
            "Azka",
            "Azzam",
            "Afif",
            "Yuki",
            "Syauqi"

    };
    String kelas = "10" ;

    String[] jurusan ={
            "RRL",
            "RPL",
            "RPL",
            "RPL",
            "RPL",
            "TKJ",
            "TKJ"
    };

    String[] tanggaltambah ={
            "20 Februari 2020",
            "22 Februari 2020",
            "01 January 2020",
            "4 Maret 2019",
            "15 Desember 2019",
            "7 November 2019",
            "8 Novemver 2019"
    };

    String[] image11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListSiswa =(ListView)findViewById(R.id.ListSiswa11);



        image11 = new String[]{
                Integer.toString(R.drawable.user),Integer.toString(R.drawable.user),Integer.toString(R.drawable.user),
                Integer.toString(R.drawable.user),Integer.toString(R.drawable.user),Integer.toString(R.drawable.user),
                Integer.toString(R.drawable.user)
        };

        mylist = new ArrayList<HashMap<String, String>>();

        for (int i=0; i<namasiswa.length; i++){
            map = new HashMap<String, String>();
            map.put("judul", namasiswa[i]);
            map.put("Keterangan", jurusan[i]);
            map.put("Gambar", image11[i]);
            map.put("Keterangan2", tanggaltambah[i]);
            mylist.add(map);
        }


        adapter = new SimpleAdapter(this, mylist, R.layout.kustomlistactivity,
                new String[]{"judul", "Keterangan", "Gambar", "Keterangan2"}, new int[]{R.id.txt_judul,(R.id.txt_keterangan),(R.id.img),(R.id.txt_keterangan1)});
        ListSiswa.setAdapter(adapter);







        ListSiswa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



                Toast.makeText(MainActivity.this, "Data Siswa Yang Dipilih " + namasiswa[position], Toast.LENGTH_SHORT).show();


                Bundle abc = new Bundle();
                abc.putString("SISWA", namasiswa[position]);
                abc.putString("KELAS", kelas);
                abc.putString("JURUSAN", jurusan[position]);
                abc.putString("TANGGAL", tanggaltambah[position]);
                Intent asd = new Intent(MainActivity.this, MenampilkanUser.class);
                asd.putExtras(abc);
                startActivity(asd);

            }
        });

    }
}
