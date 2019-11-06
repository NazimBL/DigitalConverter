package com.e_monsite.nazim_app.binazim;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;




public class Activity4 extends Activity {

    TextView n=null;
    int i=0,count=0,base=10,Sum=0;
    int[] array=new int[30];
    EditText number=null;
    int num=0;
    RadioButton rb3=null,rb4=null,rb5=null,r6=null,r7=null,r8=null,r9=null;
    Button button=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity4);

        n=(TextView)findViewById(R.id.convert);
        button=(Button)findViewById(R.id.button);
        number=(EditText)findViewById(R.id.n);

        rb3=(RadioButton)findViewById(R.id.id3);
        rb4=(RadioButton)findViewById(R.id.id4);
        rb5 =(RadioButton)findViewById(R.id.id5);
        r6=(RadioButton)findViewById(R.id.id6);
        r7=(RadioButton)findViewById(R.id.id7);
        r8=(RadioButton)findViewById(R.id.id8);
        r9=(RadioButton)findViewById(R.id.id9);

       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {


               if (rb3.isChecked()) base = 3;
               else if (rb4.isChecked()) base = 4;
               else if (rb5.isChecked()) base = 5;
               else if(r6.isChecked()) base=6;
               else if(r7.isChecked()) base=7;
               else if(r8.isChecked()) base=8;
               else if(r9.isChecked()) base=9;

               try{
                num = Integer.parseInt(number.getText().toString());
               }catch(NumberFormatException e){

                   AlertDialog.Builder builder=new AlertDialog.Builder(Activity4.this);
                   builder.setCancelable(false).setNeutralButton("OK",new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialogInterface, int i) {
                           dialogInterface.cancel();
                       }
                   }).setMessage(" The Number Entered is Too Large !").setTitle("    Out Of Range    ").show();
               }
                   do {
                   array[i] = num % 10;
                   if (array[i]>=base) {
                       AlertDialog.Builder builder=new AlertDialog.Builder(Activity4.this);
                       builder.setCancelable(false).setNeutralButton("OK",new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialogInterface, int i) {
                               dialogInterface.cancel();
                           }
                       }).setMessage(" Out of set,only digits less than "+base+" can be used in your system").setTitle("    Out Of Set    ").show();

                       break;
                   }
                   num /= 10;
                   i++;
                   count++;
               } while (num != 0);

               count--;

               for (int j=count;j>=0;j--)   Sum = Sum + ((int) Math.pow(base, j) * array[j]);

               n.setText("" + Sum);

               for(int m=0;m<array.length;m++) array[m]=0;
               count=0;
               i=0;
               Sum=0;
           }
       });

    }


}
