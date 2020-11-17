package com.example.myapplication.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.myapplication.Database.DataApplication;
import com.example.myapplication.R;

public class SysActivity extends Activity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    private DataApplication dataApplication;
    private Switch switch_password, switch_rename, switch_overwrite;
    private EditText edit_password, edit_rename;
    private Button button_save;
    private String rename, password, sta_rename, sta_password;
    private int overWrite;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sys);
//        getActionBar().setDisplayHomeAsUpEnabled(true);
        init();
    }
    int sta_renameIndex,sta_passwdIndex;
    private void init() {
        switch_password = findViewById(R.id.switch_password);
        switch_rename = findViewById(R.id.switch_rename);
        switch_overwrite = findViewById(R.id.switch_overwrite);

        edit_password = findViewById(R.id.edit_password);
        edit_rename = findViewById(R.id.edit_rename);
        switch_password.setOnCheckedChangeListener(this);
        switch_rename.setOnCheckedChangeListener(this);
        switch_overwrite.setOnCheckedChangeListener(this);

        //设置rename只能输入数字和字母
        dataApplication = DataApplication.getDataApplication();
        button_save = findViewById(R.id.button_save);
        button_save.setOnClickListener(this);

        sta_rename = dataApplication.getStaRename();                //获取记录着的密码开关；
        sta_password = dataApplication.getStaPassword();
        overWrite = dataApplication.getOverWrite();
        sta_renameIndex = dataApplication.getStaNameIndex();
        sta_passwdIndex = dataApplication.getStaPasswordIndex();

        if (sta_renameIndex==1) {                             //如果密码开关是开着的
            rename = dataApplication.getRename();
            edit_rename.setText(rename);
            Toast.makeText(this, "rename：" + rename, Toast.LENGTH_SHORT).show();
            switch_rename.setChecked(true);
        }
        if (sta_passwdIndex ==1) {
            System.out.println("当前sta_passworde开关："+sta_password);
            password = dataApplication.getPassword();
            edit_password.setText(password);
            switch_password.setChecked(true);
        }


        if (overWrite == 1) {
            switch_overwrite.setChecked(true);
        } else {
            switch_overwrite.setChecked(false);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()) {
            case R.id.switch_rename:
                //如果当前为on
                if (b) {
                    edit_rename.setVisibility(View.VISIBLE);
                    dataApplication.setStaNameIndex(1);
                    edit_rename.setKeyListener(new DigitsKeyListener() {
                        @Override
                        public int getInputType() {
                            return InputType.TYPE_TEXT_VARIATION_PASSWORD;
                        }
                        @Override
                        protected char[] getAcceptedChars() {
                            char[] data = getStringData(R.string.wordAndNum).toCharArray();
                            return data;
                        }
                    });
                } else {
                    dataApplication.setStaNameIndex(0);
                    edit_rename.setVisibility(View.INVISIBLE);
                }
                dataApplication.setStaName(""+b);
                break;
            case R.id.switch_password:
                if (b) {
                    edit_password.setVisibility(View.VISIBLE);
                    dataApplication.setStaPasswordIndex(1);
                } else {
                    dataApplication.setStaPasswordIndex(0);
                    edit_password.setVisibility(View.INVISIBLE);            //关掉开关
                }
                dataApplication.setStaPassword(""+b);
                break;
            case R.id.switch_overwrite:
                dataApplication.setOverWrite(b+"");
                break;
        }
    }

    public String getStringData(int id) {
        return getResources().getString(id);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_save:
                rename = edit_rename.getText().toString();
                password = edit_password.getText().toString();
                dataApplication.setRename(rename);
                dataApplication.setPassword(password);
                dataApplication.setPassword(password);
                dataApplication.setPassword(password);

                dataApplication.saveString("rename",rename);
                dataApplication.saveString("password",password);
                dataApplication.saveString("staName",dataApplication.getStaRename());
                dataApplication.saveString("staPassword",dataApplication.getStaPassword());
                dataApplication.saveInt("staNameIndex",dataApplication.getStaNameIndex());
                dataApplication.saveInt("staPasswdIndex",dataApplication.getStaPasswordIndex());
                break;
        }
    }
}