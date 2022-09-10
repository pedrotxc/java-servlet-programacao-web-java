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

public class NovaEmpresa {
	public void executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Empresa empresa = new Empresa();
		Date dataAbertura = null;		
		
		String nomeEmpresa = request.getParameter("nome");
		String paramData= request.getParameter("data");	
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			if(!paramData.isEmpty()) {
				dataAbertura = sdf.parse(paramData);
			}
		} catch (ParseException e) {
			throw new ServletException(e);
		}		
		
		if(!nomeEmpresa.isEmpty()) {
			System.out.println("Cadastrando nova empresa!");
			empresa.setNome(nomeEmpresa);
			empresa.setDataAbertura(dataAbertura);
			
			Banco banco = new Banco();
			banco.adiciona(empresa);
		}
		
		request.setAttribute("empresa", empresa.getNome());		
		response.sendRedirect("entrada?acao=ListaEmpresas");
	}
}
