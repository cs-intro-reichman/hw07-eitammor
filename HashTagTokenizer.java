

public class HashTagTokenizer {

	public static void main(String[] args) {
		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		

		breakHashTag(hashTag, dictionary);
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);

		for (int i = 0 ; i < 3000 ; i++)
		{
			dictionary[i] = in.readLine();
		}


		return dictionary;
	}


	public static boolean existInDictionary(String word, String []dictionary) {
		boolean existIn = false;
		int i = 0;
		while (!existIn && i < 3000)
		{
			if (dictionary[i].equals(word))
			{
				existIn = true;
			}
			i++;
		}
		return existIn;
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {
		hashtag = hashtag.toLowerCase();
		// Base case: do nothing (return) if hashtag is an empty string.
        if (hashtag.isEmpty()) {
            return;
        }
 
        int N = hashtag.length();

        for (int i = 1; i <= N; i++) {
			if (existInDictionary(hashtag.substring(0, i), dictionary))
			{
				System.out.println(hashtag.substring(0, i));
				breakHashTag(hashtag.substring(i), dictionary);
				break;
			}
        }
    }
 
}
