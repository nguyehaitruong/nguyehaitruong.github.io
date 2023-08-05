344. Reverse String
class Solution {
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[start + i];
            s[start + i] = s[end - i];
            s[end - i] = temp;
        }
    }
}
1816. Truncate Sentence
class Solution {
    public String truncateSentence(String s, int k) {
          String[] words = s.split(" ");

        StringBuilder truncatedSentence = new StringBuilder();
        for (int i = 0; i < k; i++) {
            truncatedSentence.append(words[i]).append(" ");
        }

     
        return truncatedSentence.toString().trim();
        
    }
}

1662. Check If Two String Arrays are Equivalent
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
         StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < word1.length; i++) {
            sb1.append(word1[i]);
        }

        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < word2.length; i++) {
            sb2.append(word2[i]);
        }

        return sb1.toString().equals(sb2.toString());
    }
}
387. First Unique Character in a String
class Solution {
    public int firstUniqChar(String s) {
         int[] charCount = new int[256]; 
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charCount[c]++;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charCount[c] == 1) {
                return i;
            }
        }

        return -1; 
    }
        
    }

1662. Check If Two String Arrays are Equivalent
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
         StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < word1.length; i++) {
            sb1.append(word1[i]);
        }

        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < word2.length; i++) {
            sb2.append(word2[i]);
        }

        return sb1.toString().equals(sb2.toString());
    }
}
1221. Split a String in Balanced Strings
class Solution {
    public int balancedStringSplit(String s) {
  
     int ans = 0, count = 0;
     char[] arr = s.toCharArray();

     for (char c : arr) {
         if (c == 'R') {
             count++;
         } else {
             count--;
         }

         if (count == 0) {
             ans++;
         }
     }

     return ans;
 }
    }
