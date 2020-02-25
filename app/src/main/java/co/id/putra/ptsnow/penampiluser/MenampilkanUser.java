package co.id.putra.ptsnow.penampiluser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import co.id.putra.ptsnow.MainActivity;
import co.id.putra.ptsnow.R;

public class MenampilkanUser extends AppCompatActivity {

    TextView tv1, tv2, tv3, tv4 ;

    String data1, data2, data3, data4;

    Button bt1 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menampilkan_user);
        tv1 = (TextView)findViewById(R.id.tv_nama);
        tv2 = (TextView)findViewById(R.id.tv_kelas);
        tv3 = (TextView)findViewById(R.id.tv_jurusan);
        tv4 = (TextView)findViewById(R.id.tv_tanggal);
        bt1 = (Button)findViewById(R.id.bt_back);


        Bundle getData = getIntent().getExtras();
        data1 = getData.getString("SISWA");
        data2 = getData.getString("KELAS");
        data3 = getData.getString("JURUSAN");
        data4 = getData.getString("TANGGAL");

        tv1.setText(data1);
        tv2.setText(data2);
        tv3.setText(data3);
        tv4.setText(data4);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abc = new Intent(MenampilkanUser.this, MainActivity.class);
                startActivity(abc);
            }
        });

    }
}
