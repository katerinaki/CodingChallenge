import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by karetaki on 2019-07-28.
 */
public class TopThreeWordsCalculatorTest {

    private TopThreeWordsCalculator topThreeWordsCalculator = new TopThreeWordsCalculator();

    @Test
    public void testTextWithLineBreaks()
    {
        String[] result = topThreeWordsCalculator.identifyThreeMostOccurringWords("In a village of La Mancha, the name of which I have no desire to call to\n" +
                "mind, there lived not long since one of those gentlemen that keep a lance\n" +
                "in the lance-rack, an old buckler, a lean hack, and a greyhound for\n" +
                "coursing. An olla of rather more beef than mutton, a salad on most\n" +
                "nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra\n" +
                "on Sundays, made away with three-quarters of his income.");
        assertArrayEquals(new String[]{"a", "of", "on"}, result);
    }

    @Test
    public void testTextWithColonCharacter()
    {
        String[] result = topThreeWordsCalculator.identifyThreeMostOccurringWords(" e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e");
        assertArrayEquals(new String[]{"e", "ddd", "aa"}, result);
    }

    @Test
    public void testTextWithApostrofesAndSlashes()
    {
        String[] result = topThreeWordsCalculator.identifyThreeMostOccurringWords("  //wont won't won't");
        assertArrayEquals(new String[]{"won't", "wont"}, result);
    }

    @Test
    public void testSingleApostrofeText()
    {
        String[] result = topThreeWordsCalculator.identifyThreeMostOccurringWords(" ' ");
        assertEquals(0, result.length);
    }

    @Test
    public void testApostrofesOnlyText()
    {
        String[] result = topThreeWordsCalculator.identifyThreeMostOccurringWords(" ''' ");
        assertEquals(0, result.length);
    }

    @Test
    public void testEmptyText()
    {
        String[] result = topThreeWordsCalculator.identifyThreeMostOccurringWords("");
        assertEquals(0, result.length);
    }

    @Test
    public void testNullText()
    {
        String[] result = topThreeWordsCalculator.identifyThreeMostOccurringWords(null);
        assertEquals(0, result.length);
    }

}
