package elementory.sorting;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    19/06/18
 * Time:    1:52 AM
 * @noinspection ALL
 */
public class MergeSort {

  private  Comparable [] aux ;
  public  void sort(Comparable [] a) {
    aux = new Comparable[a.length];
    sort(a,0,a.length-1);
  }

  private  void sort(Comparable a[],int lo, int  hi){
    if(hi <= lo) return;
    int mid = lo + (hi -lo)/2 ;
    sort(a,lo,mid);
    sort(a,mid+1, hi);
    
    merge(a,aux,lo,mid,hi);

  }

  private  void merge(Comparable a[],Comparable [] aux,int lo , int mid, int hi ){
    assert  isSorted(a, lo,mid);
    assert  isSorted(a, mid+1,hi);

    for(int i =lo; i <=hi; i++) {
      aux[i] = a[i];
    }

    int i = lo, j = mid+1;
    for(int k =lo; k<=hi; k++){
      if( i > mid) a[k] = aux[j++];
      else if ( j > hi) a[k] = aux [i++];
      else if(less(aux[i],aux[j])) a[k] = aux[i++];
      else a[k] = aux[j++];

    }

  assert  isSorted(a, lo,hi);
  }

  public boolean less(Comparable v, Comparable w){
    return v.compareTo(w) < 0;
  }

  public boolean isSorted(Comparable a[], int lo ,int hi){
    for (int i = 0; i < a.length-1 ; i++) {
        if(less(a[i+1] , a[i])) return false;
    }
    return true;
  }

