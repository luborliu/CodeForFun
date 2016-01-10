package leetcode.week4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q187RepeatedDNASequences {
	
	public List<String> findRepeatedDnaSequences(String s) {
        //first idea is to use HashMap<String, # of appearance>
        //then a genius idea from hottest discussion appears.....
        //instead of using 10-char string as key of hashmap, we will use a number to encode the strings
        //00->A
        //01->C
        //10->G
        //11->T
        //ACGT->00011011
        
        Set<Integer> allSet = new HashSet<Integer>();
        Set<Integer> doubleSet = new HashSet<Integer>();
        List<String> result = new ArrayList<String>();
        //with following mapping array, the time optimized to 39ms
        int[] map = new int['T'-'A'+1];
        //map['A'-'A'] = 0;
        map['C'-'A'] = 1;
        map['G'-'A'] = 2;
        map['T'-'A'] = 3;
        
            
        for(int i=0; i<s.length()-9; i++) {
            int code = 0;
            for(int j=i; j<i+10; j++) {
               code <<= 2;
               code |= map[s.charAt(j)-'A'];
               //char c = s.charAt(j);
               //the following will do comparison 4 times, time is 51ms, that's why we use a map array  
            //   if(c=='A') code |= 0;
            //   else if(c=='C') code |= 1;
            //   else if(c=='G') code |= 2;
            //   else if(c=='T') code |= 3;
            }
            if(!allSet.add(code)&&doubleSet.add(code)) result.add(s.substring(i,i+10));
        }
        return result;
    }
	
	public List<String> findRepeatedDnaSequences2(String s) {
        //first idea is to use HashMap<String, # of appearance>
        //then a genius idea from hottest discussion appears.....
        //instead of using 10-char string as key of hashmap, we will use a number to encode the strings
        //00->A
        //01->C
        //10->G
        //11->T
        //ACGT->00011011
        
        Set<Integer> allSet = new HashSet<Integer>();
        Set<Integer> doubleSet = new HashSet<Integer>();
        List<String> result = new ArrayList<String>();
        
        
        for(int i=0; i<s.length()-9; i++) {
            int code = 0;
            for(int j=i; j<i+10; j++) {
               code <<= 2;
               char c = s.charAt(j);
               //the following will do comparison 4 times, time is 51ms, that's why we use a map array  
               if(c=='A') code |= 0;
               else if(c=='C') code |= 1;
               else if(c=='G') code |= 2;
               else if(c=='T') code |= 3;
            }
            if(!allSet.add(code)&&doubleSet.add(code)) result.add(s.substring(i,i+10));
        }
        return result;
    }

}
