package com.example.entrenaencasaconpeques;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;

public class HiitTrainning9 extends AppCompatActivity {

    //Variable final que marcará la cantidad de la cuenta regresiva
    private static final long START_TIME_IN_MILLIS45 = 45000; //45 SEGUNDOS, EN MILI Segundos
    private static final long START_TIME_IN_MILLIS15 = 15000; //15 SEGUNDOS, EN MILI Segundos

    //Variables que servirán para operar y asignar a los elementos de la activity
    private TextView mTextViewCountDown45;
    private TextView mTextViewCountDown15;
    private TextView mTextViewSerie;
    private int numSerie = 1;
    private Button mButtonStart;
    private Button mButtonPause;
    private Button mButtonStop;

    //Aquí tengo que crear los Checkbocks (20) mEjercicio1
    //
    private static CheckBox mEjercicio1, mEjercicio2, mEjercicio3, mEjercicio4, mEjercicio5, mEjercicio6, mEjercicio7, mEjercicio8,
            mEjercicio9, mEjercicio10, mEjercicio11, mEjercicio12, mEjercicio13, mEjercicio14, mEjercicio15, mEjercicio16, mEjercicio17,
            mEjercicio18, mEjercicio19, mEjercicio20;
    //

    //además 4 ArrayList<String> (Sup, Inf, Ab, Car)
    //
    ///ESTOS ARRAYLIST CAMBIAN A SET LOS 4
    private Set<String> ejerciciosSuperiores, ejerciciosInferiores, ejerciciosAbdominales, ejerciciosCardio;
    //

    //Otro ArrayList<CheckBox>
    //
    private ArrayList<CheckBox> checkBoxes;
    //

    //Variable que incremente el numero al recorrer los checboxes
    private int incrementaIndiceCheckBox = 0;

    //Variable que contará regresivamente
    private CountDownTimer mCountDownTimer45;
    private CountDownTimer mCountDownTimer15;

    //Declaro variable para activar sonidos en los cronos, cuidado!
    //después hay que inicializarlos en el oncreate y luego activar funciones en el metodo del crono
    private MediaPlayer mediaPlayerAccion;
    private MediaPlayer mediaPlayerRelax;

