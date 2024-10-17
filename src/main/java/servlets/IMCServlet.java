package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import calc.IMC;

@WebServlet(urlPatterns = "/formServlet")
public class IMCServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Double altura = Double.parseDouble(req.getParameter("altura"));
		Double peso = Double.parseDouble(req.getParameter("peso"));
		System.out.println(String.format("%.2f", altura));
		System.out.println(peso);
		
		IMC calculo = new IMC();
		calculo.setAltura(altura);
		calculo.setPeso(peso);
		
		String resultado = calculo.calcularIMC();
		System.out.println(resultado);
		
		PrintWriter out = resp.getWriter();
		out.print("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Sucesso</title>\r\n"
				+ "<link rel=\"stylesheet\" href=\"style.css\">"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "	<form>\r\n"
				+ "		<label> " + "Altura: " + String.format("%.2f", altura) + "<br/>Peso: " + peso + " </label>\r\n"
				+ "		<br/>"
				+ "		<br/>"
				+ "		<label> " + "IMC cadastrado as " + new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date()) + "</label>"
				+ "		<br/>"
				+ "		<label>	 " + "Resultado do IMC:" + String.format("%.2f", calculo.getValor()) + " -> " + resultado  +	"</label>"
				+ "</br>"
				+ "</br>"
				+ "		<a href=\"index.html\">voltar</a>\r\n"
				+ "	</form>\r\n"
				+ "</body>\r\n"
				+ "</html>");
	}
}
