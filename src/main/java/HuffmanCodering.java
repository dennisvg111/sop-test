import java.util.*;

public class HuffmanCodering {

    static Map<Character, String> codes = new HashMap<>();
    static HuffKnoop boom = null;

    public static void main(String[] args) {
        //Convert het woord naar chars
        String woord = "bananen";
        ArrayList<Character> chars = new ArrayList<>();
        ArrayList<HuffKnoop> knopen = new ArrayList<>();
        for (int i = 0; i < woord.length(); i++) {
            chars.add(woord.charAt(i));
        }

        //1. Frequentie van tekens
        Set<Character> uniqueChars = new HashSet<>(chars);
        for (char c : uniqueChars) {
            knopen.add(new HuffKnoop(c, Collections.frequency(chars, c), null, null));
        }

        //2. Sorteer de tekens op frequentie
        PriorityQueue queue = new PriorityQueue(uniqueChars.size(), new Comparator<HuffKnoop>() {
            @Override
            public int compare(HuffKnoop o1, HuffKnoop o2) {
                return o1.frequentie - o2.frequentie;
            }
        });

        for (HuffKnoop knoop : knopen) {
            queue.add(knoop);
        }

        //3. Maken van de huffman boom.
        while (queue.size() > 1) {
            HuffKnoop knoopLinks = (HuffKnoop) queue.poll();
            HuffKnoop knoopRechts = (HuffKnoop) queue.poll();
            queue.add(new HuffKnoop('\0', knoopLinks.frequentie + knoopRechts.frequentie, knoopLinks, knoopRechts));
        }

        //4. Aflezen van de codes
        boom = (HuffKnoop) queue.poll();
        generateCodes(boom, "");

        Iterator it = codes.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            System.out.println(pair.getKey() + " " + pair.getValue());
        }

        //5. Coderen
        String encodedMessage = encodeMessage(woord);
        System.out.println(encodedMessage);

        //6. Decoderen
        String decodedMessage = decodeMessage(encodedMessage);
        System.out.println(decodedMessage);
    }

    public static void generateCodes(HuffKnoop knoop, String code) {
        if (knoop.leftChild == null && knoop.rightChild == null) {
            codes.put(knoop.karakter, code);
            return;
        }

        generateCodes(knoop.leftChild, code + '0');
        generateCodes(knoop.rightChild, code + '1');
    }

    public static String encodeMessage(String woord) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < woord.length(); i++) {
            sb.append(codes.get(woord.charAt(i)));
        }

        return sb.toString();
    }

    public static String decodeMessage(String encodedMessage) {
        StringBuilder sb = new StringBuilder();
        HuffKnoop temp = boom;
        for (int i = 0; i < encodedMessage.length(); i++) {
            if (encodedMessage.charAt(i) == '0') {
                temp = temp.leftChild;
                if (temp.leftChild == null && temp.rightChild == null) {
                    sb.append(temp.karakter);
                    temp = boom;
                }
            } else {
                temp = temp.rightChild;
                if (temp.leftChild == null && temp.rightChild == null) {
                    sb.append(temp.karakter);
                    temp = boom;
                }
            }
        }

        return sb.toString();

    }

}