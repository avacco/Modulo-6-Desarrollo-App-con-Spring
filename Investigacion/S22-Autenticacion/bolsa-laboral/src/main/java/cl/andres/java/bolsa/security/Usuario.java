package cl.andres.java.bolsa.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import cl.andres.java.bolsa.model.Empresa;
import cl.andres.java.bolsa.model.Postulante;

public class Usuario implements UserDetails {

	private Empresa empresa;
	private Postulante postulante;
	
	public Usuario(Postulante postulante, Empresa empresa) {
		this.postulante = postulante;
		this.empresa 	= empresa;
	}
	
	@Override
	public String getUsername() {
		if(postulante != null) return postulante.getNombre();
		if(empresa != null) return empresa.getRazonSocial();
		return null;
	}

	@Override
	public String getPassword() {
		if(postulante != null) return postulante.getContrasena();
		if(empresa != null) return empresa.getContrasena();
		return null;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(postulante != null) return List.of(new SimpleGrantedAuthority("POSTULANTE"));
		if(empresa != null) return List.of(new SimpleGrantedAuthority("EMPRESA"));
		return null;
	}
// De aqui para abajo no nos interesa, asi que dejamos que retornen true par que no hagan problema
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
// getters
	public Empresa getEmpresa() {
		return empresa;
	}

	public Postulante getPostulante() {
		return postulante;
	}

	
}
