

public class NoQuarterState implements State {
    GumballMachine gumballMachine;
 
    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
 
	public void insertCoin(int n) {
	        if(n==25)
	        {
		System.out.println("You inserted a quarter");
                }
                else if(n==10)
                {
                System.out.println("You inserted a Dime");
                }
                else if(n==5)
                {
                System.out.println("You inserted a nickel");
                }
              
                
		gumballMachine.settotalAmount(gumballMachine.getAmount()+n);
		gumballMachine.setState(gumballMachine.getHasQuarterState());
	}
 
	public void ejectCoin() {
		System.out.println("You haven't inserted a quarter");
	}
 
	public void turnCrank() {
		System.out.println("You turned, but there's no quarter");
	 }
 
	public void dispense() {
		System.out.println("You need to pay first");
	} 
 
	public String toString() {
		return "waiting for quarter";
	}
}
