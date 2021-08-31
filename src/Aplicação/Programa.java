package Aplicação;

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
import Services.iBandeiraCartão;

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
	
	static void impressão(Venda venda) throws IOException, Personalizado {
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
						System.out.print("Digite o valor unitário : ");
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
					System.out.print("Forma de Pagamento : DINHEIRO(1) , CARTÃO(2)");
					int formPagamento = sc.nextInt();
					if (formPagamento==2) {	
						venda.setTipoPagamento(TipoPagamento.CARTÃO);
						System.out.println("Deseja dividir de quantas vezes ? ");
						int parcelas = sc.nextInt();
						venda.setParcelas(parcelas);
						venda.setPago(Pago.AGUARDO);
					} else if(formPagamento==1) {
						venda.setTipoPagamento(TipoPagamento.DINHEIRO);
						venda.setPago(Pago.valueOf("PAGO")); 
						System.out.println(venda.recibo());						
					} else {
						System.out.println("Opção Inválida");
					}
				}
				venda.parcelamento();
				break;
			case 2:
				System.out.println("Para acessar essa área digite o login e a senha : ");
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
				System.out.print("Digite o salário : ");
				double salario =sc.nextDouble();
				System.out.print("Digite os descontos : ");
				double descontos=sc.nextDouble();
				if(fun==1) {
					System.out.println("Digite o guiche : ");
					int caixa=sc.nextInt();
					Funcionario funcionario = new Caixa(nome,salario,descontos,caixa);
					System.out.println(funcionario.formated());
				}else if (fun==2) {
					System.out.print("Digite a comissão : ");
					double comissão = sc.nextDouble();
					Funcionario funcionario= new Gerente(nome,salario,descontos,comissão);
					System.out.println(funcionario.formated());
				} else {
					System.out.println("Opção Inválida,tente novamente");
				}
				break;
			case 3:
				
				venda.validação();
				 int senhaCartão=0;
				iBandeiraCartão cartão=null;
				System.out.print("Visa(1) ou Master(2)");
				int tipoCartão =sc.nextInt();
				System.out.print("Digite o setor do cartão : ");
				int setor =sc.nextInt();
				if(tipoCartão==1) {
					 cartão = new Visa(setor);
					 System.out.println(cartão.verificarBandeira());
				}else if (tipoCartão==2) {
					 cartão= new MasterCard(setor);
					 System.out.println(cartão.verificarBandeira());
				} else {
					System.out.println("OPÇÃO INVÁLIDA");
				}
			        System.out.print("Senha : ");
			        senhaCartão =sc.nextInt();
			        System.out.println(cartão.senha(senhaCartão));
			        venda.setPago(Pago.PAGO);
			        impressão(venda);
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
					System.out.println("Você já é cadastrado");
				} else {
					list.add(cliente1);
					System.out.println("Cadastrado com sucesso");
				}
				
				break;
			case 6:
				break;
			default : 
				System.out.println("Opção Inválida");
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
