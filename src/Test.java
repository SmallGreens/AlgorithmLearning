import Sorting.*;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        // 生成一个随机数组，长度为1000
//        int[] arr = new int[1000];
//        for(int i = 0; i < 1000; i++){
//            arr[i] = (int)(Math.random()*10000);
//        }

        int[] arr = new int[]{325, 25, 281, 366, 520, 408, 146, 510, 835, 245, 758, 619, 52, 524, 990, 540, 792, 73, 473, 969, 106,
                644, 656, 753, 256, 255, 451, 983, 989, 664, 1, 442, 527, 959, 35, 712, 664, 904, 940, 34, 801, 868, 168, 859, 509,
                853, 844, 846, 201, 408, 460, 976, 813, 977, 372, 347, 963, 529, 401, 185, 912, 165, 213, 537, 812, 762, 318, 192, 126,
                616, 461, 336, 818, 466, 906, 586, 914, 256, 592, 109, 259, 479, 459, 680, 897, 972, 269, 702, 283, 590, 120, 398, 669,
                258, 450, 619, 406, 552, 771, 966, 546, 68, 515, 221, 121, 551, 395, 400, 674, 953, 388, 80, 164, 336, 14, 65, 146, 802,
                879, 850, 213, 457, 550, 779, 47, 736, 715, 309, 66, 282, 210, 248, 580, 994, 986, 430, 570, 756, 234, 813, 688, 860, 974,
                620, 849, 84, 112, 771, 829, 959, 594, 499, 608, 773, 612, 777, 818, 474, 911, 863, 546, 738, 225, 79, 890, 122, 466, 687,
                174, 406, 860, 577, 399, 933, 376, 315, 568, 5, 907, 989, 815, 164, 432, 214, 827, 491, 988, 595, 924, 906, 672, 911, 306,
                793, 29, 337, 390, 206, 146, 996, 869, 320, 465, 268, 101, 762, 848, 332, 727, 937, 702, 603, 937, 524, 37, 831, 635, 819,
                170, 886, 900, 742, 425, 436, 476, 906, 570, 9, 740, 306, 943, 195, 535, 886, 159, 110, 494, 418, 71, 534, 981, 899, 174,
                582, 613, 937, 945, 133, 350, 398, 742, 715, 563, 937, 715, 17, 66, 874, 875, 704, 83, 323, 887, 746, 280, 366, 387, 56, 492,
                547, 600, 833, 563, 967, 851, 619, 714, 751, 89, 775, 246, 753, 926, 758, 937, 912, 779, 307, 429, 834, 655, 423, 48, 781, 754,
                787, 954, 462, 592, 120, 275, 711, 556, 810, 872, 398, 842, 24, 683, 673, 560, 454, 198, 970, 366, 757, 435, 23, 363, 775, 972,
                510, 160, 572, 982, 855, 950, 430, 932, 132, 135, 950, 598, 990, 578, 565, 314, 12, 812, 866, 901, 920, 612, 332, 584, 641, 176,
                227, 291, 281, 793, 684, 119, 720, 279, 231, 454, 660, 646, 308, 134, 650, 452, 663, 344, 820, 13, 836, 385, 810, 212, 365, 305,
                635, 928, 712, 436, 52, 223, 405, 240, 322, 302, 335, 523, 120, 893, 669, 989, 778, 160, 372, 301, 923, 476, 919, 331, 91, 369,
                356, 9, 856, 755, 533, 259, 536, 119, 957, 835, 620, 670, 457, 447, 626, 595, 545, 527, 212, 477, 112, 68, 42, 589, 940, 520, 49,
                298, 254, 369, 492, 5, 461, 125, 401, 141, 63, 671, 828, 492, 663, 564, 581, 765, 936, 692, 988, 674, 385, 875, 590, 955, 759, 367,
                568, 700, 995, 993, 138, 84, 660, 563, 102, 82, 955, 526, 257, 42, 476, 359, 360, 52, 87, 6, 931, 884, 476, 795, 237, 906, 168, 676,
                442, 799, 50, 252, 39, 54, 732, 72, 368, 240, 407, 869, 240, 756, 216, 940, 426, 320, 509, 672, 30, 767, 813, 294, 611, 817, 756, 301,
                204, 349, 679, 618, 303, 385, 179, 521, 233, 398, 357, 521, 303, 827, 132, 902, 558, 628, 560, 375, 975, 514, 757, 356, 444, 70, 680,
                711, 948, 309, 701, 408, 945, 320, 666, 422, 53, 592, 864, 398, 810, 293, 134, 51, 456, 223, 160, 991, 383, 436, 847, 699, 163, 558, 564,
                674, 823, 622, 950, 336, 344, 854, 932, 149, 209, 215, 570, 562, 171, 658, 362, 778, 342, 4, 681, 89, 101, 43, 86, 480, 313, 4, 348, 480,
                812, 768, 167, 773, 159, 322, 737, 948, 212, 729, 477, 824, 156, 584, 515, 224, 233, 281, 737, 714, 593, 626, 523, 801, 338, 302, 607, 293,
                66, 437, 848, 74, 940, 63, 86, 303, 624, 561, 674, 173, 166, 287, 718, 677, 330, 451, 539, 517, 666, 971, 374, 169, 56, 475, 884, 372, 406,
                828, 595, 730, 567, 569, 11, 959, 634, 443, 764, 285, 226, 735, 839, 883, 460, 499, 602, 830, 879, 883, 85, 934, 746, 652, 750, 2, 733, 717,
                740, 525, 244, 929, 433, 528, 300, 658, 990, 323, 172, 721, 463, 227, 717, 3, 929, 848, 674, 740, 90, 462, 19, 814, 729, 70, 851, 517, 445,
                213, 165, 254, 113, 299, 309, 308, 586, 166, 897, 332, 284, 905, 406, 496, 400, 495, 750, 292, 679, 632, 656, 833, 863, 241, 761, 116, 173,
                574, 963, 129, 413, 439, 716, 857, 619, 72, 637, 230, 440, 420, 989, 786, 853, 72, 384, 382, 145, 931, 286, 564, 538, 743, 709, 335, 277, 1,
                876, 919, 474, 372, 414, 773, 497, 693, 109, 551, 270, 835, 155, 931, 372, 168, 293, 228, 476, 168, 227, 486, 255, 720, 250, 315, 589, 36,
                27, 81, 565, 680, 117, 183, 534, 119, 893, 60, 196, 360, 201, 246, 516, 715, 249, 289, 83, 449, 963, 576, 359, 92, 252, 136, 173, 508, 441,
                341, 726, 358, 387, 970, 292, 492, 686, 520, 832, 917, 694, 778, 679, 440, 20, 624, 548, 756, 572, 738, 180, 762, 182, 401, 1, 138, 354, 856,
                366, 770, 687, 743, 73, 451, 86, 10, 60, 363, 959, 262, 412, 275, 216, 995, 56, 39, 47, 271, 843, 934, 111, 429, 999, 631, 8, 131, 299, 83, 626,
                596, 714, 430, 254, 189, 659, 97, 131, 602, 462, 611, 448, 789, 116, 321, 716, 414, 893, 115, 746, 63, 963, 439, 500, 651, 689, 401, 466, 486,
                913, 522, 238, 211, 158, 728, 502, 418, 340, 523, 672, 86, 284, 877, 30, 92, 70, 265, 310, 970, 977, 469, 348, 794, 600, 195, 583, 491, 537,
                300, 898, 186, 870, 456, 565, 182, 587, 337, 790, 3, 972, 45, 699, 528, 961, 302, 407, 601, 422, 108, 222, 689, 333, 990, 884, 68, 880, 636,
                226, 753, 553, 744, 551, 889, 432, 128, 556, 603, 979, 734, 640, 361, 833, 972, 974, 758, 282, 962, 834, 252, 323, 607, 287, 785, 492, 145,
                465, 426, 903};
        // 冒泡排序
        //Sort s = new BubbleSort();
        // Sort s = new SimpleSelection();
       // Sort s = new SimpleInsertSort();
        //Sort s = new ShellSort();
//        Sort s = new HeapSort();
        Sort s = new MergeSort();
        s.sort(arr);

        // 判断数组是否正确排序
        boolean isSorted = true;
        int[] arr1 = Arrays.copyOf(arr,1000);
        Arrays.sort(arr1);
        for(int i = 0; i < arr.length; i++){
            if (arr[i] != arr1[i]) {
                isSorted = false;
                break;
            }
        }

        System.out.println(Arrays.toString(arr));
        System.out.println("The array is sorted: " + isSorted);
        System.out.println("Arrays' length is: " + arr.length);
        System.out.println("CompareTimes is: " + s.compareTimes);
        System.out.println("SwapTimes is: " + s.swapTimes);
    }
}
