
public class Output {
	
	public void valuesOutput(Model model) {
		for (String key : model.taxValues.keySet()) {
			System.out.printf("%s , %.2f%n",key, model.taxValues.get(key));
		}
	}

}
