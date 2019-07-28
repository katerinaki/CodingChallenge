import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by karetaki on 2019-07-28.
 */
public class TopThreeWordsCalculator {

    public String[] identifyThreeMostOccurringWords(final String text)
    {
        if (StringUtils.isBlank(text))
        {
            return new String[0];
        }
        // Map that has as key the word and as value the number of occurrences
        HashMap<String,Integer> occurrencesMap = new HashMap();
        int index =0;
        while(index < text.length()){
            StringBuilder wordBuilder = new StringBuilder();
            while ((index < text.length() ) && (Character.isLetter(text.charAt(index)))){
                wordBuilder.append(Character.toLowerCase(text.charAt(index)));
                index++;
                if (index < text.length() && text.charAt(index) == 39)
                {
                    wordBuilder.append(Character.toLowerCase(text.charAt(index)));
                    index ++;
                    if (index < text.length() && Character.isLetter(text.charAt(index)))
                    {
                        wordBuilder.append(Character.toLowerCase(text.charAt(index)));
                        index ++;
                    }
                }
            }
            if (wordBuilder.length() != 0){
                String word = wordBuilder.toString();
                if (!occurrencesMap.containsKey(word)){
                    occurrencesMap.put(word, 1);
                }
                else{
                    occurrencesMap.put(word, occurrencesMap.get(word) + 1);
                }
            }
            while ((index < text.length()) && !Character.isLetter(text.charAt(index))){
                index++;
            }
        }

        if (occurrencesMap.isEmpty())
        {
            return new String[0];
        }

        ArrayList<String> output = new ArrayList<String>();
        for (int i = 0; i<3 ; i++){
            Iterator<HashMap.Entry<String,Integer>> it = occurrencesMap.entrySet().iterator();
            HashMap.Entry<String,Integer> mostOccurringEntry = it.next();
            while (it.hasNext())
            {
                HashMap.Entry<String,Integer> entry = it.next();
                if (entry.getValue().intValue() > mostOccurringEntry.getValue().intValue()){
                    mostOccurringEntry = entry;
                }
            }
            output.add(mostOccurringEntry.getKey());
            occurrencesMap.remove(mostOccurringEntry.getKey());
            if (occurrencesMap.isEmpty())
            {
                break;
            }
        }

        return output.toArray(new String[output.size()]);
    }
}
