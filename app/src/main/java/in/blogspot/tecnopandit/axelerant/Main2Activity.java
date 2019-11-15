package in.blogspot.tecnopandit.axelerant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView=findViewById(R.id.result);
        Intent intent=getIntent();
        String f=intent.getStringExtra("finalres");
        textView.setText(f);
    }
}
