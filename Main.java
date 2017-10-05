

public class Main {

	public static void main(String[] args) {
		GumballMachine gumballMachine = new GumballMachine(5);

		System.out.println(gumballMachine);

		gumballMachine.insertCoin(10);
		gumballMachine.insertCoin(5);
		gumballMachine.insertCoin(10);
		gumballMachine.turnCrank();
		


		System.out.println(gumballMachine);

		gumballMachine.insertCoin(25);
		gumballMachine.insertCoin(25);
		gumballMachine.turnCrank();
		gumballMachine.insertCoin(5);
		gumballMachine.turnCrank();

		System.out.println(gumballMachine);
	}
}
