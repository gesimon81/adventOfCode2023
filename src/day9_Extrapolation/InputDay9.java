package day9_Extrapolation;

public class InputDay9 {
	public static final String INPUT_DAY9_TEST = 
			  "0 3 6 9 12 15\r\n"
			+ "1 3 6 10 15 21\r\n"
			+ "10 13 16 21 30 45";
	
	public static final String INPUT_DAY9 = 
			"0 4 12 24 40 60 84 112 144 180 220 264 312 364 420 480 544 612 684 760 840\r\n"
			+ "-7 -6 -4 -9 -35 -97 -191 -246 -18 1130 4645 13492 33206 73178 147656 275084 472783 741142 1026794 1146833 644835\r\n"
			+ "9 26 43 55 64 84 151 349 869 2131 5030 11432 25171 54036 113717 235730 483765 988508 2023553 4171877 8686902\r\n"
			+ "5 1 -3 -11 -29 -65 -131 -235 -344 -296 360 2612 8328 20688 44682 87630 159655 274011 447135 698255 1048345\r\n"
			+ "9 8 7 6 5 4 3 2 1 0 -1 -2 -3 -4 -5 -6 -7 -8 -9 -10 -11\r\n"
			+ "17 15 17 31 75 193 478 1098 2316 4488 8014 13206 20019 27555 33193 31168 10612 -45996 -160136 -339076 -513992\r\n"
			+ "7 13 22 40 70 117 216 496 1293 3325 7942 17464 35620 68101 123240 212832 353107 565869 879814 1332040 1969762\r\n"
			+ "2 6 18 38 66 102 146 198 258 326 402 486 578 678 786 902 1026 1158 1298 1446 1602\r\n"
			+ "14 24 44 94 201 403 760 1387 2543 4833 9607 19671 40460 81862 160925 305726 560732 994038 1706926 2846252 4620235\r\n"
			+ "1 10 39 97 196 356 617 1068 1914 3629 7307 15465 33852 75432 168942 376878 832608 1815805 3903720 8270454 17270193\r\n"
			+ "5 19 42 72 107 145 184 222 257 287 310 324 327 317 292 250 189 107 2 -128 -285\r\n"
			+ "12 15 30 80 202 462 987 2022 4016 7742 14486 26437 47626 86163 159187 302969 592100 1173777 2326006 4552222 8729546\r\n"
			+ "14 23 32 41 50 59 68 77 86 95 104 113 122 131 140 149 158 167 176 185 194\r\n"
			+ "-1 9 33 70 119 179 249 328 415 509 609 714 823 935 1049 1164 1279 1393 1505 1614 1719\r\n"
			+ "4 6 14 28 58 143 389 1043 2624 6131 13339 27174 52124 94592 163026 267567 418836 625332 888732 1196168 1508302\r\n"
			+ "4 2 5 30 104 265 572 1144 2260 4566 9450 19661 40262 80019 153337 282859 502844 863434 1435907 2318992 3646292\r\n"
			+ "-9 -13 -17 -21 -25 -29 -33 -37 -41 -45 -49 -53 -57 -61 -65 -69 -73 -77 -81 -85 -89\r\n"
			+ "12 24 36 57 124 313 761 1720 3676 7579 15237 29914 57115 105401 186792 315795 505227 755716 1034175 1235335 1121613\r\n"
			+ "22 47 82 126 192 314 558 1044 1987 3776 7139 13492 25641 49104 94473 181517 346284 653553 1219032 2249318 4113718\r\n"
			+ "18 20 30 55 104 192 355 687 1423 3123 7081 16225 37039 83491 184672 398935 838880 1713686 3398184 6541851 12235754\r\n"
			+ "15 30 70 156 328 658 1265 2333 4140 7133 12148 21006 37974 73064 149014 315318 675348 1437546 3011453 6189930 12503151\r\n"
			+ "4 5 5 15 56 174 471 1164 2702 6002 12909 27044 55299 110446 215853 414613 788476 1498775 2875725 5610685 11159750\r\n"
			+ "8 31 70 134 239 409 677 1086 1690 2555 3760 5398 7577 10421 14071 18686 24444 31543 40202 50662 63187\r\n"
			+ "9 25 66 144 277 492 830 1361 2218 3660 6175 10635 18516 32197 55353 93458 154415 249331 393456 607306 917991\r\n"
			+ "22 42 84 167 321 606 1139 2133 3968 7350 13683 25901 50230 99787 201801 411958 842563 1716835 3471119 6942204 13701436\r\n"
			+ "28 57 102 176 309 563 1070 2107 4222 8425 16458 31158 56927 100323 170786 281513 450496 701737 1066654 1585692 2310153\r\n"
			+ "20 21 22 25 38 81 184 375 654 956 1141 1146 1664 6232 26744 96835 302631 850462 2210531 5411258 12622253\r\n"
			+ "7 19 43 93 185 331 526 720 761 301 -1297 -4889 -10900 -17197 -13690 29843 189479 639343 1754419 4307877 9840271\r\n"
			+ "4 1 -1 -6 -12 -4 62 297 952 2539 6013 13028 26280 49950 90260 156155 260124 419173 655963 1000126 1489772\r\n"
			+ "18 22 27 41 78 158 304 537 876 1361 2133 3626 6952 14591 31534 67068 137438 269672 506911 915647 1595338\r\n"
			+ "19 23 35 67 133 245 402 568 640 430 -263 -1323 -1418 3984 26478 91620 250473 597977 1300999 2639727 5067019\r\n"
			+ "20 35 65 131 269 545 1086 2140 4182 8087 15395 28697 52175 92333 158960 266370 434968 693195 1079909 1647263 2464145\r\n"
			+ "3 15 44 98 185 326 581 1095 2190 4561 9679 20562 43146 88572 176802 342087 640933 1163347 2048294 3504458 5837575\r\n"
			+ "1 3 3 16 84 288 760 1695 3363 6121 10425 16842 26062 38910 56358 79537 109749 148479 197407 258420 333624\r\n"
			+ "8 35 89 185 353 666 1283 2507 4858 9161 16649 29081 48875 79256 124419 189707 281804 408943 581129 810377 1110965\r\n"
			+ "23 37 51 65 79 93 107 121 135 149 163 177 191 205 219 233 247 261 275 289 303\r\n"
			+ "9 26 71 159 305 524 831 1241 1769 2430 3239 4211 5361 6704 8255 10029 12041 14306 16839 19655 22769\r\n"
			+ "16 33 71 137 231 339 428 457 434 568 1584 5298 15624 40381 94712 207811 436248 889847 1780273 3508803 6818905\r\n"
			+ "9 9 17 48 129 315 723 1606 3508 7571 16117 33726 69225 139390 275916 538615 1040303 1993089 3792709 7168424 13442509\r\n"
			+ "16 27 46 96 221 496 1037 2011 3646 6241 10176 15922 24051 35246 50311 70181 95932 128791 170146 221556 284761\r\n"
			+ "5 24 63 139 276 511 910 1594 2775 4802 8217 13821 22750 36561 57328 87748 131257 192156 275747 388479 538104\r\n"
			+ "9 9 16 51 157 408 928 1925 3752 7036 12991 24198 46470 93037 193345 410478 873859 1837811 3782186 7579109 14760539\r\n"
			+ "10 23 45 91 186 361 646 1072 1718 2876 5475 12045 28789 69888 166179 382092 847590 1816341 3768141 7583575 14833152\r\n"
			+ "12 15 34 95 235 512 1036 2038 3998 7856 15338 29449 55222 100866 179519 311865 529884 881921 1439014 2301919 3607393\r\n"
			+ "3 15 37 70 123 224 429 829 1555 2781 4725 7648 11851 17670 25469 35631 48547 64603 84165 107562 135067\r\n"
			+ "8 29 64 113 178 283 514 1087 2460 5524 11951 24866 50179 99212 193756 375492 722940 1380935 2610294 4869119 8942436\r\n"
			+ "18 28 43 64 106 222 550 1407 3473 8127 18015 37964 76465 148273 279508 518581 960498 1800964 3454785 6808934 13749834\r\n"
			+ "17 26 46 78 114 133 97 -53 -401 -1060 -2176 -3932 -6552 -10305 -15509 -22535 -31811 -43826 -59134 -78358 -102194\r\n"
			+ "10 27 56 101 172 303 585 1221 2626 5624 11833 24382 49201 97351 189395 363975 695078 1326741 2541306 4889375 9428454\r\n"
			+ "12 24 53 125 287 617 1234 2308 4070 6822 10947 16919 25313 36815 52232 72502 98704 132068 173985 226017 289907\r\n"
			+ "6 23 62 150 325 632 1115 1810 2752 4017 5828 8762 14103 24394 44249 81494 148714 265291 460026 774446 1266905\r\n"
			+ "0 8 32 76 151 293 601 1308 2912 6429 13890 29294 60369 121751 240745 468071 898672 1713090 3260268 6221284 11925491\r\n"
			+ "6 19 44 88 161 289 545 1107 2348 4965 10179 20112 38616 73180 139233 269466 533150 1074491 2185794 4441940 8939215\r\n"
			+ "14 32 55 89 149 259 452 770 1264 1994 3029 4447 6335 8789 11914 15824 20642 26500 33539 41909 51769\r\n"
			+ "10 39 92 194 385 720 1269 2117 3364 5125 7530 10724 14867 20134 26715 34815 44654 56467 70504 87030 106325\r\n"
			+ "20 38 63 96 157 298 616 1266 2474 4550 7901 13044 20619 31402 46318 66454 93072 127622 171755 227336 296457\r\n"
			+ "17 31 62 131 280 579 1136 2118 3793 6614 11402 19765 35038 64290 122437 240554 482932 983212 2023133 4206066 8836323\r\n"
			+ "8 12 27 54 90 132 196 370 939 2648 7214 18276 43102 95574 201284 406127 791003 1498336 2783948 5126512 9468339\r\n"
			+ "28 51 82 121 168 223 286 357 436 523 618 721 832 951 1078 1213 1356 1507 1666 1833 2008\r\n"
			+ "8 28 53 83 116 140 122 4 -271 -661 -786 555 6249 22283 59905 138820 292022 573758 1074275 1949579 3483298\r\n"
			+ "4 -3 -10 -5 37 152 382 782 1468 2750 5410 11202 23669 49391 99798 193703 360732 645851 1115214 1863581 3023581\r\n"
			+ "24 44 84 162 305 563 1046 1992 3874 7559 14542 27298 49847 88770 155290 269983 474023 856431 1619479 3231867 6775748\r\n"
			+ "10 36 87 171 292 450 641 857 1086 1312 1515 1671 1752 1726 1557 1205 626 -228 -1409 -2973 -4980\r\n"
			+ "-5 -6 -5 12 68 196 456 985 2100 4469 9343 18789 35761 63669 104826 156736 204593 207548 75219 -370486 -1454950\r\n"
			+ "11 34 75 141 239 376 559 795 1091 1454 1891 2409 3015 3716 4519 5431 6459 7610 8891 10309 11871\r\n"
			+ "0 2 4 6 8 10 12 14 16 18 20 22 24 26 28 30 32 34 36 38 40\r\n"
			+ "7 28 61 124 254 511 982 1785 3073 5038 7915 11986 17584 25097 34972 47719 63915 84208 109321 140056 177298\r\n"
			+ "5 17 39 84 191 443 994 2113 4258 8205 15288 27879 50384 91301 167378 311845 590547 1133497 2196553 4281370 8365869\r\n"
			+ "18 48 92 163 286 506 901 1595 2766 4644 7494 11579 17098 24094 32327 41107 49082 53976 52272 38835 6470\r\n"
			+ "0 7 27 68 140 260 474 903 1824 3809 7967 16368 32776 63882 121310 224771 406864 720171 1247467 2116068 3517572\r\n"
			+ "4 22 55 105 174 264 377 515 680 874 1099 1357 1650 1980 2349 2759 3212 3710 4255 4849 5494\r\n"
			+ "17 23 37 65 117 212 400 817 1788 3987 8664 17982 35624 68152 128400 244019 478203 977431 2075879 4513391 9873183\r\n"
			+ "14 29 49 88 185 414 906 1904 3894 7898 16093 33065 68281 140870 288708 585336 1170726 2305775 4466201 8499930 15883953\r\n"
			+ "7 33 78 162 317 598 1104 2000 3530 6023 9936 16089 26501 46753 91758 198441 451413 1031601 2303346 4963092 10282833\r\n"
			+ "6 9 9 12 30 81 189 384 702 1185 1881 2844 4134 5817 7965 10656 13974 18009 22857 28620 35406\r\n"
			+ "1 4 27 82 181 336 559 862 1257 1756 2371 3114 3997 5032 6231 7606 9169 10932 12907 15106 17541\r\n"
			+ "20 32 43 55 79 149 351 876 2111 4787 10208 20590 39544 72742 128810 220497 366174 591722 932873 1438073 2171941\r\n"
			+ "27 48 83 145 251 416 638 867 961 654 -398 -2354 -4437 -3166 11515 64575 214023 590842 1487409 3552077 8210955\r\n"
			+ "1 18 51 115 241 487 958 1835 3413 6148 10713 18063 29509 46801 72220 108679 159833 230198 325279 451707 617385\r\n"
			+ "12 24 45 83 156 309 643 1356 2805 5614 10878 20564 38339 71385 134554 259991 519075 1070899 2265416 4854588 10409155\r\n"
			+ "11 30 69 148 297 564 1045 1956 3782 7556 15344 31052 61765 120065 228336 427270 793142 1472619 2750732 5177929 9796126\r\n"
			+ "19 43 85 160 301 579 1144 2296 4608 9157 17985 35023 67883 131190 252578 483334 917448 1726590 3226456 6006185 11184868\r\n"
			+ "0 2 16 47 102 190 317 477 638 718 552 -109 -1408 -2552 775 23343 107323 361097 1043615 2739838 6711885\r\n"
			+ "8 19 30 41 52 63 74 85 96 107 118 129 140 151 162 173 184 195 206 217 228\r\n"
			+ "21 29 29 30 55 141 339 714 1345 2325 3761 5774 8499 12085 16695 22506 29709 38509 49125 61790 76751\r\n"
			+ "15 35 68 129 242 440 765 1268 2009 3057 4490 6395 8868 12014 15947 20790 26675 33743 42144 52037 63590\r\n"
			+ "17 24 25 29 57 141 323 654 1193 2006 3165 4747 6833 9507 12855 16964 21921 27812 34721 42729 51913\r\n"
			+ "15 33 74 149 271 454 709 1037 1419 1803 2088 2105 1595 184 -2645 -7583 -15529 -27627 -45306 -70323 -104809\r\n"
			+ "-5 0 30 100 240 524 1112 2315 4716 9424 18625 36759 72943 145738 292097 583418 1153161 2242584 4273936 7964054 14495898\r\n"
			+ "8 3 -2 -12 -31 -54 -48 97 676 2387 6770 17125 40496 92007 204272 447475 971345 2091090 4459978 9410214 19617066\r\n"
			+ "18 42 89 176 339 657 1289 2526 4871 9189 17032 31374 58243 110193 213346 421080 839804 1676592 3326619 6533852 12687463\r\n"
			+ "24 33 32 19 -8 -50 -102 -136 -49 473 2262 7289 19835 48621 110656 238316 492843 991157 1960791 3853889 7582363\r\n"
			+ "14 18 21 39 110 315 811 1883 4040 8205 16089 30927 58972 112662 217520 427204 855716 1744348 3596383 7439559 15322188\r\n"
			+ "-3 -4 -1 10 37 92 191 354 605 972 1487 2186 3109 4300 5807 7682 9981 12764 16095 20042 24677\r\n"
			+ "24 46 92 185 368 710 1323 2418 4443 8365 16192 31899 63053 123665 239189 455253 852922 1575720 2878724 5220673 9441526\r\n"
			+ "5 11 17 26 37 47 59 104 294 932 2714 7067 16676 36262 73682 141431 258635 453633 767255 1256912 2001623\r\n"
			+ "3 13 39 95 206 420 835 1646 3233 6351 12563 25196 51317 105537 216866 440362 875931 1697317 3195027 5837601 10356172\r\n"
			+ "23 34 50 90 186 399 850 1766 3541 6812 12550 22166 37632 61617 97638 150226 225107 329398 471818 662914 915302\r\n"
			+ "14 19 27 31 29 47 188 717 2202 5752 13431 28996 59229 116338 222228 415936 766238 1392433 2497659 4420877 7715957\r\n"
			+ "22 48 88 154 266 456 777 1319 2240 3845 6813 12814 26034 56648 128255 293079 661970 1461954 3143994 6580482 13420090\r\n"
			+ "9 27 57 116 231 448 867 1716 3482 7124 14399 28336 53896 98861 175007 299642 497639 804177 1268533 1959460 2972957\r\n"
			+ "-5 2 26 89 231 516 1037 1929 3411 5887 10136 17600 30719 53137 89384 143329 214445 291300 344296 328391 229769\r\n"
			+ "10 30 73 147 251 375 503 626 792 1256 2850 7776 21139 53687 126416 277935 575774 1133162 2133207 3862881 6759755\r\n"
			+ "6 25 64 130 230 371 560 804 1110 1485 1936 2470 3094 3815 4640 5576 6630 7809 9120 10570 12166\r\n"
			+ "5 21 49 96 188 381 773 1520 2870 5250 9472 17165 31591 59064 111262 208803 386547 701187 1241803 2144174 3609774\r\n"
			+ "4 8 11 19 52 164 473 1201 2724 5632 10799 19463 33316 54604 86237 131909 196228 284856 404659 563867 772244\r\n"
			+ "16 17 21 43 115 288 629 1207 2056 3095 3975 3811 743 -8746 -30845 -75873 -160312 -309571 -561663 -972005 -1619581\r\n"
			+ "20 41 64 95 146 226 334 465 656 1126 2602 6972 18466 45637 104496 223248 449180 858367 1568988 2759181 4690514\r\n"
			+ "24 42 78 154 311 626 1242 2425 4680 8984 17234 33088 63554 122049 234333 449868 862900 1650010 3134026 5887858 10895573\r\n"
			+ "13 24 35 46 57 68 79 90 101 112 123 134 145 156 167 178 189 200 211 222 233\r\n"
			+ "12 33 64 116 215 402 733 1279 2126 3375 5142 7558 10769 14936 20235 26857 35008 44909 56796 70920 87547\r\n"
			+ "3 3 4 -1 -25 -93 -238 -474 -732 -738 206 3624 12659 33762 80457 181823 401424 878936 1920547 4193588 9142746\r\n"
			+ "10 16 43 118 281 578 1050 1719 2572 3544 4501 5224 5395 4586 2252 -2271 -9762 -21104 -37265 -59270 -88163\r\n"
			+ "7 21 40 64 88 114 190 496 1519 4408 11689 28662 66010 144437 302531 609532 1185287 2230407 4070518 7219532 12468068\r\n"
			+ "18 19 20 24 31 50 138 480 1524 4185 10132 22172 44745 84544 151274 258564 425046 675615 1042884 1568848 2306771\r\n"
			+ "2 13 45 110 219 374 557 718 762 535 -171 -1502 -3053 -2416 8385 50602 173946 484417 1192461 2692454 5688803\r\n"
			+ "14 41 93 176 304 512 878 1570 2957 5860 12072 25350 53185 109799 221015 431914 818552 1505483 2691447 4686364 7963758\r\n"
			+ "9 29 64 128 257 525 1071 2144 4177 7920 14718 27142 50410 95443 185129 366688 735437 1479587 2963316 5878324 11515435\r\n"
			+ "16 19 24 34 52 86 175 455 1295 3545 8960 20916 45648 94464 187794 362623 685982 1278943 2358276 4306974 7790760\r\n"
			+ "19 39 73 124 205 360 708 1522 3349 7176 14664 28524 53217 96349 171431 303116 536647 954093 1701059 3028980 5359901\r\n"
			+ "11 21 45 102 218 437 855 1689 3406 6966 14280 29052 58269 114730 221168 416748 767160 1380593 2434552 4224642 7259199\r\n"
			+ "-4 2 19 63 173 427 963 2005 3894 7124 12383 20599 32991 51125 76975 112989 162160 228102 315131 428351 573745\r\n"
			+ "-1 12 34 70 130 233 433 882 1953 4463 10073 22022 46520 95464 191794 380004 746419 1457358 2828948 5451118 10401486\r\n"
			+ "14 22 35 60 104 174 277 420 610 854 1159 1532 1980 2510 3129 3844 4662 5590 6635 7804 9104\r\n"
			+ "9 37 74 115 162 231 359 611 1087 1929 3328 5531 8848 13659 20421 29675 42053 58285 79206 105763 139022\r\n"
			+ "14 30 60 115 225 452 920 1889 3925 8250 17403 36422 74887 150368 294152 560732 1043848 1904908 3426737 6121852 10960199\r\n"
			+ "13 33 68 117 181 265 378 540 811 1358 2581 5358 11617 25866 59349 140794 342438 839116 2034831 4820180 11072302\r\n"
			+ "4 10 23 53 125 287 615 1215 2234 3916 6792 12205 23585 49261 108196 240939 529400 1130878 2334229 4649285 8944773\r\n"
			+ "0 12 47 122 268 538 1015 1820 3120 5136 8151 12518 18668 27118 38479 53464 72896 97716 128991 167922 215852\r\n"
			+ "16 25 37 67 148 350 815 1820 3891 8002 15904 30640 57313 104185 184196 317003 531650 869991 1390999 2176105 3335722\r\n"
			+ "7 13 27 67 162 360 754 1548 3200 6702 14102 29466 60657 122623 243399 474813 911029 1719659 3192341 5824533 10437948\r\n"
			+ "-8 -6 13 71 198 436 844 1494 2438 3610 4612 4343 514 -10667 -33824 -70889 -110866 -105267 85552 803711 2818074\r\n"
			+ "14 38 85 184 375 702 1212 1984 3240 5642 10963 23451 52427 117093 255476 541581 1119610 2274418 4578809 9201258 18541055\r\n"
			+ "25 31 44 84 187 422 919 1908 3776 7176 13278 24350 45030 84981 164300 324477 650636 1316593 2675177 5435792 11004698\r\n"
			+ "9 26 59 113 201 356 655 1271 2590 5462 11709 25122 53406 111972 231249 470433 942467 1857869 3599689 6850972 12816343\r\n"
			+ "10 12 36 106 267 608 1301 2667 5287 10193 19221 35721 66061 122837 231568 444139 864652 1697018 3328986 6474792 12408627\r\n"
			+ "-6 -12 -21 -25 -9 50 197 540 1338 3167 7211 15746 32911 65891 126673 234577 419810 728342 1228459 2019409 3242623\r\n"
			+ "11 18 25 32 39 46 53 60 67 74 81 88 95 102 109 116 123 130 137 144 151\r\n"
			+ "8 25 53 92 140 193 245 288 312 305 253 140 -52 -343 -755 -1312 -2040 -2967 -4123 -5540 -7252\r\n"
			+ "4 1 3 27 99 259 583 1232 2552 5276 10917 22488 45750 91310 178160 339843 635656 1171627 2140131 3893921 7081377\r\n"
			+ "11 10 14 35 90 206 432 858 1641 3038 5446 9449 15872 25842 40856 62856 94311 138306 198638 279919 387686\r\n"
			+ "22 25 22 26 60 148 307 546 877 1354 2199 4172 9516 24086 61732 152899 361419 818276 1792455 3844615 8164667\r\n"
			+ "-3 7 45 125 273 545 1066 2109 4251 8673 17706 35760 70818 136787 257331 472725 853469 1529147 2750403 5019227 9352947\r\n"
			+ "7 32 75 134 205 297 459 819 1635 3358 6707 12756 23033 39631 65331 103737 159423 238092 346747 493874 689637\r\n"
			+ "0 8 21 33 39 54 146 483 1394 3444 7523 14949 27585 47970 79464 126407 194292 289952 421761 599849 836331\r\n"
			+ "22 34 62 131 281 582 1166 2282 4380 8230 15082 26873 46487 78074 127434 202472 313730 475002 704038 1023343 1461077\r\n"
			+ "3 -3 -15 -33 -55 -62 6 285 1050 2841 6711 14709 30853 63183 128177 260102 530081 1083209 2207481 4456263 8857341\r\n"
			+ "7 17 23 19 9 21 127 486 1444 3743 8904 19860 41950 84508 163610 307266 565741 1032145 1882461 3450445 6362167\r\n"
			+ "4 8 22 58 134 291 630 1388 3082 6765 14463 29914 59853 116367 221424 415775 776340 1449322 2711168 5076766 9484732\r\n"
			+ "3 14 43 100 210 428 854 1648 3045 5370 9053 14644 22828 34440 50480 72128 100759 137958 185535 245540 320278\r\n"
			+ "25 35 49 81 159 342 749 1609 3351 6777 13410 26194 50855 98422 189666 362554 684245 1269687 2309519 4110751 7154599\r\n"
			+ "14 21 39 94 224 484 956 1776 3220 5944 11563 23901 51474 112113 241132 505141 1024546 2009023 3811863 7011128 12528108\r\n"
			+ "18 22 24 21 6 -31 -86 -99 120 1002 3370 8631 19008 37809 69728 121171 200598 318870 489588 729409 1058322\r\n"
			+ "8 4 7 36 124 333 786 1725 3601 7201 13831 25623 46145 81700 144044 255782 460470 840522 1547463 2850958 5215466\r\n"
			+ "17 28 49 99 207 409 756 1355 2488 4902 10453 23452 53362 120043 263748 563961 1174814 2392019 4780564 9420616 18383440\r\n"
			+ "19 42 90 172 300 490 761 1142 1717 2770 5136 10920 24814 56322 123295 257282 511319 970906 1769062 3106500 5278128\r\n"
			+ "-1 9 28 56 93 139 194 258 331 413 504 604 713 831 958 1094 1239 1393 1556 1728 1909\r\n"
			+ "13 33 63 122 241 460 825 1385 2189 3283 4707 6492 8657 11206 14125 17379 20909 24629 28423 32142 35601\r\n"
			+ "18 27 51 105 210 393 687 1131 1770 2655 3843 5397 7386 9885 12975 16743 21282 26691 33075 40545 49218\r\n"
			+ "11 21 46 97 193 366 668 1191 2111 3761 6726 11936 20718 34781 56227 88111 137295 224377 412322 879711 2092491\r\n"
			+ "6 19 43 73 105 142 201 321 572 1065 1963 3493 5959 9756 15385 23469 34770 50207 70875 98065 133285\r\n"
			+ "14 20 43 96 205 428 876 1735 3301 6063 10913 19662 36281 69839 141311 298920 651705 1441036 3189732 7007974 15213130\r\n"
			+ "7 27 66 140 273 497 852 1386 2155 3223 4662 6552 8981 12045 15848 20502 26127 32851 40810 50148 61017\r\n"
			+ "1 12 30 55 87 126 172 225 285 352 426 507 595 690 792 901 1017 1140 1270 1407 1551\r\n"
			+ "-4 -7 6 49 136 281 498 801 1204 1721 2366 3153 4096 5209 6506 8001 9708 11641 13814 16241 18936\r\n"
			+ "11 14 18 38 107 278 632 1311 2606 5149 10293 20835 42382 85939 172805 343763 676168 1315542 2534037 4839292 9178800\r\n"
			+ "2 4 11 33 79 152 244 331 368 284 -23 -691 -1899 -3872 -6886 -11273 -17426 -25804 -36937 -51431 -69973\r\n"
			+ "14 14 10 2 -8 -24 -60 -134 -247 -339 -196 783 4227 14509 42992 117673 303448 741928 1725310 3826880 8122058\r\n"
			+ "12 10 6 4 11 37 95 201 374 636 1012 1530 2221 3119 4261 5687 7440 9566 12114 15136 18687\r\n"
			+ "13 20 27 34 41 48 55 62 69 76 83 90 97 104 111 118 125 132 139 146 153\r\n"
			+ "-6 -4 8 32 81 194 469 1133 2672 6048 13034 26702 52103 97182 173975 300139 500870 811268 1279212 1968812 2964509\r\n"
			+ "-7 -7 10 71 227 566 1230 2446 4586 8273 14551 25150 42945 72947 124844 219801 408064 812066 1726241 3836910 8686204\r\n"
			+ "6 17 43 102 238 533 1128 2271 4426 8500 16275 31169 59494 112430 208992 380332 675790 1171187 1979939 3267664 5271054\r\n"
			+ "-1 12 45 102 183 284 397 510 607 668 669 582 375 12 -547 -1346 -2433 -3860 -5683 -7962 -10761\r\n"
			+ "20 38 76 145 269 507 980 1895 3562 6409 11006 18095 28567 43214 61926 81867 94208 79512 3336 -183235 -527535\r\n"
			+ "11 17 38 85 165 282 449 719 1244 2386 4943 10630 23099 50057 107582 228809 481245 1000903 2058564 4185863 8409645\r\n"
			+ "-4 2 23 68 146 266 437 668 968 1346 1811 2372 3038 3818 4721 5756 6932 8258 9743 11396 13226\r\n"
			+ "27 57 98 151 237 422 867 1927 4340 9587 20592 43100 88355 178137 353879 692653 1334714 2530900 4725103 8699880 15836006\r\n"
			+ "1 14 50 138 328 711 1464 2934 5783 11229 21435 40119 73480 131543 229979 392268 651589 1050788 1636808 2442508 3443080\r\n"
			+ "19 29 46 91 194 406 841 1763 3732 7817 15864 30768 56648 98793 163296 256523 385125 558401 796734 1152901 1757738\r\n"
			+ "13 37 70 112 163 223 292 370 457 553 658 772 895 1027 1168 1318 1477 1645 1822 2008 2203\r\n"
			+ "10 28 67 149 318 659 1328 2607 5009 9476 17753 33118 61871 116451 221938 429262 841028 1659924 3275775 6416139 12397756\r\n"
			+ "6 21 54 106 169 234 324 572 1376 3679 9455 22554 50197 105644 212909 414884 786866 1458249 2646020 4704634 8197761\r\n"
			+ "6 12 18 24 30 36 42 48 54 60 66 72 78 84 90 96 102 108 114 120 126\r\n"
			+ "15 34 73 145 258 418 638 957 1490 2560 5006 10817 24311 54160 116657 240729 475321 899910 1639055 2882049 4908912\r\n"
			+ "21 40 71 124 213 359 605 1057 1983 4039 8765 19642 44303 99108 218519 474039 1011681 2124154 4385819 8897208 17714481\r\n"
			+ "18 30 46 65 89 126 198 368 808 1946 4768 11433 26515 59454 129224 272864 560430 1120182 2179498 4129193 7621709\r\n"
			+ "11 26 44 66 101 166 293 561 1175 2610 5820 12474 25119 47084 81835 131383 193259 255538 289468 239506 11065\r\n"
			+ "21 38 70 127 230 432 859 1785 3762 7833 15868 31092 58941 108519 195181 345194 604107 1051488 1826178 3168309 5487200\r\n"
			+ "9 10 28 84 222 524 1136 2328 4621 9026 17461 33459 63396 118745 220471 407910 756769 1414902 2671186 5083402 9707186\r\n"
			+ "13 15 31 91 248 589 1254 2471 4631 8465 15450 28679 54623 106574 211226 421036 837005 1649727 3211485 6159471 11620662\r\n"
			+ "7 -2 -12 -16 -9 16 96 361 1145 3173 7887 18036 38751 79463 157207 302095 566043 1036208 1855038 3249368 5571615\r\n"
			+ "3 11 36 96 223 477 974 1940 3821 7520 14909 29886 60431 122413 246441 490099 959927 1851269 3520762 6617456 12316647\r\n"
			+ "1 13 40 100 234 532 1171 2463 4908 9241 16451 27732 44299 66964 95316 126283 151771 154973 104818 -52116 -403072\r\n"
			+ "15 32 61 115 216 409 800 1623 3347 6850 13718 26781 51089 95697 176978 325002 596485 1102414 2068745 3970445 7823396\r\n"
			+ "15 29 56 121 270 592 1251 2533 4921 9230 16874 30408 54600 98451 178805 326486 596275 1082507 1942636 3431795 5952178\r\n"
			+ "7 25 64 131 229 363 547 811 1221 1965 3653 8177 20861 55354 144069 359480 856203 1952117 4281458 9077979 18688197\r\n"
			+ "24 41 62 85 104 121 176 407 1164 3220 8148 18975 41310 85330 169392 326765 618248 1155531 2143418 3953905 7252132\r\n"
			+ "5 17 53 139 320 679 1367 2644 4940 8972 16011 28493 51314 94333 176804 334621 631315 1173583 2131613 3763411 6440504\r\n"
			+ "11 21 36 58 100 209 504 1239 2917 6511 13888 28577 57079 111038 210938 392938 722755 1325501 2450316 4607036 8844274";
}
