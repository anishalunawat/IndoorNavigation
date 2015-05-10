package controller;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.util.Log;

import com.example.piyush.indoornevigateion.view.MainActivity;
import com.example.piyush.indoornevigateion.view.MapView;

import java.util.ArrayList;
import java.util.List;



public class WifiFinder {

    int num[]=new int[3],n;
    String s,wifi[]={"00:3a:98:b9:94:60" /*0*/
            ,"00:3a:98:a8:fe:30"    /*1*/
            ,"00:3a:98:9c:83:40"    /*2*/
            ,"a0:d3:c1:b4:7e:d0"    /*3*/
            ,"02:0f:02:5d:d1:40"    /*4*/
            ,"00:3a:98:aa:0c:b0"    /*5*/
            ,"a0:d3:c1:b4:ce:b0"    /*6*/
            ,"a0:d3:c1:b4:de:92"    /*7*/
            ,"a0:d3:c1:b4:de:82"    /*8*/
            ,"a0:d3:c1:b4:de:80"    /*9*/
            ,"00:ba:98:a7:eb:e0"    /*10*/
            ,"00:3a:98:a3:b6:a0"    /*11*/
            ,"1c:aa:07:ed:6f:48"    /*12*/
            ,"00:3a:98:b9:b3:40"    /*13*/
            ,"00:3a:98:b9:8f:f0"    /*14*/
            ,"00:3a:98:b9:bd:60"    /*15*/
            ,"00:3a:98:9d:7f:b0"    /*16*/
            ,"00:24:73:4a:57:40"    /*17*/
            ,"a0:d3:c1:b4:7e:d1"    /*18*/
            ,"00:3a:98:a8:f9:c0"    /*19*/
            ,"00:3a:98:a9:27:30"    /*20*/
            ,"4c:4e:35:56:f1:6d"    /*21*/
            ,"a0:d3:c1:b4:9e:70"    /*22*/
            ,"00:3a:98:a9:1d:10"    /*23*/
            ,"00:3a:98:9e:8e:50"    /*24*/
            ,"a0:d3:c1:b4:7e:d1"    /*25*/
            ,"90:d3:c1:b4:fe:90"    /*26*/
            ,"a0:d3:c1:b4:ce:e0"    /*27*/
            ,"4c:60:de:fe:73:ca"    /*28*/
            ,"00:3a:98:ad:82:a0"    /*29*/
            ,"a0:b3:c1:b4:9e:70"    /*30*/
            ,"a0:d3:c1:b4:de:91"    /*31*/
            ,"a0:d3:c1:b4:de:81"    /*32*/
            ,"a0:d3:c1:b4:de:90"    /*31*/
            ,"a0:d3:c1:b4:9e:71"    /*32*/
            ,"a0:d3:c1:b4:ce:b1"    /*33*/
            ,"a0:d3:c1:b4:ce:e1"    /*34*/
            ,"a0:d3:c1:b4:ee:21"    /*35*/
            ,"a0:d3:c1:b4:ce:fo"    /*36*/
            ,"00:3a:98:b9:94:60"    /*37*/
            ,"a0:d3:c1:b4:ce:f1"    /*38*/
            ,"a0:d3:c1:b4:7e:d0"    /*39*/
            ,"a0:d3:c1:b4:ae:c1"    /*40*/
            ,"a0:d3:c1:b4:ce:a0"    /*41*/
            ,"00:3a:98:b9:a1:80"    /*42*/
            ,"30:46:9a:a3:64:5c"    /*43*/
            ,"00:3a:98:9a:88:90"    /*44*/
            ,"00:3a:98:ad:82:a0"    /*45*/
            };

    public static WifiManager wifiManager;
    private List<ScanResult> apList;
    String apSelectList;

    private String Bmob_AppId = "1b31c55348aeab1a15e5263e668fb88a";

//    @Override
//   protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        n=wifi.length;
//
//        scanAPBtn = (Button) findViewById(R.id.scanAPBtn);
//        apScanTv = (TextView) findViewById(R.id.apTv);
//        apSelectTv = (TextView) findViewById(R.id.apSelectTv);
//       wifiManager = (WifiManager) getSystemService(Service.WIFI_SERVICE);
//        point=(TextView)findViewById(R.id.point);
//        scanAPBtn.setOnClickListener(this);
//
//
//
//
//    }

//    @Override
//    public void onClick(View v) {
//        if (v.getId() == R.id.scanAPBtn) {
    public String getPosition(MainActivity m) {


        if (m.wifiManager.getWifiState() == WifiManager.WIFI_STATE_ENABLED) {


            List<ScanResult>apList = getSortList(m.wifiManager.getScanResults());


            apSelectList = getApSelectList(apList);
           return apSelectList;
        }
        return "none";
}
//    }

    public String getPosition(MapView m) {


        if (m.wifiManager.getWifiState() == WifiManager.WIFI_STATE_ENABLED) {


            List<ScanResult>apList = getSortList(m.wifiManager.getScanResults());


            apSelectList = getApSelectList(apList);
            return apSelectList;
        }
        return "none";
    }
//






