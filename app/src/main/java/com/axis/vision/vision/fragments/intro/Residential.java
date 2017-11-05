package com.axis.vision.vision.fragments.intro;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.axis.vision.vision.R;

import agency.tango.materialintroscreen.SlideFragment;

public class Residential extends SlideFragment {

   @Nullable
   @Override
   public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       final View view = inflater.inflate(R.layout.fragment_residential_slide, container, false);

       return view;
   }

   @Override
   public int backgroundColor() {
       return R.color.colorBlack;
   }

   @Override
   public int buttonsColor() {
       return R.color.colorGoldenTextDark;
   }

   @Override
   public boolean canMoveFurther() {
       return true;
   }

   @Override
   public String cantMoveFurtherErrorMessage() {
       return "eroor";
   }
}
