package com.example.yead.yeaddemo.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.example.yead.yeaddemo.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Yead on 2/15/2017.
 */

public class CustomDialog extends Dialog {
    @OnClick(R.id.dialog_ok2)
    public void okClick(){

        listener.onClickListener();
        dismiss();
    }
    private ICustomDialogEventListener listener;

    public interface ICustomDialogEventListener{
        public void onClickListener();
    }

    public CustomDialog(@NonNull Context context, ICustomDialogEventListener iCustomDialogEventListener) {
        super(context, R.style.dialog);
        this.listener= iCustomDialogEventListener;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_dialog);
        ButterKnife.bind(this);

    }
}
