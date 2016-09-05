
public class Main {

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		Output out = new Output();
		calc.run();
		out.valuesOutput(calc.model);

	}
}
