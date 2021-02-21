package com.jovialway.bookexchange.BottomSheet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.jovialway.bookexchange.Activity.MainActivity;
import com.jovialway.bookexchange.C1214R;

public class SubscribeSheet extends BottomSheetDialogFragment {
    TextView bkashpay;
    Context context;
    Button notnow;
    TextView otherspay;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(C1214R.layout.bottom_subscribe, container, false);
        this.context = getContext();
        this.notnow = (Button) v.findViewById(C1214R.C1217id.notnow);
        this.bkashpay = (TextView) v.findViewById(C1214R.C1217id.bkashpay);
        this.otherspay = (TextView) v.findViewById(C1214R.C1217id.otherspay);
        this.notnow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SubscribeSheet.this.startActivity(new Intent(SubscribeSheet.this.getActivity(), MainActivity.class));
                SubscribeSheet.this.dismiss();
            }
        });
        this.bkashpay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(SubscribeSheet.this.getActivity(), "Thanks For Payment With Bkash", 0).show();
                SubscribeSheet.this.dismiss();
            }
        });
        this.otherspay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(SubscribeSheet.this.getActivity(), "Thanks For Bank Payment", 0).show();
                SubscribeSheet.this.dismiss();
            }
        });
        return v;
    }
}
