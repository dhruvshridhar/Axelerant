package in.blogspot.tecnopandit.axelerant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
RadioGroup radioGroup;
Button button,result;
SqlHelperClass db;
RadioButton radioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new SqlHelperClass(this);
        //long r=db.insert();
        //Toast.makeText(getApplicationContext(),Long.toString(r) ,Toast.LENGTH_SHORT).show();
        result=findViewById(R.id.button2);
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String res=db.getval();
                Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
                intent.putExtra("finalres",res);
                startActivity(intent);
            }
        });
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioGroup=findViewById(R.id.rg);
                int selected = radioGroup.getCheckedRadioButtonId();
                radioButton=findViewById(selected);
                Toast.makeText(getApplicationContext(),radioButton.getText(),Toast.LENGTH_SHORT).show();
                long r=db.insert(radioButton.getTag().toString());
                Toast.makeText(getApplicationContext(),Long.toString(r) ,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
