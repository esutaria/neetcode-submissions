// class Solution {

//     public String encode(List<String> strs) {
//         if (strs.size()>0) {
//             String encoded = strs.get(0);
//             for (int i = 1; i < strs.size(); i++) {
//                 encoded += strs.get(i).length();
//                 encoded += "#";
//                 encoded += strs.get(i);
//             }
//             return encoded;
//         }
//         return "";
//     }

//     public List<String> decode(String str) {
//         String[] words = str.split(",");
//         List<String> decoded = new ArrayList<>();
//         for (int j=0; j<words.length; j++) {
//             decoded.add(words[j]);
//         }
//         return decoded;
//     }
// }


class Solution {
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        // CHANGED: Loop over ALL items so the first string gets a length prefix too
        for (String s : strs) {
            encoded.append(s.length()).append('#').append(s);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        int i = 0;
        
        while (i < str.length()) {
            int hashPos = str.indexOf('#', i);
            int length = Integer.parseInt(str.substring(i, hashPos));
            i = hashPos + 1;
            
            decoded.add(str.substring(i, i + length));
            i += length; // CHANGED: Move pointer past the extracted text
        }
        return decoded;
    }
}
