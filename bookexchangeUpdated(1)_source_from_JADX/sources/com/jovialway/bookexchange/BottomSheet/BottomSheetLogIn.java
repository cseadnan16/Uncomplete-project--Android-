package com.jovialway.bookexchange.BottomSheet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.jovialway.bookexchange.Activity.Login;
import com.jovialway.bookexchange.Activity.SingUp;
import com.jovialway.bookexchange.C1214R;

public class BottomSheetLogIn extends BottomSheetDialogFragment {
    Context context;
    Button registration;
    Button sinUp;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(C1214R.layout.bottom_login, container, false);
        this.context = getContext();
        this.sinUp = (Button) v.findViewById(C1214R.C1217id.bsLog);
        this.registration = (Button) v.findViewById(C1214R.C1217id.bsReg);
        this.sinUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                BottomSheetLogIn.this.startActivity(new Intent(BottomSheetLogIn.this.getActivity(), Login.class));
                BottomSheetLogIn.this.dismiss();
            }
        });
        this.registration.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                BottomSheetLogIn.this.startActivity(new Intent(BottomSheetLogIn.this.getActivity(), SingUp.class));
                BottomSheetLogIn.this.dismiss();
            }
        });
        return v;
    }
}
