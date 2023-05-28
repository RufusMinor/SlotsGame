package com.template;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity3 extends AppCompatActivity {
    private TextView  bet,money,winToast;
    int betV;
    private ImageView image1, image2, image3,image4,image5,image6,image7,image8,image9,line1,line2,lineGreen,lineGreen2,line3;
    private Slots slots1, slots2, slots3,slots4,slots5,slots6,slots7,slots8,slots9;
    private ImageButton button,plus,min,loto,back, exit;
    private boolean isStarted;
    private AlertDialog dialog;
    String m1000,m3000;
    public static final String APP_Preference="settings";
    public static  String APP_Preference_MONEY="text";
    public SharedPreferences mSettings;

    public static final Random RANDOM = new Random();
    int counter=0;
    int moneyPrice=1, m;
    boolean one=false;
    boolean check;



    public static long randomLong(long lower, long upper) {
        return lower + (long) (RANDOM.nextDouble() * (upper - lower));
    }
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        SharedPreferences d=getSharedPreferences(APP_Preference,MODE_PRIVATE);
        int m= d.getInt(APP_Preference_MONEY,moneyPrice);
        String o=String.valueOf(m);
        String b=" "+o;



        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);
        image7 = findViewById(R.id.image7);
        image8 = findViewById(R.id.image8);
        image9 = findViewById(R.id.image9);
        line1=findViewById(R.id.lineYelow);
        line2=findViewById(R.id.lineGrow2);
        line3=findViewById(R.id.lineGrow1);
        lineGreen=findViewById(R.id.lineGreen);
        lineGreen2=findViewById(R.id.lineGreen2);

        //Кнопка назад
        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = mSettings.edit();
                editor.putInt(APP_Preference_MONEY,moneyPrice=0);
                editor.apply();
                finish();
                killUp();
            }
        });

        //Кнопка перехода в лото
        loto=findViewById(R.id.loto);
        loto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putInt(APP_Preference_MONEY, moneyPrice);
                editor.apply();
                Intent intent=new Intent(MainActivity3.this,MainActivity4.class);
                startActivity(intent);
                SharedPreferences.Editor edito = mSettings.edit();
                edito.putInt(APP_Preference_MONEY, moneyPrice);
                edito.apply();
                one=true;
                SharedPreferences mShared=mSettings = getSharedPreferences(APP_Preference, Context.MODE_PRIVATE);
                SharedPreferences.Editor i=mShared.edit();
                i.putBoolean("flag", one);
                i.apply();


                killUp();

            }
        });

        //Окно ставок
        bet=findViewById(R.id.BetView);
        betV=0;
        String s=String.valueOf(betV);
        bet.setText(s);

        //Общее колличество монет
        money=findViewById(R.id.MoneyView);
        //Кнопка Spin
        button = findViewById(R.id.spin);
        plus=findViewById(R.id.plus);
        min=findViewById(R.id.min);

        //+ на ставках
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter+=10;
                String i=String.valueOf(counter);
                bet.setText(i);
                if (counter>0){
                    min.setEnabled(true);
                }



            }
        });
        //-на ставках
        min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter-=10;
                String s=String.valueOf(counter);
                bet.setText(s);
            if (counter==0){
                min.setEnabled(false);
            }}

        });

        if(m>0){
            money.setText(o);
        }

        //Кнопка начала игры Spin
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lineGreen2.setVisibility(View.INVISIBLE);
                line3.setVisibility(View.VISIBLE);
                lineGreen.setVisibility(View.INVISIBLE);
                line2.setVisibility(View.VISIBLE);
               if(!isStarted) {

                   slots1 = new Slots(new Slots.WheelListener() {
                        @Override
                        public void newImage(final int img) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    image1.setImageResource(img);
                                }
                            });
                        }
                    }, 200, randomLong(0, 200));

                   slots1.start();

                   slots2 = new Slots(new Slots.WheelListener() {
                        @Override
                        public void newImage(final int img) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    image2.setImageResource(img);
                                }
                            });
                        }
                    }, 200, randomLong(150, 400));

                   slots2.start();

                   slots3 = new Slots(new Slots.WheelListener() {
                        @Override
                        public void newImage(final int img) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    image3.setImageResource(img);
                                }
                            });
                        }
                    }, 200, randomLong(150, 400));

                   slots3.start();

                   slots4 = new Slots(new Slots.WheelListener() {
                        @Override
                        public void newImage(final int img) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    image4.setImageResource(img);
                                }
                            });
                        }
                    }, 200, randomLong(150, 400));

                   slots4.start();

                   slots5 = new Slots(new Slots.WheelListener() {
                        @Override
                        public void newImage(final int img) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    image5.setImageResource(img);
                                }
                            });
                        }
                    }, 200, randomLong(150, 400));

                   slots5.start();

                   slots6 = new Slots(new Slots.WheelListener() {
                        @Override
                        public void newImage(final int img) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    image6.setImageResource(img);
                                }
                            });
                        }
                    }, 200, randomLong(150, 400));

                   slots6.start();

                   slots7 = new Slots(new Slots.WheelListener() {
                        @Override
                        public void newImage(final int img) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    image7.setImageResource(img);
                                }
                            });
                        }
                    }, 200, randomLong(150, 400));

                   slots7.start();

                   slots8 = new Slots(new Slots.WheelListener() {
                        @Override
                        public void newImage(final int img) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    image8.setImageResource(img);
                                }
                            });
                        }
                    }, 200, randomLong(150, 400));

                   slots8.start();

                   slots9 = new Slots(new Slots.WheelListener() {
                        @Override
                        public void newImage(final int img) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    image9.setImageResource(img);
                                }
                            });
                        }
                    }, 200, randomLong(150, 400));

                   slots9.start();

                    isStarted = true;

                    //Крутится 3 секунды и встает на позицию
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            if(isStarted){
                            slots1.stopSlots();
                                slots2.stopSlots();
                                slots3.stopSlots();;
                                slots4.stopSlots();
                                slots5.stopSlots();
                                slots6.stopSlots();
                                slots7.stopSlots();
                                slots8.stopSlots();
                                slots9.stopSlots();

                                //Комбинации выйгрышные

                            if (slots1.currentIndex == slots2.currentIndex && slots2.currentIndex == slots3.currentIndex) {
                                //infoTextView.setText("You win the big prize");
                                moneyPrice+=1000;
                                m1000=String.valueOf(moneyPrice);
                                money.setText(m1000);
                                MessageWin(view,"1000");
                                SharedPreferences.Editor editor = mSettings.edit();
                                editor.putInt(APP_Preference_MONEY, moneyPrice);
                                editor.apply();


                            } else if (slots2.currentIndex == slots4.currentIndex && slots2.currentIndex == slots7.currentIndex) {
                                // infoTextView.setText("Little Prize");
                                line3.setVisibility(View.INVISIBLE);
                                lineGreen2.setVisibility(View.VISIBLE);
                                moneyPrice+=1500;
                                m3000=String.valueOf(moneyPrice);
                                money.setText(m3000);
                                MessageWin(view,"1500");
                                SharedPreferences.Editor editor = mSettings.edit();
                                editor.putInt(APP_Preference_MONEY, moneyPrice);
                                editor.apply();

                            }
                            else if (slots6.currentIndex == slots2.currentIndex && slots2.currentIndex == slots9.currentIndex) {
                                // infoTextView.setText("Little Prize");
                                line2.setVisibility(View.INVISIBLE);
                                lineGreen.setVisibility(View.VISIBLE);
                                moneyPrice+=1000;
                                String m=String.valueOf(moneyPrice);
                                money.setText(m);
                                MessageWin(view,"1000");

                                SharedPreferences.Editor editor = mSettings.edit();
                                editor.putInt(APP_Preference_MONEY, moneyPrice);
                                editor.apply();




                            }
//                            else if (wheel6.currentIndex == wheel2.currentIndex && wheel2.currentIndex == wheel9.currentIndex &&wheel2.currentIndex == wheel4.currentIndex && wheel2.currentIndex == wheel7.currentIndex) {
//                                // infoTextView.setText("Little Prize");
//                                line2.setVisibility(View.INVISIBLE);
//                                lineGreen.setVisibility(View.VISIBLE);
//                                line3.setVisibility(View.INVISIBLE);
//                                lineGreen2.setVisibility(View.VISIBLE);
//                                moneyPrice+=6000;
//                                String m=String.valueOf(moneyPrice);
//                                money.setText(m);
//                                MessageWin(view,"6000");}
//                            else if (wheel2.currentIndex == wheel4.currentIndex ) {
//                                moneyPrice+=20;
//                                String m=String.valueOf(moneyPrice);
//                                money.setText(m);
//                                MessageWin(view,"20");
                          //  }
                            else if (slots6.currentIndex == slots2.currentIndex ) {
                                moneyPrice+=250;
                                String m=String.valueOf(moneyPrice);
                                money.setText(m);
                                MessageWin(view,"250");
                            }
//                            else if (wheel7.currentIndex == wheel2.currentIndex ) {
//                                moneyPrice+=500;
//                                String m=String.valueOf(moneyPrice);
//                                money.setText(m);
//                                MessageWin(view,"500");
   //                         }
//                            else if (wheel3.currentIndex == wheel2.currentIndex ) {
//                                moneyPrice+=500;
//                                String m=String.valueOf(moneyPrice);
//                                money.setText(m);
//                                MessageWin(view,"500");
//                            }
                            else if (slots5.currentIndex == slots2.currentIndex&&slots2.currentIndex==slots6.currentIndex ) {
                                moneyPrice+=750;
                                String m=String.valueOf(moneyPrice);
                                money.setText(m);
                                MessageWin(view,"750");
                            }
//                            else if (wheel7.currentIndex == wheel8.currentIndex&&wheel8.currentIndex==wheel9.currentIndex ) {
//                                moneyPrice+=750;
//                                String m=String.valueOf(moneyPrice);
//                                money.setText(m);
//                                MessageWin(view,"750");
                          //  }
//                            else if (wheel8.currentIndex == wheel9.currentIndex ) {
//                                moneyPrice+=300;
//                                String m=String.valueOf(moneyPrice);
//                                money.setText(m);
//                                MessageWin(view,"300");
//                            }
                            else {

                                Toast toast = Toast.makeText(getApplicationContext(),
                                        "No win!", Toast.LENGTH_SHORT);
                                toast.show();
                            }

                            isStarted = false;
                        }}
                    }, 3000);
                }


            }

        });

