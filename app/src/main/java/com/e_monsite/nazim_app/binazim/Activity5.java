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

import java.util.ArrayList;


public class Activity5 extends Activity {

    TextView n=null;

    int i=0,count=499,a=0,j=0,k=0,base=10,num=0;
    int[] array=new int[35];

    RadioButton rb3=null,rb4=null,rb5=null,r6=null,r7=null,r8=null,r9=null;
    EditText number=null;
    Button button=null;
    ArrayList arrayList=new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity5);

        button =(Button)findViewById(R.id.button);
        n=(TextView)findViewById(R.id.convert);
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
                i=0;count=9;a=0;j=0;k=0;

                if(rb3.isChecked()) base=3;
                else if(rb4.isChecked()) base=4;
                else if(rb5.isChecked()) base=5;
                else if(r6.isChecked()) base=6;
                else if(r7.isChecked()) base=7;
                else if(r8.isChecked()) base=8;
                else if(r9.isChecked()) base=9;
                try{

                    num=Integer.parseInt(number.getText().toString());
                }catch(NumberFormatException e){

                    AlertDialog.Builder builder=new AlertDialog.Builder(Activity5.this);
                    builder.setCancelable(false).setNeutralButton("OK",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    }).setMessage(" The Number Entered is Too Large !").setTitle("    Out Of Range    ").show();
                }

                for(j=0;j<count;j++)
                {
                    array[j]=0;
                    arrayList.add(j,0);
                }

                while(a>=0) {
                    while (num>=(int)Math.pow(base,i))
                    {
                        i++;
                    }

                    a=i-1;
                    if(a<0) break;
                    array[a]=num/(int)(Math.pow(base,a));
                    arrayList.remove(a);
                    arrayList.add(a,num/(int)Math.pow(base,a));
                    i=0;
                    num=num-((int)Math.pow(base,a)*array[a]);
                }
                count--;
                while((int)arrayList.get(count)==0)
                {
                    arrayList.remove(count);
                    count--;
                    if(count<0) break;
                }

                k=count
                ;

                StringBuilder Strbuilder=new StringBuilder();
                while(k>=0)
                {

                    Strbuilder.append(arrayList.get(k));
                    k--;

                }
                n.setText(""+Strbuilder);
            }
        });

    }
    }
