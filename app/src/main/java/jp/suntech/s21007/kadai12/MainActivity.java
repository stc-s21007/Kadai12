package jp.suntech.s21007.kadai12;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BtnListener listener=new BtnListener();
        Button btConfirm=findViewById(R.id.btConfirm);
        Button btSend=findViewById(R.id.btSend);
        Button btClear=findViewById(R.id.btClear);

        btConfirm.setOnClickListener(listener);
        btClear.setOnClickListener(listener);
        btSend.setOnClickListener(listener);
    }

    private class BtnListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            int id= view.getId();

            //EditText
            EditText Name=findViewById(R.id.etName);
            EditText MTitle=findViewById(R.id.etMTitle);
            EditText Mail=findViewById(R.id.etMail);
            EditText Comment=findViewById(R.id.etComment);

            String text=Name.getText().toString()+","+MTitle.getText().toString()+","+Mail.getText().toString()+","+Comment.getText().toString();
            Toast toast=Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG);
            switch (id){
                case R.id.btSend:
                    toast.show();
                    break;
                case R.id.btConfirm:
                    OnConfirmDialogFragment Dialog=new OnConfirmDialogFragment();
                    toast.show();
                    Dialog.show(getSupportFragmentManager(),"Dialog");
                    break;
                case R.id.btClear:
                    Name.setText("");
                    MTitle.setText("");
                    Mail.setText("");
                    Comment.setText("");
                    break;
            }

        }
    }
}