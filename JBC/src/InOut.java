class InOut {
	
	public void main(String[] args){
		int iam = 3;
		String s = new String("Between");
		
		class Bicycle{
			public void sayHello(){
				//Here
				System.out.println(s);
				//System.out.println(iOther);
				System.out.println(iam);
				System.out.println(args);
			}//End of bicycle class
		}
		
		Bicycle bike = new Bicycle();
		bike.sayHello();
	}//End of amethod
	
	public void another(){
		int iOther = 5;
	}
}
