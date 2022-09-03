package br.com.estudo.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Empresa empresa = new Empresa();
		Date dataAbertura = null;		
		
		String nomeEmpresa = req.getParameter("nome");
		String paramData= req.getParameter("data");	
		
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
		
		req.setAttribute("empresa", empresa.getNome());		
		resp.sendRedirect("listaEmpresa");
	}
}
