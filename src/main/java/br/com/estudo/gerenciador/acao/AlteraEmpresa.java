package br.com.estudo.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estudo.gerenciador.modelo.Banco;
import br.com.estudo.gerenciador.modelo.Empresa;

public class AlteraEmpresa {
	public void executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("Alterando empresa:");
		
		String nomeEmpresa = request.getParameter("nome");
		String paramData= request.getParameter("data");
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Date dataAbertura;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramData);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		System.out.println(id);
		
		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaPelaId(id);
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);	
		
		response.sendRedirect("entrada?acao=ListaEmpresas");
	}
}
