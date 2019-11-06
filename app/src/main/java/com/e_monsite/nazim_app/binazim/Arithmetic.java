package com.e_monsite.nazim_app.binazim;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;



public class Arithmetic extends AppCompatActivity {

    RadioButton rb2=null,rb3=null,rb4=null,rb5=null,r6=null,r7=null,r8=null,r9=null,rb10=null,add,seb,mul,div;
     EditText edit1=null,edit2=null;
     Button button=null;
    TextView result=null,operation=null;
    int[] array1=new int[35];
    int[] array2=new int[35];
  boolean toastTag=true;
    int base=10,n1=0,n2=0,count1=0,count2=0,Sum1=0,Sum2=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arithmetic);

        rb2=(RadioButton)findViewById(R.id.id2);
        rb3=(RadioButton)findViewById(R.id.id3);
        rb4=(RadioButton)findViewById(R.id.id4);
        rb5 =(RadioButton)findViewById(R.id.id5);
        r6=(RadioButton)findViewById(R.id.id6);
        r7=(RadioButton)findViewById(R.id.id7);
        r8=(RadioButton)findViewById(R.id.id8);
        r9=(RadioButton)findViewById(R.id.id9);
        rb10=(RadioButton)findViewById(R.id.id10);

        add=(RadioButton)findViewById(R.id.add);
        seb=(RadioButton)findViewById(R.id.sub);
        mul=(RadioButton)findViewById(R.id.mul);
        div=(RadioButton)findViewById(R.id.div);

        result=(TextView)findViewById(R.id.result);
        operation=(TextView)findViewById(R.id.op);

        edit1=(EditText)findViewById(R.id.n1);
        edit2=(EditText)findViewById(R.id.n2);

        button=(Button)findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(rb3.isChecked()) base=3;
                else if(rb4.isChecked()) base=4;
                else if(rb5.isChecked()) base=5;
                else if(r6.isChecked()) base=6;
                else if(r7.isChecked()) base=7;
                else if(r8.isChecked()) base=8;
                else if(r9.isChecked()) base=9;
                else if(rb2.isChecked()) base=2;
                else base=10;

    toastTag=true;

                try{

                    n1=Integer.parseInt(edit1.getText().toString());
                    n2=Integer.parseInt(edit2.getText().toString());

                }catch(NumberFormatException e){

                    AlertDialog.Builder builder=new AlertDialog.Builder(Arithmetic.this);
                    builder.setCancelable(false).setNeutralButton("OK",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    }).setMessage(" The Number Entered is Too Large or Null!").setTitle("    Out Of Range    ").show();
                }

                count1=Split(array1,n1);
                count2=Split(array2,n2);

                for (int j=count1;j>=0;j--)   Sum1 = Sum1 + ((int) Math.pow(base, j) * array1[j]);
                for (int j=count2;j>=0;j--)   Sum2 = Sum2 + ((int) Math.pow(base, j) * array2[j]);

                if(add.isChecked()) {
                    operation.setText("+");
                    result.setText(""+(Sum1+Sum2));

                }
               else if(seb.isChecked()) {
                    operation.setText("-");
                    result.setText(""+(Sum1-Sum2));

                }
              else if(mul.isChecked()) {
                    operation.setText("x");
                    result.setText(""+(Sum1*Sum2));

                }

              else if(div.isChecked()) {
                    operation.setText("/");
                    result.setText(""+(Sum1/Sum2));

                }
                else {
                    result.setText("No Operation specified");
                    toastTag=false;
                }

            if(toastTag) Toast.makeText(Arithmetic.this,"NB : The Result is in Base 10",Toast.LENGTH_SHORT).show();

            }

        });

    }

    public int Split(int[] array,int num) {

        int row=0;
        int myCounter=0;
        Sum1=0;
        Sum2=0;
        for(int m=0;m<array.length;m++) array[m]=0;

        do {
            array[row] = num % 10;
            if (array[row]>=base) {
                AlertDialog.Builder builder=new AlertDialog.Builder(Arithmetic.this);
                builder.setCancelable(false).setNeutralButton("OK",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                }).setMessage(" Out of set,only digits less than "+base+" can be used in your system").setTitle("    Out Of Set    ").show();

                break;
            }

            num /= 10;
            row++;
            myCounter++;
        } while (num != 0);

        myCounter--;
    return myCounter;
    }

}
