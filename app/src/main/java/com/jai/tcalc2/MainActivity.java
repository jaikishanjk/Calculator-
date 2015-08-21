package com.jai.tcalc2;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    ArrayList<String> arrayman = new ArrayList<String>();
    int dcount=0;
    String s1 = "";
    String s2 = "";
    public String fin = "";
    int fn=0;



    public void btndisp (View v){
        TextView disp = (TextView) findViewById(R.id.disp);
        TextView t2 = (TextView) findViewById(R.id.t2);
        Button btn = (Button) v;
        s1 = (String) btn.getText().toString();

        int z = arrayman.size();

        if(z>0)
        {
            fin = arrayman.get(arrayman.size()-1);
            fn = fin.length();
        }

        if(!s1.contains("+") && !s1.contains("-") && !s1.contains("X") && !s1.contains("/"))
        {
            if(s1.equals(".") && dcount == 1)
            {
                LayoutInflater lf = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final Button eq = (Button) findViewById(R.id.equ);
                eq.setClickable(false);
                View popView = lf.inflate(R.layout.popwindow,null);
                final PopupWindow popUp = new PopupWindow(popView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                Button dismiss = (Button) popView.findViewById(R.id.popBt);
                dismiss.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popUp.dismiss();
                        eq.setClickable(true);
                    }
                });
                popUp.showAsDropDown(disp,-03,00);
            }
            else
            {
                if (s1.equals("."))
                {
                    dcount++;
                }
                s2 = s2 + s1;
                if (arrayman.size() > 0) arrayman.remove(arrayman.size() - 1);
                arrayman.add(s2);
                t2.setText(t2.getText().toString() + s1);
                //t2.setText(arrayman.toString());
            }
        }
        else
        {
            if(z==0)
            {
                if (s1.equals("-"))
                {
                    arrayman.add(s1);
                    s2 = s2 + s1;
                    t2.setText(s1);
                }
                else
                {
                    LayoutInflater lf = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    final Button eq = (Button) findViewById(R.id.equ);
                    eq.setClickable(false);
                    View popView = lf.inflate(R.layout.popwindow, null);
                    final PopupWindow popUp = new PopupWindow(popView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    Button dismiss = (Button) popView.findViewById(R.id.popBt);
                    dismiss.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            popUp.dismiss();
                            eq.setClickable(true);
                        }
                    });
                    popUp.showAsDropDown(disp, -03, 00);
                }
            }
            else if(z==1 && arrayman.get(0).equals("-"))
            {
                LayoutInflater lf = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final Button eq = (Button) findViewById(R.id.equ);
                eq.setClickable(false);
                View popView = lf.inflate(R.layout.popwindow, null);
                final PopupWindow popUp = new PopupWindow(popView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                Button dismiss = (Button) popView.findViewById(R.id.popBt);
                dismiss.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popUp.dismiss();
                        eq.setClickable(true);
                    }
                });
                popUp.showAsDropDown(disp, -03, 00);
            }
            else
            {
                String s8 = fin;
                int y = s8.length();
                if (fin.charAt(fn - 1) == '.') {
                    LayoutInflater lf = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    final Button eq = (Button) findViewById(R.id.equ);
                    eq.setClickable(false);
                    View popView = lf.inflate(R.layout.popwindow, null);
                    final PopupWindow popUp = new PopupWindow(popView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    Button dismiss = (Button) popView.findViewById(R.id.popBt);
                    dismiss.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            popUp.dismiss();
                            eq.setClickable(true);
                        }
                    });
                    popUp.showAsDropDown(disp, -03, 00);
                }
                else if (s8.charAt(y - 1) == '+' || s8.charAt(y - 1) == '-' || s8.charAt(y - 1) == 'X' || s8.charAt(y - 1) == '/')
                {
                    String s4 = arrayman.toString();
                    arrayman.remove(arrayman.size() - 1);
                    arrayman.remove(arrayman.size() - 1);
                    arrayman.add(s1);
                    arrayman.add(s1);
                    String s5 = "";
                    for (int i = 0; i < arrayman.size() - 2; i++) {
                        s5 = s5 + arrayman.get(i);
                    }
                    s5 = s5 + s1;
                    t2.setText(s5);
                }
                else
                {
                    arrayman.add(s1);
                    arrayman.add(s1);
                    s2 = "";
                    dcount = 0;
                    t2.setText(t2.getText().toString() + s1);
                    //t2.setText(arrayman.toString());
                }

            }
        }
    }


    public void onclickequal (View v){
        TextView t2 = (TextView) findViewById(R.id.t2);
        TextView disp = (TextView) findViewById(R.id.disp);
        float res = 0;
        int c=arrayman.size();

        if(arrayman.isEmpty() || (!arrayman.contains("+") && !arrayman.contains("-") && !arrayman.contains("X") && !arrayman.contains("/")))
        {
            LayoutInflater lf = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final Button eq = (Button) findViewById(R.id.equ);
            eq.setClickable(false);
            View popView = lf.inflate(R.layout.popwindow,null);
            final PopupWindow popUp = new PopupWindow(popView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            Button dismiss = (Button) popView.findViewById(R.id.popBt);
            dismiss.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popUp.dismiss();
                    eq.setClickable(true);
                }
            });
            popUp.showAsDropDown(disp,-03,00);
        }
        else
        {
            String s = (String) arrayman.get(arrayman.size()-1);
            int k = s.length();
            if (arrayman.get(arrayman.size()-1).equals("+") || arrayman.get(arrayman.size()-1).equals("-") || arrayman.get(arrayman.size()-1).equals("X") || arrayman.get(arrayman.size()-1).equals("/") || s.charAt(k-1)=='.') {
                LayoutInflater lf = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final Button eq = (Button) findViewById(R.id.equ);
                eq.setClickable(false);
                View popView = lf.inflate(R.layout.popwindow,null);
                final PopupWindow popUp = new PopupWindow(popView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                Button dismiss = (Button) popView.findViewById(R.id.popBt);
                dismiss.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popUp.dismiss();
                        eq.setClickable(true);
                    }
                });
        popUp.showAsDropDown(disp,-03,00);
            }
            else {
                while (c != 1) {
                    if (c > 3) {
                        if (arrayman.get(1).contains("X") || arrayman.get(1).contains("/")) {
                            if (arrayman.get(1).contains("X"))
                                res = Float.parseFloat(arrayman.get(0)) * Float.parseFloat(arrayman.get(2));
                            if (arrayman.get(1).contains("/"))
                                res = Float.parseFloat(arrayman.get(0)) / Float.parseFloat(arrayman.get(2));

                            arrayman.remove(0);
                            arrayman.remove(0);
                            arrayman.remove(0);
                            arrayman.add(0, Float.toString(res));
                            c = arrayman.size();
                        } else if (arrayman.get(3).contains("X") || arrayman.get(3).contains("/")) {
                            if (arrayman.get(3).contains("X"))
                                res = Float.parseFloat(arrayman.get(2)) * Float.parseFloat(arrayman.get(4));
                            if (arrayman.get(3).contains("/"))
                                res = Float.parseFloat(arrayman.get(2)) / Float.parseFloat(arrayman.get(4));

                            arrayman.remove(2);
                            arrayman.remove(2);
                            arrayman.remove(2);
                            arrayman.add(2, Float.toString(res));
                            c = arrayman.size();
                        } else
                        {
                            if (arrayman.get(1).contains("+"))
                                res = Float.parseFloat(arrayman.get(0)) + Float.parseFloat(arrayman.get(2));
                            if (arrayman.get(1).contains("-"))
                                res = Float.parseFloat(arrayman.get(0)) - Float.parseFloat(arrayman.get(2));
                            if (arrayman.get(1).contains("X"))
                                res = Float.parseFloat(arrayman.get(0)) * Float.parseFloat(arrayman.get(2));
                            if (arrayman.get(1).contains("/"))
                                res = Float.parseFloat(arrayman.get(0)) / Float.parseFloat(arrayman.get(2));

                            arrayman.remove(0);
                            arrayman.remove(0);
                            arrayman.remove(0);
                            arrayman.add(0, Float.toString(res));
                            c = arrayman.size();
                        }
                    }
                    else
                    {
                        if (arrayman.get(1).contains("+"))
                            res = Float.parseFloat(arrayman.get(0)) + Float.parseFloat(arrayman.get(2));
                        if (arrayman.get(1).contains("-"))
                            res = Float.parseFloat(arrayman.get(0)) - Float.parseFloat(arrayman.get(2));
                        if (arrayman.get(1).contains("X"))
                            res = Float.parseFloat(arrayman.get(0)) * Float.parseFloat(arrayman.get(2));
                        if (arrayman.get(1).contains("/"))
                            res = Float.parseFloat(arrayman.get(0)) / Float.parseFloat(arrayman.get(2));

                        arrayman.remove(0);
                        arrayman.remove(0);
                        arrayman.remove(0);
                        arrayman.add(0, Float.toString(res));
                        c = arrayman.size();
                    }
                }
                disp.setText(Float.toString(res));
                t2.setText(Float.toString(res));
                dcount=1;
                arrayman.clear();
                arrayman.add(Float.toString(res));
            }
        }
    }

    public void onclickce (View v){
        TextView t2 = (TextView) findViewById(R.id.t2);
        TextView disp = (TextView) findViewById(R.id.disp);

        s2 = "";
        s1 = "";
        disp.setText("0");
        t2.setText("");
        arrayman.clear();
        dcount=0;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
