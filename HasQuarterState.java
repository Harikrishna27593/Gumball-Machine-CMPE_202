

import java.util.Random;

public class HasQuarterState implements State {
	GumballMachine gumballMachine;
 
	public HasQuarterState(GumballMachine gumballMachine) {
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
	
	}
 
	public void ejectCoin() {
	        int amount_here=gumballMachine.getAmount();
	        
	        if(amount_here>0 && amount_here<25)
		{
		System.out.println(amount_here+" Cents returned");
		gumballMachine.settotalAmount(0);
		gumballMachine.setState(gumballMachine.getNoQuarterState());
                }
                else if(amount_here>25 && amount_here<50)
		{
		   if(gumballMachine.isfrommachine1())
		   {
		System.out.println((amount_here-25)+" Cents returned");
		gumballMachine.settotalAmount(0);
		gumballMachine.setState(gumballMachine.getSoldState());
                   }
                   else
                   {
                System.out.println((amount_here)+" Cents returned");
		gumballMachine.settotalAmount(0);
		gumballMachine.setState(gumballMachine.getNoQuarterState());
                   }
                }
                else if (amount_here>50)
		{
		System.out.println((amount_here-50)+" Cents returned");
		gumballMachine.settotalAmount(0);
		gumballMachine.setState(gumballMachine.getSoldState());
                }
                else if(amount_here==25)
                {
                System.out.println("Insuffient Amount inserted.Need 50 cents for gumball");
                System.out.println((amount_here)+" Cents returned");
		gumballMachine.settotalAmount(0);
		gumballMachine.setState(gumballMachine.getNoQuarterState());
                    
                }
		
	}
 
	public void turnCrank() {
		System.out.println("You turned...");
		int amount_here=gumballMachine.getAmount();
		if((amount_here==25 && gumballMachine.isfrommachine1()) ||amount_here==50)
		{
		gumballMachine.settotalAmount(0);
		gumballMachine.setState(gumballMachine.getSoldState());
                }
                else if(amount_here>0 && amount_here<25)
		{
		gumballMachine.ejectCoin();
                }
                else if(amount_here>25 && amount_here<50)
		{
		gumballMachine.ejectCoin();
                }
                else if(amount_here>50)
		{
		gumballMachine.ejectCoin();
                }
                else if((amount_here==25 && !gumballMachine.isfrommachine1()))
                {
                gumballMachine.ejectCoin();    
                }
                else
                {
                    gumballMachine.invalidCrank();
                    gumballMachine.setState(gumballMachine.getNoQuarterState());
                    
                }
	}

    public void dispense() {
        System.out.println("No gumball dispensed");
    }
 
	public String toString() {
		return "waiting for turn of crank";
	}
}
