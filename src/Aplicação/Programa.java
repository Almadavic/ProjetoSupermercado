package Aplica��o;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import Entidade.Caixa;
import Entidade.Cliente;
import Entidade.Dono;
import Entidade.Funcionario;
import Entidade.Gerente;
import Entidade.ItemVenda;
import Entidade.Venda;
import Enumerados.Pago;
import Enumerados.TipoPagamento;
import Erro.Personalizado;
import Services.MasterCard;
import Services.Visa;
import Services.iBandeiraCart�o;

public class Programa {

	
	static void menu() throws IOException {
		String path="c:\\temp2\\Supermercado\\menu.txt";
		BufferedReader br = new BufferedReader(new FileReader(path));
		String line = br.readLine();
		while(line!=null) {
			System.out.println(line);
			line = br.readLine();
		}
		br.close();
	}
	
	
	static void sobre() throws IOException {
		String path="c:\\temp2\\Supermercado\\sobre.txt";
		BufferedReader br = new BufferedReader(new FileReader(path));
		String line = br.readLine();
		while(line!=null) {
			System.out.println(line);
			line = br.readLine();
		}
		br.close();
	}
	
	static void impress�o(Venda venda) throws IOException, Personalizado {
		String path = "c:\\temp2\\Supermercado\\";
		File diretorio = new File(path);
		System.out.println("Digite a pasta que desja criar : ");
		String subpath=sc.next();
		boolean sucess = new File(path+subpath).mkdir();
		System.out.println("Digite o nome do arquivo : ");
		String arquivo = sc.next();
		BufferedWriter bw = new BufferedWriter(new FileWriter(path+subpath+arquivo));
		System.out.println("Criado com sucesso ? "+sucess);
		bw.write(venda.recibo());
		bw.newLine();
		bw.close();
	}
	
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args)   {
		
		try {
	Venda venda = new Venda();
int option=0;
			do {
			menu();
			option=sc.nextInt();
			
			switch (option) {
			case 1:
				System.out.print("Digite o  numero da venda : ");
				int numero=sc.nextInt();
				int quantidade=0;
				int contador=0;
				int vetor[]=null;
				while (quantidade!=-1) {
					vetor= new int[contador];
					
						venda.setNumero(numero);
						System.out.print("Digite a quantidade ,(-1) Para Finalizar!");
					 quantidade=sc.nextInt();
					 if(quantidade!=-1 ) {
						System.out.print("Digite o valor unit�rio : ");
						double valor=sc.nextDouble();
					System.out.print("Digite o nome do Produto : ");
					String nomeProduto=sc.next();
					ItemVenda item = new ItemVenda(nomeProduto,valor,quantidade);
					venda.adicionarItem(item);
					contador++;
					
					 }
					}
				if(vetor.length>=1) {
				System.out.println("Total : "+venda.descontos());
					System.out.print("Forma de Pagamento : DINHEIRO(1) , CART�O(2)");
					int formPagamento = sc.nextInt();
					if (formPagamento==2) {	
						venda.setTipoPagamento(TipoPagamento.CART�O);
						System.out.println("Deseja dividir de quantas vezes ? ");
						int parcelas = sc.nextInt();
						venda.setParcelas(parcelas);
						venda.setPago(Pago.AGUARDO);
					} else if(formPagamento==1) {
						venda.setTipoPagamento(TipoPagamento.DINHEIRO);
						venda.setPago(Pago.valueOf("PAGO")); 
						System.out.println(venda.recibo());						
					} else {
						System.out.println("Op��o Inv�lida");
					}
				}
				venda.parcelamento();
				break;
			case 2:
				System.out.println("Para acessar essa �rea digite o login e a senha : ");
				System.out.print("Login : ");
				String login =sc.next();
				System.out.print("Senha : ");
				String senha=sc.next();
				Dono dono = new Dono(login,senha);
				//------------------------------------//
				System.out.print("Deseja acessar quadro Caixa(1) ou Gerente(2) ?");
				int fun =sc.nextInt();
				System.out.print("Digite o nome : ");
				String nome=sc.next();
				System.out.print("Digite o sal�rio : ");
				double salario =sc.nextDouble();
				System.out.print("Digite os descontos : ");
				double descontos=sc.nextDouble();
				if(fun==1) {
					System.out.println("Digite o guiche : ");
					int caixa=sc.nextInt();
					Funcionario funcionario = new Caixa(nome,salario,descontos,caixa);
					System.out.println(funcionario.formated());
				}else if (fun==2) {
					System.out.print("Digite a comiss�o : ");
					double comiss�o = sc.nextDouble();
					Funcionario funcionario= new Gerente(nome,salario,descontos,comiss�o);
					System.out.println(funcionario.formated());
				} else {
					System.out.println("Op��o Inv�lida,tente novamente");
				}
				break;
			case 3:
				
				venda.valida��o();
				 int senhaCart�o=0;
				iBandeiraCart�o cart�o=null;
				System.out.print("Visa(1) ou Master(2)");
				int tipoCart�o =sc.nextInt();
				System.out.print("Digite o setor do cart�o : ");
				int setor =sc.nextInt();
				if(tipoCart�o==1) {
					 cart�o = new Visa(setor);
					 System.out.println(cart�o.verificarBandeira());
				}else if (tipoCart�o==2) {
					 cart�o= new MasterCard(setor);
					 System.out.println(cart�o.verificarBandeira());
				} else {
					System.out.println("OP��O INV�LIDA");
				}
			        System.out.print("Senha : ");
			        senhaCart�o =sc.nextInt();
			        System.out.println(cart�o.senha(senhaCart�o));
			        venda.setPago(Pago.PAGO);
			        impress�o(venda);
				break;
			case 4:
				sobre();
				break;
			case 5:
				Set<Cliente>list = new HashSet<>();
				list.add(new Cliente("Victor","victor@hotmail.com"));
				list.add(new Cliente("Matheus" ,"matheus@hotmail.com"));
				list.add(new Cliente("Larissa","larissa@hotmail.com"));
				System.out.print("Digite seu Nome : ");
				String nomeCliente =sc.next();
				System.out.println("Digite seu email : ");
				String email =sc.next();
				Cliente cliente1 = new Cliente(nomeCliente,email);
				venda.setCliente(cliente1);
				System.out.println(venda.getCliente());
				if (list.contains(cliente1)) {
					System.out.println("Voc� j� � cadastrado");
				} else {
					list.add(cliente1);
					System.out.println("Cadastrado com sucesso");
				}
				
				break;
			case 6:
				break;
			default : 
				System.out.println("Op��o Inv�lida");
			}
			
			
			}while(option<6);
			
			
			
			
			
			
		}
		catch(IOException e) {
			System.out.println("Erro : "+e.getMessage());
		}
		catch(Personalizado e ) {
			System.out.println("Erro : "+e.getMessage());
		}
		finally {
			sc.close();
			System.out.println("Programa Finalizado!");
		}

	}

}
