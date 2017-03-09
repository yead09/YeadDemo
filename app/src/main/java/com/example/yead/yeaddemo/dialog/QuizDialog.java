package com.example.yead.yeaddemo.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.yead.yeaddemo.DialogActivity;
import com.example.yead.yeaddemo.ListViewActivity;
import com.example.yead.yeaddemo.R;
import com.example.yead.yeaddemo.ViewPagerActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Yead on 3/7/2017.
 */

public class QuizDialog extends Dialog{

    private QuizDialog.ICustomDialogEventListener listener;
    private int checkedID;


    @BindView(R.id.quizrdg)
    RadioGroup radioGroup;

    @OnClick(R.id.quizCancel)
    public void onCancel(){
        //Intent intent = new Intent(getContext(), ViewPagerActivity.class );
        //getContext().startActivity(intent);
        dismiss();
    }

    @OnClick(R.id.quizOK)
    public void onOkay(){
        switch (checkedID){
            case R.id.quiz1:
                listener.onClickListener();
                Intent intent = new Intent(getContext(), DialogActivity.class );
                getContext().startActivity(intent);
                break;
            case R.id.quiz2:
                Intent intent2 = new Intent(getContext(), ListViewActivity.class );
                getContext().startActivity(intent2);
                break;
            default:
        }
        dismiss();
    }






      public QuizDialog(@NonNull Context context, QuizDialog.ICustomDialogEventListener listener){
          super(context, R.style.dialog);
          this.listener = listener;
      }

    public interface ICustomDialogEventListener{
        public void onClickListener();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_dialog);
        ButterKnife.bind(this);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                //toastShort("You checked the radio button"+checkedId);
                checkedID = checkedId;
            }
        });
    }
}
