import java.util.*;


public class Autocomplete {
    private Trie root;

    public Autocomplete() {
        root = new Trie(' ');
    }

    public List finish(String input) {
        Trie end = root;

        for (int j = 0; j < input.length(); j++) {
            end = end.getChild(input.charAt(j));
            if (end == null) {
                return new ArrayList();
            }
        }
        return end.getWords();
    }

    public boolean find(String word) {
        Trie loc = root;

        for (char n : word.toCharArray()) {
            if (loc.getChild(n) == null) {
                return false;
            } else {
                loc = loc.getChild(n);
            }
        }
        return loc.end;
    }


    public void place(String word) {
        if (find(word))
            return;

        Trie loc = root;
        Trie pre;

        for (char n : word.toCharArray()) {
            pre = loc;
            Trie child = loc.getChild(n);

            if (!(child == null)) {
                loc = child;
                child.parent = pre;
            } else {
                loc.child.add(new Trie(n));
                loc = loc.getChild(n);
                loc.parent = pre;
            }
        }
        loc.end = true;
    }
}
