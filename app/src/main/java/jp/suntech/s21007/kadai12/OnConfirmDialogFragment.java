package jp.suntech.s21007.kadai12;

import androidx.fragment.app.DialogFragment;
import androidx.appcompat.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class OnConfirmDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("送信確認");
        builder.setMessage("この内容で送信しますか？");
        builder.setPositiveButton("送信",new DialogButtonClickListener());
        builder.setNegativeButton("キャンセル",new DialogButtonClickListener());
        AlertDialog dialog=builder.create();
        return dialog;
    }

    private class DialogButtonClickListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog,int which){
            String msg="";
            Toast toast;
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    msg="送信しました。";
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    msg="キャンセルしました。";
                    break;
            }
            Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT).show();
        }
    }
}
