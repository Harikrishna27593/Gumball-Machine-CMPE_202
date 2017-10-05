

public class GumballMachine {
 
	State soldOutState;
	State noQuarterState;
	State hasQuarterState;
	State soldState;
 
	State state = soldOutState;
	int count = 0;
	int amount=0;
	boolean gumball_in_slot;
	boolean is_it_from_machine1;
 
	public GumballMachine(int numberGumballs) {
		soldOutState = new SoldOutState(this);
		noQuarterState = new NoQuarterState(this);
		hasQuarterState = new HasQuarterState(this);
		soldState = new SoldState(this);

		this.count = numberGumballs;
		this.amount=0;
		this.gumball_in_slot=false;
		this.is_it_from_machine1=true;
 		if (numberGumballs > 0) {
			state = noQuarterState;
		} 
	}
 
	public void insertCoin(int n) {
	        if(n==5 || n==10)
	        {
	            this.is_it_from_machine1=false;
	        }
		state.insertCoin(n);
	}
 
	public void ejectCoin() {
		state.ejectCoin();
	}
 
	public void turnCrank() {
		state.turnCrank();
		state.dispense();
	}

	void setState(State state) {
		this.state = state;
	}
        
	public boolean hasgumball(){return this.gumball_in_slot;}
        public boolean isfrommachine1(){return this.is_it_from_machine1;}
	void releaseBall() {
		System.out.println("A gumball comes rolling out the slot...");
		if (count != 0) {
			count = count - 1;
		}
		this.gumball_in_slot=true;
	}
 
	int getCount() {
		return count;
	}
	
	int getAmount(){
	        return amount;
	}
        public void settotalAmount(int Total){
            amount=Total;
        }
	void refill(int count) {
		this.count = count;
		state = noQuarterState;
	}

    public State getState() {
        return state;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }
 
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\nMighty Gumball, Inc.");
		result.append("\nJava-enabled Standing Gumball Model #2004");
		result.append("\nInventory: " + count + " gumball");
		if (count != 1) {
			result.append("s");
		}
		result.append("\n");
		result.append("Machine is " + state + "\n");
		return result.toString();
	}
	public void invalidCrank() {
		System.out.println("Invalid crank...Insert 25 cents or 50 cents");
	}
}
