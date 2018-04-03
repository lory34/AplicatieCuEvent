package ro.thenewone.aplicatiecuevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;
import android.view.MotionEvent;
import android.view.GestureDetector;
import android.support.v4.view.GestureDetectorCompat;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,
GestureDetector.OnDoubleTapListener{

    private TextView textul2;
    private GestureDetectorCompat gestureDetect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textul2 = (TextView)findViewById(R.id.text2);
        this.gestureDetect = new GestureDetectorCompat(this,this);
        gestureDetect.setOnDoubleTapListener(this);
        //primul lucru pe care tb sa il facem ne trebuie o referinta la butonul nostru
        Button butonulMeu = (Button)findViewById(R.id.buton);
        //Acum trebuie sa luam butonul si sa setam eventListener, adica ii spunem butonului sa stea si sa astepte pentru o actiune
        //Deci la referinta care tocmai am facut-o setam listenerul utilizand metoda setOnClickListener iar intre parantezele metodei
        //trecem metoda callback care in mare inseamna ca dupa ce cineva a apasat butonul fa asta
        //Problema este ca nu putem pur si simplu sa punem metoda direct aici ci mai intai trebuie sa o punem in interiorul unei
        // interfete, iar pentru a face interfata scriem new Button iar interfata este onClickListener
        //Aici in interfata punem metoda callback

        butonulMeu.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        //Aici punem orice se va intampla cand se apasa butonul, in exemplul nostru se schimba textul din textview-ul
                        //din layout,se schimba at cand apasam butonul
                        //pentru a schimba textul facem o referinta la TextView-ul nostru din layout,ii facem cast
                        TextView loryText = (TextView)findViewById(R.id.text);
                        //acum ca avem referinta loryText, tb sa chemam metoda .setText, aceasta metoda ia ceea ce scriem intre
                        // parantezele sale si schimba cu textul din layout at camd butonul este apasat
                        loryText.setText("Good Job");
                    }
                }


        );

        butonulMeu.setOnLongClickListener(
                new Button.OnLongClickListener(){
                    public boolean onLongClick(View v){
                        TextView loryText = (TextView)findViewById(R.id.text);
                        loryText.setText("Asta a fost lung");
                        return true;
                    }
                }

        );
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        textul2.setText("On single Tap");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        textul2.setText("On double Tap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        textul2.setText("On Double Tap Event");
        return true;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        textul2.setText("On Down");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {
        textul2.setText("On Show Press");

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        textul2.setText("On Single Tap Up");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        textul2.setText("On Scroll");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        textul2.setText("On Long Press");

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        textul2.setText("On Fling");
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetect.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
