import java.util.Arrays;
import java.util.ArrayList;

public class Dictionary implements DictionaryInterface {
  /**
   * The keys in the dictionary.
   */
  private ArrayList<String> keys;
  /**
   * The objects in the dictionary.
   */
  private ArrayList<Object> objects;

  /**
   * Constructs a dictionary.
   * @return An empty dicitonary.
   */
  public Dictionary() {
    this.keys = new ArrayList<String>();
    this.objects = new ArrayList<Object>();
  }

  /**
   * Constructs a dictionary.
   *    An array of keys.
   *    An array of objects.
   *   A dictionary with keys and objects.
   */
  public Dictionary(String[] keys, Object[] objects) {
    if (keys.length != objects.length) {
      throw new IllegalArgumentException("The number of keys must match the number of objects.");
    }

    this.keys = new ArrayList<String>(Arrays.asList(keys));
    this.objects = new ArrayList<Object>(Arrays.asList(objects));
  }


  public Object get(String key) {
    int index = keys.indexOf(key);

    if (index == -1) {
      return null;
    }

    return objects.get(index);
  }


  public void set(String key, Object value) {
    int index = keys.indexOf(key);

    if (index == -1) {
      keys.add(key);
      objects.add(value);
      return;
    }

    objects.set(index, value);
  }

  public void remove(String key) {
    int index = keys.indexOf(key);

    if (index == -1) {
      return;
    }

    keys.remove(index);
    objects.remove(index);
  }

  public void empty() {
    keys = new ArrayList<String>();
    objects = new ArrayList<Object>();
  }

  public int size() {
    return keys.size();
  }


  public boolean isEmpty() {
    return keys.size() == 0;
  }

  
  public ArrayList<String> keys() {
    return keys;
  }

  /**
   * Follows Apple's NSDictionary description for dictionary equality:
   * Two dictionaries have equal contents if they each hold the same number
   * of entries and, for a given key, the corresponding value objects in each
   * dictionary satisfy the isEqual: test.
   *
   * 
   * 
   */
  public boolean equals(Object obj) {
    if (!obj.getClass().equals(Dictionary.class)) {
      return false;
    }

    Dictionary comparison = (Dictionary)obj;

    if (size() != comparison.size()) {
      return false;
    }

    for (String key : keys) {
      if (comparison.get(key) == null || get(key) == null) {
        return false;
      }

      if (comparison.get(key).equals(get(key))) {
        continue;
      } else {
        return false;
      }
    }

    return true;
  }

  /**
   * Displays the dictionary's contents.
   * A beautified output of the dictionary.
   */
  public String toString() {
    String output = "{";

    for (int i = 0; i < keys.size(); i++) {
      if (i == 0) {
        output = output + "\n";
      }

      output = output + "  \"" + keys.get(i) + "\" => " + objects.get(i);

      if (i != keys.size() - 1) {
        output = output + ",";
      }

      output = output + "\n";
    }

    output = output + "}";

    return output;
  }
}
