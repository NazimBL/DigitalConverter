package com.e_monsite.nazim_app.binazim;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Binary extends Activity {

    TextView n=null;
    int i=0,num=0;
    int [] array=new int [35];
    EditText number=null;
    Button button=null,button2=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binary);


        n=(TextView)findViewById(R.id.convert);

        button=(Button)findViewById(R.id.button);
        button2=(Button)findViewById(R.id.button2);

        number=(EditText)findViewById(R.id.n);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


try{
                     num = Integer.parseInt(number.getText().toString());
}catch(NumberFormatException e){

    AlertDialog.Builder builder=new AlertDialog.Builder(Binary.this);
    builder.setCancelable(false).setNeutralButton("OK",new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }).setMessage(" The Number Entered is Too Large !").setTitle("    Out Of Range    ").show();
}

                n.setText(toBinary(array,num));
            }

        });

button2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        try{
            num = Integer.parseInt(number.getText().toString());
        }catch(NumberFormatException e){

            AlertDialog.Builder builder=new AlertDialog.Builder(Binary.this);
            builder.setCancelable(false).setNeutralButton("OK",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            }).setMessage(" The Number Entered is Too Large !").setTitle("    Out Of Range    ").show();
        }

         Split(array,num);
        n.setText(toBcd(array,i));


    }
});

    }
    public void Split(int[] array,int num) {

int row=0;
int myCounter=0;

        do {
            array[row] = num % 10;

            num /= 10;
            row++;
            myCounter++;
        } while (num != 0);

        i=myCounter;
    }

    public String toBinary(int[] binary,int n){
        int  i2 = 0;
        int count2 = binary.length-1;
        int a = 0;
        int  k2 = 0;


        for(int j=0;j<binary.length;j++) binary[j]=0;
        while (a >= 0) {
            while (n>= (int) Math.pow(2, i2)) {
                i2++;
            }
            a = i2 - 1;
            if (a < 0) break;
            binary[i2] = 1;
            i2 = 0;
            n = n- (int) (Math.pow(2, a));
        }

        while (count2 != 0) {
            if (binary[count2] == 1) {
                k2 = count2;
                count2 = 1;
            }
            count2--;
        }

        StringBuilder builder = new StringBuilder();
        while (k2 > 0) {

            builder.append(binary[k2]);
            k2--;
        }
        return builder.toString();
    }

  public String toBcd(int[] array,int count){


      String bcd="";
      StringBuilder builder=new StringBuilder();

      for(int w=count-1;w>=0;w--){

          if (array[w]==9) bcd="1001";
          else if (array[w]==8) bcd="1000";
          else if (array[w]==7) bcd="0111";
          else if (array[w]==6) bcd="0110";
          else if (array[w]==5) bcd="0101";
          else if (array[w]==4) bcd="0100";
          else if (array[w]==3) bcd="0011";
          else if (array[w]==2) bcd="0010";
          else if (array[w]==1) bcd="0001";
          else bcd="0000";
          builder.append(bcd);

      }
  return  builder.toString();
  }


}