//
        mSettings=getSharedPreferences(APP_Preference,MODE_PRIVATE);
       int a= mSettings.getInt(APP_Preference_MONEY,moneyPrice=m);




    }



    //Toast с картинкой о выйгрышной комбинации и суммой
    @SuppressLint("MissingInflatedId")
    public void MessageWin(View view,String win){
        LayoutInflater layoutInflater = getLayoutInflater();

        View view1 = layoutInflater.inflate(R.layout.win_toast,null);

        Toast toast = new Toast(getApplicationContext());
        winToast=view1.findViewById(R.id.text_win_toast);
        winToast.setText(win);

        toast.setView(view1);

        toast.setGravity(Gravity.CENTER_VERTICAL,0,0);

        toast.setDuration(Toast.LENGTH_LONG);

        toast.show();

    }




    public void killUp(){
        this.finish();
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
    protected void onStop(){
        super.onStop();
        SharedPreferences n=getSharedPreferences(APP_Preference,MODE_PRIVATE);
        check= n.getBoolean("flag",one);


        if (check) {

            SharedPreferences.Editor edito = mSettings.edit();
            one=false;
            edito.putBoolean("flag", one);
            edito.apply();

    }
        if(!check){

            SharedPreferences.Editor edit = mSettings.edit();
            edit.putInt(APP_Preference_MONEY, moneyPrice=0);
            edit.apply();

    }}
}