package de.entessimo.savearray;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final String FILE_NAME = "example.txt";
    TextView tV1;
    TextView tV2;
    TextView tV3;
    String[] textArray = {"asdf","asdfasf","jztergb"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tV1 = findViewById(R.id.tV1);
        tV2 = findViewById(R.id.tV2);
        tV3 = findViewById(R.id.tV3);

    }

    public void save (View v) {
        FileOutputStream fos = null;
        //String text1 = textArray[0];
        //String text2 = textArray[1];
        String text3;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= 2; i++) {
            sb.append(textArray[i]).append("/n€$§/n");
        }
        text3 = sb.toString();
            try {
                fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
                fos.write(text3.getBytes());
            } catch(FileNotFoundException e){
                e.printStackTrace();
            } catch(IOException e){
                e.printStackTrace();
            } finally{
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


    }
}
