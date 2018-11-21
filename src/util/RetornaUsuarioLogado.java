package util;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import daoGenerico.DAOGenerico;
import modelo.ClienteTitular;

public class RetornaUsuarioLogado {

	public static ClienteTitular get() {
		DAOGenerico<ClienteTitular> dao = new DAOGenerico<>(ClienteTitular.class);
		ClienteTitular func = new ClienteTitular();
		String nomeUsuario="";
		
		Authentication authentication = (Authentication) 
				SecurityContextHolder.getContext().getAuthentication(); 
		if(authentication != null){
			Object obj = authentication.getPrincipal();
			if (obj instanceof UserDetails) {
				nomeUsuario = ((UserDetails)obj).getUsername();
			} else {
				nomeUsuario = obj.toString();
			}		
		}
		
	List<ClienteTitular> lf = dao.consultarCondicao("email='" + nomeUsuario + "'");
		if(lf.size()>0) {
			func = lf.get(0);
		}
		return func;
	}

}