        private List<ScanResult> getSortList (List < ScanResult > list) {
            List<ScanResult> sortList = new ArrayList<ScanResult>();
            ScanResult[] scanResults = new ScanResult[list.size()];
            list.toArray(scanResults);
            ScanResult temp;
            for (int i = 0; i < scanResults.length - 1; i++) {
                for (int j = i + 1; j < scanResults.length; j++) {
                    if (scanResults[i].level < scanResults[j].level) {
                        temp = scanResults[j];
                        scanResults[j] = scanResults[i];
                        scanResults[i] = temp;
                    }
                }
            }
            for (int i = 0; i < scanResults.length; i++) {
                sortList.add(scanResults[i]);
            }
            return sortList;
        }

        private String getApSelectList (List < ScanResult > list) {
//            List<ScanResult> selectList = new ArrayList<ScanResult>();
           List<ScanResult> iterator = list;
            int l = 0, k = 3;

            n= wifi.length;
            int strength = 0, strength1 = 0;
            for (int i = 0; i < k; i++) {
                int j;
                //Log.e("Wifi Finder",String.valueOf(iterator.size()));
                if (iterator.size()>i) {
                    ScanResult b = iterator.get(i);
                    s = b.BSSID;
                    Log.e("wifi finder","hello"+ s);

//                    selectList.add(b);
                    Log.e("Wifi FInder","size of wifi is  "+n);
                    for (j = 0; j < n; j++) {
                        Log.e("Wifi FInder","size of wifi is  "+n);
                        if (wifi[j].equalsIgnoreCase(s)) {
                            Log.e("main Activity", String.valueOf(l) + "   n = " + String.valueOf(n) + "   length = " + wifi.length);
                            if (num[0] == 28 || num[1] == 28 || num[2] == 28 || num[0] == 7 || num[1] == 7 || num[2] == 7 || num[0] == 0 || num[1] == 0 || num[2] == 0 || num[0] == 5 || num[0] == 29 || num[1] == 29 || num[2] == 29 || num[1] == 5 || num[2] == 5 || num[0] == 14 || num[1] == 14 || num[2] == 14) {
                                strength = b.level;
                                Log.e("wifi finder","hello strength is strength  "+ strength1);
                            }
                            if (num[0] == 44 || num[1] == 44 || num[2] == 44 || num[0] == 14 || num[1] == 14 || num[2] == 14 || num[0] == 32 || num[1] == 32 || num[2] == 32 || num[0] == 22 || num[1] == 22 || num[2] == 22 || num[0] == 32 || num[1] == 32 || num[2] == 32 || num[0] == 19 || num[1] == 19 || num[2] == 19) {
                                strength1 = b.level;
                                Log.e("wifi finder","hello strength is  "+ strength1);
                            }
                            num[l] = j;
                            l++;
                            break;
                        }

                    }
//                    if (j == n) {
//                        k++;
//                    }
                }

            }

//            if (((num[0] == 7 || num[1] == 7 || num[2] == 7) && (strength < -67 && strength > -71)) || ((num[0] == 32 || num[1] == 32 || num[2] == 32) && (strength1 < -67 && strength1 > -71))) {
//               return("Class Room 108");
//            } else if (((num[0] == 0 || num[1] == 0 || num[2] == 0) && (strength < -60 && strength > -78)) || ((num[0] == 22 || num[1] == 22 || num[2] == 22) && (strength1 < -64 && strength1 > -78)) || (num[2] == 32)) {
//                return ("Class Room 106");
//            } else if ((num[0] == 5 || num[1] == 5 || num[2] == 5) && (strength < -60 && strength > -78)) {
//               return ("faculty");
//            } else
            if ((num[0] == 23 || num[1] == 23 || num[2] == 23) || (num[0] == 11 || num[1] == 11 || num[2] == 11) || (num[0] == 13 || num[1] == 13 || num[2] == 13)) {
               return ("Reception");
            } else if (((num[0] == 28 || num[1] == 28 || num[2] == 28) && (strength < -64 && strength > -76)) || ((num[0] == 14 || num[1] == 14 || num[2] == 14) && (strength1 < -59 && strength1 > -82))) {
                return ("Class Room 101");
            } else if (((num[0] == 14 || num[1] == 14 || num[2] == 14) && (strength < -55 && strength > -66)) || ((num[0] == 19 || num[1] == 19 || num[2] == 19) && (strength1 < -65 && strength1 > -80))) {
                return ("Class Room 103");
            } else if (((num[0] == 28 || num[1] == 28 || num[2] == 28)) || ((num[0] == 44 || num[1] == 44 || num[2] == 44) && (strength1 < -75 && strength1 > -78))) {
               return ("Entry");
            } else if (((num[0] == 14 || num[1] == 14 || num[2] == 14) && (strength < -65 && strength > -77)) || ((num[0] == 19 || num[1] == 19 || num[2] == 19) && (strength1 < -65 && strength1 > -70))) {
                return ("Class Room 132");
            } else if (((num[0] == 29 || num[1] == 29 || num[2] == 29) && (strength < -57 && strength > -76)) || ((num[0] == 44 || num[1] == 44 || num[2] == 44) && (strength1 < -79 && strength1 > -83))) {
                return ("Class Romm 134");
            }


            return "none";
        }

}