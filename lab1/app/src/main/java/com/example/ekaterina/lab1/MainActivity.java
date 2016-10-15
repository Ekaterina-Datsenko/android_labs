package com.example.ekaterina.lab1;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.RequiresPermission;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.security.acl.Permission;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyApp";

    private TextView Tv;
    private Button Btn;
    private TextView Msg;

    //@SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
   // @RequiresPermission(Manifest.permission.CALL_PHONE)
    //public static final String ACTION_CALL = "android.intent.action.CALL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView Tv = (TextView) findViewById(R.id.textView12);
        Button Btn = (Button) findViewById(R.id.button2);
        TextView Msg = (TextView) findViewById(R.id.textView10);

        Tv.setOnClickListener(onClickListener);
        Btn.setOnClickListener(onClickListener);
        Msg.setOnClickListener(onClickListener);
    }

    private final View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.textView12: {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getResources().getString(R.string.pnumber)));
                    startActivity(intent);
                    break;
                }

                case R.id.button2: {
                    Intent intent1 = new Intent(Intent.ACTION_CALL);
                    intent1.setData(Uri.parse("tel:" + getResources().getString(R.string.pnumber)));
                    startActivity(intent1);
                    break;
                }

                case R.id.textView10: {
                    String[] mail = {getString(R.string.gmail)};
                    Intent share = new Intent(Intent.ACTION_SEND);
                    share.setType("message/rfc822");
                    share.putExtra(Intent.EXTRA_EMAIL, mail);
                    share.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.tema));
                    share.putExtra(Intent.EXTRA_TEXT, getString(R.string.txt));
                    startActivity(Intent.createChooser(share, "Send Email"));

                }

            }

        }
    };

    // Вызывается, когда метод onCreate завершил свою работу,
    // и используется для восстановления состояния пользовательского
    // интерфейса
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Восстановите состояние UI из переменной savedInstanceState.
        // Этот объект типа Bundle также был передан в метод onCreate.
    }

    // Вызывается перед тем, как Активность становится "видимой".
    @Override
    public void onRestart(){
        super.onRestart();
        // Загрузите изменения, учитывая то, что Активность
        // уже стала "видимой" в рамках данного процесса.
    }

    // Вызывается в начале "видимого" состояния.
    @Override
    public void onStart(){
        super.onStart();
        // Примените к UI все необходимые изменения, так как
        // Активность теперь видна на экране.
    }



    // Вызывается в начале "активного" состояния.
    @Override
    public void onResume(){
        super.onResume();
        // Возобновите все приостановленные обновления UI,
        // потоки или процессы, которые были "заморожены",
        // когда данный объект был неактивным.
    }

    // Вызывается для того, чтобы сохранить пользовательский интерфейс
    // перед выходом из "активного" состояния.
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Сохраните состояние UI в переменную savedInstanceState.
        // Она будет передана в метод onCreate при закрытии и
        // повторном запуске процесса.
        super.onSaveInstanceState(savedInstanceState);
    }

    // Вызывается перед выходом из "активного" состояния
    @Override
    public void onPause(){
        // "Замораживает" пользовательский интерфейс, потоки
        // или трудоемкие процессы, которые могут не обновляться,
        // пока Активность не находится на переднем плане.
        super.onPause();
    }

    // Вызывается перед тем, как Активность перестает быть "видимой".
    @Override
    public void onStop(){
        // "Замораживает" пользовательский интерфейс, потоки
        // или операции, которые могут подождать, пока Активность
        // не отображается на экране. Сохраняйте все введенные
        // данные и изменения в UI так, как будто после вызова
        // этого метода процесс должен быть закрыт.
        super.onStop();
    }

    // Вызывается перед выходом из "полноценного" состояния.
    @Override
    public void onDestroy(){
        // Очистите все ресурсы. Это касается завершения работы
        // потоков, закрытия соединений с базой данных и т. д.
        super.onDestroy();
    }




}
