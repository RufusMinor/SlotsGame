package com.template;

import static com.template.MainActivity3.APP_Preference;
import static com.template.MainActivity3.APP_Preference_MONEY;
import static com.template.MainActivity3.APP_Preference_MONEY;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.wajahatkarim3.easyflipview.EasyFlipView;

import java.util.Random;

public class MainActivity4 extends AppCompatActivity {

    ImageButton back;
    Button claim;
    TextView winMoney,winMoney2,winMoney3,winMoney4,winMoney5,winMoney6,winM;
    EasyFlipView card1,card2,card3,card4,card5,card6;
    private AlertDialog dialog;
    public SharedPreferences mSettings;
    int moneyPrice;
    public boolean one;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
         winM=findViewById(R.id.textWinMoney);
        mSettings=getSharedPreferences(APP_Preference,MODE_PRIVATE);


        back=findViewById(R.id.back_lotto);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity4.this,MainActivity3.class);
                startActivity(intent);

                killApp();

            }
        });

        //Получаем рандомные числа на карты
        Random random = new Random();
        int randomNumber = random.nextInt(1000);
        int randomNumber2 = random.nextInt(1000);
        int randomNumber3 = random.nextInt(1000);
        int randomNumber4 = random.nextInt(1000);
        int randomNumber5 = random.nextInt(1000);
        int randomNumber6 = random.nextInt(1000);
        String win=randomNumber+"$";
        String win2=randomNumber2+"$";
        String win3=randomNumber3+"$";
        String win4=randomNumber4+"$";
        String win5=randomNumber5+"$";
        String win6=randomNumber6+"$";
        Log.d("Random"," " +win+randomNumber3);

        winMoney=findViewById(R.id.winMoney);
        winMoney2=findViewById(R.id.winMoney2);
        winMoney3=findViewById(R.id.winMoney3);
        winMoney4=findViewById(R.id.winMoney4);
        winMoney5=findViewById(R.id.winMoney5);
        winMoney6=findViewById(R.id.winMoney6);
        winMoney.setText(win);
        winMoney2.setText(win2);
        winMoney3.setText(win3);
        winMoney4.setText(win4);
        winMoney5.setText(win5);
        winMoney6.setText(win6);

        card1=findViewById(R.id.card1);
        card2=findViewById(R.id.card2);
        card3=findViewById(R.id.card3);
        card4=findViewById(R.id.card4);
        card5=findViewById(R.id.card5);
        card6=findViewById(R.id.card6);


        //Прослушиваем клики на карты
        card1.setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                Log.d("Random","AAAAAAAAAAAAAAA " );
                card2.setFlipEnabled(false);
                card3.setFlipEnabled(false);
                card4.setFlipEnabled(false);
                card5.setFlipEnabled(false);
                card6.setFlipEnabled(false);
                int rN=randomNumber;

                int q=mSettings.getInt(APP_Preference_MONEY,moneyPrice);
                Log.d("AAAA","Вот "+q);
                int sum=q+rN;

                SharedPreferences.Editor editor = mSettings.edit();
                editor.putInt(APP_Preference_MONEY,moneyPrice=sum);
                editor.apply();
                SharedPreferences z=getSharedPreferences(APP_Preference, Context.MODE_PRIVATE);
                int r=z.getInt(APP_Preference_MONEY,moneyPrice);
                Log.d("AAAA","Вот "+r);

                DialodLottery(win);
            }
        });
        card2.setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                card3.setFlipEnabled(false);
                card1.setFlipEnabled(false);
                card3.setFlipEnabled(false);
                card4.setFlipEnabled(false);
                card5.setFlipEnabled(false);
                card6.setFlipEnabled(false);
                DialodLottery(win2);
                int rN=randomNumber2;
                int q=mSettings.getInt(APP_Preference_MONEY,moneyPrice);
                Log.d("AAAA","Вот "+q);
                int sum=q+rN;

                SharedPreferences.Editor editor = mSettings.edit();
                editor.putInt(APP_Preference_MONEY,moneyPrice=sum);
                editor.apply();
                SharedPreferences z=getSharedPreferences(APP_Preference, Context.MODE_PRIVATE);
                int r=z.getInt(APP_Preference_MONEY,moneyPrice);
                Log.d("AAAA","Вот "+r);
            }
        });
        card3.setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                card2.setFlipEnabled(false);
            card1.setFlipEnabled(false);
            card2.setFlipEnabled(false);
            card4.setFlipEnabled(false);
            card5.setFlipEnabled(false);
            card6.setFlipEnabled(false);
                int rN=randomNumber3;
                int q=mSettings.getInt(APP_Preference_MONEY,moneyPrice);
                Log.d("AAAA","Вот "+q);
                int sum=q+rN;

                SharedPreferences.Editor editor = mSettings.edit();
                editor.putInt(APP_Preference_MONEY,moneyPrice=sum);
                editor.apply();
                SharedPreferences z=getSharedPreferences(APP_Preference, Context.MODE_PRIVATE);
                int r=z.getInt(APP_Preference_MONEY,moneyPrice);
                Log.d("AAAA","Вот "+r);
                DialodLottery(win3);
            }
        });
        card4.setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                card1.setFlipEnabled(false);
                card3.setFlipEnabled(false);
                card2.setFlipEnabled(false);
                card5.setFlipEnabled(false);
                card6.setFlipEnabled(false);
                DialodLottery(win4);
                int rN=randomNumber4;
                int q=mSettings.getInt(APP_Preference_MONEY,moneyPrice);
                Log.d("AAAA","Вот "+q);
                int sum=q+rN;

                SharedPreferences.Editor editor = mSettings.edit();
                editor.putInt(APP_Preference_MONEY,moneyPrice=sum);
                editor.apply();
                SharedPreferences z=getSharedPreferences(APP_Preference, Context.MODE_PRIVATE);
                int r=z.getInt(APP_Preference_MONEY,moneyPrice);
                Log.d("AAAA","Вот "+r);

            }
        });
        card5.setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                card1.setFlipEnabled(false);
                card3.setFlipEnabled(false);
                card4.setFlipEnabled(false);
                card2.setFlipEnabled(false);
                card6.setFlipEnabled(false);
                int rN=randomNumber5;
                int q=mSettings.getInt(APP_Preference_MONEY,moneyPrice);
                Log.d("AAAA","Вот "+q);
                int sum=q+rN;

                SharedPreferences.Editor editor = mSettings.edit();
                editor.putInt(APP_Preference_MONEY,moneyPrice=sum);
                editor.apply();
                SharedPreferences z=getSharedPreferences(APP_Preference, Context.MODE_PRIVATE);
                int r=z.getInt(APP_Preference_MONEY,moneyPrice);
                Log.d("AAAA","Вот "+r);
                DialodLottery(win5);
            }
        });
        card6.setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                card1.setFlipEnabled(false);
                card3.setFlipEnabled(false);
                card4.setFlipEnabled(false);
                card5.setFlipEnabled(false);
                card2.setFlipEnabled(false);
                int rN=randomNumber6;
                int q=mSettings.getInt(APP_Preference_MONEY,moneyPrice);
                Log.d("AAAA","Вот "+q);
                int sum=q+rN;

                SharedPreferences.Editor editor = mSettings.edit();
                editor.putInt(APP_Preference_MONEY,moneyPrice=sum);
                editor.apply();
                SharedPreferences z=getSharedPreferences(APP_Preference, Context.MODE_PRIVATE);
                int r=z.getInt(APP_Preference_MONEY,moneyPrice);
                Log.d("AAAA","Вот "+r);
                DialodLottery(win6);
            }
        });






        }


        //AlertDialog с суммой выйгрыша с карты и кнопкой "забрать"
        @SuppressLint("MissingInflatedId")
        public void DialodLottery(String money){

            AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity4.this);
            View view1=getLayoutInflater().inflate(R.layout.dialog_lottery,null);
            TextView winM=view1.findViewById(R.id.textWinMoney);
            claim=view1.findViewById(R.id.claim);
            claim.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Award received!", Toast.LENGTH_SHORT);
                    toast.show();
                }
            });
            String r="ddd";
            winM.setText("Your reward: "+money+" coins");
            builder.setView(view1);
            dialog=builder.create();
            dialog.show();

        }
        @Override
    public void onBackPressed(){
        super.onBackPressed();
            SharedPreferences.Editor editor = mSettings.edit();
            editor.putInt(APP_Preference_MONEY,moneyPrice=0);
            editor.apply();
            finish();

        }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putInt(APP_Preference_MONEY, moneyPrice=0);
        editor.apply();



    }
        public void killApp(){
        this.finish();
        }

    }
