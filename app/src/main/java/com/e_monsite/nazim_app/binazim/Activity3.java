package com.e_monsite.nazim_app.binazim;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;


public class Activity3 extends Activity {

    TextView n=null;
    int i=0,count=9,a=0,j=0,k=0;
    int[] array=new int[35];
    int  num=0;
    ArrayList arrayList=new ArrayList();



    EditText number=null;
    Button button=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3);

        n=(TextView)findViewById(R.id.convert);
        button=(Button)findViewById(R.id.button);
        number=(EditText)findViewById(R.id.n);

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            i=0;count=9;a=0;j=0;k=0;


           try{
             num= Integer.parseInt(number.getText().toString());
           }catch(NumberFormatException e){

               AlertDialog.Builder builder=new AlertDialog.Builder(Activity3.this);
               builder.setCancelable(false).setNeutralButton("OK",new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                       dialogInterface.cancel();
                   }
               }).setMessage(" The Number Entered is Too Large !").setTitle("    Out Of Range    ").show();
           }

            arrayList.clear();
            for(j=0;j<10;j++)
            {
                array[j]=0;
                arrayList.add(j,0);
            }
            while(a>=0) {
                while (num>=(int)Math.pow(16,i))
                {
                    i++;
                }

                a=i-1;
                if(a<0) break;
                array[a]=num/(int)(Math.pow(16,a));
                arrayList.remove(a);
                arrayList.add(a,num/(int)Math.pow(16,a));
                i=0;
                num=num-((int)Math.pow(16,a)*array[a]);
               }

           while((int)arrayList.get(count)==0)
            {
               arrayList.remove(count);
                           count--;
                if(count<0) break;
          }

          k=count;



            StringBuilder builder=new StringBuilder();

                while(k>=0)
                {

                    if((int)arrayList.get(k)==10) {
                     arrayList.remove(k);
                     arrayList.add(k,"A");
                  }
                  else if((int)arrayList.get(k)==11)
                  {
                      arrayList.remove(k);
                      arrayList.add(k,"B");
                  }
                  else if((int)arrayList.get(k)==12)
                  {
                      arrayList.remove(k);
                      arrayList.add(k,"C");
                  }
                  else if((int)arrayList.get(k)==13)
                  {
                      arrayList.remove(k);
                      arrayList.add(k,"D");
                  }
                  else if((int)arrayList.get(k)==14)
                  {
                      arrayList.remove(k);
                      arrayList.add(k,"E");
                  }
                  else if((int)arrayList.get(k)==15)
                  {
                      arrayList.remove(k);
                      arrayList.add(k,"F");
                  }

                builder.append(arrayList.get(k));
                    k--;

                }
                n.setText(""+builder);
        }
    });

    }

}
