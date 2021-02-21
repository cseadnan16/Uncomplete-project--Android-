package com.jovialway.bookexchange.Activity;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.C0198Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.jovialway.bookexchange.BottomSheet.BottomSheetLogIn;
import com.jovialway.bookexchange.C1214R;
import com.jovialway.bookexchange.Fragment.HomeFragment;
import com.jovialway.bookexchange.Fragment.ProfileFragment;
import com.jovialway.bookexchange.Fragment.WishFragment;
import com.jovialway.bookexchange.SessionClass.C1220SessionClass;

public class MainActivity extends AppCompatActivity {
    private long backpresstime;
    BottomNavigationView bottomNavigationView;

    /* renamed from: br */
    BroadcastReceiver f120br;
    /* access modifiers changed from: private */
    public BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        public boolean onNavigationItemSelected(MenuItem item) {
            int itemId = item.getItemId();
            if (itemId == C1214R.C1217id.home) {
                MainActivity.this.getSupportFragmentManager().beginTransaction().replace(C1214R.C1217id.container, new HomeFragment()).commit();
                return true;
            } else if (itemId == C1214R.C1217id.profile) {
                if (MainActivity.this.sessionClass.isLoggedIn()) {
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            MainActivity.this.getSupportFragmentManager().beginTransaction().replace(C1214R.C1217id.container, new ProfileFragment()).commit();
                        }
                    }, 1000);
                } else {
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            new BottomSheetLogIn().show(MainActivity.this.getSupportFragmentManager(), FirebaseAnalytics.Event.LOGIN);
                        }
                    }, 1000);
                }
                return true;
            } else if (itemId != C1214R.C1217id.wish) {
                return false;
            } else {
                MainActivity.this.getSupportFragmentManager().beginTransaction().replace(C1214R.C1217id.container, new WishFragment()).commit();
                return true;
            }
        }
    };
    C1220SessionClass sessionClass;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkInternetConnection();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon((int) C1214R.mipmap.ic_launcher_round);
        getWindow().getDecorView().setSystemUiVisibility(8192);
        getWindow().setStatusBarColor(-1);
    }

    private void checkInternetConnection() {
        if (this.f120br == null) {
            this.f120br = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    NetworkInfo info = (NetworkInfo) intent.getExtras().getParcelable("networkInfo");
                    NetworkInfo.State state = info.getState();
                    Log.d("TEST Internet", info.toString() + " " + state.toString());
                    if (state == NetworkInfo.State.CONNECTED) {
                        MainActivity.this.setContentView((int) C1214R.layout.activity_main);
                        MainActivity mainActivity = MainActivity.this;
                        mainActivity.sessionClass = C1220SessionClass.getInstance(mainActivity);
                        MainActivity mainActivity2 = MainActivity.this;
                        mainActivity2.bottomNavigationView = (BottomNavigationView) mainActivity2.findViewById(C1214R.C1217id.botomNavigation);
                        MainActivity.this.getSupportFragmentManager().beginTransaction().replace(C1214R.C1217id.container, new HomeFragment()).commit();
                        MainActivity.this.bottomNavigationView.setOnNavigationItemSelectedListener(MainActivity.this.mOnNavigationItemSelectedListener);
                        return;
                    }
                    MainActivity.this.setContentView((int) C1214R.layout.internet_screen);
                    Toast.makeText(MainActivity.this.getApplicationContext(), "Internet connection is Off", 1).show();
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.f120br, intentFilter);
        }
    }

    public boolean onNavigationItemSelected(MenuItem item) {
        final C0198Fragment[] selectFragment = {null};
        int itemId = item.getItemId();
        if (itemId == C1214R.C1217id.home) {
            selectFragment[0] = new HomeFragment();
        } else if (itemId != C1214R.C1217id.profile) {
            if (itemId == C1214R.C1217id.wish) {
                selectFragment[0] = new WishFragment();
            }
        } else if (this.sessionClass.isLoggedIn()) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    selectFragment[0] = new ProfileFragment();
                }
            }, 1000);
        } else {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    new BottomSheetLogIn().show(MainActivity.this.getSupportFragmentManager(), FirebaseAnalytics.Event.LOGIN);
                }
            }, 1000);
        }
        getSupportFragmentManager().beginTransaction().replace(C1214R.C1217id.container, selectFragment[0]).commit();
        return false;
    }

    public void onBackPressed() {
        if (this.backpresstime + 2000 > System.currentTimeMillis()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setIcon(C1214R.C1216drawable.logo_main);
            builder.setMessage("Do you really want to close this app?");
            builder.setTitle("Confirmation Alert!");
            builder.setCancelable(true);
            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    MainActivity.this.finish();
                    MainActivity.this.finish();
                    Intent intent = new Intent("android.intent.action.MAIN");
                    intent.addFlags(67108864);
                    intent.addCategory("android.intent.category.HOME");
                    MainActivity.this.startActivity(intent);
                }
            });
            builder.create().show();
        } else {
            Toast.makeText(getApplicationContext(), "Press back again to exit", 0).show();
        }
        this.backpresstime = System.currentTimeMillis();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C1214R.C1219menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == C1214R.C1217id.conditions) {
            Intent i = new Intent("android.intent.action.VIEW");
            i.setData(Uri.parse("https://docs.google.com/document/d/11U_IdiPIcJ1frO-NkTG4IngdFcX9HinU0EPdMS88OP4/edit?usp=sharing"));
            startActivity(i);
            return true;
        } else if (id == C1214R.C1217id.disclaimer) {
            Intent i2 = new Intent("android.intent.action.VIEW");
            i2.setData(Uri.parse("https://docs.google.com/document/d/1wjldGqtOQs3pg3zy8Bu5O4bhdZpWJYKN5Hbjhd2z6rs/edit?usp=sharing"));
            startActivity(i2);
            return true;
        } else if (id == C1214R.C1217id.other) {
            Intent i3 = new Intent("android.intent.action.VIEW");
            i3.setData(Uri.parse("https://play.google.com/store/apps/dev?id=5405265530863735793"));
            startActivity(i3);
            return true;
        } else if (id == C1214R.C1217id.rate) {
            Intent i4 = new Intent("android.intent.action.VIEW");
            i4.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.jovialway.norensirclass"));
            startActivity(i4);
            return true;
        } else if (id != C1214R.C1217id.privacy) {
            return super.onOptionsItemSelected(item);
        } else {
            Intent i5 = new Intent("android.intent.action.VIEW");
            i5.setData(Uri.parse("https://docs.google.com/document/d/1_CRM5FTQNxc9Evk1kRYim_XHhb0x5jrPEjC3m-WEaPA/edit?usp=sharing"));
            startActivity(i5);
            return true;
        }
    }
}
