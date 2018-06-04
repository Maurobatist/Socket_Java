//importa bibliotecas
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//cria classe servidor
public class Servidor {
	public static void main(String[] args) throws IOException{
		//cria socket que irá esperar conexões na porta 12345
		ServerSocket servidor = new ServerSocket(12345);
		System.out.println("Porta 12345 aberta!");
		
		/*criamos um objeto Socket, o qual irá tratar da comunicação com o cliente, 
		 * assim que um pedido de conexão chegar ao servidor e a conexão for aceita:*/
		Socket cliente = servidor.accept();
		//retorna o ip do cliente
		System.out.println("Nova conexão com o cliente: " + cliente.getInetAddress().getHostAddress()
		);
		//Lê todas informações que o cliente envia
		Scanner s = new Scanner(cliente.getInputStream());
		//Em seguida imprime as informações enquanto houver
		while (s.hasNextLine()) {
			System.out.println(s.nextLine());
		}
		//fecha todos objetos
		s.close();
		servidor.close();
		cliente.close();
	}
}