import java.util.HashMap;

/**
 * Made to convert quadrent indecies to actual grid bounds.
 */
public class RangeTranslator {

    private static HashMap<Integer,Range> mapping = null;

    public static Range getRange(int quadrentKey){
        if(mapping == null){
            initialize();
        }
        return mapping.get(quadrentKey);
    }

    private static void initialize(){
        mapping = new HashMap<Integer, Range>();
        mapping.put(0,new Range(0,49,0,49));
        mapping.put(1,new Range(50,99,0,49));
        mapping.put(2,new Range(100,149,0,49));
        mapping.put(3,new Range(150,199,0,49));
        mapping.put(4,new Range(200,249,0,49));
        mapping.put(5,new Range(250,299,0,49));
        mapping.put(6,new Range(300,349,0,49));
        mapping.put(7,new Range(350,399,0,49));
        mapping.put(8,new Range(400,449,0,49));
        mapping.put(9,new Range(450,499,0,49));
        mapping.put(10,new Range(500,549,0,49));
        mapping.put(11,new Range(550,599,0,49));
        mapping.put(12,new Range(600,649,0,49));
        mapping.put(13,new Range(650,699,0,49));
        mapping.put(14,new Range(700,749,0,49));
        mapping.put(15,new Range(750,799,0,49));
        mapping.put(16,new Range(800,849,0,49));
        mapping.put(17,new Range(850,899,0,49));
        mapping.put(18,new Range(900,949,0,49));
        mapping.put(19,new Range(950,999,0,49));
        mapping.put(20,new Range(0,49,50,99));
        mapping.put(21,new Range(50,99,50,99));
        mapping.put(22,new Range(100,149,50,99));
        mapping.put(23,new Range(150,199,50,99));
        mapping.put(24,new Range(200,249,50,99));
        mapping.put(25,new Range(250,299,50,99));
        mapping.put(26,new Range(300,349,50,99));
        mapping.put(27,new Range(350,399,50,99));
        mapping.put(28,new Range(400,449,50,99));
        mapping.put(29,new Range(450,499,50,99));
        mapping.put(30,new Range(500,549,50,99));
        mapping.put(31,new Range(550,599,50,99));
        mapping.put(32,new Range(600,649,50,99));
        mapping.put(33,new Range(650,699,50,99));
        mapping.put(34,new Range(700,749,50,99));
        mapping.put(35,new Range(750,799,50,99));
        mapping.put(36,new Range(800,849,50,99));
        mapping.put(37,new Range(850,899,50,99));
        mapping.put(38,new Range(900,949,50,99));
        mapping.put(39,new Range(950,999,50,99));
        mapping.put(40,new Range(0,49,100,149));
        mapping.put(41,new Range(50,99,100,149));
        mapping.put(42,new Range(100,149,100,149));
        mapping.put(43,new Range(150,199,100,149));
        mapping.put(44,new Range(200,249,100,149));
        mapping.put(45,new Range(250,299,100,149));
        mapping.put(46,new Range(300,349,100,149));
        mapping.put(47,new Range(350,399,100,149));
        mapping.put(48,new Range(400,449,100,149));
        mapping.put(49,new Range(450,499,100,149));
        mapping.put(50,new Range(500,549,100,149));
        mapping.put(51,new Range(550,599,100,149));
        mapping.put(52,new Range(600,649,100,149));
        mapping.put(53,new Range(650,699,100,149));
        mapping.put(54,new Range(700,749,100,149));
        mapping.put(55,new Range(750,799,100,149));
        mapping.put(56,new Range(800,849,100,149));
        mapping.put(57,new Range(850,899,100,149));
        mapping.put(58,new Range(900,949,100,149));
        mapping.put(59,new Range(950,999,100,149));
        mapping.put(60,new Range(0,49,150,199));
        mapping.put(61,new Range(50,99,150,199));
        mapping.put(62,new Range(100,149,150,199));
        mapping.put(63,new Range(150,199,150,199));
        mapping.put(64,new Range(200,249,150,199));
        mapping.put(65,new Range(250,299,150,199));
        mapping.put(66,new Range(300,349,150,199));
        mapping.put(67,new Range(350,399,150,199));
        mapping.put(68,new Range(400,449,150,199));
        mapping.put(69,new Range(450,499,150,199));
        mapping.put(70,new Range(500,549,150,199));
        mapping.put(71,new Range(550,599,150,199));
        mapping.put(72,new Range(600,649,150,199));
        mapping.put(73,new Range(650,699,150,199));
        mapping.put(74,new Range(700,749,150,199));
        mapping.put(75,new Range(750,799,150,199));
        mapping.put(76,new Range(800,849,150,199));
        mapping.put(77,new Range(850,899,150,199));
        mapping.put(78,new Range(900,949,150,199));
        mapping.put(79,new Range(950,999,150,199));
        mapping.put(80,new Range(0,49,200,249));
        mapping.put(81,new Range(50,99,200,249));
        mapping.put(82,new Range(100,149,200,249));
        mapping.put(83,new Range(150,199,200,249));
        mapping.put(84,new Range(200,249,200,249));
        mapping.put(85,new Range(250,299,200,249));
        mapping.put(86,new Range(300,349,200,249));
        mapping.put(87,new Range(350,399,200,249));
        mapping.put(88,new Range(400,449,200,249));
        mapping.put(89,new Range(450,499,200,249));
        mapping.put(90,new Range(500,549,200,249));
        mapping.put(91,new Range(550,599,200,249));
        mapping.put(92,new Range(600,649,200,249));
        mapping.put(93,new Range(650,699,200,249));
        mapping.put(94,new Range(700,749,200,249));
        mapping.put(95,new Range(750,799,200,249));
        mapping.put(96,new Range(800,849,200,249));
        mapping.put(97,new Range(850,899,200,249));
        mapping.put(98,new Range(900,949,200,249));
        mapping.put(99,new Range(950,999,200,249));
        mapping.put(100,new Range(0,49,250,299));
        mapping.put(101,new Range(50,99,250,299));
        mapping.put(102,new Range(100,149,250,299));
        mapping.put(103,new Range(150,199,250,299));
        mapping.put(104,new Range(200,249,250,299));
        mapping.put(105,new Range(250,299,250,299));
        mapping.put(106,new Range(300,349,250,299));
        mapping.put(107,new Range(350,399,250,299));
        mapping.put(108,new Range(400,449,250,299));
        mapping.put(109,new Range(450,499,250,299));
        mapping.put(110,new Range(500,549,250,299));
        mapping.put(111,new Range(550,599,250,299));
        mapping.put(112,new Range(600,649,250,299));
        mapping.put(113,new Range(650,699,250,299));
        mapping.put(114,new Range(700,749,250,299));
        mapping.put(115,new Range(750,799,250,299));
        mapping.put(116,new Range(800,849,250,299));
        mapping.put(117,new Range(850,899,250,299));
        mapping.put(118,new Range(900,949,250,299));
        mapping.put(119,new Range(950,999,250,299));
        mapping.put(120,new Range(0,49,300,349));
        mapping.put(121,new Range(50,99,300,349));
        mapping.put(122,new Range(100,149,300,349));
        mapping.put(123,new Range(150,199,300,349));
        mapping.put(124,new Range(200,249,300,349));
        mapping.put(125,new Range(250,299,300,349));
        mapping.put(126,new Range(300,349,300,349));
        mapping.put(127,new Range(350,399,300,349));
        mapping.put(128,new Range(400,449,300,349));
        mapping.put(129,new Range(450,499,300,349));
        mapping.put(130,new Range(500,549,300,349));
        mapping.put(131,new Range(550,599,300,349));
        mapping.put(132,new Range(600,649,300,349));
        mapping.put(133,new Range(650,699,300,349));
        mapping.put(134,new Range(700,749,300,349));
        mapping.put(135,new Range(750,799,300,349));
        mapping.put(136,new Range(800,849,300,349));
        mapping.put(137,new Range(850,899,300,349));
        mapping.put(138,new Range(900,949,300,349));
        mapping.put(139,new Range(950,999,300,349));
        mapping.put(140,new Range(0,49,350,399));
        mapping.put(141,new Range(50,99,350,399));
        mapping.put(142,new Range(100,149,350,399));
        mapping.put(143,new Range(150,199,350,399));
        mapping.put(144,new Range(200,249,350,399));
        mapping.put(145,new Range(250,299,350,399));
        mapping.put(146,new Range(300,349,350,399));
        mapping.put(147,new Range(350,399,350,399));
        mapping.put(148,new Range(400,449,350,399));
        mapping.put(149,new Range(450,499,350,399));
        mapping.put(150,new Range(500,549,350,399));
        mapping.put(151,new Range(550,599,350,399));
        mapping.put(152,new Range(600,649,350,399));
        mapping.put(153,new Range(650,699,350,399));
        mapping.put(154,new Range(700,749,350,399));
        mapping.put(155,new Range(750,799,350,399));
        mapping.put(156,new Range(800,849,350,399));
        mapping.put(157,new Range(850,899,350,399));
        mapping.put(158,new Range(900,949,350,399));
        mapping.put(159,new Range(950,999,350,399));
        mapping.put(160,new Range(0,49,400,449));
        mapping.put(161,new Range(50,99,400,449));
        mapping.put(162,new Range(100,149,400,449));
        mapping.put(163,new Range(150,199,400,449));
        mapping.put(164,new Range(200,249,400,449));
        mapping.put(165,new Range(250,299,400,449));
        mapping.put(166,new Range(300,349,400,449));
        mapping.put(167,new Range(350,399,400,449));
        mapping.put(168,new Range(400,449,400,449));
        mapping.put(169,new Range(450,499,400,449));
        mapping.put(170,new Range(500,549,400,449));
        mapping.put(171,new Range(550,599,400,449));
        mapping.put(172,new Range(600,649,400,449));
        mapping.put(173,new Range(650,699,400,449));
        mapping.put(174,new Range(700,749,400,449));
        mapping.put(175,new Range(750,799,400,449));
        mapping.put(176,new Range(800,849,400,449));
        mapping.put(177,new Range(850,899,400,449));
        mapping.put(178,new Range(900,949,400,449));
        mapping.put(179,new Range(950,999,400,449));
        mapping.put(180,new Range(0,49,450,499));
        mapping.put(181,new Range(50,99,450,499));
        mapping.put(182,new Range(100,149,450,499));
        mapping.put(183,new Range(150,199,450,499));
        mapping.put(184,new Range(200,249,450,499));
        mapping.put(185,new Range(250,299,450,499));
        mapping.put(186,new Range(300,349,450,499));
        mapping.put(187,new Range(350,399,450,499));
        mapping.put(188,new Range(400,449,450,499));
        mapping.put(189,new Range(450,499,450,499));
        mapping.put(190,new Range(500,549,450,499));
        mapping.put(191,new Range(550,599,450,499));
        mapping.put(192,new Range(600,649,450,499));
        mapping.put(193,new Range(650,699,450,499));
        mapping.put(194,new Range(700,749,450,499));
        mapping.put(195,new Range(750,799,450,499));
        mapping.put(196,new Range(800,849,450,499));
        mapping.put(197,new Range(850,899,450,499));
        mapping.put(198,new Range(900,949,450,499));
        mapping.put(199,new Range(950,999,450,499));
        mapping.put(200,new Range(0,49,500,549));
        mapping.put(201,new Range(50,99,500,549));
        mapping.put(202,new Range(100,149,500,549));
        mapping.put(203,new Range(150,199,500,549));
        mapping.put(204,new Range(200,249,500,549));
        mapping.put(205,new Range(250,299,500,549));
        mapping.put(206,new Range(300,349,500,549));
        mapping.put(207,new Range(350,399,500,549));
        mapping.put(208,new Range(400,449,500,549));
        mapping.put(209,new Range(450,499,500,549));
        mapping.put(210,new Range(500,549,500,549));
        mapping.put(211,new Range(550,599,500,549));
        mapping.put(212,new Range(600,649,500,549));
        mapping.put(213,new Range(650,699,500,549));
        mapping.put(214,new Range(700,749,500,549));
        mapping.put(215,new Range(750,799,500,549));
        mapping.put(216,new Range(800,849,500,549));
        mapping.put(217,new Range(850,899,500,549));
        mapping.put(218,new Range(900,949,500,549));
        mapping.put(219,new Range(950,999,500,549));
        mapping.put(220,new Range(0,49,550,599));
        mapping.put(221,new Range(50,99,550,599));
        mapping.put(222,new Range(100,149,550,599));
        mapping.put(223,new Range(150,199,550,599));
        mapping.put(224,new Range(200,249,550,599));
        mapping.put(225,new Range(250,299,550,599));
        mapping.put(226,new Range(300,349,550,599));
        mapping.put(227,new Range(350,399,550,599));
        mapping.put(228,new Range(400,449,550,599));
        mapping.put(229,new Range(450,499,550,599));
        mapping.put(230,new Range(500,549,550,599));
        mapping.put(231,new Range(550,599,550,599));
        mapping.put(232,new Range(600,649,550,599));
        mapping.put(233,new Range(650,699,550,599));
        mapping.put(234,new Range(700,749,550,599));
        mapping.put(235,new Range(750,799,550,599));
        mapping.put(236,new Range(800,849,550,599));
        mapping.put(237,new Range(850,899,550,599));
        mapping.put(238,new Range(900,949,550,599));
        mapping.put(239,new Range(950,999,550,599));
        mapping.put(240,new Range(0,49,600,649));
        mapping.put(241,new Range(50,99,600,649));
        mapping.put(242,new Range(100,149,600,649));
        mapping.put(243,new Range(150,199,600,649));
        mapping.put(244,new Range(200,249,600,649));
        mapping.put(245,new Range(250,299,600,649));
        mapping.put(246,new Range(300,349,600,649));
        mapping.put(247,new Range(350,399,600,649));
        mapping.put(248,new Range(400,449,600,649));
        mapping.put(249,new Range(450,499,600,649));
        mapping.put(250,new Range(500,549,600,649));
        mapping.put(251,new Range(550,599,600,649));
        mapping.put(252,new Range(600,649,600,649));
        mapping.put(253,new Range(650,699,600,649));
        mapping.put(254,new Range(700,749,600,649));
        mapping.put(255,new Range(750,799,600,649));
        mapping.put(256,new Range(800,849,600,649));
        mapping.put(257,new Range(850,899,600,649));
        mapping.put(258,new Range(900,949,600,649));
        mapping.put(259,new Range(950,999,600,649));
        mapping.put(260,new Range(0,49,650,699));
        mapping.put(261,new Range(50,99,650,699));
        mapping.put(262,new Range(100,149,650,699));
        mapping.put(263,new Range(150,199,650,699));
        mapping.put(264,new Range(200,249,650,699));
        mapping.put(265,new Range(250,299,650,699));
        mapping.put(266,new Range(300,349,650,699));
        mapping.put(267,new Range(350,399,650,699));
        mapping.put(268,new Range(400,449,650,699));
        mapping.put(269,new Range(450,499,650,699));
        mapping.put(270,new Range(500,549,650,699));
        mapping.put(271,new Range(550,599,650,699));
        mapping.put(272,new Range(600,649,650,699));
        mapping.put(273,new Range(650,699,650,699));
        mapping.put(274,new Range(700,749,650,699));
        mapping.put(275,new Range(750,799,650,699));
        mapping.put(276,new Range(800,849,650,699));
        mapping.put(277,new Range(850,899,650,699));
        mapping.put(278,new Range(900,949,650,699));
        mapping.put(279,new Range(950,999,650,699));
        mapping.put(280,new Range(0,49,700,749));
        mapping.put(281,new Range(50,99,700,749));
        mapping.put(282,new Range(100,149,700,749));
        mapping.put(283,new Range(150,199,700,749));
        mapping.put(284,new Range(200,249,700,749));
        mapping.put(285,new Range(250,299,700,749));
        mapping.put(286,new Range(300,349,700,749));
        mapping.put(287,new Range(350,399,700,749));
        mapping.put(288,new Range(400,449,700,749));
        mapping.put(289,new Range(450,499,700,749));
        mapping.put(290,new Range(500,549,700,749));
        mapping.put(291,new Range(550,599,700,749));
        mapping.put(292,new Range(600,649,700,749));
        mapping.put(293,new Range(650,699,700,749));
        mapping.put(294,new Range(700,749,700,749));
        mapping.put(295,new Range(750,799,700,749));
        mapping.put(296,new Range(800,849,700,749));
        mapping.put(297,new Range(850,899,700,749));
        mapping.put(298,new Range(900,949,700,749));
        mapping.put(299,new Range(950,999,700,749));
        mapping.put(300,new Range(0,49,750,799));
        mapping.put(301,new Range(50,99,750,799));
        mapping.put(302,new Range(100,149,750,799));
        mapping.put(303,new Range(150,199,750,799));
        mapping.put(304,new Range(200,249,750,799));
        mapping.put(305,new Range(250,299,750,799));
        mapping.put(306,new Range(300,349,750,799));
        mapping.put(307,new Range(350,399,750,799));
        mapping.put(308,new Range(400,449,750,799));
        mapping.put(309,new Range(450,499,750,799));
        mapping.put(310,new Range(500,549,750,799));
        mapping.put(311,new Range(550,599,750,799));
        mapping.put(312,new Range(600,649,750,799));
        mapping.put(313,new Range(650,699,750,799));
        mapping.put(314,new Range(700,749,750,799));
        mapping.put(315,new Range(750,799,750,799));
        mapping.put(316,new Range(800,849,750,799));
        mapping.put(317,new Range(850,899,750,799));
        mapping.put(318,new Range(900,949,750,799));
        mapping.put(319,new Range(950,999,750,799));
        mapping.put(320,new Range(0,49,800,849));
        mapping.put(321,new Range(50,99,800,849));
        mapping.put(322,new Range(100,149,800,849));
        mapping.put(323,new Range(150,199,800,849));
        mapping.put(324,new Range(200,249,800,849));
        mapping.put(325,new Range(250,299,800,849));
        mapping.put(326,new Range(300,349,800,849));
        mapping.put(327,new Range(350,399,800,849));
        mapping.put(328,new Range(400,449,800,849));
        mapping.put(329,new Range(450,499,800,849));
        mapping.put(330,new Range(500,549,800,849));
        mapping.put(331,new Range(550,599,800,849));
        mapping.put(332,new Range(600,649,800,849));
        mapping.put(333,new Range(650,699,800,849));
        mapping.put(334,new Range(700,749,800,849));
        mapping.put(335,new Range(750,799,800,849));
        mapping.put(336,new Range(800,849,800,849));
        mapping.put(337,new Range(850,899,800,849));
        mapping.put(338,new Range(900,949,800,849));
        mapping.put(339,new Range(950,999,800,849));
        mapping.put(340,new Range(0,49,850,899));
        mapping.put(341,new Range(50,99,850,899));
        mapping.put(342,new Range(100,149,850,899));
        mapping.put(343,new Range(150,199,850,899));
        mapping.put(344,new Range(200,249,850,899));
        mapping.put(345,new Range(250,299,850,899));
        mapping.put(346,new Range(300,349,850,899));
        mapping.put(347,new Range(350,399,850,899));
        mapping.put(348,new Range(400,449,850,899));
        mapping.put(349,new Range(450,499,850,899));
        mapping.put(350,new Range(500,549,850,899));
        mapping.put(351,new Range(550,599,850,899));
        mapping.put(352,new Range(600,649,850,899));
        mapping.put(353,new Range(650,699,850,899));
        mapping.put(354,new Range(700,749,850,899));
        mapping.put(355,new Range(750,799,850,899));
        mapping.put(356,new Range(800,849,850,899));
        mapping.put(357,new Range(850,899,850,899));
        mapping.put(358,new Range(900,949,850,899));
        mapping.put(359,new Range(950,999,850,899));
        mapping.put(360,new Range(0,49,900,949));
        mapping.put(361,new Range(50,99,900,949));
        mapping.put(362,new Range(100,149,900,949));
        mapping.put(363,new Range(150,199,900,949));
        mapping.put(364,new Range(200,249,900,949));
        mapping.put(365,new Range(250,299,900,949));
        mapping.put(366,new Range(300,349,900,949));
        mapping.put(367,new Range(350,399,900,949));
        mapping.put(368,new Range(400,449,900,949));
        mapping.put(369,new Range(450,499,900,949));
        mapping.put(370,new Range(500,549,900,949));
        mapping.put(371,new Range(550,599,900,949));
        mapping.put(372,new Range(600,649,900,949));
        mapping.put(373,new Range(650,699,900,949));
        mapping.put(374,new Range(700,749,900,949));
        mapping.put(375,new Range(750,799,900,949));
        mapping.put(376,new Range(800,849,900,949));
        mapping.put(377,new Range(850,899,900,949));
        mapping.put(378,new Range(900,949,900,949));
        mapping.put(379,new Range(950,999,900,949));
        mapping.put(380,new Range(0,49,950,999));
        mapping.put(381,new Range(50,99,950,999));
        mapping.put(382,new Range(100,149,950,999));
        mapping.put(383,new Range(150,199,950,999));
        mapping.put(384,new Range(200,249,950,999));
        mapping.put(385,new Range(250,299,950,999));
        mapping.put(386,new Range(300,349,950,999));
        mapping.put(387,new Range(350,399,950,999));
        mapping.put(388,new Range(400,449,950,999));
        mapping.put(389,new Range(450,499,950,999));
        mapping.put(390,new Range(500,549,950,999));
        mapping.put(391,new Range(550,599,950,999));
        mapping.put(392,new Range(600,649,950,999));
        mapping.put(393,new Range(650,699,950,999));
        mapping.put(394,new Range(700,749,950,999));
        mapping.put(395,new Range(750,799,950,999));
        mapping.put(396,new Range(800,849,950,999));
        mapping.put(397,new Range(850,899,950,999));
        mapping.put(398,new Range(900,949,950,999));
        mapping.put(399,new Range(950,999,950,999));
    }



}
