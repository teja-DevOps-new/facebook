package com.springbootproject.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="adminLogin")
public class AdminLogin {
	    
	    @Id
	    @GeneratedValue(strategy= GenerationType.IDENTITY)
	    private Long id;
	   
	    private String username;
	    
	    
	    private String password;
	    
	    public AdminLogin()
	    {
	           
	    }

		public AdminLogin(Long id, String username, String password) {
			super();
			this.id = id;
			this.username = username;
			this.password = password;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
	    

}

