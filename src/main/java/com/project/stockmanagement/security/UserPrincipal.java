package com.project.stockmanagement.security;

import com.project.stockmanagement.model.entity.UserAccount;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class UserPrincipal implements UserDetails {

	private UserAccount user;

	public UserPrincipal() {

	}
	public UserPrincipal(UserAccount user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "MyUserPrincipal [user=" + user + "]";
	}



	public UserAccount getUser() {
		return user;
	}

	public void setUser(UserAccount user) {
		this.user = user;
	}

	// TODO : Cette méthode définie le role de l'utilisateur
	// si vous changer la conception de vos classe User/Role il faut la mettre à
	// jour
	// Les Role doivent être créer sous forme d'une collection de type
	// GrantedAuthority
	// Dans notre conception l'utilisateur a un et un seul role, ainsi il suffit de
	// créer
	// un objet de type GrantedAuthority avec le role définit par
	// user.getRole().getRoleName()
	// donc enfin la collection des roles de l'utilisateur contient un seul role
	// sous forme
	// de GrantedAuthority

	public Collection<? extends GrantedAuthority> getAuthorities() {
		//authorizations list
		ArrayList<GrantedAuthority> arrayAuths = new ArrayList<GrantedAuthority>();
		//Create an authorization with the same name as the role name.
		if(user.getRole()!=null){
			SimpleGrantedAuthority auth = new SimpleGrantedAuthority(user.getRole().getRoleName());
			//Add this authorization to the list of authorizations of this user
			arrayAuths.add(auth);
		}
		return arrayAuths;
	}

	// TODO : les méthodes suivantes à adapter si vous changer la conception des
	// classes
	// Sinon vous pouvez les laisser telles quelles
	public String getFirstName() {
		return user.getPerson().getFirstName();
	}

	public String getLastName() {
		return user.getPerson().getLastName();
	}

	public String getEmail() {
		return user.getPerson().getEmail();
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return user.isAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return user.isAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return user.isCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {
		return user.isEnabled();
	}

}