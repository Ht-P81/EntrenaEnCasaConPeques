package com.example.entrenaencasaconpeques.vista;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.example.entrenaencasaconpeques.R;
import com.example.entrenaencasaconpeques.controlador.ConexionSQLite;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;

public class HiitTrainningActivity extends AppCompatActivity {

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
    private Button mButtonResetTraining;


    //Checkbox que mapeamos con los elementos de la vista
    private static CheckBox mEjercicio1, mEjercicio2, mEjercicio3, mEjercicio4, mEjercicio5, mEjercicio6, mEjercicio7, mEjercicio8,
            mEjercicio9, mEjercicio10, mEjercicio11, mEjercicio12, mEjercicio13, mEjercicio14, mEjercicio15, mEjercicio16, mEjercicio17,
            mEjercicio18, mEjercicio19, mEjercicio20;


    //ArrayList con los que recorremos los ejercicios de cada grupo
    private Set<String> ejerciciosSuperiores, ejerciciosInferiores, ejerciciosAbdominales, ejerciciosCardio;

    //ArrayList de los Checbox para saber cuales ha seleccionado y ponerlos en nuestra sesion de hiitTrainning
    private ArrayList<CheckBox> checkBoxes;

    //Variable que incremente el numero al recorrer los checboxes
    private int incrementaIndiceCheckBox = 0;
    private int etiquetaNumeroSerie = 1;
    private int numeroTotalEjercicios;

    //Variable que contará regresivamente
    private CountDownTimer mCountDownTimer45;
    private CountDownTimer mCountDownTimer15;

    //Declaro variables para activar sonidos en los cronos, cuidado!
    //después hay que inicializarlos en el oncreate y luego activar funciones en el metodo del crono
    private MediaPlayer mediaPlayerAccion;
    private MediaPlayer mediaPlayerRelax;
    private MediaPlayer mediaPlayerTerminado;

    //Variable que marcará el contenido de la cuenta atras
    private long mTimeLeftInMillis45 = START_TIME_IN_MILLIS45;
    private long mTimeLeftInMillis15 = START_TIME_IN_MILLIS15;

