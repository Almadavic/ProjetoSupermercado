package Aplicação;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Entidade.Caixa;
import Entidade.Cliente;
import Entidade.Dono;
import Entidade.Funcionario;
import Entidade.Gerente;
import Entidade.ItemVenda;
import Entidade.Venda;
import Enumerados.TipoPagamento;
import Erro.Personalizado;

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
	
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args)   {
		
		try {
		int option=0;
			do {
			menu();
			option=sc.nextInt();
			
			Venda venda = new Venda();
			switch (option) {
			case 1:
				int quantidade=0;
				while (quantidade!=-1) {
					if (quantidade!=-1) {
						System.out.print("Digite o  numero da venda : ");
						int numero=sc.nextInt();
						venda.setNumero(numero);
						System.out.print("Digite a quantidade ,(-1) Para Finalizar!");
					 quantidade=sc.nextInt();
						System.out.print("Digite o valor unitário : ");
						double valor=sc.nextDouble();
					System.out.println("Digite o nome do Produto : ");
					String nomeProduto=sc.next();
					ItemVenda item = new ItemVenda(nomeProduto,valor,quantidade);
					venda.adicionarItem(item);
					System.out.print("Forma de Pagamento : DINHEIRO(1) , CARTÃO(2)");
					venda.setTipoPagamento(TipoPagamento.valueOf(sc.next()));
					if (venda.getTipoPagamento()==TipoPagamento.CARTÃO) {
						System.out.println("Deseja dividir de quantas vezes ? ");
						int parcelas = sc.nextInt();
					} else {
						
					}
					}
				}
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
				break;
			case 4:
				sobre();
				break;
			case 5:
				List<Cliente>list = new ArrayList<>();
				list.add(new Cliente("Victor","victor@hotmail.com"));
				list.add(new Cliente("Matheus" ,"matheus@hotmail.com"));
				list.add(new Cliente("Larissa","larissa@hotmail.com"));
				System.out.print("Digite seu Nome : ");
				String nomeCliente =sc.next();
				System.out.println("Digite seu email : ");
				String email =sc.next();
				Cliente cliente = new Cliente(nomeCliente,email);
				if (list.contains(cliente)) {
					System.out.println("Você já é cadastrado");
				} else {
					list.add(cliente);
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
