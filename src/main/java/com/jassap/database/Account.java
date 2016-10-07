/*
 * Copyright (C) 2013 by danjian <josepwnz@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.jassap.database;
/**
 * Las cuentas cargadas de accounts.json se usan a traves de esta clase 
 * @author danjian
 */
public class Account {
	private String username;
	private String password;
	
	public Account(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public Account() {
	}
	
	public void setUser(String username) {
		this.username = username;
	}
	
	public String getUser() {
		return username;
	}
	
	public void setPass(String password) {
		this.password = password;
	}
	
	public String getPass() {
		return password;
	}
}