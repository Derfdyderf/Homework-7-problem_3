import java.util.*;


public class Trie {
    char letter;
    LinkedList<Trie> child;
    boolean end;
    Trie parent;

    public Trie(char n) {
        letter = n;
        child = new LinkedList<Trie>();
        end = false;
    }

    public List<String> getWords() {
        List<String> list = new ArrayList<>();
        if (end)
            list.add(toString());

        if (!(child == null)) {
            for (Trie trie : child) {
                if (!(trie == null))
                    list.addAll(trie.getWords());
            }
        }
        return list;

    }

    public String toString() {

        if (parent == null)
            return "";
        else
            return parent.toString() + new String(new char[] {letter});
    }

    public Trie getChild(char n) {
        if (!(child == null)) {
            for (Trie children : child) {
                if (children.letter == n) {
                    return children;
                }
            }
        }
        return null;
    }


}