    //Creamos las variables que hacen la conexión con la base de datos
    private ConexionSQLite conexionSQLite;
    private SQLiteDatabase db;
    private boolean empiezaSesion; //para evitar duplicar registro de sesiones

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiit_trainning);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ///Inicialización de los Arrays
        ejerciciosSuperiores = new LinkedHashSet<>();
        ejerciciosInferiores = new LinkedHashSet<>();
        ejerciciosAbdominales = new LinkedHashSet<>();
        ejerciciosCardio = new LinkedHashSet<>();
        checkBoxes = new ArrayList<>();

        //Mapeamos las variables creadas con elementos del layout (vistas)
        mTextViewCountDown45 = findViewById(R.id.TV_crono45);
        mTextViewCountDown15 = findViewById(R.id.TV_crono15);
        mTextViewSerie = findViewById(R.id.TV_Numero_Serie);
        mButtonStart = findViewById(R.id.btn_Start);
        mButtonPause = findViewById(R.id.btn_Pause);
        mButtonStop = findViewById(R.id.btn_Stop);
        mButtonResetTraining = findViewById(R.id.btn_ResetTrainning);

        //Aquí mapeamos los checkboxes elementos de la actividad con las variables de tipo checkboxes (20) además de agregarselos al arrayList de checkBoxes
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

        //Inicializamos los variables d etipo mediaPlayer (sonidos cronos)
        mediaPlayerAccion = MediaPlayer.create(this, R.raw.vamos_alto);
        mediaPlayerAccion.setVolume(1000, 1000);
        mediaPlayerRelax = MediaPlayer.create(this, R.raw.relax_alto);
        mediaPlayerRelax.setVolume(1000,1000);
        mediaPlayerTerminado = MediaPlayer.create(this, R.raw.felicidades);
        mediaPlayerTerminado.setVolume(1000,1000);

        //Inicializamos las variables relacionadas con la base de datos
        conexionSQLite = new ConexionSQLite(this);
        db = conexionSQLite.getReadableDatabase();
        empiezaSesion = false;

        ///AQUI CARGAMOS EL METODO CARGAR PREFERENCIAS
        cargarPreferencias();

        if(ejerciciosSuperiores != null) {
            //Bucles for each que recorrer los ejercicios y aquellos que estén marcados los pondrá visibles
            for (String ejercicio : ejerciciosSuperiores) {
                checkBoxes.get(incrementaIndiceCheckBox).setVisibility(View.VISIBLE);
                if (etiquetaNumeroSerie<10) {
                    checkBoxes.get(incrementaIndiceCheckBox).setText("0" + etiquetaNumeroSerie + " " + ejercicio);
                }else{
                    checkBoxes.get(incrementaIndiceCheckBox).setText(etiquetaNumeroSerie +" "+ ejercicio);
                }
                incrementaIndiceCheckBox++;
                etiquetaNumeroSerie++;
            }
        }

        if(ejerciciosInferiores != null) {
            for (String ejercicio : ejerciciosInferiores) {
                checkBoxes.get(incrementaIndiceCheckBox).setVisibility(View.VISIBLE);
                if (etiquetaNumeroSerie<10) {
                    checkBoxes.get(incrementaIndiceCheckBox).setText("0" + etiquetaNumeroSerie + " " + ejercicio);
                }else{
                    checkBoxes.get(incrementaIndiceCheckBox).setText(etiquetaNumeroSerie +" "+ ejercicio);
                }
                incrementaIndiceCheckBox++;
                etiquetaNumeroSerie++;
            }
        }

        if(ejerciciosAbdominales != null) {
            for (String ejercicio : ejerciciosAbdominales) {
                checkBoxes.get(incrementaIndiceCheckBox).setVisibility(View.VISIBLE);
                if (etiquetaNumeroSerie<10) {
                    checkBoxes.get(incrementaIndiceCheckBox).setText("0" + etiquetaNumeroSerie + " " + ejercicio);
                }else{
                    checkBoxes.get(incrementaIndiceCheckBox).setText(etiquetaNumeroSerie +" "+ ejercicio);
                }
                incrementaIndiceCheckBox++;
                etiquetaNumeroSerie++;
            }
        }

        if(ejerciciosCardio != null) {
            for (String ejercicio : ejerciciosCardio) {
                checkBoxes.get(incrementaIndiceCheckBox).setVisibility(View.VISIBLE);
                if (etiquetaNumeroSerie<10){
                    checkBoxes.get(incrementaIndiceCheckBox).setText("0"+etiquetaNumeroSerie +" "+ ejercicio);
                }else{
                    checkBoxes.get(incrementaIndiceCheckBox).setText(etiquetaNumeroSerie +" "+ ejercicio);
                }
                incrementaIndiceCheckBox++;
                etiquetaNumeroSerie++;
            }
        }

        //Creamos funcionalidad al botón start
        mButtonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Le decimos que cuando le demos al botón start comience la cuenta atrás de 45 segundos (metodo startTimer45())
                startTimer45();
                //Que active el sonido cuando se inicie el entrenamiento
                mediaPlayerAccion.start();

                //Ponemos este condicional para evitar sobreescribir 2 veces la misma sesión
                if(empiezaSesion == false){
                    //LLamamos al método que guarda la sesión
                    guardarRegistroActividad();
                    empiezaSesion = true;
                }

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

        //Creamos funcionalidad al boton Reset Trainning
        mButtonResetTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetearEntrenamiento();

                Intent intent = new Intent(HiitTrainningActivity.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Ejercicios reiniciados correctamente, por favor seleccione nuevos ejercicios", Toast.LENGTH_LONG).show();
            }
        });

        //Actualizamos el crono si le damos a stop
        updateCountDownText45();
        updateCountDownText15();

    }//Llave de cierre del Oncreate


    //Desarrollo de los metodos invocados
    //Metodo para poder acumular ejercicios de diferentes grupos muscuales de una misma activity mediante SharedPreferences
    private void cargarPreferencias(){
        SharedPreferences preferencias = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        ejerciciosSuperiores = preferencias.getStringSet("Superiores", null);
        ejerciciosInferiores = preferencias.getStringSet("Inferiores", null);
        ejerciciosAbdominales = preferencias.getStringSet("Abdominales", null);
        ejerciciosCardio = preferencias.getStringSet("Cardio", null);

        //Creamos estas variables dentro del método para contabilizar el número total de ejercicios de cada grupo muscular
        int numTotalSup = 0, numTotalInf=0, numTotalAb=0, numTotalCar=0;

        //condicional que establezca que si hay ejercicios los contabilize en su correspondiente tamaño de array
        if(ejerciciosSuperiores !=null){
            numTotalSup = ejerciciosSuperiores.size();
        }

        //condicional que establezca que si hay ejercicios los contabilize en su correspondiente tamaño de array
        if(ejerciciosInferiores !=null){
            numTotalInf = ejerciciosInferiores.size();
        }

        //condicional que establezca que si hay ejercicios los contabilize en su correspondiente tamaño de array
        if(ejerciciosAbdominales !=null){
            numTotalAb = ejerciciosAbdominales.size();
        }

        //condicional que establezca que si hay ejercicios los contabilize en su correspondiente tamaño de array
        if(ejerciciosCardio !=null){
            numTotalCar = ejerciciosCardio.size();
        }

        //Una vez contabilazados cada grupos los agrupamos en el total para poder interactuar con los cronos y series
        numeroTotalEjercicios = numTotalSup + numTotalInf + numTotalAb + numTotalCar;
    }

    private void resetearEntrenamiento(){
        SharedPreferences preferencias = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putStringSet("Superiores", null);
        editor.putStringSet("Inferiores", null);
        editor.putStringSet("Abdominales", null);
        editor.putStringSet("Cardio", null);
        editor.apply();
    }

    //Este método es el más importante, se instancia un objeto de tipo CountDowntimer
    //será el encargado de darle funcionalidad al crono de acción de ejercicios (45 segundos)
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
                //Por tanto aquí le decimos que al acabar el crono de acción empiece el descanso con el sonido de descanso
                mediaPlayerRelax.start();
            }
        }.start();
    }

    //será el encargado de darle funcionalidad al crono de descanso entre ejercicios (15 segundos)
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

                //Reset de cronómetros
                pauseTimer45();
                pauseTimer15();
                resetTimer45();
                resetTimer15();

                if(numSerie <= numeroTotalEjercicios){
                    //Con esto conseguimos que se le añada un 0 delante hasta el ejercicio numero 9
                    if(numSerie < 10){
                        mTextViewSerie.setText("0"+numSerie);

                        //A partir del ejercicio numero 10 no tendremos que añadir ningún cero pq ya son de dos dígitos
                    }else{
                        mTextViewSerie.setText(numSerie);
                    }

                    //Por último de decimos que inicie la cuenta de nuevo
                    startTimer45();
                    //Por tanto que active el sonido de empezar ejercicio para interactuar con el usuario
                    mediaPlayerAccion.start();
                }else{
                    Toast.makeText(getApplicationContext(),"Felicidades, has completado tu sesión de entrenamiento", Toast.LENGTH_LONG).show();
                    mediaPlayerTerminado.start();
                }
            }
        }.start();
    }

    //Aquí paramos la cuenta regresiva
    private void pauseTimer45(){
        if (mCountDownTimer45 != null)
        mCountDownTimer45.cancel();
    }

    //Aquí paramos la cuenta regresiva
    private void pauseTimer15(){
        if (mCountDownTimer15 != null) //Con esta condición evitamos NPE
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

    //Metodo para actualizar la cuenta del crono
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

    //Metodo  void guardarRegistroActividad
    private void guardarRegistroActividad(){

        //Cargamos las preferencias de Usuario, sus datos.
        SharedPreferences preferencias = getSharedPreferences("DatosUsuario", Context.MODE_PRIVATE);

        //Obtenemos la información del IdUsuario, primaryKey, por tanto único
        int idUsuario = preferencias.getInt("usuarioId", 0);

        //instanciamos objeto de tipo Date para la fecha y lahora
        Date fechaHoraActual = new Date();

        //Esta intrucción es para dar formato (cuidado que son guiones y NO barras)
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //Finalmente pasamos a un string el formato de fecha.
        String fechaHora = sdf.format(fechaHoraActual);

        //Array de ejercicios
        ArrayList<Integer> idEjercicios = new ArrayList<>();

        //Llenamos el arrayList con los id's de los ejercicios seleccionados por el usuario
        if(ejerciciosSuperiores != null) {
            for (String ejercicio : ejerciciosSuperiores) {

                String[] parametro = {ejercicio};

                try {
                    String select = "SELECT id FROM EJERCICIO WHERE nombreEjercicio = ?";
                    Cursor cursor = db.rawQuery(select, parametro);
                    cursor.moveToFirst();
                    idEjercicios.add(cursor.getInt(0));
                    cursor.close();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Se ha producido un error", Toast.LENGTH_LONG).show();
                }
            }
        }

        if(ejerciciosInferiores != null) {
            for (String ejercicio : ejerciciosInferiores) {

                String[] parametro = {ejercicio};

                try {
                    String select = "SELECT id FROM EJERCICIO WHERE nombreEjercicio = ?";
                    Cursor cursor = db.rawQuery(select, parametro);
                    cursor.moveToFirst();
                    idEjercicios.add(cursor.getInt(0));
                    cursor.close();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Se ha producido un error", Toast.LENGTH_LONG).show();
                }
            }
        }

        if(ejerciciosAbdominales != null) {
            for (String ejercicio : ejerciciosAbdominales) {

                String[] parametro = {ejercicio};

                try {
                    String select = "SELECT id FROM EJERCICIO WHERE nombreEjercicio = ?";
                    Cursor cursor = db.rawQuery(select, parametro);
                    cursor.moveToFirst();
                    idEjercicios.add(cursor.getInt(0));
                    cursor.close();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Se ha producido un error", Toast.LENGTH_LONG).show();
                }
            }
        }

        if(ejerciciosCardio != null) {
            for (String ejercicio : ejerciciosCardio) {

                String[] parametro = {ejercicio};

                try {
                    String select = "SELECT id FROM EJERCICIO WHERE nombreEjercicio = ?";
                    Cursor cursor = db.rawQuery(select, parametro);
                    cursor.moveToFirst();
                    idEjercicios.add(cursor.getInt(0));
                    cursor.close();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Se ha producido un error", Toast.LENGTH_LONG).show();
                }
            }
        }

        //Cerramos la conexion
        db.close();

        //Información del método creado en el controlador para registrar la sesión con los campos solitados.
        conexionSQLite.registroSesiones(idUsuario, idEjercicios, fechaHora);

        //información y feedback con el usuario
        Toast.makeText(this, "Registro de sesión completado", Toast.LENGTH_LONG).show();

    }

    //Método del botón volver
    public void Volver(View vista){

        onBackPressed();
    }
}