  public  static  void  main(String [] args) {
//    Comparable a [] = {21,45,11,01,13,55,90,32};
//    MergeSort ms = new MergeSort();
//    ms.sort(a);
	  String s = "user_activity_brand_6296, user_activity_brand_1, user_activity_brand_7818, user_activity_brand_7928, user_activity_brand_7882, user_activity_brand_6315, user_activity_brand_7897, user_activity_brand_7902, user_activity_brand_8005, user_activity_brand_6350, user_activity_brand_7898, user_activity_brand_6328, user_activity_brand_6223, user_activity_brand_8020, user_activity_brand_6386, user_activity_brand_7816, user_activity_brand_6278, user_activity_brand_7894_4, user_activity_brand_6323, user_activity_brand_6283, user_activity_brand_6311, user_activity_brand_6353, user_activity_brand_6251, user_activity_brand_203, user_activity_brand_1078, user_activity_brand_7878, user_activity_brand_7948, user_activity_brand_192, user_activity_brand_123, user_activity_brand_6066, user_activity_brand_6282, user_activity_brand_1100, user_activity_brand_6309, user_activity_brand_6475, user_activity_brand_7824, user_activity_brand_7892, user_activity_brand_8028_4, user_activity_brand_334, user_activity_brand_7883, user_activity_brand_6388, user_activity_brand_6235, user_activity_brand_8026, user_activity_brand_6344, user_activity_brand_7947_4, user_activity_brand_6620, user_activity_brand_3512, user_activity_brand_7604, user_activity_brand_1630, user_activity_brand_7810, user_activity_brand_404, user_activity_brand_6252, user_activity_brand_7949, user_activity_brand_6351, user_activity_brand_6280, user_activity_brand_8009, user_activity_brand_6336, user_activity_brand_6338, user_activity_brand_7937, user_activity_brand_8023, user_activity_brand_6342, user_activity_brand_8019_4, user_activity_brand_7909, user_activity_brand_7992, user_activity_brand_7046, user_activity_brand_6265, user_activity_brand_6337, user_activity_brand_7879, user_activity_brand_6250, user_activity_brand_7880, user_activity_brand_7982, user_activity_brand_6369, user_activity_brand_7935, user_activity_brand_7986, user_activity_brand_7815, user_activity_brand_6292, user_activity_brand_7931, user_activity_brand_7979, user_activity_brand_7881, user_activity_brand_6335, user_activity_brand_7950, user_activity_brand_8007, user_activity_brand_1627, user_activity_brand_7872, user_activity_brand_8017_4, user_activity_brand_7809, user_activity_brand_7923, user_activity_brand_7994, user_activity_brand_6296_4, user_activity_brand_7927, user_activity_brand_7995, user_activity_brand_8010, user_activity_brand_8006, user_activity_brand_7917, user_activity_brand_7887, user_activity_brand_7254, user_activity_brand_8000, user_activity_brand_6316, user_activity_brand_7889, user_activity_brand_6347, user_activity_brand_272, user_activity_brand_176, user_activity_brand_8013, user_activity_brand_8025, user_activity_brand_6348, user_activity_brand_7999, user_activity_brand_6324, user_activity_brand_8012, user_activity_brand_7873, user_activity_brand_6340, user_activity_brand_6304, user_activity_brand_7888, user_activity_brand_348, user_activity_brand_6166, user_activity_brand_7896, user_activity_brand_210, user_activity_brand_7877, user_activity_brand_6333, user_activity_brand_365, user_activity_brand_7828, user_activity_brand_7102, user_activity_brand_7947, user_activity_brand_74, user_activity_brand_6260, user_activity_brand_8024, user_activity_brand_6312, user_activity_brand_6349, user_activity_brand_6320, user_activity_brand_7993, user_activity_brand_6370, user_activity_brand_6221_4, user_activity_brand_7886, user_activity_brand_7903, user_activity_brand_7990, user_activity_brand_8004, user_activity_brand_8015, user_activity_brand_6181, user_activity_brand_7908, user_activity_brand_7885, user_activity_brand_6343, user_activity_brand_6940, user_activity_brand_7941, user_activity_brand_8014, user_activity_brand_254, user_activity_brand_7820, user_activity_brand_7914, user_activity_brand_7919, user_activity_brand_6319, user_activity_brand_7940, user_activity_brand_6305, user_activity_brand_800, user_activity_brand_8017, user_activity_brand_8022, user_activity_brand_6387, user_activity_brand_8011_4, user_activity_brand_216, user_activity_brand_7894, user_activity_brand_6287, user_activity_brand_7819, user_activity_brand_6345, user_activity_brand_111, user_activity_brand_6326, user_activity_brand_6248, user_activity_brand_7890, user_activity_brand_269, user_activity_brand_7933, user_activity_brand_7943, user_activity_brand_8011, user_activity_brand_7985, user_activity_brand_8001, user_activity_brand_7905, user_activity_brand_6331, user_activity_brand_6327, user_activity_brand_6273, user_activity_brand_7934, user_activity_brand_129, user_activity_brand_7065, user_activity_brand_8, user_activity_brand_7900, user_activity_brand_6264, user_activity_brand_8016, user_activity_brand_6921, user_activity_brand_7924, user_activity_brand_7103, user_activity_brand_8019, user_activity_brand_7946, user_activity_brand_51, user_activity_brand_7906, user_activity_brand_7895, user_activity_brand_7932, user_activity_brand_6384, user_activity_brand_7827, user_activity_brand_6277, user_activity_brand_6390, user_activity_brand_8028, user_activity_brand_8027, user_activity_brand_6221, user_activity_brand_7930, user_activity_brand_7891, user_activity_brand_244, user_activity_brand_8008, user_activity_brand_7918, user_activity_brand_6385, user_activity_brand_7996, user_activity_brand_6321, user_activity_brand_7884, user_activity_brand_7981, user_activity_brand_6289, user_activity_brand_7822, user_activity_brand_7871";;
//	  String s =  "user_activity_brand_8029 ,user_activity_brand_6296 ,user_activity_brand_1 ,user_activity_brand_7818 ,user_activity_brand_7928 ,user_activity_brand_7882 ,user_activity_brand_6315 ,user_activity_brand_7897 ,user_activity_brand_7902 ,user_activity_brand_8005 ,user_activity_brand_6350 ,user_activity_brand_7898 ,user_activity_brand_6328 ,user_activity_brand_8037 ,user_activity_brand_6223 ,user_activity_brand_8020 ,user_activity_brand_6386 ,user_activity_brand_8032 ,user_activity_brand_7816 ,user_activity_brand_6278 ,user_activity_brand_7894_4 ,user_activity_brand_6323 ,user_activity_brand_6283 ,user_activity_brand_6311 ,user_activity_brand_6353 ,user_activity_brand_6251 ,user_activity_brand_203 ,user_activity_brand_1078 ,user_activity_brand_7878 ,user_activity_brand_7948 ,user_activity_brand_192 ,user_activity_brand_123 ,user_activity_brand_6066 ,user_activity_brand_6282 ,user_activity_brand_1100 ,user_activity_brand_6309 ,user_activity_brand_6475 ,user_activity_brand_7824 ,user_activity_brand_7892 ,user_activity_brand_8028_4 ,user_activity_brand_334 ,user_activity_brand_7883 ,user_activity_brand_6388 ,user_activity_brand_6235 ,user_activity_brand_8026 ,user_activity_brand_6344 ,user_activity_brand_7947_4 ,user_activity_brand_6620 ,user_activity_brand_3512 ,user_activity_brand_7604 ,user_activity_brand_1630 ,user_activity_brand_7810 ,user_activity_brand_404 ,user_activity_brand_6252 ,user_activity_brand_7949 ,user_activity_brand_8030 ,user_activity_brand_6351 ,user_activity_brand_6280 ,user_activity_brand_8009 ,user_activity_brand_6336 ,user_activity_brand_6338 ,user_activity_brand_7937 ,user_activity_brand_8023 ,user_activity_brand_6342 ,user_activity_brand_8019_4 ,user_activity_brand_7909 ,user_activity_brand_7992 ,user_activity_brand_7046 ,user_activity_brand_6265 ,user_activity_brand_6337 ,user_activity_brand_7879 ,user_activity_brand_6250 ,user_activity_brand_7880 ,user_activity_brand_7982 ,user_activity_brand_6369 ,user_activity_brand_7935 ,user_activity_brand_7986 ,user_activity_brand_7815 ,user_activity_brand_6292 ,user_activity_brand_7931 ,user_activity_brand_7979 ,user_activity_brand_7881 ,user_activity_brand_6335 ,user_activity_brand_7950 ,user_activity_brand_8007 ,user_activity_brand_1627 ,user_activity_brand_7872 ,user_activity_brand_8017_4 ,user_activity_brand_7809 ,user_activity_brand_7923 ,user_activity_brand_7994 ,user_activity_brand_6296_4 ,user_activity_brand_7927 ,user_activity_brand_7995 ,user_activity_brand_8010 ,user_activity_brand_8006 ,user_activity_brand_7917 ,user_activity_brand_7887 ,user_activity_brand_7254 ,user_activity_brand_8033 ,user_activity_brand_8000 ,user_activity_brand_8030_4 ,user_activity_brand_6316 ,user_activity_brand_7889 ,user_activity_brand_6347 ,user_activity_brand_272 ,user_activity_brand_176 ,user_activity_brand_8013 ,user_activity_brand_8025 ,user_activity_brand_6348 ,user_activity_brand_7999 ,user_activity_brand_6324 ,user_activity_brand_8012 ,user_activity_brand_7873 ,user_activity_brand_6340 ,user_activity_brand_6304 ,user_activity_brand_7888 ,user_activity_brand_348 ,user_activity_brand_6166 ,user_activity_brand_8036 ,user_activity_brand_7896 ,user_activity_brand_210 ,user_activity_brand_7877 ,user_activity_brand_6333 ,user_activity_brand_365 ,user_activity_brand_7828 ,user_activity_brand_7102 ,user_activity_brand_7947 ,user_activity_brand_74 ,user_activity_brand_6260 ,user_activity_brand_8024 ,user_activity_brand_6312 ,user_activity_brand_6349 ,user_activity_brand_6320 ,user_activity_brand_7993 ,user_activity_brand_6370 ,user_activity_brand_6221_4 ,user_activity_brand_7886 ,user_activity_brand_7903 ,user_activity_brand_7990 ,user_activity_brand_8004 ,user_activity_brand_8015 ,user_activity_brand_6181 ,user_activity_brand_7908 ,user_activity_brand_7885 ,user_activity_brand_6343 ,user_activity_brand_6940 ,user_activity_brand_7941 ,user_activity_brand_8014 ,user_activity_brand_254 ,user_activity_brand_7820 ,user_activity_brand_7914 ,user_activity_brand_7919 ,user_activity_brand_6319 ,user_activity_brand_7940 ,user_activity_brand_6305 ,user_activity_brand_800 ,user_activity_brand_8017 ,user_activity_brand_8022 ,user_activity_brand_6387 ,user_activity_brand_8011_4 ,user_activity_brand_216 ,user_activity_brand_7894 ,user_activity_brand_6287 ,user_activity_brand_7819 ,user_activity_brand_8031 ,user_activity_brand_6345 ,user_activity_brand_111 ,user_activity_brand_6326 ,user_activity_brand_6248 ,user_activity_brand_7890 ,user_activity_brand_269 ,user_activity_brand_7933 ,user_activity_brand_7943 ,user_activity_brand_8011 ,user_activity_brand_7985 ,user_activity_brand_8001 ,user_activity_brand_7905 ,user_activity_brand_6331 ,user_activity_brand_6327 ,user_activity_brand_6273 ,user_activity_brand_7934 ,user_activity_brand_129 ,user_activity_brand_7065 ,user_activity_brand_8 ,user_activity_brand_7900 ,user_activity_brand_6264 ,user_activity_brand_8016 ,user_activity_brand_6921 ,user_activity_brand_7924 ,user_activity_brand_7103 ,user_activity_brand_8019 ,user_activity_brand_7946 ,user_activity_brand_51 ,user_activity_brand_7906 ,user_activity_brand_7895 ,user_activity_brand_7932 ,user_activity_brand_6384 ,user_activity_brand_7827 ,user_activity_brand_6277 ,user_activity_brand_6390 ,user_activity_brand_8028 ,user_activity_brand_8027 ,user_activity_brand_6221 ,user_activity_brand_7930 ,user_activity_brand_7891 ,user_activity_brand_244 ,user_activity_brand_8008 ,user_activity_brand_7918 ,user_activity_brand_6385 ,user_activity_brand_7996 ,user_activity_brand_6321 ,user_activity_brand_7884 ,user_activity_brand_7981 ,user_activity_brand_8035 ,user_activity_brand_6289 ,user_activity_brand_7822 ,user_activity_brand_7871 ";
	  String [] keys = s.split(",");
	  System.out.println(keys.length);
  }

}
