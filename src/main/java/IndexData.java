import java.util.List;

public class IndexData {
    private List<String> index;
    private int unkownWords;

    public IndexData(List<String> index, int unkownWords) {
        this.index = index;
        this.unkownWords = unkownWords;
    }

    public List<String> getIndex() {
        return index;
    }

    public int getUnkownWords() {
        return unkownWords;
    }
}
