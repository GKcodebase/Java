package CheatSheet.DataStructure;

/**
 * The Pair.
 *
 * @param <F> the type parameter
 * @param <S> the type parameter
 */
public class Pair<F, S> {
    /**
     * The First.
     */
    F first;
    /**
     * The Second.
     */
    S second;

    /**
     * Instantiates a new Pair.
     *
     * @param first  the first
     * @param second the second
     */
    Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }
}
