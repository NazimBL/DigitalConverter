package com.e_monsite.nazim_app.binazim;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Activity2 extends Activity {

    TextView textView=null;
    Button b=null;
    EditText editText=null;
    int i=0,j=0,count=0;
    int Sum=0,n=0;
    int[] array=new int[30];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);


textView=(TextView)findViewById(R.id.id1);
 b=(Button)findViewById(R.id.button);
 editText=(EditText)findViewById(R.id.nomro);

        for(int m=0;m<array.length;m++) array[m]=0;


b.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {


try {
    n = Integer.parseInt(editText.getText().toString());
}catch(NumberFormatException e){

    AlertDialog.Builder builder=new AlertDialog.Builder(Activity2.this);
    builder.setCancelable(false).setNeutralButton("OK",new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }).setMessage(" The Number Entered is Too Large !").setTitle("    Out Of Range    ").show();
}
        do {
            array[i]=n%10;
            if (array[i]>1) {
                AlertDialog.Builder builder=new AlertDialog.Builder(Activity2.this);
                builder.setCancelable(false).setNeutralButton("OK",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                }).setMessage(" Not a binary number,only digits less than 2 can be used in Binary systems").setTitle("    Out Of Set    ").show();

                  break;
            }
            n/=10;
            i++;
            count++;
        } while (n != 0);

            count--;

        for (j=count;j>=0;j--)  Sum=Sum+((int)Math.pow(2,j)*array[j]);

    textView.setText(""+Sum);

    for(int m=0;m<array.length;m++) array[m]=0;
   count=0;
   i=0;
   Sum=0;
}


});

    }

}
