package Cliente;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.swing.JOptionPane;

import com.Remote.UsuarioBeanRemote;
import com.entidades.TipoUsuario;
import com.entidades.Usuario;

import EJBLocator.EJBLocator;

public class VerificarUsuario {
	
	
	public static Usuario checknomypass(String usuario, String pass) throws NamingException {
		// TODO Auto-generated method stub
		 UsuarioBeanRemote UsuariosBeanRemote;
		
		 try {
			UsuariosBeanRemote =EJBLocator.getInstance().lookup(UsuarioBeanRemote.class);
			
			List<Usuario> usuarios = UsuariosBeanRemote.ObtenerUsuarioYPass(usuario, pass);
			
								
			if(!usuarios.isEmpty()) {
				return usuarios.get(0);
			} else {
				JOptionPane.showMessageDialog(null, "Error, Usuario o Contraseña no válidas, Por favor revise los datos ingresados");
			}
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();				
	}

		 return null;
	}
	
	

	
	
	public List<TipoUsuario> listarTiposUisuario () throws NamingException, Exception {
		// TODO Auto-generated method stub
		 UsuarioBeanRemote UsuariosRemote;
		 List<TipoUsuario> tiposUsu = new ArrayList<TipoUsuario>();
		 
		 try {
			UsuariosRemote =EJBLocator.getInstance().lookup(UsuarioBeanRemote.class);			
		 	tiposUsu = UsuariosRemote.ObtenerTipoUsu();
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();			
		}
		 finally{
			 return tiposUsu;
		 }


	}


}
