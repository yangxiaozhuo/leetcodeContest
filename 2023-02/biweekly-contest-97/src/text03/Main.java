package text03;

/**
 * @author yangxiaozhuo
 * @date 2023/02/04
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        [3937,3938,3939,3951,3951,3959,3975,3988,3993,4010,4031,4033,4036,4038,4039,4041,4047,4058,4059,4064,4072,4081,4084,4084,4089,4094,4098,4112,4114,4116,4123,4123,4127,4130,4135,4143,4149,4152,4163,4164,4176,4178,4180,4198,4216,4224,4233,4240,4253,4259,4273,4286,4305,4322,4335,4350,4364,4378,4396,4397,4398,4404,4415,4421,4430,4469,4476,4490,4492,4497,4504,4519,4519,4525,4526,4530,4530,4540,4550,4554,4563,4571,4571,4595,4595,4606,4639,4639,4660,4663,4676,4678,4680,4695,4697,4709,4709,4711,4724,4751,4781,4786,4786,4794,4797,4801,4807,4808,4817,4822,4824,4825,4840,4851,4887,4889,4891,4910,4917,4927,4931,4932,4951,4959,4964,4993,4997,5003,5003,5006,5006,5022,5029,5035,5043,5045,5045,5046,5059,5060,5079,5084,5105,5109,5109,5112,5120,5126,5130,5142,5143,5151,5152,5154,5156,5168,5189,5213,5214,5223,5226,5235,5247,5259,5272,5289,5303,5309,5317,5322,5344,5347,5352,5374,5379,5380,5383,5385,5391,5418,5425,5429,5432,5479,5486,5490,5502,5502,5505,5506,5509,5515,5518,5519,5521,5526,5528,5533,5536,5536,5538,5555,5556,5557,5557,5566,5571,5580,5585,5596,5604,5619,5634,5649,5668,5694,5696,5699,5701,5704,5709,5732,5745,5745,5746,5749,5762,5766,5766,5770,5773,5796,5810,5817,5823,5838,5843,5846,5860,5869,5872,5877,5880,5896,5899,5902,5905,5910,5913,5913,5915,5923]
//        220  74

//        [5626,5627,5630,5631,5633,5634,5638,5639,5639,5643,5651,5653,5653,5653,5653,5656,5657,5657,5661,5673,5674,5679,5685,5690,5692,5694,5695,5699,5700,5705,5705,5711,5711,5713,5714,5715,5716,5717,5717,5717,5720,5720,5721,5724,5725,5728,5729,5731,5731,5731,5732,5736,5738,5739,5740,5742,5742,5743,5747,5752,5752,5759,5764,5766,5767,5769,5771,5773,5776,5777,5779,5781,5784,5788,5790,5796,5799,5803,5805,5806,5809,5810,5815,5820,5822,5822,5827,5829,5832,5833,5834,5839,5839,5845,5846,5847,5849,5850,5851,5852,5855,5859,5864,5865,5869,5869,5875,5879,5884,5885,5891,5894,5895,5895,5896,5896,5897,5897,5900,5905,5911,5913,5916,5917,5921,5922,5924,5926,5932,5934,5935,5945,5946,5951,5953,5955,5956,5956,5957,5958,5958,5967,5967,5967,5968,5969,5973,5975,5976,5980,5980,5982,5987,5989,5994,5996,5998,6002,6003,6005,6014,6019,6023,6027,6030,6035,6036,6039,6039,6043,6043,6051,6051,6051,6053,6054,6055,6061,6064,6066,6066,6068,6068,6069,6072,6072,6075,6075,6075,6075,6077,6077,6078,6079,6080,6086,6088,6092,6094,6095,6096,6102,6109,6110,6110,6111,6111,6111,6116,6116,6117,6122,6127,6131,6133,6136,6136,6137,6142,6142,6142,6146,6147,6148,6149,6154,6154,6163,6172,6175,6176,6182,6183,6185,6186,6190,6193,6194,6201,6202,6203,6208,6209,6219,6220,6221,6222,6224,6225,6225,6225,6227,6227,6230,6235,6240,6243,6244,6245,6246,6247,6251,6254,6255,6256,6260,6261,6264,6265,6266,6266,6267,6268,6269,6270,6271,6273,6279,6280,6281,6282,6286,6287,6287,6287,6288,6289,6289,6290,6291,6292,6298,6300,6303,6305,6313,6316,6317,6318,6320,6322,6328,6331,6331,6334,6334,6336,6336,6337,6340,6347,6347,6352,6355,6355,6357,6361,6361,6363,6366,6371,6373,6374,6375,6377,6380,6385,6395,6395,6401,6407,6413,6416,6418,6419,6419,6419,6420,6430,6433,6435,6437,6440,6440,6445,6446,6449,6450,6452,6452,6452,6454,6455,6456,6458,6462,6465,6467,6469,6477,6478,6483,6492,6493,6494,6495,6496,6497,6497,6497,6498,6499,6501,6503,6507,6509,6510,6510,6511,6511,6513,6515,6518,6518,6519,6519,6524,6525,6526,6527,6529,6535,6536,6536,6543,6546,6548,6552,6553,6554,6555,6560,6564,6565,6566,6572,6574,6579,6580,6583,6586,6591,6599,6599,6600,6605,6610,6614,6614,6616,6628,6630,6633,6640,6641,6644,6646,6646,6650,6651,6652,6653,6654,6655,6659,6659,6660,6663,6663,6664,6665,6668,6671,6671,6673,6673,6674,6681,6685,6686,6686,6690,6693,6696,6697,6699,6701,6703,6704,6707,6708,6708,6711,6714,6715,6717,6718,6724,6726,6727,6728,6732,6743,6743,6743,6744,6746,6747,6752,6752,6753,6754,6754,6754,6758,6760,6760,6764,6765,6782,6783,6791,6792,6794,6796,6796,6803,6804,6804,6808,6815,6817,6819,6819,6822,6822,6826,6827,6835,6837,6837,6837,6837,6840,6841,6844,6847,6850,6850,6852,6852,6852,6855,6856,6860,6860,6861,6861,6868,6868,6870,6872,6874,6876,6878,6879,6880,6882,6886,6889,6890,6892,6897,6897,6898,6900,6900,6903,6903,6905,6905,6905,6907,6912,6917,6917,6917,6923,6924,6924,6927,6931,6935,6935,6941,6943,6944,6945,6946,6953,6958,6959,6966,6967,6968,6970,6974,6978,6981,6982,6983,6987,6987,6987,6988,6989,6989,6992,6992,6993,6993,6998,7000,7000,7002,7003,7008,7009,7010,7012,7014,7016,7018,7019,7022,7023,7026,7026,7027,7032,7037,7037,7041,7042,7045,7053,7053,7054,7055,7057,7060,7061,7061,7064,7066,7069,7070,7072,7072,7079,7081,7097,7098,7099,7106,7106,7106,7110,7110,7112,7112,7117,7120,7120,7122,7126,7129,7134,7137,7146,7147,7149,7160,7160,7160,7162,7165,7165,7172,7176,7176,7177,7177,7178,7179,7187,7189,7190,7191,7197,7197,7197,7201,7206,7208,7214,7217,7218,7222,7225,7229,7230,7234,7235,7236,7236,7242,7245,7246,7252,7254,7256,7257,7257,7258,7263,7264,7265,7271,7277,7282,7285,7288,7292,7294,7295,7296,7300,7301,7304,7304,7306,7307,7309,7310,7311,7312,7313,7314,7322,7322,7336,7337,7342,7346,7347,7348,7350,7358,7358,7359,7366,7368,7370,7374,7375,7378,7379,7379,7380,7380,7383,7383,7390,7390,7391,7393,7395,7401,7403,7409,7410,7419,7422,7423,7425,7427,7429,7440,7441,7448,7452,7453,7453,7456,7457,7458,7459,7462,7462,7467,7467,7469,7471,7471,7472,7473,7476,7476,7478,7478,7481,7481,7482,7483,7483,7490,7491,7495,7499,7500,7502,7508,7512,7512,7516,7516,7517,7519,7530,7531,7535,7536,7545,7547,7549,7549,7550,7550,7560,7571,7578,7578,7582,7582,7592,7596,7597,7597,7600,7604,7605,7607,7615,7617,7618,7619,7619,7619,7621,7622,7623,7624,7626,7629,7636,7637,7644,7645,7646,7649,7649,7649,7654,7655,7657,7662,7666,7667,7673,7673,7676,7679,7679,7683,7683,7687,7693,7695,7698,7699,7706,7707,7708,7711,7712,7713,7716,7717,7718,7720,7724,7730,7739,7739,7741,7741,7743,7745,7746,7748,7748,7748,7750,7756,7758,7765,7767,7768,7772,7777,7788,7789,7797,7797,7801,7801,7807,7811,7811,7812,7813,7819,7825,7827,7829,7843,7844,7850,7852,7852,7854,7854,7855,7861,7865,7869,7870,7872,7875,7878,7878,7886,7889,7890,7893,7895,7897,7900,7902,7903,7905,7906,7907,7911,7916,7920,7922,7924,7926,7930,7932,7942,7947,7947,7949,7949,7952,7958,7959,7963,7967,7968,7973,7973,7977,7978,7981,7992,7994,7995,7999,8003,8004,8005,8006,8009,8009,8010,8011,8012,8012,8014,8015,8017,8024,8025,8034,8035,8036,8038,8039,8040,8051,8051,8059,8065,8066,8069,8072,8073,8073,8076,8079,8084,8086,8091,8093,8093,8094,8095,8095,8096,8096,8099,8102,8107,8111,8114,8115,8118,8119,8127,8129,8130,8136,8139,8144,8147,8151,8151,8153,8154,8162,8162,8163,8166,8167,8167,8167,8167,8168,8170,8174,8176,8183,8185,8187,8188,8190,8194,8195,8196,8196,8200,8204,8204,8205,8205,8208,8213,8219,8221,8223,8229,8231,8239,8240,8240,8240,8241,8245,8246,8254,8256,8260,8272,8272,8272,8274,8281,8281,8282,8291,8298,8299,8301,8301,8302,8306,8307,8308,8309,8310,8314,8318,8318,8320,8322,8322,8327,8327,8333,8336,8338,8340,8348,8349,8357,8359,8371,8379,8381,8381,8382,8385,8385,8385,8387,8388,8389,8390,8394,8402,8403,8406,8406,8408,8408,8410,8411,8412,8413,8414,8414,8419,8420,8420,8424,8427,8431]
//        879 758
        int[] nums = new int[]{5626, 5627, 5630, 5631, 5633, 5634, 5638, 5639, 5639, 5643, 5651, 5653, 5653, 5653, 5653, 5656, 5657, 5657, 5661, 5673, 5674, 5679, 5685, 5690, 5692, 5694, 5695, 5699, 5700, 5705, 5705, 5711, 5711, 5713, 5714, 5715, 5716, 5717, 5717, 5717, 5720, 5720, 5721, 5724, 5725, 5728, 5729, 5731, 5731, 5731, 5732, 5736, 5738, 5739, 5740, 5742, 5742, 5743, 5747, 5752, 5752, 5759, 5764, 5766, 5767, 5769, 5771, 5773, 5776, 5777, 5779, 5781, 5784, 5788, 5790, 5796, 5799, 5803, 5805, 5806, 5809, 5810, 5815, 5820, 5822, 5822, 5827, 5829, 5832, 5833, 5834, 5839, 5839, 5845, 5846, 5847, 5849, 5850, 5851, 5852, 5855, 5859, 5864, 5865, 5869, 5869, 5875, 5879, 5884, 5885, 5891, 5894, 5895, 5895, 5896, 5896, 5897, 5897, 5900, 5905, 5911, 5913, 5916, 5917, 5921, 5922, 5924, 5926, 5932, 5934, 5935, 5945, 5946, 5951, 5953, 5955, 5956, 5956, 5957, 5958, 5958, 5967, 5967, 5967, 5968, 5969, 5973, 5975, 5976, 5980, 5980, 5982, 5987, 5989, 5994, 5996, 5998, 6002, 6003, 6005, 6014, 6019, 6023, 6027, 6030, 6035, 6036, 6039, 6039, 6043, 6043, 6051, 6051, 6051, 6053, 6054, 6055, 6061, 6064, 6066, 6066, 6068, 6068, 6069, 6072, 6072, 6075, 6075, 6075, 6075, 6077, 6077, 6078, 6079, 6080, 6086, 6088, 6092, 6094, 6095, 6096, 6102, 6109, 6110, 6110, 6111, 6111, 6111, 6116, 6116, 6117, 6122, 6127, 6131, 6133, 6136, 6136, 6137, 6142, 6142, 6142, 6146, 6147, 6148, 6149, 6154, 6154, 6163, 6172, 6175, 6176, 6182, 6183, 6185, 6186, 6190, 6193, 6194, 6201, 6202, 6203, 6208, 6209, 6219, 6220, 6221, 6222, 6224, 6225, 6225, 6225, 6227, 6227, 6230, 6235, 6240, 6243, 6244, 6245, 6246, 6247, 6251, 6254, 6255, 6256, 6260, 6261, 6264, 6265, 6266, 6266, 6267, 6268, 6269, 6270, 6271, 6273, 6279, 6280, 6281, 6282, 6286, 6287, 6287, 6287, 6288, 6289, 6289, 6290, 6291, 6292, 6298, 6300, 6303, 6305, 6313, 6316, 6317, 6318, 6320, 6322, 6328, 6331, 6331, 6334, 6334, 6336, 6336, 6337, 6340, 6347, 6347, 6352, 6355, 6355, 6357, 6361, 6361, 6363, 6366, 6371, 6373, 6374, 6375, 6377, 6380, 6385, 6395, 6395, 6401, 6407, 6413, 6416, 6418, 6419, 6419, 6419, 6420, 6430, 6433, 6435, 6437, 6440, 6440, 6445, 6446, 6449, 6450, 6452, 6452, 6452, 6454, 6455, 6456, 6458, 6462, 6465, 6467, 6469, 6477, 6478, 6483, 6492, 6493, 6494, 6495, 6496, 6497, 6497, 6497, 6498, 6499, 6501, 6503, 6507, 6509, 6510, 6510, 6511, 6511, 6513, 6515, 6518, 6518, 6519, 6519, 6524, 6525, 6526, 6527, 6529, 6535, 6536, 6536, 6543, 6546, 6548, 6552, 6553, 6554, 6555, 6560, 6564, 6565, 6566, 6572, 6574, 6579, 6580, 6583, 6586, 6591, 6599, 6599, 6600, 6605, 6610, 6614, 6614, 6616, 6628, 6630, 6633, 6640, 6641, 6644, 6646, 6646, 6650, 6651, 6652, 6653, 6654, 6655, 6659, 6659, 6660, 6663, 6663, 6664, 6665, 6668, 6671, 6671, 6673, 6673, 6674, 6681, 6685, 6686, 6686, 6690, 6693, 6696, 6697, 6699, 6701, 6703, 6704, 6707, 6708, 6708, 6711, 6714, 6715, 6717, 6718, 6724, 6726, 6727, 6728, 6732, 6743, 6743, 6743, 6744, 6746, 6747, 6752, 6752, 6753, 6754, 6754, 6754, 6758, 6760, 6760, 6764, 6765, 6782, 6783, 6791, 6792, 6794, 6796, 6796, 6803, 6804, 6804, 6808, 6815, 6817, 6819, 6819, 6822, 6822, 6826, 6827, 6835, 6837, 6837, 6837, 6837, 6840, 6841, 6844, 6847, 6850, 6850, 6852, 6852, 6852, 6855, 6856, 6860, 6860, 6861, 6861, 6868, 6868, 6870, 6872, 6874, 6876, 6878, 6879, 6880, 6882, 6886, 6889, 6890, 6892, 6897, 6897, 6898, 6900, 6900, 6903, 6903, 6905, 6905, 6905, 6907, 6912, 6917, 6917, 6917, 6923, 6924, 6924, 6927, 6931, 6935, 6935, 6941, 6943, 6944, 6945, 6946, 6953, 6958, 6959, 6966, 6967, 6968, 6970, 6974, 6978, 6981, 6982, 6983, 6987, 6987, 6987, 6988, 6989, 6989, 6992, 6992, 6993, 6993, 6998, 7000, 7000, 7002, 7003, 7008, 7009, 7010, 7012, 7014, 7016, 7018, 7019, 7022, 7023, 7026, 7026, 7027, 7032, 7037, 7037, 7041, 7042, 7045, 7053, 7053, 7054, 7055, 7057, 7060, 7061, 7061, 7064, 7066, 7069, 7070, 7072, 7072, 7079, 7081, 7097, 7098, 7099, 7106, 7106, 7106, 7110, 7110, 7112, 7112, 7117, 7120, 7120, 7122, 7126, 7129, 7134, 7137, 7146, 7147, 7149, 7160, 7160, 7160, 7162, 7165, 7165, 7172, 7176, 7176, 7177, 7177, 7178, 7179, 7187, 7189, 7190, 7191, 7197, 7197, 7197, 7201, 7206, 7208, 7214, 7217, 7218, 7222, 7225, 7229, 7230, 7234, 7235, 7236, 7236, 7242, 7245, 7246, 7252, 7254, 7256, 7257, 7257, 7258, 7263, 7264, 7265, 7271, 7277, 7282, 7285, 7288, 7292, 7294, 7295, 7296, 7300, 7301, 7304, 7304, 7306, 7307, 7309, 7310, 7311, 7312, 7313, 7314, 7322, 7322, 7336, 7337, 7342, 7346, 7347, 7348, 7350, 7358, 7358, 7359, 7366, 7368, 7370, 7374, 7375, 7378, 7379, 7379, 7380, 7380, 7383, 7383, 7390, 7390, 7391, 7393, 7395, 7401, 7403, 7409, 7410, 7419, 7422, 7423, 7425, 7427, 7429, 7440, 7441, 7448, 7452, 7453, 7453, 7456, 7457, 7458, 7459, 7462, 7462, 7467, 7467, 7469, 7471, 7471, 7472, 7473, 7476, 7476, 7478, 7478, 7481, 7481, 7482, 7483, 7483, 7490, 7491, 7495, 7499, 7500, 7502, 7508, 7512, 7512, 7516, 7516, 7517, 7519, 7530, 7531, 7535, 7536, 7545, 7547, 7549, 7549, 7550, 7550, 7560, 7571, 7578, 7578, 7582, 7582, 7592, 7596, 7597, 7597, 7600, 7604, 7605, 7607, 7615, 7617, 7618, 7619, 7619, 7619, 7621, 7622, 7623, 7624, 7626, 7629, 7636, 7637, 7644, 7645, 7646, 7649, 7649, 7649, 7654, 7655, 7657, 7662, 7666, 7667, 7673, 7673, 7676, 7679, 7679, 7683, 7683, 7687, 7693, 7695, 7698, 7699, 7706, 7707, 7708, 7711, 7712, 7713, 7716, 7717, 7718, 7720, 7724, 7730, 7739, 7739, 7741, 7741, 7743, 7745, 7746, 7748, 7748, 7748, 7750, 7756, 7758, 7765, 7767, 7768, 7772, 7777, 7788, 7789, 7797, 7797, 7801, 7801, 7807, 7811, 7811, 7812, 7813, 7819, 7825, 7827, 7829, 7843, 7844, 7850, 7852, 7852, 7854, 7854, 7855, 7861, 7865, 7869, 7870, 7872, 7875, 7878, 7878, 7886, 7889, 7890, 7893, 7895, 7897, 7900, 7902, 7903, 7905, 7906, 7907, 7911, 7916, 7920, 7922, 7924, 7926, 7930, 7932, 7942, 7947, 7947, 7949, 7949, 7952, 7958, 7959, 7963, 7967, 7968, 7973, 7973, 7977, 7978, 7981, 7992, 7994, 7995, 7999, 8003, 8004, 8005, 8006, 8009, 8009, 8010, 8011, 8012, 8012, 8014, 8015, 8017, 8024, 8025, 8034, 8035, 8036, 8038, 8039, 8040, 8051, 8051, 8059, 8065, 8066, 8069, 8072, 8073, 8073, 8076, 8079, 8084, 8086, 8091, 8093, 8093, 8094, 8095, 8095, 8096, 8096, 8099, 8102, 8107, 8111, 8114, 8115, 8118, 8119, 8127, 8129, 8130, 8136, 8139, 8144, 8147, 8151, 8151, 8153, 8154, 8162, 8162, 8163, 8166, 8167, 8167, 8167, 8167, 8168, 8170, 8174, 8176, 8183, 8185, 8187, 8188, 8190, 8194, 8195, 8196, 8196, 8200, 8204, 8204, 8205, 8205, 8208, 8213, 8219, 8221, 8223, 8229, 8231, 8239, 8240, 8240, 8240, 8241, 8245, 8246, 8254, 8256, 8260, 8272, 8272, 8272, 8274, 8281, 8281, 8282, 8291, 8298, 8299, 8301, 8301, 8302, 8306, 8307, 8308, 8309, 8310, 8314, 8318, 8318, 8320, 8322, 8322, 8327, 8327, 8333, 8336, 8338, 8340, 8348, 8349, 8357, 8359, 8371, 8379, 8381, 8381, 8382, 8385, 8385, 8385, 8387, 8388, 8389, 8390, 8394, 8402, 8403, 8406, 8406, 8408, 8408, 8410, 8411, 8412, 8413, 8414, 8414, 8419, 8420, 8420, 8424, 8427, 8431};
        System.out.println(solution.maximizeWin(nums, 879));
    }
}

class Solution {
    public int maximizeWin(int[] prizePositions, int k) {
        int len = k + 1 + k + 1;
        int res = 0;
        int l = 0;
        int r = 0;
        while (r < prizePositions.length) {
            while (r < prizePositions.length && prizePositions[r] < prizePositions[l] + len) {
                r++;
            }
            res = Math.max(res, r - l);
            l++;
            while (l < prizePositions.length && prizePositions[l] == prizePositions[l - 1]) {
                l++;
            }
        }
        int tempRes = 0;
        len = k + 1;
        l = 0;
        r = 0;
        int[] temp = new int[2];
        while (r < prizePositions.length) {
            while (r < prizePositions.length && prizePositions[r] < prizePositions[l] + len) {
                r++;
            }
            if (tempRes < r - l) {
                tempRes = r - l;
                temp = new int[]{l, r};
            }
            l++;
            while (l < prizePositions.length && prizePositions[l] == prizePositions[l - 1]) {
                l++;
            }
        }
        int tempRes2 = 0;
        len = k + 1;
        l = 0;
        r = 0;
        while (r < prizePositions.length) {
            while (r < prizePositions.length && prizePositions[r] < prizePositions[l] + len) {
                if (r == temp[0]) {
                    r = temp[1] + 1;
                } else {
                    r++;
                }
            }
            if (l < temp[0] && r > temp[1]) {
                tempRes2 = Math.max(tempRes2, r - l - temp[1] - temp[0] + 1);
            } else {
                tempRes2 = Math.max(tempRes2, r - l);
            }
            l++;
            while (l < prizePositions.length && prizePositions[l] == prizePositions[l - 1]) {
                l++;
            }
        }
        return Math.max(res, tempRes + tempRes2);
    }
}