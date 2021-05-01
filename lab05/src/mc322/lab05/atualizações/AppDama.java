package lab05;

public class AppDama {
	char[][]tab;
	boolean state;
	
	public AppDama (){
		tab = new char [10][10];
	}
	
	public static void criaTabuleiro (AppDama d, boolean state) {
		peca p = new peca();
		
		state=true;
		
		for(int i=1;i<=9;i++) {	
						
			for(int j=1;j<=8;j++) {
						
				if(i==4 | i==5) d.tab[i][j]='-';
			
				else {
					if(state) {
						
						if((i==8|i==6) && j%2!=0)d.tab[i][j]=p.retorno('p');
						else if(i==2 && j%2!=0)d.tab[i][j]=p.retorno('b');
						else d.tab[i][j]='-';
					}
					else if(!state) { 
						if((i==1|i==3) && j%2==0)d.tab[i][j]=p.retorno('b');
						else if(i==7 && j%2==0)d.tab[i][j]=p.retorno('p');
						else d.tab[i][j]='-';
						
					}
				}state=!state;			
				
			}System.out.println();
				
		}
	
	}
	
	public static int traduzPos (char c) {
		//traduz as instruções em indices do vetor do tabuleiro
			int var=0;
			if(c=='a' | c=='1') var=1;
			else if(c=='a' | c=='1') var=1;
			else if(c=='b' | c=='2') var=2;
			else if(c=='c' | c=='3') var=3;
			else if(c=='d' | c=='4') var=4;
			else if(c=='e' | c=='5') var=5;
			else if(c=='f' | c=='6') var=6;
			else if(c=='g' | c=='7') var=7;
			else if(c=='h' | c=='8') var=8;
			
			return var;
	}
	
	public static boolean validaPos (int i_origem, int j_origem, int i_destino, int j_destino, AppDama d) {
		boolean state_1=false,state_2=false,state_pos=false;
		int cont_1, a;
		
		cont_1 = i_destino - i_origem;
		if(cont_1<0)cont_1=cont_1*(-1);
		
			
		for(a=1; a<=cont_1;a++) {
			if(i_destino==i_origem+a | i_destino==i_origem-a) {
				state_1=true;
				break;}
		}
		if(j_destino==j_origem+a | j_destino==j_origem-a){
				state_2=true;
				
		}
		if(state_1 && state_2 && d.tab[i_destino][j_destino]=='-')state_pos=true;
		else state_pos=false;
		
	return state_pos;	
	}
	
	public static void mostraTabuleiro (AppDama d) {
		System.out.println();
		char a='a';
		for(int i=8;i>=0;i--) {
			if(i!=0)System.out.print(+i);
			
			
			for(int j=1;j<=9;j++) {
				
				if(i==0 && j>1) {System.out.print(a+" ");a++;
				}else {
					System.out.print(" ");
					System.out.print(d.tab[i][j]);}
				
					}System.out.println();
				}				
	}
		
	
	public static void executaJogo(String diretorio) {
		AppDama t = new AppDama();
		criaTabuleiro(t,true);
		
		System.out.print("Tabuleiro inicial:");
		mostraTabuleiro(t);
		
		CSVReader csv = new CSVReader();
		csv.setDataSource(diretorio);
		
		//vetor contendo os passos de execução
		String commands[] = csv.requestCommands();
		char [] posInicial = new char[2];
		char [] posFinal = new char[2];
		
		int n=commands.length; //contem o número de comandos presentes no .csv
		
		for(int j=1;j<n;j++) {
			posInicial[0]=commands[j].charAt(0);
			posInicial[1]=commands[j].charAt(1);
			
			posFinal[0]=commands[j].charAt(3);
			posFinal[1]=commands[j].charAt(4);
			
			System.out.println("\n");
			System.out.println("Source:"+posInicial[0]+"" +posInicial[1]);
			System.out.print("Target:"+posFinal[0]+"" +posFinal[1]);
			
			alteraPos(posInicial,posFinal,t);
			mostraTabuleiro(t);
			
		} 
	}
	
	public static void alteraPos(char[] A, char [] B, AppDama t) {
		
		int i_1, j_1,i_2, j_2, posInter_i, posInter_j;
			
			//posicao inicial
			i_1=traduzPos(A[1]);
			j_1=traduzPos(A[0]);
			
			//posicao final
			i_2=traduzPos(B[1]);
			j_2=traduzPos(B[0]);
			if(i_2>i_1)posInter_i=1;
			else posInter_i=-1;
			
			if(j_2>j_1)posInter_j=1;
			else posInter_j=-1;
			
			if(validaPos(i_1,j_1,i_2,j_2,t)) {
				//verifica distância até a posFinal e se há uma peça entre elas:
				
				int dist=i_1-i_2;if(dist<0)dist=dist*(-1);
				System.out.println("\ndist:"+dist+"\nposIntermed:"+posInter_i);
				if(dist==1) {System.out.print("\nEntrei aqui");
					t.tab[i_2][j_2]=t.tab[i_1][j_1];
					t.tab[i_1][j_1]='-';
				}else if (dist==2 && t.tab[i_1+posInter_i][j_1+posInter_j]!='-') {System.out.print("\nEntrei aqui2");
					t.tab[i_2][j_2]=t.tab[i_1][j_1];
					t.tab[i_1+posInter_i][j_1+posInter_j]='-';
					t.tab[i_1][j_1]='-';
				}
			}
	}
	
	public static void main (String args []) {
		String diretorio = "C:\\Users\\55119\\OneDrive\\Documentos\\testeRestaUm\\arq001.csv";
		executaJogo(diretorio);
	}
}
