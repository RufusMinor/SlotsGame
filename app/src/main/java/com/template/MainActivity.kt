package com.template

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var status: TextView? = null
    var load: ImageView? = null
    var load2: ImageView? = null
    var load3: ImageView? = null
    var load4: ImageView? = null
    var load5: ImageView? = null
    var load6: ImageView? = null
    var play: ImageButton? = null
    var ramka: ImageView? = null


    private var progressStatus = 0
    private var handler = Handler()


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load)



        status=findViewById(R.id.status)
        load=findViewById(R.id.icecream1)
        load2=findViewById(R.id.icecream2)
        load3=findViewById(R.id.icecream3)
        load4=findViewById(R.id.icecream4)
        load5=findViewById(R.id.icecream5)
        load6=findViewById(R.id.icecream6)
        play=findViewById(R.id.play)
        ramka=findViewById(R.id.ramka)


        Thread(Runnable {
            while (progressStatus < 100){
                progressStatus +=1

                Thread.sleep(60)

                handler.post {

                    status?.text="$progressStatus%"


                }
            }
        }).start()
        Thread(Runnable {

                Thread.sleep(1000)

                handler.post {
                    load?.setVisibility(View.VISIBLE)



            }
        }).start()

        Thread(Runnable {

                Thread.sleep(2000)

                handler.post {
                    load2?.setVisibility(View.VISIBLE)


            }
        }).start()

        Thread(Runnable {

                Thread.sleep(3000)

                handler.post {
                    load3?.setVisibility(View.VISIBLE)


            }
        }).start()

        Thread(Runnable {
                Thread.sleep(4000)
                handler.post {
                    load4?.setVisibility(View.VISIBLE)



            }
        }).start()

        Thread(Runnable {
                Thread.sleep(5000)
                handler.post {
                    load5?.setVisibility(View.VISIBLE)


            }
        }).start()

        Thread(Runnable {

                Thread.sleep(6000)

                handler.post {
                    load6?.setVisibility(View.VISIBLE)


                    load?.setVisibility(View.INVISIBLE)
                    load2?.setVisibility(View.INVISIBLE)
                    load3?.setVisibility(View.INVISIBLE)
                    load4?.setVisibility(View.INVISIBLE)
                    load5?.setVisibility(View.INVISIBLE)
                    load6?.setVisibility(View.INVISIBLE)
                    ramka?.setVisibility(View.INVISIBLE)
                    status?.setVisibility(View.INVISIBLE)


                    play?.setVisibility(View.VISIBLE)
                    play?.setOnClickListener(View.OnClickListener {

                        val intent = Intent(this@MainActivity, MainActivity3::class.java)
                        startActivity(intent)
                        killAPP()
                        finish()
                    })

            }
        }).start()






} fun killAPP() {
        finish()
    }
}