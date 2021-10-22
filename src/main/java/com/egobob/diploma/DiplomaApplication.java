package com.egobob.diploma;

import com.egobob.diploma.domain.Role;
import com.egobob.diploma.domain.User;
import com.egobob.diploma.service.security.RoleService;
import com.egobob.diploma.service.security.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class DiplomaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DiplomaApplication.class, args);

		/*
		RoleService roleService = context.getBean(RoleService.class);
		UserService userService = context.getBean(UserService.class);
		loadUsers(userService);
		loadRoles(roleService);
		assignUsersToUserRole(userService, roleService);
		assignUsersToAdminRole(userService, roleService);
		*/
	}

	private static void loadUsers(UserService userService) {
		User user1 = new User();
		user1.setUsername("user");
		user1.setPassword("user");
		userService.saveOrUpdate(user1);

		User user2 = new User();
		user2.setUsername("admin");
		user2.setPassword("admin");
		userService.saveOrUpdate(user2);
	}

	private static void loadRoles(RoleService roleService) {
		Role role = new Role();
		role.setName("USER");
		roleService.saveOrUpdate(role);

		Role adminRole = new Role();
		adminRole.setName("ADMIN");
		roleService.saveOrUpdate(adminRole);
	}

	// TODO: improve logic
	private static void assignUsersToUserRole(UserService userService, RoleService roleService) {
		List<Role> roles = (List<Role>) roleService.listAll();
		List<User> users = (List<User>) userService.listAll();
		roles.forEach(role -> {
			if (role.getName().equalsIgnoreCase("USER")) {
				users.forEach(user -> {
					if (user.getUsername().equals("user")) {
						user.addRole(role);
						userService.saveOrUpdate(user);
					}
				});
			}
		});
	}
	// TODO: improve logic
	private static void assignUsersToAdminRole(UserService userService, RoleService roleService) {
		List<Role> roles = (List<Role>) roleService.listAll();
		List<User> users = (List<User>) userService.listAll();
		roles.forEach(role -> {
			if (role.getName().equalsIgnoreCase("ADMIN")) {
				users.forEach(user -> {
					if (user.getUsername().equals("admin")) {
						user.addRole(role);
						userService.saveOrUpdate(user);
					}
				});
			}
		});
	}

}
