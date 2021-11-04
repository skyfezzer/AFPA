public class ManipArgs{
	public static void main(String[] args){
		for(int i=0;i<args.length;i++){
			System.out.println("Argument num."+i+" : "+args[i]);
			
		}
		int somme = Integer.parseInt(args[3]) + Integer.parseInt(args[4]);
		System.out.println("args[3] + args[4] = " + somme);
		
	}
}