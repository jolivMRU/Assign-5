import java.util.*;
/**
 * Class that holds the string of a given subsequence
 * 
 * @author Joseph Oliva
 * 
 */
public class Kmer
{
    String subsequence;
    public Kmer (String subsequence)
    {
        this.subsequence = subsequence;
    }

    public int hashCode()
    {
        return subsequence.hashCode();
    }
}
