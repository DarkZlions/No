import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {
	/*
	 * @param Float = registry id
	 * @param Byte = text
	 */
	private static final Map<Integer, String> map99 = new HashMap<>();
	
	public static void main(String[] args) {
		map99.put(13823, "Hello");
		Supplier<Map<Integer, String>> zresuppli3 = () -> map99;
		Supplier<Supplier<Map<Integer, String>>> consumer = () -> zresuppli3;
		TreeMap<Supplier<Map<Integer, String>>, Integer> baum = new TreeMap<Supplier<Map<Integer,String>>, Integer>();
		baum.put(zresuppli3, 13823);
		Supplier<Supplier<Supplier<Map<Integer, String>>>> function3 = () -> consumer;
		Map<Supplier<Supplier<Supplier<Map<Integer, String>>>>, String> supMap = new HashMap<>();
		supMap.put(function3, function3.get().get().get().get(baum.get(function3.get())));
		Map<Map<Integer, String>, TreeMap<Supplier<Map<Integer, String>>, Integer>> m = new HashMap<>();
		m.put(map99, baum);
		
		Consumer<String> output = a -> System.out.println(consumer.get().get().get(m.get(map99).get(zresuppli3)) + a);
		output.accept(" World!");
	}
}