    //Variable que marcará el contenido de la cuenta atras
    private long mTimeLeftInMillis45 = START_TIME_IN_MILLIS45;
    private long mTimeLeftInMillis15 = START_TIME_IN_MILLIS15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiit_trainning9);


        ///ESTA INICIALIZACIÓN CAMBIA A LINKEDHASHSET
        ejerciciosSuperiores = new LinkedHashSet<>();
        ejerciciosInferiores = new LinkedHashSet<>();
        ejerciciosAbdominales = new LinkedHashSet<>();
        ejerciciosCardio = new LinkedHashSet<>();

        //Inicializamos el ArrayList de checkBoxes
        checkBoxes = new ArrayList<>();
        //

        //Enlazamos las variables creadas con elementos del layout
        mTextViewCountDown45 = findViewById(R.id.TV_crono45);
        mTextViewCountDown15 = findViewById(R.id.TV_crono15);
        mTextViewSerie = findViewById(R.id.TV_Numero_Serie);
        mButtonStart = findViewById(R.id.btn_Start);
        mButtonPause = findViewById(R.id.btn_Pause);
        mButtonStop = findViewById(R.id.btn_Stop);

        //Aquí mapeamos los checkboxes elementos de la actividad con las variables de tipo checkboxes (20) además de agregarselos al arrayList de checkBoxes
        //
        checkBoxes.add(mEjercicio1 = findViewById(R.id.ChBx_Ejercicio1));
        checkBoxes.add(mEjercicio2 = findViewById(R.id.ChBx_Ejercicio2));
        checkBoxes.add(mEjercicio3 = findViewById(R.id.ChBx_Ejercicio3));
        checkBoxes.add(mEjercicio4 = findViewById(R.id.ChBx_Ejercicio4));
        checkBoxes.add(mEjercicio5 = findViewById(R.id.ChBx_Ejercicio5));
        checkBoxes.add(mEjercicio6 = findViewById(R.id.ChBx_Ejercicio6));
        checkBoxes.add(mEjercicio7 = findViewById(R.id.ChBx_Ejercicio7));
        checkBoxes.add(mEjercicio8 = findViewById(R.id.ChBx_Ejercicio8));
        checkBoxes.add(mEjercicio9 = findViewById(R.id.ChBx_Ejercicio9));
        checkBoxes.add(mEjercicio10 = findViewById(R.id.ChBx_Ejercicio10));
        checkBoxes.add(mEjercicio11 = findViewById(R.id.ChBx_Ejercicio11));
        checkBoxes.add(mEjercicio12 = findViewById(R.id.ChBx_Ejercicio12));
        checkBoxes.add(mEjercicio13 = findViewById(R.id.ChBx_Ejercicio13));
        checkBoxes.add(mEjercicio14 = findViewById(R.id.ChBx_Ejercicio14));
        checkBoxes.add(mEjercicio15 = findViewById(R.id.ChBx_Ejercicio15));
        checkBoxes.add(mEjercicio16 = findViewById(R.id.ChBx_Ejercicio16));
        checkBoxes.add(mEjercicio17 = findViewById(R.id.ChBx_Ejercicio17));
        checkBoxes.add(mEjercicio18 = findViewById(R.id.ChBx_Ejercicio18));
        checkBoxes.add(mEjercicio19 = findViewById(R.id.ChBx_Ejercicio19));
        checkBoxes.add(mEjercicio20 = findViewById(R.id.ChBx_Ejercicio20));
        //


        //Inicializamos los variables d etipo mediaPlayer (sonidos cronos)
        mediaPlayerAccion = MediaPlayer.create(this, R.raw.vamos_alto);
        mediaPlayerAccion.setVolume(1000, 1000);
        mediaPlayerRelax = MediaPlayer.create(this, R.raw.relax_alto);
        mediaPlayerRelax.setVolume(1000,1000);

        ///AQUI CARGAMOS EL METODO CARGAR PREFERENCIAS
        cargarPreferencias();


        //Recepcionamos el bundle envíado desde el MainActivity
        //
        Bundle informacion = getIntent().getExtras();
        //

        //Condicional que obtenga el ArrayList de String con su clave envíado desde el MainActivity
        ///ESTE IF LO COMENTAMOS
        //
        /*
        if(informacion !=null){
            ejerciciosSuperiores = informacion.getStringArrayList("ejerciciosSuperiores");
            ejerciciosInferiores = informacion.getStringArrayList("ejerciciosInferiores");
            ejerciciosAbdominales = informacion.getStringArrayList("ejerciciosAbdominales");
            ejerciciosCardio = informacion.getStringArrayList("ejerciciosCardio");
        }
         */
        ///

        ///SE COMENTARAN LOS 4 BUCLES FOR Y SE CAMBIARAN POR BUCLES FOR EACH
        for(String ejercicio: ejerciciosSuperiores){
            checkBoxes.get(incrementaIndiceCheckBox).setVisibility(View.VISIBLE);
            checkBoxes.get(incrementaIndiceCheckBox).setText(ejercicio);
            incrementaIndiceCheckBox++;
        }

        for(String ejercicio: ejerciciosInferiores){
            checkBoxes.get(incrementaIndiceCheckBox).setVisibility(View.VISIBLE);
            checkBoxes.get(incrementaIndiceCheckBox).setText(ejercicio);
            incrementaIndiceCheckBox++;
        }

        for(String ejercicio: ejerciciosAbdominales){
            checkBoxes.get(incrementaIndiceCheckBox).setVisibility(View.VISIBLE);
            checkBoxes.get(incrementaIndiceCheckBox).setText(ejercicio);
            incrementaIndiceCheckBox++;
        }

        for(String ejercicio: ejerciciosCardio){
            checkBoxes.get(incrementaIndiceCheckBox).setVisibility(View.VISIBLE);
            checkBoxes.get(incrementaIndiceCheckBox).setText(ejercicio);
            incrementaIndiceCheckBox++;
        }

        /*
        //Se necesitarán tantos bucles for como grupos musculares haya (SUPERIORES)
        for (int i = 0; i< ejerciciosSuperiores.size(); i++){
            checkBoxes.get(incrementaIndiceCheckBox).setVisibility(View.VISIBLE);
            checkBoxes.get(incrementaIndiceCheckBox).setText(ejerciciosSuperiores.get(i));
            incrementaIndiceCheckBox++;
        }

        //Se necesitarán tantos bucles for como grupos musculares haya (INFERIORES)
        for (int i = 0; i< ejerciciosInferiores.size(); i++){
            checkBoxes.get(incrementaIndiceCheckBox).setVisibility(View.VISIBLE);
            checkBoxes.get(incrementaIndiceCheckBox).setText(ejerciciosInferiores.get(i));
            incrementaIndiceCheckBox++;
        }

        //Se necesitarán tantos bucles for como grupos musculares haya (ABDOMINALES)
        for (int i = 0; i< ejerciciosAbdominales.size(); i++){
            checkBoxes.get(incrementaIndiceCheckBox).setVisibility(View.VISIBLE);
            checkBoxes.get(incrementaIndiceCheckBox).setText(ejerciciosAbdominales.get(i));
            incrementaIndiceCheckBox++;
        }

        //Se necesitarán tantos bucles for como grupos musculares haya (CARDIO)
        for (int i = 0; i< ejerciciosCardio.size(); i++){
            checkBoxes.get(incrementaIndiceCheckBox).setVisibility(View.VISIBLE);
            checkBoxes.get(incrementaIndiceCheckBox).setText(ejerciciosCardio.get(i));
            incrementaIndiceCheckBox++;
        }
         */
        //







        //Creamos funcionalidad al botón start
        mButtonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Le decimos que cuando le demos al botón start comience la cuenta atrás de 45 segundos (metodo startTimer45())
                startTimer45();
                mediaPlayerAccion.start();


            }
        });

        //Creamos funcionalidad al boton pause
        mButtonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Al botón pause le decimos que pare cualquiera de los cronometros que esté en marcha (45 o 15)
                pauseTimer45();
                pauseTimer15();
            }
        });

        //Creamos funcionalidad al boton stop
        mButtonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //El botón stop, parará (pause) los cronómetros que estén en marcha (pauseTimer) y los reinicirá (resetTimer)
                pauseTimer45();
                pauseTimer15();
                resetTimer45();
                resetTimer15();
                reseteoSeries();
            }
        });

        //Actualizamos el crono si le damos a stop
        updateCountDownText45();
        updateCountDownText15();

    }//Llave de cierre del Oncreate

    //Desarrollo de los metodos invocados

    //Metodo para poder acumular ejercicios de diferentes activities mediante SharedPreferences
    private void cargarPreferencias(){
        SharedPreferences preferencias = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        ejerciciosSuperiores = preferencias.getStringSet("superiores", null);
        ejerciciosInferiores = preferencias.getStringSet("inferiores", null);
        ejerciciosAbdominales = preferencias.getStringSet("abdominales", null);
        ejerciciosCardio = preferencias.getStringSet("cardio", null);

    }

    //Este método es el más importante, se instancia un objeto de tipo CountDowntimer
    private void startTimer45(){
        //pasamos por parámetro al constructor del objeto CountDownTimer la variable que es igual
        // a la variable final que guarda el tiempo asignado tambien le ponemos los intervalos segundos X1000
        mCountDownTimer45 = new CountDownTimer(mTimeLeftInMillis45, 1000) {
            //Se insertan automáticamente estos dos métodos
            @Override
            public void onTick(long millisUntilFinished) {
                //variable auxiliar que iguale a la final con el tiempo a ejecutar en milisegundos
                mTimeLeftInMillis45 = millisUntilFinished;
                //actualización de la cuenta regresiva
                updateCountDownText45();
            }

            @Override
            public void onFinish() {
                //Aquí le decimos que cuando acabe la cuenta del crono de 45 comience con la cuenta del crono de 15
                startTimer15();
                mediaPlayerRelax.start();
            }
        }.start();
    }

    //Este método es el más importante, se instancia un objeto de tipo CountDowntimer
    private void startTimer15(){
        //pasamos por parámetro al constructor del objeto CountDownTimer la variable que es igual
        // a la variable final que guarda el tiempo asignado tambien le ponemos los intervalos segundos X1000
        mCountDownTimer15 = new CountDownTimer(mTimeLeftInMillis15, 1000) {
            //Se insertan automáticamente estos dos métodos
            @Override
            public void onTick(long millisUntilFinished) {
                //variable auxiliar que iguale a la final con el tiempo a ejecutar en milisegundos
                mTimeLeftInMillis15 = millisUntilFinished;
                //actualización de la cuenta regresiva
                updateCountDownText15();
            }

            @Override
            public void onFinish() {
                //Aquí le decimos que cuando se acabe la cuenta atrás del crono de 15 autoincremente en 1 el numero de serie
                numSerie++;

                //Con esto conseguimos que se le añada un 0 delante hasta el ejercicio numero 9
                if(numSerie < 10){
                    mTextViewSerie.setText("0"+numSerie);

                //A partir del ejercicio numero 10 no tendremos que añadir ningún cero pq ya son de dos dígitos
                }else{
                    mTextViewSerie.setText(numSerie);
                }

                //Reset de cronómetros
                pauseTimer45();
                pauseTimer15();
                resetTimer45();
                resetTimer15();

                //Por último de decimos que inicie la cuenta de nuevo
                startTimer45();
                mediaPlayerAccion.start();
            }
        }.start();
    }

    //Aquí paramos la cuenta regresiva
    private void pauseTimer45(){
        mCountDownTimer45.cancel();
    }

    //Aquí paramos la cuenta regresiva
    private void pauseTimer15(){
        mCountDownTimer15.cancel();
    }

    //Aquí reiniciamos la cuenta regresiva
    private void resetTimer45(){
        mTimeLeftInMillis45 = START_TIME_IN_MILLIS45;
        //Llamamos el método que le da formato a los cronometros
        updateCountDownText45();
    }

    //Aquí reiniciamos la cuenta regresiva
    private void resetTimer15(){
        mTimeLeftInMillis15 = START_TIME_IN_MILLIS15;
        //Llamamos el método que le da formato a los cronometros
        updateCountDownText15();
    }

    //Metodo para actulizar la cuenta del crono
    private void updateCountDownText45(){
        //esta línea es para ver si son minutos, entonces la private static final long START_TIME_IN_MILLIS = sería + de 60000 para minutos
        //en nuestro caso nuestro crono es de 45 segundos, por tanto sería 45000 mili segundos
        int minutes45 = (int) (mTimeLeftInMillis45 / 1000) / 60;
        int seconds45 = (int) (mTimeLeftInMillis45 / 1000) % 60;

        //ahora lo pasamos a una cadena de String
        String timeLeftFormatted = String.format(Locale.getDefault(),"%02d:%02d", minutes45, seconds45);

        //Esa cadena de String se la pasamos a la variable asignada para el elemento textView_countdown)
        mTextViewCountDown45.setText(timeLeftFormatted);

    }


    //Metodo para actulizar la cuenta del crono
    private void updateCountDownText15(){
        //esta línea es para ver si son minutos, entonces la private static final long START_TIME_IN_MILLIS = sería + de 60000 para minutos
        //en nuestro caso nuestro crono es de 15 segundos, por tanto sería 15000 mili segundos
        int minutes15 = (int) (mTimeLeftInMillis15 / 1000) / 60;
        int seconds15 = (int) (mTimeLeftInMillis15 / 1000) % 60;

        //ahora lo pasamos a una cadena de String
        String timeLeftFormatted15 = String.format(Locale.getDefault(),"%02d:%02d", minutes15, seconds15);

        //Esa cadena de String se la pasamos a la variable asignada para el elemento textView_countdown)
        mTextViewCountDown15.setText(timeLeftFormatted15);

    }

    //Creamos el método que reinicie el numero de serie cuando se pulsa la tecla stop
    private void reseteoSeries(){
        numSerie = 1;
        mTextViewSerie.setText("01");

    }

    //Método del botón volver
    public void Volver(View vista){
        onBackPressed();
    }
}
