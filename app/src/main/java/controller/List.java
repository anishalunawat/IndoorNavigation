package controller;

/**
 * Created by Piyush on 14-04-2015.
 */
public class List {
    public Point[] point;
    public  Point[] entry() {

        point = new Point[103];
        for(int i=0;i<103;i++)
            point[i]=new Point();
        //ground floor
        point[0].p="Entry"; point[0].x=741;point[0].y=100; point[0].parent="0";point[0].z=0;
        point[1].p="A"; point[1].x=512;point[1].y=120; point[1].parent="0";point[1].z=0;
        point[2].p="B";point[2].x=512;point[2].y=200;point[2].parent="0";point[2].z=0;
        point[3].p="Wash Room 1"; point[3].x=566;point[3].y=250;point[3].parent="0";point[3].z=0;
        point[4].p="Server Room"; point[4].x=566;point[4].y=400;point[4].parent="0";point[4].z=0;
        point[5].p="C";point[5].x=566;point[5].y=431;point[5].parent="0";point[5].z=0;
        point[6].p="Class Room 101";point[6].x=566;point[6].y=633;point[6].parent="0";point[6].z=0;
        point[7].p="Class Room 102";point[7].x=566;point[7].y=925;point[7].parent="0";point[7].z=0;
        point[8].p="Class Room 103";point[8].x=566;point[8].y=1198;point[8].parent="0";point[8].z=0;
        point[9].p="Class Room 104";point[9].x=566;point[9].y=1315;point[9].parent="0";point[9].z=0;
        point[10].p="Class Room 105";point[10].x=566;point[10].y=1440;point[10].parent="0";point[10].z=0;
        point[11].p="D";point[11].x=566;point[11].y=1510;point[11].parent="0";point[11].z=0;
        point[12].p="E";point[12].x=630;point[12].y=1516;point[12].parent="0";point[12].z=0;
        point[13].p="F";point[13].x=630;point[13].y=1622;point[13].parent="0";point[13].z=0;
        point[14].p="G";point[14].x=636;point[14].y=1835;point[14].parent="0";point[14].z=0;
        point[15].p="H";point[15].x=550;point[15].y=1835;point[15].parent="0";point[15].z=0;
        point[16].p="Class Room 106";point[16].x=550;point[16].y=2445;point[16].parent="0";point[16].z=0;
        point[17].p="Class Room 107";point[17].x=550;point[17].y=2644;point[17].parent="0";point[17].z=0;
        point[18].p="Wash Room 2";point[18].x=550;point[18].y=2766;point[18].parent="0";point[18].z=0;
        point[19].p="Class Room 108";point[19].x=550;point[19].y=2874;point[19].parent="0";point[19].z=0;
        point[20].p="Stairs";point[20].x=347;point[20].y=286;point[20].parent="0";point[20].z=0;
        point[21].p="I";point[21].x=190;point[21].y=286;point[21].parent="0";point[21].z=0;
        point[22].p="J";point[22].x=343;point[22].y=2950;point[22].parent="0";point[22].z=0;
        point[23].p="K";point[23].x=200;point[23].y=2950;point[23].parent="0";point[23].z=0;
        point[24].p="Class Room 114";point[24].x=198;point[24].y=2976;point[24].parent="0";point[24].z=0;
        point[25].p="Class Room 113";point[25].x=198;point[25].y=3007;point[25].parent="0";point[25].z=0;
        point[26].p="Class Room 110";point[26].x=198;point[26].y=3007;point[26].parent="0";point[26].z=0;
        point[27].p="Class Room 112";point[27].x=200;point[27].y=3072;point[27].parent="0";point[27].z=0;
        point[28].p="Class Room 109";point[28].x=198;point[28].y=2976;point[28].parent="0";point[28].z=0;
        point[29].p="Class Room 111";point[29].x=200;point[29].y=2883;point[29].parent="0";point[29].z=0;
        point[30].p="L";point[30].x=368;point[30].y=2697;point[30].parent="0";point[30].z=0;
        point[31].p="M";point[31].x=187;point[31].y=2705;point[31].parent="0";point[31].z=0;
        point[32].p="Stairs 1";point[32].x=178;point[32].y=2834;point[32].parent="0";point[32].z=0;
        point[33].p="N";point[33].x=310;point[33].y=2834;point[33].parent="0";point[33].z=0;
        point[34].p="O";point[34].x=366;point[34].y=2434;point[34].parent="0";point[34].z=0;
        point[35].p="P";point[35].x=206;point[35].y=2434;point[35].parent="0";point[35].z=0;
        point[36].p="Class Room 118";point[36].x=206;point[36].y=2456;point[36].parent="0";point[36].z=0;
        point[37].p="Class Room 117";point[37].x=203;point[37].y=2481;point[37].parent="0";point[37].z=0;
        point[38].p="Class Room 124";point[38].x=206;point[38].y=2481;point[38].parent="0";point[38].z=0;
        point[39].p="Class Room 116";point[39].x=206;point[39].y=2581;point[39].parent="0";point[39].z=0;
        point[40].p="Class Room 125";point[40].x=206;point[40].y=2581;point[40].parent="0";point[40].z=0;
        point[41].p="Class Room 115";point[41].x=206;point[41].y=2625;point[41].parent="0";point[41].z=0;
        point[42].p="Class Room 126";point[42].x=206;point[42].y=2625;point[42].parent="0";point[42].z=0;
        point[43].p="Class Room 119";point[43].x=206;point[43].y=2356;point[43].parent="0";point[36].z=0;
        point[44].p="Class Room 123";point[44].x=206;point[44].y=2356;point[44].parent="0";point[44].z=0;
        point[45].p="Class Room 120";point[45].x=206;point[45].y=2326;point[45].parent="0";point[45].z=0;
        point[46].p="Class Room 121";point[46].x=206;point[46].y=2226;point[46].parent="0";point[46].z=0;
        point[47].p="Class Room 128";point[47].x=206;point[47].y=2116;point[47].parent="0";point[47].z=0;
        point[48].p="Administration";point[48].x=206;point[48].y=2116;point[48].parent="0";point[48].z=0;
        point[49].p="Reception";point[49].x=188;point[49].y=1682;point[49].parent="0";point[49].z=0;
        point[50].p="Class Room 129";point[50].x=141;point[50].y=1449;point[50].parent="0";point[50].z=0;
        point[51].p="Class Room 130";point[51].x=206;point[51].y=1449;point[51].parent="0";point[51].z=0;
        point[52].p="Class Room 131";point[52].x=206;point[52].y=1455;point[52].parent="0";point[52].z=0;
        point[53].p="Near Reception";point[53].x=183;point[53].y=1866;point[53].parent="0";point[53].z=0;
        point[54].p="Q";point[54].x=374;point[54].y=1856;point[54].parent="0";point[54].z=0;
        point[55].p="R";point[55].x=374;point[55].y=1477;point[55].parent="0";point[55].z=0;
        point[56].p="Class Room 132";point[56].x=360;point[56].y=1224;point[56].parent="0";point[56].z=0;
        point[57].p="Class Room 133";point[57].x=360;point[57].y=952;point[57].parent="0";point[57].z=0;
        point[58].p="Class Room 134";point[58].x=360;point[58].y=673;point[58].parent="0";point[58].z=0;
        point[59].p="Class Room 135";point[59].x=360;point[59].y=447;point[59].parent="0";point[59].z=0;
        point[60].p="Class Room 122";point[60].x=206;point[60].y=2226;point[60].parent="0";point[60].z=0;

//
//
//
//
//
//
//
//
//        //first floor
        point[60].p="Stairs2";point[60].x=53;point[60].y=73;point[60].parent="0";point[60].z=1;
        point[61].p="o";point[61].x=109;point[61].y=71;point[61].parent="0";point[61].z=1;
        point[62].p="Class Room 230";point[62].x=111;point[62].y=144;point[62].parent="0";point[62].z=1;
        point[63].p="Class Room 229";point[63].x=111;point[63].y=215;point[63].parent="0";point[63].z=1;
        point[64].p="Class Room 228";point[64].x=111;point[64].y=302;point[64].parent="0";point[64].z=1;
        point[65].p="Class Room 227";point[65].x=111;point[65].y=388;point[65].parent="0";point[65].z=1;
        point[66].p="Class Room 226";point[66].x=111;point[66].y=413;point[66].parent="0";point[66].z=1;
        point[67].p="Class Room 225";point[67].x=37;point[67].y=461;point[67].parent="0";point[67].z=1;
        point[68].p="p";point[68].x=119;point[68].y=461;point[68].parent="0";point[68].z=1;
        point[69].p="Library";point[69].x=155;point[69].y=461;point[69].parent="0";point[69].z=1;
        point[70].p="q";point[70].x=196;point[70].y=482;point[70].parent="0";point[70].z=1;
        point[71].p="Room 202";point[71].x=204;point[71].y=531;point[71].parent="0";point[71].z=1;
        point[72].p="r";point[72].x=191;point[72].y=581;point[72].parent="0";point[72].z=1;
        point[73].p="S";point[73].x=125;point[73].y=585;point[73].parent="0";point[73].z=1;
        point[74].p="Data Center";point[74].x=174;point[74].y=602;point[74].parent="0";point[74].z=1;
        point[75].p="Class Room 204";point[75].x=174;point[75].y=656;point[75].parent="0";point[75].z=1;
        point[76].p="Class Room 205";point[76].x=181;point[76].y=925;point[76].parent="0";point[76].z=1;
        point[77].p="Class Room 206";point[77].x=183;point[77].y=935;point[77].parent="0";point[77].z=1;
        point[78].p="Class Room 207";point[78].x=171;point[78].y=933;point[78].parent="0";point[78].z=1;
        point[79].p="Class Room 208";point[79].x=144;point[79].y=933;point[79].parent="0";point[79].z=1;
        point[80].p="Class Room 209";point[80].x=133;point[80].y=933;point[80].parent="0";point[80].z=1;
        point[81].p="Class Room 210";point[81].x=104;point[81].y=933;point[81].parent="0";point[81].z=1;
        point[82].p="Class Room 213";point[82].x=133;point[82].y=933;point[82].parent="0";point[82].z=1;
        point[83].p="Class Room 211";point[83].x=81;point[83].y=933;point[83].parent="0";point[83].z=1;
        point[84].p="Class Room 212 D";point[84].x=81;point[84].y=933;point[84].parent="0";point[84].z=1;
        point[85].p="Class Room 212 A";point[85].x=65;point[85].y=933;point[85].parent="0";point[85].z=1;
        point[86].p="Class Room 212";point[86].x=66;point[86].y=950;point[86].parent="0";point[86].z=1;
        point[87].p="Class Room 212 B";point[87].x=67;point[87].y=925;point[87].parent="0";point[87].z=1;
        point[88].p="Class Room 212 C";point[88].x=65;point[88].y=902;point[88].parent="0";point[88].z=1;
        point[89].p="T";point[89].x=121;point[89].y=734;point[89].parent="0";point[89].z=1;
        point[90].p="U";point[90].x=70;point[90].y=732;point[90].parent="0";point[90].z=1;
        point[91].p="Class Room 219";point[91].x=72;point[91].y=748;point[91].parent="0";point[91].z=1;
        point[92].p="Class Room 214";point[92].x=72;point[92].y=748;point[92].parent="0";point[92].z=1;
        point[93].p="Class Room 218";point[93].x=71;point[93].y=776;point[93].parent="0";point[93].z=1;
        point[94].p="Class Room 215";point[94].x=71;point[94].y=776;point[94].parent="0";point[94].z=1;
        point[95].p="Class Room 217";point[95].x=73;point[95].y=817;point[95].parent="0";point[95].z=1;
        point[96].p="Class Room 216";point[96].x=73;point[96].y=817;point[96].parent="0";point[96].z=1;
        point[97].p="Class Room 220";point[97].x=72;point[97].y=714;point[97].parent="0";point[97].z=1;
        point[98].p="Class Room 224";point[98].x=72;point[98].y=714;point[98].parent="0";point[98].z=1;
        point[99].p="Class Room 221";point[99].x=72;point[99].y=685;point[99].parent="0";point[99].z=1;
        point[100].p="Class Room 223";point[100].x=72;point[100].y=685;point[100].parent="0";point[100].z=1;
        point[101].p="Class Room 216";point[101].x=70;point[101].y=641;point[101].parent="0";point[101].z=1;
        point[102].p="Class Room 222";point[102].x=70;point[102].y=600;point[102].parent="0";point[102].z=1;






        return point;
    }


