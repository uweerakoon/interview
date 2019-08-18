package Wayfair;

public class StrStr {

  public int strStr(String haystack, String needle) {
    int n = needle.length();
    int m = haystack.length();
    if(m < n) return -1;
    if(n == 0) return 0;
    for(int i=0;i<=m-n;++i){
      if((haystack.substring(i,i+n)).equals(needle))
        return i;
    }
    return -1;
    // return haystack.indexOf(needle);
  }
}
