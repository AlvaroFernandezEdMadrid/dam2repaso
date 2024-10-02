package ejercicioStreams.org.ejercicioStream1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {

	/*
	 * 

1. Find all transactions in the year 2011 and sort them by value (small to high).
2. What are all the unique cities where the traders work?
3. Find all traders from Cambridge and sort them by name.
4. Return a string of all traders' names sorted alphabetically.
5. Are any traders based in Milan?
6. Print all transactions' values from the traders living in Cambridge.
7. What's the highest value of all the transactions?
8. Find the transaction with the smallest value.

9. Mostrar el total de las transacciones por la ciudad de los agentes. Intentar ordenar por cantidad.
	 */
	public static void main(String[] args) {
		final Consumer<Object> ESCRIBIDOR = System.out::println;

		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario","Milan");
		Trader alan = new Trader("Alan","Cambridge");
		Trader brian = new Trader("Brian","Cambridge");

		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950));

		//Find all transactions in the year 2011 and sort them by value (small to high).

		System.out.println("\n Todas las transacciones de 2011 ordenadas de menor a mayor: \n");

		transactions.stream()
		.filter(t->t.getYear()==2011)
		.sorted((t1,t2)->t1.getValue())
		.collect(Collectors.toList()).forEach(ESCRIBIDOR);;

		//What are all the unique cities where the traders work?

		System.out.println("\n Ciudades donde trabajan los trader: \n");

		transactions.stream()
		.map(t->t.getTrader())
		.map(Trader::getCity)
		.distinct()
		.collect(Collectors.toList())
		.forEach(ESCRIBIDOR);

		//Find all traders from Cambridge and sort them by name.

		System.out.println("\nTraders de Cambridge ordenados por su nombre:\n");

		transactions.stream()
		.map(t->t.getTrader())
		.filter(a -> a.getCity().equalsIgnoreCase("Cambridge"))
		.sorted((t1, t2) -> t1.getName().compareTo(t2.getName()))
		.collect(Collectors.toList()).forEach(ESCRIBIDOR);

		//Return a string of all traders' names sorted alphabetically.

		System.out.println("\nUn solo string con los nombres de todos los trader ordenados alfabeticamente:\n");

		transactions.stream()
		.map(t->t.getTrader())
		.map(t->t.getName())
		.sorted((a,b)->a.compareTo(b))
		.reduce((a,b)->a+b)
		.ifPresentOrElse(ESCRIBIDOR, ()->System.out.println("Sin datos"));

		//Are any traders based in Milan?

		System.out.println("\nHay algun Trader en Milan?\n");

		System.out.println(transactions.stream()
				.map(Transaction::getTrader)
				.anyMatch(trader -> trader.getCity().equals("Milan")) 
				? "Hay un Trader en Milan." 
						: "No hay Traders en Milan.");

		//Print all transactions' values from the traders living in Cambridge.

		System.out.println("\nMostrar los valores de las transacciones de los Trader de Cambridge:\n");

		transactions.stream()
		.filter(t -> t.getTrader()
				.getCity()
				.equalsIgnoreCase("cambridge"))
		.map(Transaction::getValue)
		.collect(Collectors.toList())
		.forEach(ESCRIBIDOR);

		//What's the highest value of all the transactions?

		System.out.println("\nEl valor mas alto de todas las transacciones:\n");

		transactions.stream()
		.map(Transaction::getValue)
		.min((a,b)->Integer.min(a, b))
		.ifPresentOrElse(ESCRIBIDOR, () ->System.out.println("SIN DATO"));

		//Find the transaction with the smallest value.

		System.out.println("\nEl valor mas pequenio de todas las transacciones:\n");

		transactions.stream()
		.map(Transaction::getValue)
		.max((a,b)->Integer.max(a, b))
		.ifPresentOrElse(ESCRIBIDOR, () ->System.out.println("SIN DATO"));

		//Mostrar el total de las transacciones por la ciudad de los agentes. Intentar ordenar por cantidad.

		System.out.println("\nMostrar el total de las transacciones por la ciudad de los Trader:\n");

		Map<String, Integer> totalPorCiudad = transactions.stream()
				.collect(Collectors.groupingBy(
						t -> t.getTrader().getCity(), 
						Collectors.summingInt(Transaction::getValue) 
						));

		totalPorCiudad.entrySet().stream()
		.sorted((a,b)->a.getValue()
				.compareTo(b.getValue()))
		.forEach(ESCRIBIDOR);

	}

}
