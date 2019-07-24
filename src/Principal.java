import java.util.Date;
import java.util.List;
import java.util.Scanner;

import dao.MercadoriaDAO;
import dao.MercadoriaDAOImpl;
import model.Mercadoria;

public class Principal {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Escolha a opção");
		System.out.println("1 - Criar entrada");
		System.out.println("2 - Atualizar entrada");
		System.out.println("3 - Procurar por nome");
		System.out.println("4 - Listar todos");
		System.out.println("5 - Vender");
		
		int o = s.nextInt();
		Mercadoria m = new Mercadoria();
		MercadoriaDAO mDao = new MercadoriaDAOImpl();
		List<Mercadoria> l = null;
		switch (o) {
		case 1:
			System.out.println();
			System.out.println();
			System.out.println("Insira o nome da água");
			m.setNome(s.next());
			System.out.println("Insira a quantidade da água");
			m.setQuantidade(s.nextInt());
			System.out.println("Insira a data de entrada da água");
			m.setEntrada(s.next());
			System.out.println("Insira a data de saida da água");
			m.setSaida(s.next());
			System.out.println("Insira o preço da água");
			m.setPreco(s.nextFloat());
			mDao.create(m);
			break;
		case 2:
			System.out.println();
			System.out.println();
			System.out.println("Insira o nome a ser atualizado");
			m = mDao.findByName(s.next());
			System.out.println("Insira a quantidade da água");
			m.setQuantidade(s.nextInt());
			System.out.println("Insira a data de entrada da água");
			m.setEntrada(s.next());
			System.out.println("Insira a data de saida da água");
			m.setSaida(s.next());
			System.out.println("Insira o preço da água");
			m.setPreco(s.nextFloat());
			mDao.update(m);
			break;		
		case 3:
			System.out.println();
			System.out.println();
			System.out.println("Insira o nome a ser pesquisado");
			m = mDao.findByName(s.next());
			System.out.println("Objeto recuperado:");
			System.out.println("Nome: "+m.getNome()+" Quantidade: "+m.getQuantidade()+" Preco: "+m.getPreco());
		break;
		case 4:
			System.out.println();
			System.out.println();
			System.out.println("Lista de objetos");
			l = mDao.findAll();
			for (Mercadoria m1 : l) {
				System.out.println("Objeto recuperado:");
				System.out.println("Nome: "+m1.getNome()+" Quantidade: "+m1.getQuantidade()+" Preco: "+m1.getPreco());	
			}
		break;	
		case 5:
			System.out.println();
			System.out.println();
			System.out.println("Insira o nome da água para venda");
			m = mDao.findByName(s.next());
			System.out.println("Quantas águas?");
			int i = s.nextInt();
			m.setQuantidade(m.getQuantidade() - i);
			mDao.update(m);
			//rDao.create(new RegistroDeVenda(m.getNome(), i, "24/07/2019"));
			break;		
		}
		
	}

}