    public String[][] addAdjList() {
        String[][] adjlist = new String[][]{{"Entry","A"},//1
                {"A","Entry","B"},//2
                {"B","A","Wash Room 1","Server Room","Stairs","Class Room 135"},//3
                {"Wash Room 1","B","Server Room"},//4
                {"Server Room","B","Wash Room 1","C"},//5
                {"C","Server Room","Class Room 101"},                                                      //6
                {"Class Room 101","Class Room 102","C"},                                                    //7
                {"Class Room 102","Class Room 101","Class Room 103"},                                       //8
                {"Class Room 103","Class Room 102","Class Room 104"},                                       //9
                {"Class Room 104","Class Room 103","Class Room 105"},                                   //10
                {"Class Room 105","Class Room 104","D"},//11
                {"D","Class Room 105","E"},//12
                {"E","D","F"},//13
                {"F","E","G"},//14
                {"G","F","H"},//15
                {"H","G","Class Room 106"},//16
                {"Class Room 106","H","Class Room 107"},//17
                {"Class Room 107","Class Room 106","Wash Room 2"},//18
                {"Wash Room 2","Class Room 107","Class Room 108"},//19
                {"Class Room 108","Wash Room 2","J"},//20
                {"J","Class Room 108","K","L"},//21
                {"Stairs","B","I","Class Room 135"},//22
                {"K","J","Class Room 114","Class Room 113","Class Room 110","Class Room 111"},//23
                {"Class Room 111","K"},//24
                {"Class Room 114","Class Room 113","Class Room 110","K"},//25
                {"Class Room 113","Class Room 110","Class Room 114","Class Room 109","Class Room 112"},//26
                {"Class Room 110","Class Room 113","Class Room 114","Class Room 112","Class Room 109"},//27
                {"Class Room 109","Class Room 110","Class Room 112","Class Room 113"},//28
                {"Class Room 112","Class Room 109","Class Room 110","Class Room 113"},//29
                {"L","J","M","O"},//30
                {"M","L","N"},//31
                {"N","Stairs 1"},//32
                {"Stairs 1","N"},//33
                {"O","P","L","Recpt P1"},//34
                {"P","O","Class Room 118","Class Room 117","Class Room 124","Class Room 123","Class Room 119"},//35
                {"Class Room 118","P","Class Room 117","Class Room 124","Class Room 123","Class Room 119"},//36
                {"Class Room 117","Class Room 118","Class Room 124","Class Room 116","Class Room 125"},//37
                {"Class Room 124","Class Room 117","Class Room 118","Class Room 116","Class Room 125"},//38
                {"Class Room 116","Class Room 115","Class Room 117","Class Room 124","Class Room 125","Class Room 126"},//39
                {"Class Room 125","Class Room 115","Class Room 117","Class Room 124","Class Room 116","Class Room 126"},//40
                {"Class Room 115","Class Room 116","Class Room 126","Class Room 125"},//41
                {"Class Room 126","Class Room 116","Class Room 115","Class Room 125"},//42
                {"Class Room 119","Class Room 118","Class Room 120","Class Room 123"},//43
                {"Class Room 123","Class Room 119","Class Room 120","Class Room 121","Class Room 122"},//44
                {"Class Room 120","Class Room 121","Class Room 122","Class Room 123","Class Room 119"},//45
                {"Class Room 122","Class Room 128","Administration","Class Room 121","Class Room 123","Class Room 120"},//46
                {"Class Room 121","Class Room 122","Class Room 128","Administration"},//47
                {"Administration","Class Room 121","Class Room 122","Class Room 128","Near Reception"},//48
                {"Class Room 128","Administration","Class Room 121","Class Room 122","Near Reception"},//49
                {"Near Reception","Reception","Administration","Q","Class Room 128"},//50
                {"Reception","Class Room 129","Class Room 130","Class Room 131","R"},//51
                {"Q","R","O","Near Reception"},//52
                {"R","Class Room 131","Class Room 132","Q"},//53
                {"Class Room 129","Reception","Class Room 130"},//54
                {"Class Room 130","R","Class Room 129"},//55
                {"Class Room 131","R","Class Room 130","Reception"},//56
                {"Class Room 132","R","Class Room 133"},//57
                {"Class Room 133","Class Room 132","Class Room 134"},//58
                {"Class Room 134","Class Room 133","Class Room 135"},//59
                {"Class Room 135","Class Room 134","Stairs"},//60
                {"I","Stairs","Stairs2"},//61
                {"Stairs2","Stairs","o","I"},//62
                {"o","Stairs2","Class Room 230"},//63
                {"Class Room 230","Class Room 229","Stairs2"},//64
                {"Class Room 229","Class Room 228","Class Room 230"},//65
                {"Class Room 228","Class Room 227", "Class Room 229"},//66
                {"Class Room 227","p","Class Room 228"},//67
                {"p", "Class Room 226", "Library","Class Room 227","S"},//67
                {"Class Room 226","Class Room 225","Class Room 227"},//68
                {"Class Room 225","Class Room 226"},//69
                {"Library","p","q"},//70
                {"q","Library","Class Room 202"},//71
                {"Class Room 202","r","q"},//72
                {"r","S","Data Center","Class Room 202"},//73
                {"S", "Data Center", "p","T"},//74
                {"Data Center", "Class Room 204","r","S"},//75
                {"Class Room 204","Data Center","Class Room 205"},//76
                {"Class Room 205", "Class Room 206","Class Room 204"},//77
                {"Class Room 206","Class Room 205", "Class Room 207"},//78
                {"Class Room 207","Class Room 208", "Class Room 206"},//79
                {"Class Room 208", "Class Room 209","Class Room 207"},//80
                {"Class Room 209","Class Room 210","Class Room 213","Class Room 208","T"},//81
                {"Class Room 210","Class Room 213","Class Room 211","Class Room 212 D","Class Room 209"},//82
                {"Class Room 213","Class Room 210","Class Room 211","Class Room 212 D","Class Room 209"},//83
                {"Class Room 211","Class Room 213", "Class Room 210","Class Room 212 D","Class Room 212 A","Class Room 212 B"},//84
                {"Class Room 212 D","Class Room 211","Class Room 213", "Class Room 210","Class Room 212 A","Class Room 212 B"},//85
                {"Class Room 212 A","Class Room 212 B","Class Room 211", "Class Room 212 D","Class Room 212"},//86
                {"Class Room 212", "Class Room 212 A"},//87
                {"Class Room 212 B","Class Room 212 A","Class Room 211", "Class Room 212 D","Class Room 212 C"},//88
                {"Class Room 212 C", "Class Room 212 B"},//89
                {"T","Class Room 209", "S","U"},//90
                {"U","T","Class Room 220","Class Room 224","Class Room 219","Class Room 214"},//91
                {"Class Room 219","U","Class Room 214","Class Room 215", "Class Room 218"},//92
                {"Class Room 214","Class Room 220","T","Class Room 215", "Class Room 218"},//93
                {"Class Room 218","Class Room 217", "Class Room 216","Class Room 215","Class Room 219","Class Room 214"},//94
                {"Class Room 215","Class Room 217", "Class Room 216","Class Room 218","Class Room 219","Class Room 214"},//95
                {"Class Room 220", "U","Class Room 224","Class Room 223", "Class Room 221"},//96
                {"Class Room 224", "U","Class Room 220","Class Room 223", "Class Room 221"},//97
                {"Class Room 223", "Class Room 224", "Class Room 222", "Class Room 220", "Class Room 221"},//98
                {"Class Room 221", "Class Room 224", "Class Room 222", "Class Room 220", "Class Room 223"},//99
                {"Class Room 222","Class Room 221", "Class Room 223"},//100+1
                {"Class Room 217","Class Room 216","Class Room 215","Class Room 218"},
                {"Class Room 216","Class Room 215","Class Room 217","Class Room 218"}
        };
        return adjlist;

    }
}
