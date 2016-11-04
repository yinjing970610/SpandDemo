package com.example.hp.spanddemo;

import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.graphics.MaskFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.MaskFilterSpan;
import android.text.style.RasterizerSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private MaskFilterSpan maskFilterSpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        setTvv1();
        setV2();
        set3();
    }

    private void set3() {
        SpannableString word = new SpannableString("ghjkldsfdf");
        word.setSpan(new BackgroundColorSpan(Color.GREEN), 0, word.length(),
                Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        tv4.append("\n");
        tv4.append(word);
        word = new SpannableString("fdsfs- http://orgcent.com");
        word.setSpan(new ForegroundColorSpan(Color.BLUE), 6, word.length(),
                Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        tv4.append("\n");
        tv4.append(word);
        SpannableStringBuilder multiWord = new SpannableStringBuilder();
        multiWord.append("dfsdfds");
        multiWord.append("fdsfdsf");
        multiWord.append("dsfsddssd");

        StyleSpan span = new StyleSpan(Typeface.BOLD_ITALIC);
        multiWord.setSpan(span, 0, multiWord.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        tv3.setText(multiWord);
    }

    private void setV2() {
        SpannableString ss = new SpannableString("图片：.");
        Drawable d = getResources().getDrawable(R.mipmap.ic_launcher);
        d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
        ImageSpan span = new ImageSpan(d, ImageSpan.ALIGN_BASELINE);
        ss.setSpan(span, 3, 4, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);

        tv2.setText(ss);
    }

    private void setTvv1() {
        SpannableString ss = new SpannableString("af dsfhodsphfdsfajdjgggggggggddasfsdfdfsdfsd");
        int length = ss.length();
        System.out.println("length:" + ss.length());
        ss.setSpan(new ForegroundColorSpan(Color.RED), 0, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(new URLSpan("sadasdas"), 2, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(new StyleSpan(Typeface.ITALIC), 5, 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(new StrikethroughSpan(), 7, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(new UnderlineSpan(), 10, 16, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(new ForegroundColorSpan(Color.GREEN), 10, 13, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        ss.setSpan(new RasterizerSpan(),13,15,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        ss.setSpan(new SuperscriptSpan(),15.17,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        ss.setSpan(new MaskFilterSpan(MaskFilter),17,19,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(new BackgroundColorSpan(Color.RED),19,22,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(new AbsoluteSizeSpan(20),22,24,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(new RelativeSizeSpan(30),24,26,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        maskFilterSpan = new MaskFilterSpan(new EmbossMaskFilter(new float[]{1,1,3}, 1.5f, 8, 3));
        ss.setSpan(maskFilterSpan, length - 10, length, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);

        tv1.setText(ss);

    }
}
